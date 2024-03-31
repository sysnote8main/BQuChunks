package com.sysnote8.bquchunks;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = Tags.MODID,
        version = Tags.VERSION,
        name = Tags.MODNAME,
        acceptedMinecraftVersions = "[1.12.2]",
        dependencies = "required-after:betterquesting"
)
public class MainMod {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
