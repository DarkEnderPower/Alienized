package com.darkenderhilda.alienized.foundation.ui.text;

import com.darkenderhilda.alienized.foundation.ui.utils.Area;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;

public class ItemStackTextElement implements ITextElement<ItemStack> {

    @Override
    public void accept(ItemStack stack) {

    }

    @Override
    public String getString() {
        return "";
    }

    @Override
    public Area getBounds(FontRenderer fr) {
        return null;
    }
}
