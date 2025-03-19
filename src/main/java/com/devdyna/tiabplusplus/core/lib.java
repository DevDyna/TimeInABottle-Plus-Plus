package com.devdyna.tiabplusplus.core;

import com.devdyna.tiabplusplus.Config;
import com.devdyna.tiabplusplus.utils.LevelUtil;
import com.haoict.tiab.common.config.NBTKeys;
import com.haoict.tiab.common.config.TiabConfig;
import com.haoict.tiab.common.core.ItemRegistry;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class lib {
        public static int randomTimeValue(Level level) {
                return LevelUtil.getRandomValue(Config.MIN_VALUE_TIME.get() <= Config.MAX_VALUE_TIME
                                .get()
                                                ? Config.MIN_VALUE_TIME
                                                                .get()
                                                : Config.MAX_VALUE_TIME
                                                                .get(),
                                Config.MIN_VALUE_TIME.get() >= Config.MAX_VALUE_TIME
                                                .get()
                                                                ? Config.MIN_VALUE_TIME
                                                                                .get()
                                                                : Config.MAX_VALUE_TIME
                                                                                .get(),
                                level);
        }

        public static boolean checkforTIAB(Player player) {
                return getTIAB(player) != null;
        }

        public static ItemStack getTIAB(Player player) {
                for (ItemStack item : player.getInventory().items) {
                        if (item != null && item.getItem() == ItemRegistry.timeInABottleItem.get()) {
                                return item;
                        }
                }
                return null;
        }

        public static void unckeckedAdd(ItemStack stack, int value) {
                int old_accumulated = stack.getOrCreateTag().getInt(NBTKeys.TOTAL_ACCUMULATED_TIME);
                int old_stored = stack.getOrCreateTag().getInt(NBTKeys.STORED_TIME);

                int accumulated = old_accumulated + Math.min(value, TiabConfig.COMMON.maxStoredTime.get());
                int stored = old_stored + Math.min(value, TiabConfig.COMMON.maxStoredTime.get());
                stack.getOrCreateTag().putInt(NBTKeys.TOTAL_ACCUMULATED_TIME,
                                accumulated > 0 ? Math.min(value, TiabConfig.COMMON.maxStoredTime.get())
                                                : old_accumulated);
                stack.getOrCreateTag().putInt(NBTKeys.STORED_TIME,
                                stored > 0 ? Math.min(value, TiabConfig.COMMON.maxStoredTime.get()) : old_stored);
        }
}
