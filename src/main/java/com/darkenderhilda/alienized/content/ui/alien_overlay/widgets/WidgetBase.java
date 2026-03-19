package com.darkenderhilda.alienized.content.ui.alien_overlay.widgets;

import com.darkenderhilda.alienized.foundation.ui.elements.utils.IResizable;
import com.darkenderhilda.alienized.foundation.ui.elements.AbstractElement;
import com.darkenderhilda.alienized.foundation.ui.utils.Point;

public abstract class WidgetBase <E extends WidgetBase<E>> extends AbstractElement<E> implements IResizable<E> {

    private final Point abstractPos = new Point();

    public E abstractPos(float x, float y) {
        abstractPos.setLocation(x ,y);
        return getThis();
    }

    public Point getAbstractPos() {
        return abstractPos;
    }
}
