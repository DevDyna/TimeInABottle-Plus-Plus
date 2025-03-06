package com.devdyna.tiabplusplus.core;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();


    public static final ModConfigSpec.IntValue CHANCE_TIAB = builder
            .comment("Chance of success 1/X")
            .defineInRange("chance", 1000, 1, Integer.MAX_VALUE);

            public static final ModConfigSpec.BooleanValue SHOW_TOAST = builder
            .comment("Show Toast")
            .define("Toast",true);

            public static final ModConfigSpec.BooleanValue SHOW_CHAT = builder
            .comment("Show on Chat")
            .define("Chat",false);

            public static final ModConfigSpec.BooleanValue SHOW_ACTION = builder
            .comment("Show on ActionBar")
            .define("ActionBar",false);

            public static final ModConfigSpec.BooleanValue PLAY_SOUND = builder
            .comment("Play sound on event triggered")
            .define("Sound",true);

            public static final ModConfigSpec.BooleanValue SHOW_ALERT = builder
            .comment("Show an alert when TIAB still missing")
            .define("Alert",true);

            public static final ModConfigSpec.BooleanValue EVENT_RightClickBlock = builder
            .comment("This event could generate time")
            .define("status",true);

            public static final ModConfigSpec.BooleanValue EVENT_BreakEvent = builder
            .comment("This event could generate time")
            .define("status",true);

            public static final ModConfigSpec.BooleanValue EVENT_EntityInteract = builder
            .comment("This event could generate time")
            .define("status",true);

            public static final ModConfigSpec.BooleanValue EVENT_LeftClickBlock = builder
            .comment("This event could generate time")
            .define("status",true);

            public static final ModConfigSpec.BooleanValue EVENT_RightClickItem = builder
            .comment("This event could generate time")
            .define("status",true);

            public static final ModConfigSpec.IntValue MIN_VALUE_TIME = builder
            .comment("Min value of ticks of rewarding")
            .defineInRange("min", 1000, 1, Integer.MAX_VALUE-1);

            public static final ModConfigSpec.IntValue MAX_VALUE_TIME = builder
            .comment("Max value of ticks of rewarding")
            .defineInRange("max", 10000, 2, Integer.MAX_VALUE);
            

            public static final ModConfigSpec configBuilder = builder.build();
}
