package com.devdyna.tiabplusplus.core;

import java.util.List;

import org.mangorage.tiab.common.api.ICommonTimeInABottleAPI;
import org.mangorage.tiab.common.core.StoredTimeComponent;
import org.mangorage.tiab.common.misc.CommonHelper;
import com.devdyna.tiabplusplus.Config;
import com.devdyna.tiabplusplus.utils.LevelUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.Level;

public class TimeProcess {

        private static long click = 0;
        private static long time;

        public static void addTime(boolean canBeSpammed, Level level, Player player, int value) {

                // LogUtils.getLogger().info("init:"+String.valueOf(i));

                if (level == null)
                        return;

                // show a warning about low chance
                if (Config.CHANCE_TIAB.getAsInt() < 100) {
                        Result.unsafeChance(level);
                }

                // verify if TIAB still on inventory
                if (!lib.checkforTIAB(player)) {
                        Result.missingTIAB(level);
                        return;
                }

                if (canBeSpammed && Config.SAFE_CLICK.getAsBoolean()) {

                        if (level.isClientSide)
                                return;

                        time = level.getLevelData().getGameTime() - click;

                        if (time < Config.SAFE_TICK_DELAY.getAsInt()) {
                                return;
                        } else {
                                if (level.random.nextInt(Config.CHANCE_TIAB.getAsInt()) == 0) {
                                        unsafeAddTime(level, player, value);
                                }
                        }

                        click = level.getLevelData().getGameTime();

                } else {
                        if (level.random.nextInt(Config.CHANCE_TIAB.getAsInt()) == 0) {
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
                        CommonHelper.modify(item, ICommonTimeInABottleAPI.COMMON_API.get()
                                        .getRegistration().getStoredTime(),
                                        () -> new StoredTimeComponent(0, 0),
                                        old -> lib.unckeckedAdd(old, value));
                        // update lore item
                        item.set(DataComponents.LORE, new ItemLore(
                                        List.of(
                                                        CommonHelper.getStoredTimeTranslated(item),
                                                        CommonHelper.getTotalTimeTranslated(item))));
                        // select output to show
                        Rendering.outputSelect(
                                        Component.literal(Rendering.convertTicks(value) + " Seconds")
                                                        .withStyle(value < 0 ? ChatFormatting.RED
                                                                        : ChatFormatting.GREEN),
                                        player,
                                        level);

                }

                if (Config.PLAY_SOUND.getAsBoolean())
                        level.playLocalSound(player, SoundEvents.PLAYER_LEVELUP, SoundSource.AMBIENT,
                                        10,
                                        0.1f * LevelUtil.getRandomValue(9, level));
        }

}
