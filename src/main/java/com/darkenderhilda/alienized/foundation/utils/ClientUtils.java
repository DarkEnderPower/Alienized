package com.darkenderhilda.alienized.foundation.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class ClientUtils {

    public static void displayScreen(GuiScreen screen) {
        getMc().displayGuiScreen(screen);
    }

    @Nullable
    public static GuiScreen getCurrentScreen() {
        return getMc().currentScreen;
    }

    public static Minecraft getMc() {
        return Minecraft.getMinecraft();
    }
}
