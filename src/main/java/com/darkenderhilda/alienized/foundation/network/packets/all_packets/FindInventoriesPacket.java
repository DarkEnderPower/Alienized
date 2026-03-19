package com.darkenderhilda.alienized.foundation.network.packets.all_packets;

import com.darkenderhilda.alienized.foundation.network.packets.base.ServerPacketBase;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class FindInventoriesPacket
        extends ServerPacketBase<FindInventoriesPacket> {

    private BlockPos pos;


    public FindInventoriesPacket() {
    }

    public FindInventoriesPacket(BlockPos pos) {
        this.pos = pos;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(pos.getX());
        buf.writeInt(pos.getY());
        buf.writeInt(pos.getZ());
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
    }

    @Override
    protected void handle(FindInventoriesPacket message, MessageContext ctx) {

    }
}
