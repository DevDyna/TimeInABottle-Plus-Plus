package com.devdyna.tiabplusplus.core;

import org.mangorage.tiab.common.api.ICommonTimeInABottleAPI;
import org.mangorage.tiab.common.api.ITiabItemSearch;
import org.mangorage.tiab.common.api.impl.IStoredTimeComponent;
import org.mangorage.tiab.common.core.StoredTimeComponent;
import org.mangorage.tiab.common.misc.CommonHelper;
import org.mangorage.tiab.neoforge.core.Registration;

import com.devdyna.tiabplusplus.Config;
import com.devdyna.tiabplusplus.utils.LevelUtil;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class lib {
    public static int randomTimeValue(Level level) {
                return LevelUtil.getRandomValue(Config.MIN_VALUE_TIME.getAsInt() <= Config.MAX_VALUE_TIME
                                .getAsInt()
                                                ? Config.MIN_VALUE_TIME
                                                                .getAsInt()
                                                : Config.MAX_VALUE_TIME
                                                                .getAsInt(),
                                Config.MIN_VALUE_TIME.getAsInt() >= Config.MAX_VALUE_TIME
                                                .getAsInt()
                                                                ? Config.MIN_VALUE_TIME
                                                                                .getAsInt()
                                                                : Config.MAX_VALUE_TIME
                                                                                .getAsInt(),
                                level);
        }

        public static boolean checkforTIAB(Player player) {
                return getTIAB(player) != null;
        }

        public static ItemStack getTIAB(Player player) {
                for (ITiabItemSearch handler : ICommonTimeInABottleAPI.COMMON_API.get().getSearchHandlers()) {
                        ItemStack item = handler.findItem(player);
                        if (item != null && item.getItem() == Registration.TIAB_ITEM.get()) {
                                return item;
                        }
                }
                                return null;
        }

        public static IStoredTimeComponent unckeckedAdd(IStoredTimeComponent old, int value) {
                return CommonHelper
                                .isPositive(old.stored() + value) &&
                                CommonHelper.isPositive(
                                                old.total() + value)
                                                                ? new StoredTimeComponent(
                                                                                Math.min(old.stored()
                                                                                                + value,
                                                                                                ICommonTimeInABottleAPI.COMMON_API
                                                                                                                .get()
                                                                                                                .getConfig()
                                                                                                                .MAX_STORED_TIME()),
                                                                                old.total() + value)
                                                                : old;
        }
}
