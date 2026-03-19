package com.darkenderhilda.alienized.foundation.ui.elements.utils;

public interface IInteractable {

    default boolean onMouseClick(int mouseX, int mouseY, int mouseButton) {
        return false;
    }

    default boolean onMouseClickStart(int mouseX, int mouseY, int mouseButton) {
        return false;
    }

    default boolean onMouseClickEnd(int mouseX, int mouseY, int mouseButton) {
        return false;
    }

    default void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {}

    default boolean onScroll(int mouseX, int mouseY, int scroll) {
        return false;
    }

    default boolean isFocused() {
        return false;
    }

    default boolean onKeyboardClick(char typedChar, int keycode) {
        return false;
    }

    default boolean onKeyboardClickStart(char typedChar, int keycode) {
        return false;
    }

    default boolean onKeyboardClickEnd(char typedChar, int keycode) {
        return false;
    }
}
