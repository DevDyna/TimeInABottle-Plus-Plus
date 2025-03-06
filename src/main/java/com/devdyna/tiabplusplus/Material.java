package com.devdyna.tiabplusplus;

import com.devdyna.tiabplusplus.core.ItemTime;
import com.devdyna.tiabplusplus.utils.RegUtil;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Material {

    public static void register(IEventBus bus) {
        zItems.register(bus);
    }

    public static final DeferredRegister.Items zItems = DeferredRegister.createItems(Main.MODID);

    public static final DeferredHolder<Item, ItemTime> PLUS = zItems.register("plus", () -> new ItemTime(true));
    public static final DeferredHolder<Item, ItemTime> LESS = zItems.register("less", () -> new ItemTime(false));

    public static final TagKey<Block> DENY_TIME_BLOCK = RegUtil.createtagBlock("deny_time");
    public static final TagKey<Item> DENY_TIME_ITEM = RegUtil.createtagItem("deny_time");

}
