package com.darkenderhilda.alienized.content.ui.alien_overlay.alien_keybinds;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AlienKeybindsService {

    private final List<AlienKeybind> keybinds = new ArrayList<>();

    public void onLoad() {
        Yaml yaml = new Yaml();
    }

    public void saveKeybinds() {
        try {
            Path configDir = Paths.get("config");
            Path configFile = configDir.resolve("mymod-config.yaml");

            createConfigDirectory(configDir);

            if (!Files.exists(configFile)) {
                //createDefaultConfig(configFile);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void createConfigDirectory(Path dir) throws IOException {
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
    }

    public void addKeybind(AlienKeybind keybind) {
        keybinds.add(keybind);
    }

    public boolean hasKeybind(int keycode) {
        return keybinds.stream().anyMatch(keybind -> keybind.getKeyCode() == keycode);
    }

    public List<AlienKeybind> getKeybinds() {
        return keybinds;
    }
}
