package com.devdyna.tiabplusplus;


import com.devdyna.tiabplusplus.core.ItemTime;
import com.devdyna.tiabplusplus.utils.RegUtil;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Material {

    public static void register(IEventBus bus) {
        zItems.register(bus);
    }

    public static final DeferredRegister<Item> zItems = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
    

    public static final RegistryObject<Item> PLUS = zItems.register("plus", () -> new ItemTime(true));
    public static final RegistryObject<Item> LESS = zItems.register("less", () -> new ItemTime(false));

    public static final TagKey<Block> DENY_TIME_BLOCK = RegUtil.createtagBlock("deny_time");
    public static final TagKey<Item> DENY_TIME_ITEM = RegUtil.createtagItem("deny_time");

}
