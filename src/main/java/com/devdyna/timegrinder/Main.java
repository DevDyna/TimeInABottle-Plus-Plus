package com.devdyna.timegrinder;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

// import org.mangorage.tiab.*;


@Mod(Main.MODID)
public class Main {

    public static final String MODID = "timegrinder";

    public Main(IEventBus modEventBus, ModContainer modContainer) {
 
        NeoForge.EVENT_BUS.register(new Events());
    }
}
