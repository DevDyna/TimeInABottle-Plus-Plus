package com.devdyna.tiabplusplus;

import org.mangorage.tiab.neoforge.core.Registration;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class CreativeTab {
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == Registration.TIAB_CREATIVE_TAB.getKey())
            Material.zItems.getEntries().forEach(e -> {
                event.accept((Item) e.get());
            });

    }
}
