package com.devdyna.tiabplusplus.core;

import com.devdyna.tiabplusplus.Config;
import com.devdyna.tiabplusplus.Main;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;

public class Result {
    public static void missingTIAB(Level level) {
                if (Config.SHOW_ALERT.get() && !level.isClientSide())
                        Rendering.renderToast(
                                        Component.translatable("tip." + Main.MODID + ".missing")
                                                        .withStyle(ChatFormatting.BLUE));
        }
        
        // //Deprecated tip
        // public static void tooFast(Level level) {
        //         if (Config.SPAM_WARNING.getAsBoolean() && !level.isClientSide())
        //                 Rendering.renderToast(
        //                                 Component.translatable("tip." + Main.MODID + ".toofast")
        //                                                 .withStyle(ChatFormatting.BLUE));
        // }

        public static void unsafeChance(Level level){
                if (Config.CHANCE_WARNING.getAsBoolean())
                Rendering.renderToast(
                                Component.translatable("tip." + Main.MODID + ".highchance")
                                                .withStyle(ChatFormatting.BLUE));
        }
}
