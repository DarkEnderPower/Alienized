package com.darkenderhilda.alienized.content.ui.gui.better_crafting_gui;

import com.darkenderhilda.alienized.content.ui.gui.better_crafting_gui.recipe_history_panel.RecipeHistoryPanelLogic;
import com.darkenderhilda.alienized.foundation.utils.ClientUtils;
import net.minecraft.client.gui.GuiScreen;

public class BCGuiLogic {

    private final RecipeHistoryPanelLogic recipeHistoryPanelLogic = new RecipeHistoryPanelLogic();

    private GuiScreen parentScreen;

    public void handleGuiOpening(GuiScreen parentScreen) {
        this.parentScreen = parentScreen;
    }

    public void handleGuiClosing() {
        ClientUtils.displayScreen(parentScreen);
    }

    public RecipeHistoryPanelLogic getRecipeHistoryPanelLogic() {
        return recipeHistoryPanelLogic;
    }
}
