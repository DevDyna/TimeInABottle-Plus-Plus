package com.devdyna.tiabplusplus;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
        private static final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        public static final ModConfigSpec.BooleanValue CONSUME_ITEM = builder
                        .comment("Debug items can be consumed")
                        .define("debugItemConsume", false);

        public static final ModConfigSpec.IntValue CHANCE_TIAB = builder
                        .comment("Chance of success 1/X")
                        .defineInRange("chance", 1000, 1, Integer.MAX_VALUE);

        public static final ModConfigSpec.BooleanValue SHOW_TOAST = builder
                        .comment("Show Toast")
                        .define("Toast", true);

        public static final ModConfigSpec.BooleanValue SHOW_CHAT = builder
                        .comment("Show on Chat")
                        .define("Chat", false);

        public static final ModConfigSpec.BooleanValue SHOW_ACTION = builder
                        .comment("Show on ActionBar")
                        .define("ActionBar", false);

        public static final ModConfigSpec.BooleanValue PLAY_SOUND = builder
                        .comment("Play sound on event triggered")
                        .define("Sound", true);

        public static final ModConfigSpec.BooleanValue SHOW_ALERT = builder
                        .comment("Show an alert when TIAB still missing")
                        .define("Alert", true);

        public static final ModConfigSpec.IntValue MIN_VALUE_TIME = builder
                        .comment("Min value of ticks of rewarding")
                        .defineInRange("min", 1000, 1, Integer.MAX_VALUE - 1);

        public static final ModConfigSpec.IntValue MAX_VALUE_TIME = builder
                        .comment("Max value of ticks of rewarding")
                        .defineInRange("max", 10000, 2, Integer.MAX_VALUE);

        public static final ModConfigSpec.BooleanValue CHANCE_WARNING = builder
                        .comment("Show toast to inform that was configured an unbalanced chance rate")
                        .define("chance_warning", true);

        public static final ModConfigSpec.BooleanValue SAFE_CLICK = builder
                        .comment("Enable/Disable clicker spam proof at many of events")
                        .comment("Events related:\n-AttackEntity\n-Bonemeal\n-Fishing\n-ItemUseBlock\n-EntityInteract\n-LeftClickBlock\n-LeftClickEmpty\n-RightClickBlock\n-RightClickEmpty\n-RightClickItem\n-ItemCrafted")
                        .define("safe_click", true);

        public static final ModConfigSpec.IntValue SAFE_TICK_DELAY = builder
                        .comment("Tick of delay before to accept the action as valid")
                        .comment("Too low will be unsafe for spam-clicking")
                        .defineInRange("safe_tick_delay", 4, 0, Integer.MAX_VALUE);

        public static final ModConfigSpec.BooleanValue E_ANVIL = builder
                        .comment("Anvil Repairing: This event could generate time")
                        .define("event_anvil", true);

        public static final ModConfigSpec.BooleanValue E_ATTACK_ENTITY = builder
                        .comment("Attack Entity: This event could generate time")
                        .define("event_attack_entity", false);

        public static final ModConfigSpec.BooleanValue E_BONEMEAL = builder
                        .comment("Bonemeal: This event could generate time")
                        .define("event_bonemeal", true);

        public static final ModConfigSpec.BooleanValue E_CRIT_ATTACK = builder
                        .comment("Critic Hit: This event could generate time")
                        .define("event_critic_attack", true);

        public static final ModConfigSpec.BooleanValue E_FISHING = builder
                        .comment("Fishing: This event could generate time")
                        .define("event_fishing", true);

        public static final ModConfigSpec.BooleanValue E_ENCHANTING = builder
                        .comment("Item Enchanting: This event could generate time")
                        .define("event_enchanting", true);

        public static final ModConfigSpec.BooleanValue E_ITEM_USE_BLOCK = builder
                        .comment("Item use on block: This event could generate time")
                        .define("event_item_use_block", true);

        public static final ModConfigSpec.BooleanValue EP_ENTITY_INTERACT = builder
                        .comment("Entity Interact: This event could generate time")
                        .define("event_entity_interact", false);

        public static final ModConfigSpec.BooleanValue EP_LEFT_CLICK_BLOCK = builder
                        .comment("Left Click Block: This event could generate time")
                        .define("event_left_click_block", false);

        public static final ModConfigSpec.BooleanValue EP_LEFT_CLICK_EMPTY = builder
                        .comment("Left Click Empty: This event could generate time")
                        .define("event_left_click_empty", false);

        public static final ModConfigSpec.BooleanValue EP_RIGHT_CLICK_BLOCK = builder
                        .comment("Right Click Block: This event could generate time")
                        .define("event_right_click_block", false);

        public static final ModConfigSpec.BooleanValue EP_RIGHT_CLICK_EMPTY = builder
                        .comment("Right Click Empty: This event could generate time")
                        .define("event_right_click_empty", false);

        public static final ModConfigSpec.BooleanValue EP_RIGHT_CLICK_ITEM = builder
                        .comment("Right Click Item: This event could generate time")
                        .define("event_right_click_item", false);

        public static final ModConfigSpec.BooleanValue EP_CRAFTING = builder
                        .comment("Crafting Items: This event could generate time")
                        .define("event_crafting", true);

        public static final ModConfigSpec.BooleanValue EP_SMELTING = builder
                        .comment("Smelting Items: This event could generate time")
                        .define("event_smelting", true);

        public static final ModConfigSpec configBuilder = builder.build();
}
