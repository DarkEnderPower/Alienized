package com.darkenderhilda.alienized.content.ui.gui.better_crafting_gui.recipe_history_panel;

import com.darkenderhilda.alienized.Internal;
import com.darkenderhilda.alienized.foundation.ui.elements.AbstractElement;
import com.darkenderhilda.alienized.foundation.ui.elements.utils.IInteractable;
import com.darkenderhilda.alienized.foundation.ui.render.drawables.DrawableColor;
import com.darkenderhilda.alienized.foundation.ui.elements.SimpleButton;

import java.awt.*;

public class RecipeHistoryPanel
        extends AbstractElement<RecipeHistoryPanel>
        implements IInteractable {

    private final RecipeHistoryPanelLogic logic;
    private SimpleButton prevPageButton;
    private SimpleButton nextPageButton;

    public RecipeHistoryPanel() {
        logic = Internal.bcGuiLogic.getRecipeHistoryPanelLogic();
    }

    @Override
    protected void renderElement(int mouseX, int mouseY) {
        renderDrawable(new DrawableColor(Color.ORANGE));
        prevPageButton.render(mouseX, mouseY);
        nextPageButton.render(mouseX, mouseY);
    }

    @Override
    public boolean onMouseClick(int mouseX, int mouseY, int mouseButton) {
        if(prevPageButton.onMouseClick(mouseX, mouseY, mouseButton)) {
            return true;
        } else if(nextPageButton.onMouseClick(mouseX, mouseY, mouseButton)) {
            return true;
        }


        return false;
    }

    @Override
    public void buildElement() {
        prevPageButton = new SimpleButton()
                .onClick(logic::prevPage)
                .bounds(getX(), getY(), 24, 24);

        nextPageButton = new SimpleButton()
                .onClick(logic::nextPage)
                .bounds(getX() + getWidth() - 24, getY(), 24, 24);
    }
}
