package com.darkenderhilda.alienized.foundation.network.packets.base;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public abstract class PacketBase <P extends PacketBase<P>>
        implements IMessage, IMessageHandler<P, IMessage> {

    @Override
    public void toBytes(ByteBuf buf) {
    }

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public final IMessage onMessage(P message, MessageContext ctx) {
        if(isClientToServerPacket()) {
            ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> handle(message, ctx));
        } else {
            Minecraft.getMinecraft().addScheduledTask(() -> handle(message, ctx));
        }

        return null;
    }

    protected abstract void handle(P message, MessageContext ctx);

    protected abstract boolean isClientToServerPacket();

}
