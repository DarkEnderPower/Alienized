package com.darkenderhilda.alienized.foundation.network.packets.all_packets;

import com.darkenderhilda.alienized.Alienized;
import com.darkenderhilda.alienized.foundation.network.packets.base.ServerPacketBase;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class OpenGuiPacket
        extends ServerPacketBase<OpenGuiPacket> {

    private int guiId;

    public OpenGuiPacket() {
    }

    public OpenGuiPacket(int guiId) {
        this.guiId = guiId;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(guiId);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        guiId = buf.readInt();
    }

    @Override
    protected void handle(OpenGuiPacket message, MessageContext ctx) {
        final EntityPlayerMP player = ctx.getServerHandler().player;
        final BlockPos pos = player.getPosition();
        player.openGui(Alienized.INSTANCE, message.guiId, player.world, pos.getX(), pos.getY(), pos.getZ());
    }
}
