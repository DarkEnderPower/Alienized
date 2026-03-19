package com.darkenderhilda.alienized.content.ui.alien_overlay;

import com.darkenderhilda.alienized.content.ui.alien_overlay.alien_keybinds.AlienKeybindsService;
import com.darkenderhilda.alienized.foundation.ui.elements.utils.IInteractable;
import com.darkenderhilda.alienized.foundation.ui.render.drawables.DrawableColor;
import com.darkenderhilda.alienized.foundation.ui.render.drawables.IDrawable;
import com.darkenderhilda.alienized.foundation.ui.elements.AbstractElement;
import com.darkenderhilda.alienized.foundation.ui.elements.utils.InputHandler;
import com.darkenderhilda.alienized.foundation.ui.elements.SimpleButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AlienOverlay {

    private boolean visible = false;

    private final IDrawable defaultBg = new DrawableColor(new Color(0, 0, 0, 150));

    protected final List<AbstractElement<?>> elements = new ArrayList<>();
    private final InputHandler inputHandler = new InputHandler();

    //Services
    private final AlienKeybindsService alienKeybindsService = new AlienKeybindsService();

    private final OverlayCanvas overlayCanvas = new OverlayCanvas(this)
            .moveOnEdge(true)
            .zlevel(300);
    private final SimpleButton keyBindMenuButton = new SimpleButton()
            .onClick(() -> System.out.println("Da"))
            .zlevel(300);

    public AlienOverlay() {
        elements.add(keyBindMenuButton);
    }

    public void render(GuiScreen guiScreen, int mouseX, int mouseY) {
        if(visible) {
            renderDefaultBg(guiScreen);

            overlayCanvas.render(mouseX, mouseY);
            keyBindMenuButton.render(mouseX, mouseY);
        }
    }

    public boolean handleMouseInput() {
        //basic elements goes before canvas as they above canvas
        if(inputHandler.handleMouseInput(getInteractables())) {
            return true;
        } return inputHandler.handleMouseInput(overlayCanvas);
    }

    public boolean handleKeyboardInput() {

        return false;
    }

    public void update() {
        GuiScreen guiScreen = Minecraft.getMinecraft().currentScreen;
        if(guiScreen == null && visible) {
            turnOff();
        }
    }

    public void onGuiInit(GuiScreen guiScreen) {
        overlayCanvas.onGuiInit(guiScreen);
        keyBindMenuButton.bounds(guiScreen.width - 30, guiScreen.height - 30, 20, 20);
    }

    public void turnOn() {
        visible = true;
    }

    public void turnOff() {
        visible = false;
    }

    public void toggleVisibility() {
        if(visible) {
            turnOff();
        } else {
            turnOn();
        }
    }

    public boolean isVisible() {
        return visible;
    }

    private void renderDefaultBg(GuiScreen guiScreen) {
        defaultBg.draw(0, 0, guiScreen.width, guiScreen.height, 300);
    }

    protected List<IInteractable> getInteractables() {
        List<IInteractable> list = new ArrayList<>();

        for (AbstractElement<?> e : elements) {
            if(e instanceof IInteractable) {
                list.add((IInteractable) e);
            }
        }

        return list;
    }
}
