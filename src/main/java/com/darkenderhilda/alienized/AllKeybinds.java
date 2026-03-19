package com.darkenderhilda.alienized;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class AllKeybinds {

    public static KeyBinding openBCGuiKey;
    public static KeyBinding alienOverlayKey;

    public static void init() {
        openBCGuiKey = keyBinding("Open Better Crafting Gui", Keyboard.KEY_F);
        alienOverlayKey = keyBinding("Toggle Overlay Visibility", Keyboard.KEY_C);
    }

    private static KeyBinding keyBinding(String description, int key) {
        KeyBinding keyBinding = new KeyBinding(description, key, "Create");
        ClientRegistry.registerKeyBinding(keyBinding);
        return keyBinding;
    }
}
