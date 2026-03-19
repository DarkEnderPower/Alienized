package com.darkenderhilda.alienized.foundation.ui.render.drawables;

import com.darkenderhilda.alienized.foundation.ui.utils.GuiRender;

import java.awt.*;

public class DrawableColor
        implements IDrawable {

    private Color color;

    public DrawableColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(float x, float y, float width, float height, int zLevel) {
        GuiRender.drawRect(x, y, width, height, zLevel, color);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
