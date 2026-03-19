package com.darkenderhilda.alienized.content.ui.alien_overlay;

import com.darkenderhilda.alienized.Alienized;
import com.darkenderhilda.alienized.content.ui.alien_overlay.widgets.WidgetBase;
import com.darkenderhilda.alienized.content.ui.alien_overlay.widgets.all_widgets.WidgetForTests;
import com.darkenderhilda.alienized.foundation.ui.elements.utils.IInteractable;
import com.darkenderhilda.alienized.foundation.ui.utils.GuiRender;
import com.darkenderhilda.alienized.foundation.ui.render.drawables.DrawableResource;
import com.darkenderhilda.alienized.foundation.ui.elements.AbstractElement;
import com.darkenderhilda.alienized.foundation.ui.elements.utils.IParent;
import com.darkenderhilda.alienized.foundation.ui.utils.Area;
import com.darkenderhilda.alienized.foundation.ui.utils.Point;
import net.minecraft.client.gui.GuiScreen;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OverlayCanvas extends AbstractElement<OverlayCanvas>
        implements IInteractable, IParent<WidgetBase<?>> {

    private final AlienOverlay alienOverlay;

    private final List<WidgetBase<?>> widgets = new ArrayList<>();

    public static final DrawableResource drawable = new DrawableResource(Alienized.asLocation("textures/ui/ecgui/entry_green.png"));
    //debug
    private final Area border = new Area();
    private final Area allowed = new Area();

    private float resolutionW = 0;
    private float resolutionH = 0;

    private final Point center = new Point();
    //todo перед тем как обновить это нужно отправить запрос оверлею и получить разрешение. Нужно также обновлять стейт оверлея вместе с этим
    private boolean isDragging = false;
    private float lastMouseX;
    private float lastMouseY;

    //todo move to config
    private boolean moveOnEdge = false;
    //todo move to config
    private final int borderRadius = 10;


    private boolean isDraggingWidget = false;
    private WidgetBase<?> draggedWidget = null;
    private float lastMouseXWidget;
    private float lastMouseYWidget;

    public OverlayCanvas(AlienOverlay alienOverlay) {
        this.alienOverlay = alienOverlay;
    }

    @Override
    protected void renderElement(int mouseX, int mouseY) {
        widgets.forEach(widget -> widget.render(mouseX, mouseY));

        renderDebug();
    }

    private void renderDebug() {
        GuiRender.drawBorder(allowed,1, zLevel, Color.ORANGE);
        GuiRender.drawBorder(border,1, zLevel, Color.RED);
    }

    @Override
    protected void updateElement(int mouseX, int mouseY) {
        if(alienOverlay.isVisible()) {
            float w = border.getWidth();
            float h = border.getHeight();
            border.setBounds(center.getX() - w / 2, center.getY() - h / 2, w, h);

            handleMouseOnBorder(mouseX, mouseY);

            widgets.forEach(widget -> widget.pos(center.getX() + widget.getAbstractPos().getX(), center.getY() + widget.getAbstractPos().getY()));
        }
    }

    @Override
    public boolean onMouseClickStart(int mouseX, int mouseY, int mouseButton) {
        if(hovered) {
            if(mouseButton == 0) {
                if(GuiScreen.isShiftKeyDown()) {
                    WidgetBase<?> widget = getElementUnderMouse();
                    if(widget != null) {
                        isDraggingWidget = true;
                        draggedWidget = widget;
                        lastMouseXWidget = mouseX - widget.getAbstractPos().getX();
                        lastMouseYWidget = mouseY - widget.getAbstractPos().getY();
                        return true;
                    }
                }
            }

            if(mouseButton == 1) {
                isDragging = true;
                lastMouseX = mouseX;
                lastMouseY = mouseY;
                return true;
            }

        }

        return false;
    }


    @Override
    public boolean onMouseClickEnd(int mouseX, int mouseY, int mouseButton) {
        if(mouseButton == 0) {
            if(isDraggingWidget) {
                isDraggingWidget = false;
                draggedWidget = null;
                return true;
            }
        }

        if(mouseButton == 1) {
            if(isDragging) {
                isDragging = false;
                return true;
            }
        }

        return false;
    }

    @Override
    public void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        if(isDragging) {
            moveCenterTo(center.getX() + mouseX - lastMouseX, center.getY() + mouseY - lastMouseY);

            lastMouseX = mouseX;
            lastMouseY = mouseY;
        }

        if(isDraggingWidget) {
            moveElementTo(mouseX - lastMouseXWidget, mouseY - lastMouseYWidget);
        }
    }

    public OverlayCanvas moveOnEdge(boolean moveOnEdge) {
        this.moveOnEdge = moveOnEdge;
        return this;
    }

    public void onGuiInit(GuiScreen guiScreen) {
        //todo change to full screen, for now i need it smaller to debug
        bounds(10, 10, guiScreen.width - 20, guiScreen.height - 20);
        if(getWidth() > resolutionW) resolutionW = getWidth();
        if(getHeight() > resolutionH) resolutionH = getHeight();

        center.setLocation(getBounds().getCenter().getX(), getBounds().getCenter().getY());

        border.setBounds(center.getX() - resolutionW / 2, center.getY() - resolutionH / 2, resolutionW, resolutionH);

        float w = border.getWidth() - getWidth();
        float h = border.getHeight() - getHeight();
        allowed.setBounds(center.getX() - w / 2, center.getY() - h / 2, w, h);

        //todo tests
        widgets.clear();
        widgets.add(new WidgetForTests().zlevel(300).abstractPos(-10, -10).size(20, 20));
        widgets.add(new WidgetForTests().zlevel(300).abstractPos(-100, -100).size(20, 20));
    }

    @Override
    public List<WidgetBase<?>> getElements() {
        return List.copyOf(widgets);
    }

    @Override
    public void acceptElement(WidgetBase<?> widget) {
        widgets.add(widget);
    }

    //todo need height system, for now keep only one element in area
    @Nullable
    private WidgetBase<?> getElementUnderMouse() {
        for(WidgetBase<?> widget : widgets) {
            if(widget.isHovered()) return widget;
        }

        return null;
    }

    private void handleMouseOnBorder(int mouseX, int mouseY) {
        if(!moveOnEdge) return;

        float x = 0;
        float y = 0;

        if(new Area(getX(), getY(), getWidth(), borderRadius).contains(mouseX, mouseY)) y += 2;
        if(new Area(getX(), getY(), borderRadius, getHeight()).contains(mouseX, mouseY)) x += 2;
        if(new Area(getX(), getY() + getHeight() - borderRadius, getWidth(), borderRadius).contains(mouseX, mouseY)) y -= 2;
        if(new Area(getX() + getWidth() - 5, getY(), borderRadius, getHeight()).contains(mouseX, mouseY)) x -= 2;

        moveCenterTo(center.getX() + x, center.getY() + y);
    }

    private void moveCenterTo(float x, float y) {
        if(x < allowed.getX()) {
            x = allowed.getX();
        }

        if(x > allowed.getX() + allowed.getWidth()) {
            x = allowed.getX() + allowed.getWidth();
        }

        if(y < allowed.getY()) {
            y = allowed.getY();
        }

        if(y > allowed.getY() + allowed.getHeight()) {
            y = allowed.getY() + allowed.getHeight();
        }

        center.setLocation(x, y);
    }

    private void moveElementTo(float x, float y) {
        float eX = center.getX() + x;
        float eY = center.getY() + y;

        if(eX < border.getX()) {
            x= -(border.getWidth() / 2);
        }

        if(eY < border.getY()) {
            y = -(border.getHeight() / 2);
        }

        if(eX > border.getX() + border.getWidth() - draggedWidget.getWidth()) {
            x = border.getWidth() / 2 - draggedWidget.getWidth();
        }

        if(eY > border.getY() + border.getHeight() - draggedWidget.getHeight()) {
            y = border.getHeight() / 2 - draggedWidget.getHeight();
        }

        draggedWidget.abstractPos(x, y);
    }
}
