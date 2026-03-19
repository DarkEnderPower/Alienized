package com.darkenderhilda.alienized.foundation.ui.text;

import com.darkenderhilda.alienized.foundation.ui.utils.Area;
import net.minecraft.client.gui.FontRenderer;

public class StringTextElement
        implements ITextElement<String> {

    private String s = "";

    @Override
    public void accept(String string) {
        s = string;
    }

    @Override
    public String getString() {
        return s;
    }

    @Override
    public Area getBounds(FontRenderer fr) {
        return new Area(fr.getStringWidth(s), fr.FONT_HEIGHT);
    }
}
