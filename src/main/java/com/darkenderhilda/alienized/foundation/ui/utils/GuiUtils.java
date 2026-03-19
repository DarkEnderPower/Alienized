package com.darkenderhilda.alienized.foundation.ui.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class GuiUtils {

    public static void playSound(SoundEvent sound, float pitch) {
        Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(sound, pitch));

    }

    public static void playPressSound() {
        playSound(SoundEvents.UI_BUTTON_CLICK, 1.0F);
    }
}
