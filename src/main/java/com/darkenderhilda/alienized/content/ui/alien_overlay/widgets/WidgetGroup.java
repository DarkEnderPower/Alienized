package com.darkenderhilda.alienized.content.ui.alien_overlay.widgets;

import com.darkenderhilda.alienized.foundation.ui.render.drawables.DrawableColor;
import com.darkenderhilda.alienized.foundation.ui.render.drawables.IDrawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//todo api
public class WidgetGroup {

    public static final List<WidgetGroup> allGroups = new ArrayList<>();

    public static WidgetGroup COMMON = registerGroup("Common", new DrawableColor(Color.ORANGE), "");

    /**
     *  Call this to create new Group
     * @param name Display name
     * @param icon Display icon, 20x20
     * @param description Can be empty, then it will not be displayed
     */
    public static WidgetGroup registerGroup(String name, IDrawable icon, String description) {
        WidgetGroup group = new WidgetGroup(icon, name, description);
        allGroups.add(group);
        return group;
    }

    private final IDrawable icon;
    private final String name;
    private final String description;

    public WidgetGroup(IDrawable icon, String name, String description) {
        this.icon = icon;
        this.name = name;
        this.description = description;
    }

    public IDrawable getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
