package com.darkenderhilda.alienized;

import net.minecraftforge.common.config.Config;

@Config(modid = Alienized.MOD_ID, name = Alienized.MOD_NAME)
public class CreateConfig {

    public static final ECGuiSettings ECGuiSettings = new ECGuiSettings();
    public static class ECGuiSettings {

        @Config.RangeInt(min = 1)
        @Config.Comment("Maximum Allowed Entries")
        public int recipeHistoryLimit = 100;

        @Config.RangeInt(min = 1)
        @Config.Comment("Inventory Finder Range")
        public int inventoryFinderRange = 10;
    }
}
