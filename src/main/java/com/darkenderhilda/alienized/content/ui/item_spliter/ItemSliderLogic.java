package com.darkenderhilda.alienized.content.ui.item_spliter;

import com.darkenderhilda.alienized.foundation.utils.MouseHelper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;

import java.awt.*;

public class ItemSliderLogic {

    private boolean enabled = false;
    private final Rectangle area = new Rectangle();

    private GuiContainer container;
    private Slot slot;
    private int inStackCount;

    public void init(GuiContainer container, Slot slot) {
        enabled = true;
        this.container = container;
        this.slot = slot;
        inStackCount = slot.getStack().getCount();
    }

    public void update() {
        if(enabled) {
            if(slot == null) {
                enabled = false;
            } else if(slot.getStack().getCount() != inStackCount) {
                enabled = false;
            }
        }
    }

    public void handlerGuiOpen() {
        if(enabled) {
            enabled = false;
        }
    }

    public void updateArea(Rectangle area) {
        this.area.setBounds(area);
    }

    public boolean canDrawTooltip() {
        if(enabled) {
            return !area.contains(MouseHelper.getMouseX(), MouseHelper.getMouseY());
        }

        return true;
    }

    //todo change to final X not slot X
    public int getSlotX() {
        return container.getGuiLeft() + slot.xPos;
    }

    public int getSlotY() {
        return container.getGuiTop() + slot.yPos;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
