package com.darkenderhilda.alienized.foundation.ui.elements;

import com.darkenderhilda.alienized.Alienized;
import com.darkenderhilda.alienized.AllColors;
import com.darkenderhilda.alienized.foundation.ui.elements.utils.IPositioned;
import com.darkenderhilda.alienized.foundation.ui.utils.GuiRender;
import com.darkenderhilda.alienized.foundation.ui.render.drawables.IDrawable;
import com.darkenderhilda.alienized.foundation.ui.utils.Area;

import java.util.function.Consumer;

public abstract class AbstractElement<E extends AbstractElement<E>>
        implements IPositioned<E> {

    protected final Area area = new Area();

    protected int zLevel = 0;
    protected boolean enabled = true;
    protected boolean hovered = false;
    protected boolean init = false;

    protected Consumer<E> updateListener;

    public final void render(int mouseX, int mouseY) {
        if(!enabled) {
            return;
        }

        hovered = isMouseOver(mouseX, mouseY);

        if(Alienized.debug && hovered) {
            GuiRender.drawBorder(getBounds(), 1, zLevel, AllColors.MOD_COLOR);
        }

        update(mouseX, mouseY);
        renderElement(mouseX, mouseY);
    }

    protected abstract void renderElement(int mouseX, int mouseY);

    public final void update(int mouseX, int mouseY) {
        if(!init) {
            buildElement();
            init = true;
        }

        updateElement(mouseX, mouseY);

        if(updateListener != null) {
            updateListener.accept(getThis());
        }
    }

    public void buildElement() {}

    protected void updateElement(int mouseX, int mouseY) {}

    public E updateListener(Consumer<E> updateListener) {
        this.updateListener = updateListener;
        return getThis();
    }

    //TODO WORK?
    public E updateListener(Consumer<E> updateListener, boolean merge) {
        if(merge && updateListener != null) {
            this.updateListener = getThis().updateListener.andThen(updateListener);
        } else {
            this.updateListener = updateListener;
        }

        return getThis();
    }

    public E zlevel(int zLevel) {
        this.zLevel = zLevel;
        return getThis();
    }

    public E enabled(boolean enabled) {
        this.enabled = enabled;
        return getThis();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isHovered() {
        return hovered;
    }

    @Override
    public Area getBounds() {
        return area;
    }

    @SuppressWarnings("unchecked")
    public E getThis(){
        return (E) this;
    }

    protected void renderDrawable(IDrawable drawable) {
        drawable.draw(getBounds(), zLevel);
    }
}
