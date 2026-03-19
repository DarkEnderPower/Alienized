package com.darkenderhilda.alienized.foundation.ui.utils;

import com.darkenderhilda.alienized.Alienized;
import com.darkenderhilda.alienized.content.ui.gui.better_crafting_gui.BCContainer;
import com.darkenderhilda.alienized.content.ui.gui.better_crafting_gui.BCGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.jspecify.annotations.Nullable;


public class GuiHandler
        implements IGuiHandler {

    public static final int ECGui = 0;

    public static void init() {
        NetworkRegistry.INSTANCE.registerGuiHandler(Alienized.INSTANCE, new GuiHandler());
    }

    @Override
    public @Nullable Object getClientGuiElement(int ID, EntityPlayer player, World world, int j, int k, int l) {
        switch (ID) {
            case ECGui:
                return new BCGui(new BCContainer(player.inventory, world));
        }

        return null;
    }

    @Override
    public @Nullable Object getServerGuiElement(int ID, EntityPlayer player, World world, int j, int k, int l) {
        switch (ID) {
            case ECGui:
                return new BCContainer(player.inventory, world);
        }

        return null;
    }
}
