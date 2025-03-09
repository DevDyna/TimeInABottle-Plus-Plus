package com.devdyna.tiabplusplus.core;

import java.util.List;

import org.mangorage.tiab.common.api.ICommonTimeInABottleAPI;
import org.mangorage.tiab.common.api.ITiabItemSearch;
import org.mangorage.tiab.common.core.StoredTimeComponent;
import org.mangorage.tiab.common.misc.CommonHelper;
import org.mangorage.tiab.neoforge.core.Registration;

import com.devdyna.tiabplusplus.Config;
import com.devdyna.tiabplusplus.Main;
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

public class TimeWork {

        private static long click = 0;

        public static boolean addTime(Level level, Player player, int value) {
                for (ITiabItemSearch handler : ICommonTimeInABottleAPI.COMMON_API.get().getSearchHandlers()) {
                        ItemStack item = handler.findItem(player);
                        if (item != null && item.getItem() == Registration.TIAB_ITEM.get()) {
                                if (!level.isClientSide())
                                        CommonHelper.modify(item, ICommonTimeInABottleAPI.COMMON_API.get()
                                                        .getRegistration().getStoredTime(),
                                                        () -> new StoredTimeComponent(0, 0),
                                                        old -> {
                                                                return (CommonHelper
                                                                                .isPositive(old.stored() + value) &&
                                                                                CommonHelper.isPositive(
                                                                                                old.total() + value))
                                                                                                                ? new StoredTimeComponent(
                                                                                                                                Math.min(old.stored()
                                                                                                                                                + value,
                                                                                                                                                ICommonTimeInABottleAPI.COMMON_API
                                                                                                                                                                .get()
                                                                                                                                                                .getConfig()
                                                                                                                                                                .MAX_STORED_TIME()),
                                                                                                                                old.total() + value)
                                                                                                                : old;
                                                        });
                                if (!level.isClientSide())
                                        item.set(DataComponents.LORE, new ItemLore(
                                                        List.of(
                                                                        CommonHelper.getStoredTimeTranslated(item),
                                                                        CommonHelper.getTotalTimeTranslated(item))));
                                if (!level.isClientSide())
                                        Rendering.outputSelect(
                                                        Component.literal(Rendering.convertTicks(value) + " Seconds")
                                                                        .withStyle(value < 0 ? ChatFormatting.RED
                                                                                        : ChatFormatting.GREEN),
                                                        player,
                                                        level);

                                if (Config.PLAY_SOUND.getAsBoolean())
                                        level.playLocalSound(player, SoundEvents.PLAYER_LEVELUP, SoundSource.AMBIENT,
                                                        10,
                                                        0.1f * LevelUtil.getRandomValue(9, level));

                                return true;
                        }

                }
                return false;
        }

        public static void tryAddTime(Level level, Player player, int value) {
                click = level.getLevelData().getGameTime();

                if (level != null && !level.isClientSide && level.getLevelData().getGameTime() - click < 4) {
                        if (Config.SPAM_WARNING.getAsBoolean())
                                Rendering.renderToast(
                                                Component.translatable("tip." + Main.MODID + ".toofast")
                                                                .withStyle(ChatFormatting.BLUE));
                        return;
                }

                if (Config.CHANCE_TIAB.getAsInt() < 100) {
                        if (Config.CHANCE_WARNING.getAsBoolean())
                                Rendering.renderToast(
                                                Component.translatable("tip." + Main.MODID + ".highchance")
                                                                .withStyle(ChatFormatting.BLUE));
                        return;
                }

                if (level.random.nextInt(Config.CHANCE_TIAB.getAsInt()) == 0)
                        verifyTIAB(level, player, value);

        }

        public static void verifyTIAB(Level level, Player player, int value) {
                if (!addTime(level, player, value) && Config.SHOW_ALERT.get() && !level.isClientSide())
                        Rendering.renderToast(
                                        Component.translatable("tip." + Main.MODID + ".missing")
                                                        .withStyle(ChatFormatting.BLUE));

        }

}
