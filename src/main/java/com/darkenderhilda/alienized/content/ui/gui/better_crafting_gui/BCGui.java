package com.darkenderhilda.alienized.content.ui.gui.better_crafting_gui;

import com.darkenderhilda.alienized.Alienized;
import com.darkenderhilda.alienized.AllColors;
import com.darkenderhilda.alienized.Internal;
import com.darkenderhilda.alienized.content.ui.gui.better_crafting_gui.recipe_history_panel.RecipeHistoryPanel;
import com.darkenderhilda.alienized.foundation.ui.utils.AlienGuiContainer;
import com.darkenderhilda.alienized.foundation.ui.utils.GuiRender;
import com.darkenderhilda.alienized.foundation.ui.render.drawables.DrawableResource;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

@SideOnly(Side.CLIENT)
public class BCGui
        extends AlienGuiContainer {

    private static final ResourceLocation CRAFTING_TABLE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/crafting_table.png");

    private final BCGuiLogic logic;

    private RecipeHistoryPanel recipeHistoryPanel;

    public static final DrawableResource drawable = new DrawableResource(Alienized.asLocation("textures/ui/ecgui/entry_brown.png"));
    public static final DrawableResource drawable2 = new DrawableResource(Alienized.asLocation("textures/ui/ecgui/entry_green.png"));

    public BCGui(Container container) {
        super(container);

        logic = Internal.bcGuiLogic;
    }

    @Override
    public void initGui() {
        super.initGui();

        int rightAreaWidth = (width - getGuiRight() - 5) / 24 * 24;

        int elementCount = (height - 40 - 48) / 24;
        if(elementCount % 2 != 0) {
            elementCount--;
        }
        int rightAreaHeight = elementCount * 24 + 40;
        int rightAreaX = width - rightAreaWidth;
        int rightAreaY = (height - rightAreaHeight) / 2;

        element(recipeHistoryPanel = new RecipeHistoryPanel()
                .bounds(rightAreaX, rightAreaY + (float) rightAreaHeight / 2, rightAreaWidth, (float) rightAreaHeight / 2));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GuiRender.drawModGuiBackground(this);
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);

        GuiRender.drawRect(15, 15, 50, 50, 0, Color.DARK_GRAY);
        GuiRender.drawRect(10, 10, 50, 50, 0, AllColors.MOD_COLOR);


        recipeHistoryPanel.render(mouseX, mouseY);

        drawable.draw(80, 80, 24, 24);
        drawable2.draw(104, 80, 24, 24);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(CRAFTING_TABLE_GUI_TEXTURES);
        int i = this.guiLeft;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRenderer.drawString(I18n.format("container.crafting"), 28, 6, 4210752);
        this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }
}
