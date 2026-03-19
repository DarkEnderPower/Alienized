package com.darkenderhilda.alienized;

import com.darkenderhilda.alienized.foundation.network.packets.PacketHandler;
import com.darkenderhilda.alienized.foundation.proxy.CommonProxy;
import com.darkenderhilda.alienized.foundation.ui.utils.GuiHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Alienized.MOD_ID, name = Alienized.MOD_NAME, version = Alienized.VERSION)
public class Alienized {

    @Deprecated
    public static final boolean debug = true;

    public static final String MOD_ID = "alienized";
    public static final String MOD_NAME = "Alienized";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(Alienized.MOD_ID)
    public static Alienized INSTANCE;

    @SidedProxy(clientSide = "com.darkenderhilda.alienized.foundation.proxy.ClientProxy",
                serverSide = "com.darkenderhilda.alienized.foundation.proxy.CommonProxy")
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        PacketHandler.init();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GuiHandler.init();
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    public static ResourceLocation asLocation(String name) {
        return new ResourceLocation(Alienized.MOD_ID, name);
    }
}
