package com.darkenderhilda.alienized.foundation.network.packets;

import com.darkenderhilda.alienized.Alienized;
import com.darkenderhilda.alienized.foundation.network.packets.all_packets.FindInventoriesPacket;
import com.darkenderhilda.alienized.foundation.network.packets.all_packets.MirrorItemPacket;
import com.darkenderhilda.alienized.foundation.network.packets.all_packets.OpenGuiPacket;
import com.darkenderhilda.alienized.foundation.network.packets.all_packets.SyncInventoriesClientPacket;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {

    public static SimpleNetworkWrapper INSTANCE;

    public static void init() {
        PacketHandler.INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Alienized.MOD_ID);
        int idx = 0;
        //client -> server
        PacketHandler.INSTANCE.registerMessage(OpenGuiPacket.class, OpenGuiPacket.class, idx++, Side.SERVER);
        PacketHandler.INSTANCE.registerMessage(MirrorItemPacket.class, MirrorItemPacket.class, idx++, Side.SERVER);
        PacketHandler.INSTANCE.registerMessage(FindInventoriesPacket.class, FindInventoriesPacket.class, idx++, Side.SERVER);
        //server -> client
        PacketHandler.INSTANCE.registerMessage(SyncInventoriesClientPacket.class, SyncInventoriesClientPacket.class, idx++, Side.CLIENT);
    }
}
