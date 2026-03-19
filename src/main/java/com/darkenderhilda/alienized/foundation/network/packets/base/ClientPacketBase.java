package com.darkenderhilda.alienized.foundation.network.packets.base;

public abstract class ClientPacketBase <P extends ClientPacketBase<P>>
        extends PacketBase<P> {

    @Override
    protected final boolean isClientToServerPacket() {
        return false;
    }
}
