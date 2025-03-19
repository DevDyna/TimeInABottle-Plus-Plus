package com.devdyna.tiabplusplus.core;

import com.devdyna.tiabplusplus.Config;
import com.devdyna.tiabplusplus.utils.LevelUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class TimeProcess {

        private static long click = 0;
        private static long time;

        public static void addTime(boolean canBeSpammed, Level level, Player player, int value) {

                // LogUtils.getLogger().info("init:"+String.valueOf(i));

                if (level == null)
                        return;

                // show a warning about low chance
                if (Config.CHANCE_TIAB.get() < 100) {
                        Result.unsafeChance(level);
                }

                // verify if TIAB still on inventory
                if (!lib.checkforTIAB(player)) {
                        Result.missingTIAB(level);
                        return;
                }

                if (canBeSpammed && Config.SAFE_CLICK.get()) {

                        if (level.isClientSide)
                                return;

                        time = level.getLevelData().getGameTime() - click;

                        if (time < Config.SAFE_TICK_DELAY.get()) {
                                return;
                        } else {
                                if (level.random.nextInt(Config.CHANCE_TIAB.get()) == 0) {
                                        unsafeAddTime(level, player, value);
                                }
                        }

                        click = level.getLevelData().getGameTime();

                } else {
                        if (level.random.nextInt(Config.CHANCE_TIAB.get()) == 0) {
                                unsafeAddTime(level, player, value);
                        }
                }

        }

        public static void AddTimeByItem(Level level, Player player, int value) {
                if (lib.checkforTIAB(player))
                        unsafeAddTime(level, player, value);
                else
                        Result.missingTIAB(level);
        }

        private static void unsafeAddTime(Level level, Player player, int value) {
                if (!level.isClientSide()) {
                        ItemStack item = lib.getTIAB(player);
                        // add value of time to TIAB
                        lib.unckeckedAdd(item, value);
                        // select output to show
                        Rendering.outputSelect(
                                        Component.literal(Rendering.convertTicks(value) + " Seconds")
                                                        .withStyle(value < 0 ? ChatFormatting.RED
                                                                        : ChatFormatting.GREEN),
                                        player,
                                        level);

                }

                if (Config.PLAY_SOUND.get())
                        level.playSound(player, player.getOnPos(), SoundEvents.PLAYER_LEVELUP, SoundSource.AMBIENT,
                                        10,
                                        0.1f * LevelUtil.getRandomValue(9, level));
        }

}
