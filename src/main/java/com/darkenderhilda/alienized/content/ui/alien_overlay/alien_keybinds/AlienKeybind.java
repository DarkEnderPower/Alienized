package com.darkenderhilda.alienized.content.ui.alien_overlay.alien_keybinds;

public class AlienKeybind {

    //todo make non final and allow changes
    private final int keyCode;
    private final String name;

    public AlienKeybind(int keyCode, String name) {
        this.keyCode = keyCode;
        this.name = name;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public String getName() {
        return name;
    }
}
