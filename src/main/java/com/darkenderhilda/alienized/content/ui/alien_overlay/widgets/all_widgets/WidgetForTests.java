package com.darkenderhilda.alienized.content.ui.alien_overlay.widgets.all_widgets;

import com.darkenderhilda.alienized.content.ui.alien_overlay.widgets.WidgetBase;
import com.darkenderhilda.alienized.foundation.ui.render.drawables.DrawableColor;

import java.awt.*;

public class WidgetForTests extends WidgetBase<WidgetForTests> {

    @Override
    protected void renderElement(int mouseX, int mouseY) {
        renderDrawable(new DrawableColor(Color.ORANGE));
    }
}
