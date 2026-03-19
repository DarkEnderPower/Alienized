package com.darkenderhilda.alienized.content.ui.gui.better_crafting_gui.recipe_history_panel;

import com.darkenderhilda.alienized.CreateConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.ArrayList;
import java.util.List;

public class RecipeHistoryManager {

    private final List<RecipeHistoryEntry> ENTRIES = new ArrayList<>();
    private IRecipe lastAddedRecipe;

    public void addNewRecipe(IRecipe recipe) {
        if (lastAddedRecipe != null && lastAddedRecipe == recipe) {
            return;
        }
        lastAddedRecipe = recipe;

        ItemStack stack = ItemHandlerHelper.copyStackWithSize(recipe.getRecipeOutput().copy(), 1);
        for (RecipeHistoryEntry entry : ENTRIES) {
            if(ItemStack.areItemsEqualIgnoreDurability(entry.getItemStack(), stack)) {
                entry.addNewRecipeSafe(recipe);
                ENTRIES.remove(entry);
                ENTRIES.addFirst(entry);
                return;
            }
        }

        RecipeHistoryEntry entry = new RecipeHistoryEntry(stack);
        entry.addNewRecipeSafe(recipe);
        ENTRIES.addFirst(entry);

        if(ENTRIES.size() > CreateConfig.ECGuiSettings.recipeHistoryLimit) {
            ENTRIES.removeLast();
        }


    }

    public List<RecipeHistoryEntry> getEntries() {
        return new ArrayList<>(ENTRIES);
    }

    public void clearEntries() {
        ENTRIES.clear();
        lastAddedRecipe = null;
    }
}
