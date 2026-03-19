package com.darkenderhilda.alienized.test;

import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

@Mod.EventBusSubscriber
public class Tests {

    @SubscribeEvent
    public static void onTestButtonClicked(GuiScreenEvent.KeyboardInputEvent.Pre event) {
        if(Keyboard.getEventKey() == Keyboard.KEY_X) {
            if(Keyboard.getEventKeyState()) {
                runTest();
            }
        }

        if(Keyboard.getEventKey() == Keyboard.KEY_R) {
            if(Keyboard.getEventKeyState()) {
                runTest2();
            }
        }
    }

    private static void runTest() {
    }

    private static void runTest2() {
    }

    @SubscribeEvent
    public static void o213(ItemTooltipEvent event) {
        event.getToolTip().add("PRESS W, FREAK!");
    }
}
