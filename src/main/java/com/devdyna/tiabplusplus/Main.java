package com.devdyna.tiabplusplus;

import com.devdyna.tiabplusplus.core.Events;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MODID)
public class Main {
    
        public static final String MODID = "tiabplusplus";
    


    public Main() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // config
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.configBuilder);
        // item reg
        Material.register(modEventBus);
        // events
        MinecraftForge.EVENT_BUS.register(new Events());
        // tab reg
        modEventBus.addListener(CreativeTab::addCreative);

    }

}
