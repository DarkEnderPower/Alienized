package com.darkenderhilda.alienized;

import com.darkenderhilda.alienized.content.ui.gui.better_crafting_gui.BCGuiLogic;
import com.darkenderhilda.alienized.content.ui.item_spliter.ItemSliderLogic;
import com.darkenderhilda.alienized.content.ui.alien_overlay.AlienOverlay;
import com.darkenderhilda.alienized.content.ui.gui.better_crafting_gui.recipe_history_panel.RecipeHistoryManager;

public class Internal {

    public static final RecipeHistoryManager recipeHistoryManager = new RecipeHistoryManager();

    public static final BCGuiLogic bcGuiLogic = new BCGuiLogic();
    public static final ItemSliderLogic itemSliderLogic = new ItemSliderLogic();

    public static final AlienOverlay alienOverlay = new AlienOverlay();
}
