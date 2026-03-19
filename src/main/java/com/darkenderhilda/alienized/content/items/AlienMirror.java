package com.darkenderhilda.alienized.content.items;

import com.darkenderhilda.alienized.Alienized;
import com.darkenderhilda.alienized.AllCreativeTabs;
import com.darkenderhilda.alienized.AllItems;
import com.darkenderhilda.alienized.foundation.ui.utils.GuiHandler;
import com.darkenderhilda.alienized.lib.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AlienMirror
        extends Item
        implements IHasModel {

    public AlienMirror() {
        setRegistryName(Alienized.asLocation("item_alien_mirror"));
        setTranslationKey(this.getRegistryName().toString());

        setCreativeTab(AllCreativeTabs.ALIENIZED_TAB);
        setMaxStackSize(1);

        AllItems.ITEMS.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        BlockPos pos = player.getPosition();
        if (!world.isRemote) {
            player.openGui(Alienized.INSTANCE, GuiHandler.ECGui, world, pos.getX(), pos.getY(), pos.getZ());
        }

        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public void registerModel() {
        Alienized.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
