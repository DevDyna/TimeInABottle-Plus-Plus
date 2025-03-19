package com.devdyna.tiabplusplus;

import com.devdyna.tiabplusplus.core.Events;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.config.ModConfig;

@Mod(Main.MODID)
public class Main {

    public static final String MODID = "tiabplusplus";

    public Main(IEventBus modEventBus, ModContainer modContainer) {
        //config
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.configBuilder);
        //item reg
        Material.register(modEventBus);
        //events
        NeoForge.EVENT_BUS.register(new Events());
        //tab reg
        modEventBus.addListener(CreativeTab::addCreative);
    }

    
}
