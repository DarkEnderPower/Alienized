package com.darkenderhilda.alienized.content.ui.gui.better_crafting_gui.inventory_finder;

import com.darkenderhilda.alienized.CreateConfig;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class InventoryFinderManager {


    public static void find(BlockPos blockPos) {
        AxisAlignedBB aabb = new AxisAlignedBB(blockPos);
        aabb.grow(CreateConfig.ECGuiSettings.inventoryFinderRange);

        BlockPos.getAllInBox(new BlockPos(aabb.minX, aabb.minY, aabb.minZ), new BlockPos( aabb.maxX, aabb.maxY, aabb.maxZ)).forEach(
                pos ->  {

                });
    }
}
