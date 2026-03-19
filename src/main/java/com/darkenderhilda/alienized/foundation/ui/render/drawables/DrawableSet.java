package com.darkenderhilda.alienized.foundation.ui.render.drawables;

import java.util.ArrayList;
import java.util.List;

public class DrawableSet
        implements IDrawable {

    private final List<IDrawable> drawables = new ArrayList<>();

    public DrawableSet(IDrawable...drawable) {
        drawables.addAll(List.of(drawable));
    }

    @Override
    public void draw(float x, float y, float width, float height, int zLevel) {
        drawables.forEach(drawable -> drawable.draw(x, y, width, height, zLevel));
    }
}
