package com.darkenderhilda.alienized.content.ui.alien_overlay;

import com.darkenderhilda.alienized.content.ui.alien_overlay.widgets.WidgetBase;
import com.darkenderhilda.alienized.content.ui.alien_overlay.widgets.all_widgets.WidgetForTests;

//todo просто класс возращающий лист виджетов
public class DummySaveHandler {

    public static WidgetBase<?> getABBA() {
        return new WidgetForTests().bounds(100, 100, 20, 20);
    }
}
