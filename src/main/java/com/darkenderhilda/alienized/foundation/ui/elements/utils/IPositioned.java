package com.darkenderhilda.alienized.foundation.ui.elements.utils;

import com.darkenderhilda.alienized.foundation.ui.utils.Area;
import com.darkenderhilda.alienized.foundation.ui.utils.Point;

public interface IPositioned<E> {

    Area getBounds();

    default boolean isMouseOver(int mouseX, int mouseY) {
        return getBounds().contains(mouseX, mouseY);
    }

    default E bounds(Area area) {
        getBounds().setBounds(area);
        return getThis();
    }

    default E bounds(float x, float y, float width, float height) {
        getBounds().setBounds(x, y, width, height);
        return getThis();
    }

    default E x(float x) {
        getBounds().setX(x);
        return getThis();
    }

    default E y(float y) {
        getBounds().setY(y);
        return getThis();
    }

    default E width(float width) {
        getBounds().setWidth(width);
        return getThis();
    }

    default E height(float height) {
        getBounds().setHeight(height);
        return getThis();
    }

    default E pos(float x, float y) {
        getBounds().setLocation(x, y);
        return getThis();
    }

    default E pos(Point p) {
        getBounds().setLocation(p.getX(), p.getY());
        return getThis();
    }

    default E size(float width, float height) {
        getBounds().setSize(width, height);
        return getThis();
    }

    default float getX() {
        return getBounds().getX();
    }

    default float getY() {
        return getBounds().getY();
    }

    default float getWidth() {
        return getBounds().getWidth();
    }

    default float getHeight() {
        return getBounds().getHeight();
    }

    @SuppressWarnings("unckecked")
    E getThis();
}
