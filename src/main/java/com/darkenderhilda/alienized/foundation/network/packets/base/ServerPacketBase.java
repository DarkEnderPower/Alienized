package com.darkenderhilda.alienized.foundation.network.packets.base;

public abstract class ServerPacketBase<P extends ServerPacketBase<P>>
        extends PacketBase<P> {

    @Override
    protected final boolean isClientToServerPacket() {
        return true;
    }
}
