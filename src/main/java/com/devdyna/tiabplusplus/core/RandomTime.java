package com.devdyna.tiabplusplus.core;

import com.devdyna.tiabplusplus.Config;
import com.devdyna.tiabplusplus.utils.LevelUtil;

import net.minecraft.world.level.Level;

public class RandomTime {

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

}
