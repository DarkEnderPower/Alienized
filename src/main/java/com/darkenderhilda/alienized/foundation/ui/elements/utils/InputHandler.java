package com.darkenderhilda.alienized.foundation.ui.elements.utils;

import com.darkenderhilda.alienized.foundation.utils.MouseHelper;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.List;


public class InputHandler {

    private long lastMouseEvent = 0;

    public boolean handleMouseInput(IInteractable interactable) {
        return handleMouseInput(List.of(interactable));
    }

    //todo all this code doesn't  imply zLevel of element, if multiple under mouse all will be called
    public boolean handleMouseInput(List<IInteractable> list) {
        int mouseX = MouseHelper.getMouseX();
        int mouseY = MouseHelper.getMouseY();
        int mouseButton = Mouse.getEventButton();
        int scroll = Mouse.getEventDWheel();
        boolean keyState = Mouse.getEventButtonState();


        if(scroll != 0) {
            for (IInteractable element : list) {
                element.onScroll(mouseX, mouseY, scroll);
            }

            return true;
        }

        boolean b = false;

        if(keyState) {
            for (IInteractable element : list) {
                if(element.onMouseClick(mouseX, mouseY, mouseButton)){
                    b = true;
                }

                if(element.onMouseClickStart(mouseX, mouseY, mouseButton)){
                    b = true;
                }

                lastMouseEvent = Minecraft.getSystemTime();
            }
        } else {
            for (IInteractable element : list) {
                if(element.onMouseClickEnd(mouseX, mouseY, mouseButton)){
                    b = true;
                }
            }
        }

        if(lastMouseEvent > 0L) {
            long l = Minecraft.getSystemTime() - this.lastMouseEvent;

            for (IInteractable element : list) {
                element.mouseClickMove(mouseX, mouseY, mouseButton, l);
            }
        }

        return b;
    }

    public boolean handleKeyboardInput(IInteractable interactable) {
        return handleKeyboardInput(List.of(interactable));
    }

    public boolean handleKeyboardInput(List<IInteractable> list) {
        char typedChar = Keyboard.getEventCharacter();
        int keyCode = Keyboard.getEventKey();
        boolean keyState = Keyboard.getEventKeyState();


        boolean b = false;

        if(keyState) {
            for (IInteractable element : list) {
                if(element.onKeyboardClick(typedChar, keyCode)){
                    b = true;
                }

                if(element.onKeyboardClickStart(typedChar, keyCode)){
                    b = true;
                }
            }
        } else {
            for (IInteractable element : list) {
                if(element.onKeyboardClickEnd(typedChar, keyCode)){
                    b = true;
                }
            }
        }

        return b;
    }
}

