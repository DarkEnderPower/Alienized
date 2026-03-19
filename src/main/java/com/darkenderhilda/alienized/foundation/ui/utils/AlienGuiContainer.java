package com.darkenderhilda.alienized.foundation.ui.utils;

import com.darkenderhilda.alienized.foundation.ui.elements.AbstractElement;
import com.darkenderhilda.alienized.foundation.ui.elements.utils.IInteractable;
import com.darkenderhilda.alienized.foundation.ui.elements.utils.InputHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AlienGuiContainer
        extends GuiContainer {

    protected final List<AbstractElement<?>> elements = new ArrayList<>();
    private final InputHandler inputHandler = new InputHandler();

    public AlienGuiContainer(Container p_i1072_1) {
        super(p_i1072_1);
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();

        inputHandler.handleMouseInput(getInteractables());
    }

    @Override
    public void handleKeyboardInput() throws IOException {
        super.handleKeyboardInput();

        inputHandler.handleKeyboardInput(getInteractables());
    }

    protected void element(AbstractElement<?> e) {
        elements.add(e);
    }

    protected List<IInteractable> getInteractables() {
        List<IInteractable> list = new ArrayList<>();

        for (AbstractElement<?> e : elements) {
            if(e instanceof IInteractable) {
                list.add((IInteractable) e);
            }
        }

        return list;
    }

    protected int getGuiRight() {
        return guiLeft + xSize;
    }

    protected int getGuiBottom() {
        return guiTop + ySize;
    }
}
