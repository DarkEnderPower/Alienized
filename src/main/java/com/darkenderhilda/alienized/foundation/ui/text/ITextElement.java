package com.darkenderhilda.alienized.foundation.ui.text;

import com.darkenderhilda.alienized.foundation.ui.utils.Area;
import net.minecraft.client.gui.FontRenderer;

public interface ITextElement<T> {

    void accept(T t);

    String getString();

    Area getBounds(FontRenderer fr);
}
