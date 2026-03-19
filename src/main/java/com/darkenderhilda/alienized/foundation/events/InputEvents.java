package com.darkenderhilda.alienized.foundation.events;

import com.darkenderhilda.alienized.AllItems;
import com.darkenderhilda.alienized.AllKeybinds;
import com.darkenderhilda.alienized.Internal;
import com.darkenderhilda.alienized.content.ui.gui.better_crafting_gui.BCGui;
import com.darkenderhilda.alienized.foundation.network.packets.PacketHandler;
import com.darkenderhilda.alienized.foundation.network.packets.all_packets.MirrorItemPacket;
import com.darkenderhilda.alienized.foundation.network.packets.all_packets.OpenGuiPacket;
import com.darkenderhilda.alienized.foundation.ui.utils.GuiHandler;
import com.darkenderhilda.alienized.foundation.ui.utils.GuiUtils;
import com.darkenderhilda.alienized.foundation.utils.ClientUtils;
import com.darkenderhilda.alienized.foundation.utils.MouseHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.items.ItemHandlerHelper;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

//TODO make not static methods
@Mod.EventBusSubscriber(Side.CLIENT)
public class InputEvents {

    @SubscribeEvent
    public static void onGuiMouseInput(GuiScreenEvent.MouseInputEvent.Pre event) {
        event.setCanceled(handlerMouseEvent(event));
    }

    private static boolean handlerMouseEvent(GuiScreenEvent.MouseInputEvent.Pre event) {
        int mouseX = MouseHelper.getMouseX();
        int mouseY = MouseHelper.getMouseY();
        int mouseButton = Mouse.getEventButton();
        int scroll = Mouse.getEventDWheel();
        boolean keyState = Mouse.getEventButtonState();

        if(handleAlienMirrorInput(event.getGui(), mouseButton)) {
            return true;
        } else if(handleStackSliderInput(event.getGui(), mouseButton, keyState)) {
            return true;
        } else if(Internal.alienOverlay.handleMouseInput()) {
            return true;
        }

        return false;
    }

    private static boolean handleAlienMirrorInput(GuiScreen guiScreen, int mouseButton) {
        if (guiScreen instanceof GuiContainer) {
            ItemStack cursorStack = guiScreen.mc.player.inventory.getItemStack();
            if (!cursorStack.isEmpty() && cursorStack.getItem() == AllItems.AlienMirror) {
                Slot slot = ((GuiContainer) guiScreen).getSlotUnderMouse();
                if (slot != null) {
                    ItemStack stackTarget = slot.getStack();
                    if (!stackTarget.isEmpty()) {
                        if(mouseButton == 1) {
                            PacketHandler.INSTANCE.sendToServer(new MirrorItemPacket(ItemHandlerHelper.copyStackWithSize(stackTarget, 1)));
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private static boolean handleStackSliderInput(GuiScreen guiScreen, int mouseButton, boolean keyState) {
        if (guiScreen instanceof GuiContainer guiContainer) {
            if(mouseButton == 0 && GuiScreen.isAltKeyDown()) {
                if(keyState) {
                    Slot slot = guiContainer.getSlotUnderMouse();
                    if(slot != null) {
                        if(!slot.getStack().isEmpty()) {
                            if(slot.getStack().getCount() > 1) {
                                Internal.itemSliderLogic.init(guiContainer, slot);
                                return true;
                            }
                        }

                    }
                }

            }
        }
        return false;
    }

    @SubscribeEvent
    public static void onGuiKeyboardEvent(GuiScreenEvent.KeyboardInputEvent.Pre event) {
        event.setCanceled(handleKeyboardEvent());
    }

    private static boolean handleKeyboardEvent() {
        char typedChar = Keyboard.getEventCharacter();
        int keyCode = Keyboard.getEventKey();
        boolean keyState = Keyboard.getEventKeyState();


        if(handleECGuiOpen(keyCode, keyState)) {
            return true;
        } else if(handleAlienOverlay(keyCode, keyState)) {
            return true;
        } else if(Internal.alienOverlay.handleKeyboardInput()) {
            return true;
        }

        return false;
    }

    private static boolean handleECGuiOpen(int keyCode, boolean keyState) {
        if(AllKeybinds.openBCGuiKey.isActiveAndMatches(keyCode) && keyState) {
            GuiScreen screen = ClientUtils.getCurrentScreen();
            if (screen instanceof BCGui) {
                Internal.bcGuiLogic.handleGuiClosing();
            } else {
                PacketHandler.INSTANCE.sendToServer(new OpenGuiPacket(GuiHandler.ECGui));
                Internal.bcGuiLogic.handleGuiOpening(screen);
            }

            GuiUtils.playPressSound();
            return true;
        }

        return false;
    }

    private static boolean handleAlienOverlay(int keyCode, boolean keyState) {
        if(AllKeybinds.alienOverlayKey.isActiveAndMatches(keyCode) && keyState) {
            Internal.alienOverlay.toggleVisibility();
            return true;
        }

        return false;
    }
}
