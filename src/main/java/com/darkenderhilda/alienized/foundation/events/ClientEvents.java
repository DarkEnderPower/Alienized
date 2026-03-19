package com.darkenderhilda.alienized.foundation.events;

import com.darkenderhilda.alienized.Internal;
import com.darkenderhilda.alienized.foundation.utils.MouseHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.GuiContainerEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onGuiOpen(GuiOpenEvent event) {



    }

    @SubscribeEvent
    public static void onGuiInit(GuiScreenEvent.InitGuiEvent.Post event) {
        Internal.itemSliderLogic.handlerGuiOpen();
        Internal.alienOverlay.onGuiInit(event.getGui());
    }

    /**
     * Draws above most GuiContainer elements, but below the tooltips.
     */
    @SubscribeEvent
    public static void onDrawForeground(GuiContainerEvent.DrawForeground event) {
    }

    @SubscribeEvent
    public static void onDrawForegroundPre(GuiScreenEvent.DrawScreenEvent.Pre event) {

    }


    @SubscribeEvent
    public static void onDrawForegroundPost(GuiScreenEvent.DrawScreenEvent.Post event) {
        int mouseX = MouseHelper.getMouseX();
        int mouseY = MouseHelper.getMouseY();
        Internal.alienOverlay.render(event.getGui(), mouseX, mouseY);
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if(event.phase == TickEvent.Phase.START) return;

        MouseHelper.update();

        if(Minecraft.getMinecraft().world == null) return;

        Internal.itemSliderLogic.update();
        Internal.alienOverlay.update();
    }

    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        IRecipe recipe = CraftingManager.findMatchingRecipe((InventoryCrafting) event.craftMatrix, event.player.world);
        Internal.recipeHistoryManager.addNewRecipe(recipe);
    }

    @SubscribeEvent
    public static void onItemTooltip(RenderTooltipEvent.Pre event) {
        event.setCanceled(Internal.alienOverlay.isVisible());
    }

    @SubscribeEvent
    public static void onPotionShift(GuiScreenEvent.PotionShiftEvent event) {

    }
}
