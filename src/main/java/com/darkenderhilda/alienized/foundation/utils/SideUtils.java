package com.darkenderhilda.alienized.foundation.utils;

import net.minecraft.client.Minecraft;

public class SideUtils {

    public static boolean isClientSide() {
        return Minecraft.getMinecraft().world.isRemote;
    }

    public static boolean isServerSide() {
        return !isClientSide();
    }
}
