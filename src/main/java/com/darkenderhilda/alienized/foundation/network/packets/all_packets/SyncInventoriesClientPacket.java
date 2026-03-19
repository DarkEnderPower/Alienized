package com.darkenderhilda.alienized.foundation.network.packets.all_packets;

import com.darkenderhilda.alienized.foundation.network.packets.base.ClientPacketBase;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.ArrayList;
import java.util.List;

public class SyncInventoriesClientPacket
        extends ClientPacketBase<SyncInventoriesClientPacket> {

    private final List<BlockPos> inventories = new ArrayList<>();

    public SyncInventoriesClientPacket() {
    }

    public SyncInventoriesClientPacket(List<BlockPos> inventories) {
        this.inventories.addAll(inventories);
    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    protected void handle(SyncInventoriesClientPacket message, MessageContext ctx) {

    }
}
