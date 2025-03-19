package com.devdyna.tiabplusplus.utils;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class LevelUtil {
    public static boolean isDimension(Level level, ResourceKey<Level> dim) {
        return level.dimension().equals(dim);
    }

    public static void SimplePlaceBlock(Level level, BlockPos pos, Block block) {
        level.setBlock(pos, block.defaultBlockState(), 32);
    }

    public static int ValidFaces(BlockPos pos, Level level, TagKey<Block> tag) {
        BlockPos[] dir = { pos.above(), pos.below(), pos.north(), pos.south(), pos.east(), pos.west() };
        int value = 0;
        for (BlockPos face : dir) {
            value += level.getBlockState(face).is(tag) ? 1 : 0;
        }
        return value;
    }

    @SuppressWarnings("deprecation")
    public static List<Holder<Block>> ResourceByTag(TagKey<Block> tag) {
        return BuiltInRegistries.BLOCK.getOrCreateTag(tag).stream().toList();
    }

    public static Block ResourceByTag(TagKey<Block> tag, int index) {
        return ResourceByTag(tag).get(index).value();
    }

    public static int getSizeTag(TagKey<Block> tag) {
        return ResourceByTag(tag).size() - 1;
    }

    public static void popItemFromPos(Level level, double x, double y, double z, ItemStack itemStack) {
        ItemEntity itementity = new ItemEntity(level,
                x,
                y,
                z,
                itemStack);
        level.addFreshEntity(itementity);
    }

    public static void popItemFromPos(Level level, int x, int y, int z, ItemStack itemStack) {
        popItemFromPos(level, (double) x, (double) y, (double) z, itemStack);
    }

    public static void popItemFromPos(LevelAccessor level, double x, double y, double z, ItemStack itemStack) {
        popItemFromPos((Level) level, x, y, z, itemStack);
    }

    // @SuppressWarnings("null")
    // public static List<ItemStack> getItemStackFromLootTable(LevelAccessor level, String raw_ore_name, float luck) {

    //     Builder builder = new LootParams.Builder((ServerLevel) level);
    //     LootParams params = builder.create(LootContextParamSets.EMPTY);
    //     builder.withLuck(luck);

    //     LootTable lootTable = level.getServer().reloadableRegistries()
    //             .getLootTable(ResourceKey
    //                     .create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(
    //                             IDUtil.getModName(raw_ore_name), "blocks/"
    //                                     + raw_ore_name.substring(raw_ore_name.lastIndexOf('.') + 1))));
    //     return lootTable.getRandomItems(params);

    // }

    // public static List<ItemStack> getItemStackFromLootTable(LevelAccessor level, String raw_ore_name) {
    //     return getItemStackFromLootTable(level, raw_ore_name, 1);
    // }

    // public static List<ItemStack> getItemStackFromLootTable(LevelAccessor level, String raw_ore_name, Player player) {
    //     return getItemStackFromLootTable(level, raw_ore_name, player.getLuck());
    // }

    // public static List<ItemStack> getItemStackFromLootTable(LevelAccessor level, BlockState state) {
    //     return getItemStackFromLootTable(level, state.getBlock().getDescriptionId(), 1);
    // }

    // example
    // /**
    //  * 
    //  * @param level
    //  * @param ModName          "minecraft"
    //  * @param resourcelocation "blocks/stone"
    //  * @return
    //  */
    // public static List<ItemStack> getItemStackFromLootTable(ServerLevel level, String ModName,
    //         String resourcelocation) {
    //     LootTable lootTable = level.getServer().reloadableRegistries()
    //             .getLootTable(ResourceKey
    //                     .create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(
    //                             ModName, resourcelocation)));
    //     return lootTable.getRandomItems(new LootParams.Builder(level).create(LootContextParamSets.EMPTY));
    // }

    /**
     * @return a value [0 , max] inclusive
     */
    public static int getRandomValue(int max, Level l) {
        if (max <= 0)
            return 1;

        return l.random.nextInt(max) + 1;
    }

    /**
     * @return a value [min , max] inclusive
     */
    public static int getRandomValue(int min, int max, Level l) {
        return getRandomValue(max, l) + min;
    }

    public static boolean chance(int v, Level l) {
        if (v == 0)
            return false;

        return getRandomValue(100, l) <= v;
    }

    public static boolean rnd50(Level l) {
        return chance(50, l);
    }

    public static BlockPos RandomPos3D(Level l, BlockPos pos) {
        BlockPos[] a = {
                pos.above(),
                pos.below(),
                pos.north(),
                pos.south(),
                pos.east(),
                pos.west()
        };

        BlockPos s = a[l.random.nextInt(6)];

        if (s.equals(pos.above()) || s.equals(pos.below())) {
            BlockPos[] b = {
                    s,
                    s.equals(pos.above()) ? pos.below() : pos.above(),
                    s.north(),
                    s.south(),
                    s.east(),
                    s.west()
            };
            return b[l.random.nextInt(6)];
        } else {
            return s;
        }

    }

}
