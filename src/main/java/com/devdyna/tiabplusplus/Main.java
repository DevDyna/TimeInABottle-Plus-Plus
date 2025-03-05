package com.devdyna.tiabplusplus;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.config.ModConfig;


@Mod(Main.MODID)
public class Main {

    public static final String MODID = "tiabplusplus";

    public Main(IEventBus modEventBus, ModContainer modContainer) {
    modContainer.registerConfig(ModConfig.Type.COMMON, Config.config);
        NeoForge.EVENT_BUS.register(new com.devdyna.tiabplusplus.Events());
    }
}
