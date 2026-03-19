package com.darkenderhilda.alienized.foundation.ui.render.drawables;

import com.darkenderhilda.alienized.foundation.ui.utils.Area;

public interface IDrawable {

    IDrawable BLANK = new DrawableBlank();

    void draw(float x, float y, float width, float height, int zLevel);

    default void draw(float x, float y, float width, float height) {
        draw(x, y, width, height, 0);
    }

    default void draw(Area area, int zLevel) {
        draw(area.getX(), area.getY(), area.getWidth(), area.getHeight(), zLevel);
    }

    default void draw(Area area) {
        draw(area.getX(), area.getY(), area.getWidth(), area.getHeight());
    }
}
