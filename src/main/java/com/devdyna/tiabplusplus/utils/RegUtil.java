package com.devdyna.tiabplusplus.utils;

import com.devdyna.tiabplusplus.Main;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class RegUtil {

    public static TagKey<Item> createtagItem(String name) {
        return ForgeRegistries.ITEMS.tags().createTagKey(ResourceLocation.tryBuild(Main.MODID, name));
    }

    public static TagKey<Block> createtagBlock(String name) {
        return ForgeRegistries.BLOCKS.tags().createTagKey(ResourceLocation.tryBuild(Main.MODID, name));

    }

}
