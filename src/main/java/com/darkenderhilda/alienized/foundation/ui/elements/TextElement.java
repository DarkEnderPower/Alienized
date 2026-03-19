package com.darkenderhilda.alienized.foundation.ui.elements;

import com.darkenderhilda.alienized.AllColors;
import com.darkenderhilda.alienized.foundation.ui.text.utils.HorizontalAlignment;
import com.darkenderhilda.alienized.foundation.ui.text.utils.VerticalAlignment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

import java.awt.*;

public class TextElement
        extends AbstractElement<TextElement> {

    private final FontRenderer fontRenderer;

    private String text = "";
    private Color color = AllColors.TEXT_COLOR;
    private HorizontalAlignment horizontalAlign;
    private VerticalAlignment verticalAlign;


    public TextElement() {
        fontRenderer = Minecraft.getMinecraft().fontRenderer;
    }

    @Override
    protected void renderElement(int mouseX, int mouseY) {

    }

    public TextElement text(String text) {
        this.text = text;
        return getThis();
    }

    public TextElement color(Color color) {
        this.color = color;
        return getThis();
    }

    public TextElement horizontalAlign(HorizontalAlignment horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
        return getThis();
    }

    public TextElement verticalAlign(VerticalAlignment verticalAlign) {
        this.verticalAlign = verticalAlign;
        return getThis();
    }
}
