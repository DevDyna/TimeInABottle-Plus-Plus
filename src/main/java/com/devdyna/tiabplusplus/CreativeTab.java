package com.devdyna.tiabplusplus;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

public class CreativeTab {
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES)
            Material.zItems.getEntries().forEach(e -> {
                event.accept((Item) e.get());
            });

    }
}
