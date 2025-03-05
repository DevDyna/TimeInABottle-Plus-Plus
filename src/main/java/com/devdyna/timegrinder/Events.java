package com.devdyna.timegrinder;

import java.util.List;

import org.mangorage.tiab.common.api.ICommonTimeInABottleAPI;
import org.mangorage.tiab.common.api.ITiabItemSearch;
import org.mangorage.tiab.common.core.StoredTimeComponent;
import org.mangorage.tiab.common.misc.CommonHelper;
import org.mangorage.tiab.neoforge.core.Registration;

import com.devdyna.timegrinder.utils.LevelUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;

public class Events {

    private int MIN = 1000;
    private int MAX = 10000;

    @SubscribeEvent
    public void RightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        tryAddTime(event.getLevel(), event.getEntity(), LevelUtil.getRandomValue(MIN, MAX, event.getLevel()));
    }

    @SubscribeEvent
    public void BreakEvent(BlockEvent.BreakEvent event) {
        tryAddTime((Level) event.getLevel(), event.getPlayer(),
                LevelUtil.getRandomValue(MIN, MAX, (Level) event.getLevel()));
    }

    @SubscribeEvent
    public void EntityInteract(PlayerInteractEvent.EntityInteract event) {
        tryAddTime(event.getLevel(), event.getEntity(), LevelUtil.getRandomValue(MIN, MAX, event.getLevel()));
    }

    @SubscribeEvent
    public void LeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        tryAddTime(event.getLevel(), event.getEntity(), LevelUtil.getRandomValue(MIN, MAX, event.getLevel()));
    }

    @SubscribeEvent
    public void RightClickItem(PlayerInteractEvent.RightClickItem event) {
        tryAddTime(event.getLevel(), event.getEntity(), LevelUtil.getRandomValue(MIN, MAX, event.getLevel()));
    }

    public void tryAddTime(Level level, Player player, int value) {
        // if (LevelUtil.getRandomValue(1000, level) <= 1000)
        if (LevelUtil.chance(25, level))
            for (ITiabItemSearch handler : ICommonTimeInABottleAPI.COMMON_API.get().getSearchHandlers()) {
                ItemStack item = handler.findItem(player);
                if (item != null && item.getItem() == Registration.TIAB_ITEM.get()) {
                    CommonHelper.modify(item, ICommonTimeInABottleAPI.COMMON_API.get()
                            .getRegistration().getStoredTime(), () -> new StoredTimeComponent(0, 0), old -> {
                                return (CommonHelper
                                        .isPositive(old.stored() + value) &&
                                        CommonHelper.isPositive(old.total() + value))
                                                ? new StoredTimeComponent(
                                                        Math.min(old.stored() + value,
                                                                ICommonTimeInABottleAPI.COMMON_API.get().getConfig()
                                                                        .MAX_STORED_TIME()),
                                                        old.total() + value)
                                                : old;
                            });
                    item.set(DataComponents.LORE, new ItemLore(
                            List.of(
                                    CommonHelper.getStoredTimeTranslated(item),
                                    CommonHelper.getTotalTimeTranslated(item))));
                    renderToast(convertTicks(value));
                    level.playLocalSound(player, SoundEvents.PLAYER_LEVELUP, SoundSource.AMBIENT, 10,
                            0.1f * LevelUtil.getRandomValue(9, level));
                    break;
                }

            }
    }

    public void renderToast(String text) {
        Minecraft minecraft = Minecraft.getInstance();

        minecraft.getToasts().addToast(new Toast() {

            @SuppressWarnings("null")
            @Override
            public Visibility render(GuiGraphics gui, ToastComponent comp, long delta) {
                gui.blitSprite(ResourceLocation.parse("toast/advancement"), 0, 0, 160, 32);
                gui.renderFakeItem(new ItemStack(Registration.TIAB_ITEM.get()), 8, 8);
                gui.drawString(minecraft.font,
                        Component.literal("+" + text + " Seconds").withStyle(ChatFormatting.AQUA), 24, 12, 0);

                return delta >= 1000L * comp.getNotificationDisplayTimeMultiplier()
                        ? Toast.Visibility.HIDE
                        : Toast.Visibility.SHOW;
            }

        });
    }

    public static String convertTicks(int ticks) {
        return String.format("%02d:%02d", (ticks / 20) / 60, (ticks / 20) % 60);
    }

}
