package com.devdyna.tiabplusplus;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();


    public static final ModConfigSpec.IntValue CHANCE_TIAB = builder
            .comment("Chance of success")
            .defineInRange("Chance", 100, 1, 100);

static final ModConfigSpec config = builder.build();
}
