package com.darkenderhilda.alienized.content.ui.gui.better_crafting_gui.recipe_history_panel;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeHistoryEntry {

    private final ItemStack itemStack;
    private final List<IRecipe> recipes = new ArrayList<>();

    public RecipeHistoryEntry(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public void addNewRecipeSafe(IRecipe recipe) {
        if(!recipes.contains(recipe)) {
            recipes.remove(recipe);
            recipes.addFirst(recipe);
        }
    }

    public void addNewRecipe(IRecipe recipe) {
        recipes.add(recipe);
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public List<IRecipe> getRecipes() {
        return recipes;
    }

    public RecipeHistoryEntry copy() {
        RecipeHistoryEntry entry = new RecipeHistoryEntry(itemStack);
        for (IRecipe recipe : recipes) {
            entry.addNewRecipe(recipe);
        }

        return entry;
    }

    @Override
    public String toString() {
        return itemStack.getDisplayName() + ": " + recipes.size();
    }
}
