package com.darkenderhilda.alienized.foundation.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Mouse;

public class MouseHelper {

    private static int mouseX = 0;
    private static int mouseY = 0;

    public static void update() {
        GuiScreen guiScreen = ClientUtils.getCurrentScreen();
        if(guiScreen != null) {
            Minecraft mc = Minecraft.getMinecraft();
            mouseX = Mouse.getEventX() * guiScreen.width / mc.displayWidth;
            mouseY = guiScreen.height - Mouse.getEventY() * guiScreen.height / mc.displayHeight - 1;
        }
    }

    public static int getMouseX() {
        return mouseX;
    }

    public static int getMouseY() {
        return mouseY;
    }
}
