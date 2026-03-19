package com.darkenderhilda.alienized.foundation.ui.elements;

import com.darkenderhilda.alienized.AllColors;
import com.darkenderhilda.alienized.foundation.ui.elements.utils.IInteractable;
import com.darkenderhilda.alienized.foundation.ui.utils.GuiUtils;
import com.darkenderhilda.alienized.foundation.ui.render.drawables.DrawableColor;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class SimpleButton
        extends AbstractElement<SimpleButton>
        implements IInteractable {

    protected Runnable onClick = () -> {};

    protected boolean playSound = true;
    protected SoundEvent sound = SoundEvents.UI_BUTTON_CLICK;

    @Override
    protected void renderElement(int mouseX, int mouseY) {
        renderDrawable(new DrawableColor(AllColors.MOD_COLOR));
    }

    @Override
    public boolean onMouseClickStart(int mouseX, int mouseY, int mouseButton) {
        if(hovered) {
            if(mouseButton == 0) {
                if(playSound) {
                    GuiUtils.playSound(sound, 1.0F);
                }

                onClick.run();
            }
        }

        return false;
    }

    public SimpleButton onClick(Runnable onClick) {
        this.onClick = onClick;
        return getThis();
    }

    public SimpleButton playSound(boolean playSound) {
        this.playSound = playSound;
        return getThis();
    }

    public SimpleButton sound(SoundEvent sound) {
        this.sound = sound;
        return getThis();
    }
}
