package com.devdyna.tiabplusplus;

import com.devdyna.tiabplusplus.core.ItemTime;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {

    public static void register(IEventBus bus) {
        zItems.register(bus);
    }

    public static final DeferredRegister.Items zItems = DeferredRegister.createItems(Main.MODID);

    public static final DeferredHolder<Item,ItemTime> PLUS = zItems.register("plus", ()->new ItemTime(true));
    public static final DeferredHolder<Item, ItemTime> LESS = zItems.register("less",()-> new ItemTime(false));

}
