package com.darkenderhilda.alienized.foundation.network.packets.all_packets;

import com.darkenderhilda.alienized.foundation.network.packets.base.ServerPacketBase;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MirrorItemPacket
        extends ServerPacketBase<MirrorItemPacket> {

    private ItemStack stack;

    public MirrorItemPacket() {
    }

    public MirrorItemPacket(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeItemStack(buf, stack);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        stack = ByteBufUtils.readItemStack(buf);
    }

    @Override
    protected void handle(MirrorItemPacket message, MessageContext ctx) {
        final EntityPlayerMP player = ctx.getServerHandler().player;
        InventoryPlayer inventoryPlayer = player.inventory;
        inventoryPlayer.setItemStack(ItemStack.EMPTY);
        player.updateHeldItem();
        ItemStack stack = message.stack;
        stack.setStackDisplayName(stack.getDisplayName() + " (Mirrored)");
        inventoryPlayer.addItemStackToInventory(message.stack);
        player.world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, ((player.getRNG().nextFloat() - player.getRNG().nextFloat()) * 0.7F + 1.0F) * 2.0F);
    }


}
