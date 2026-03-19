package com.darkenderhilda.alienized;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AllCreativeTabs {

    public static final CreativeTabs ALIENIZED_TAB = new CreativeTabs("alienized_tab") {
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(Item.getItemFromBlock(Blocks.BEDROCK));
        }
    };
}
