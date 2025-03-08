package com.devdyna.tiabplusplus;

import com.devdyna.tiabplusplus.core.Config;
import com.devdyna.tiabplusplus.core.TimeWork;
import com.devdyna.tiabplusplus.utils.LevelUtil;

import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

public class Events {

        @SubscribeEvent
        public void RightClickBlock(PlayerInteractEvent.RightClickBlock event) {
                if (Config.EVENT_RightClickBlock.getAsBoolean()
                                && !event.getItemStack().is(Material.DENY_TIME_ITEM)
                                && !event.getLevel().getBlockState(event.getPos()).is(Material.DENY_TIME_BLOCK))
                        TimeWork.tryAddTime(event.getLevel(), event.getEntity(),
                                        LevelUtil.getRandomValue(
                                                        Config.MIN_VALUE_TIME.getAsInt() <= Config.MAX_VALUE_TIME
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
                                                        event.getLevel()));
        }

        @SubscribeEvent
        public void BreakEvent(BlockEvent.BreakEvent event) {
                if (Config.EVENT_BreakEvent.getAsBoolean()
                                && !event.getState().is(Material.DENY_TIME_BLOCK)
                                && !event.getPlayer().getMainHandItem().is(Material.DENY_TIME_ITEM))
                        TimeWork.tryAddTime((Level) event.getLevel(), event.getPlayer(),
                                        LevelUtil.getRandomValue(
                                                        Config.MIN_VALUE_TIME.getAsInt() <= Config.MAX_VALUE_TIME
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
                                                        (Level) event.getLevel()));
        }

        @SubscribeEvent
        public void EntityInteract(PlayerInteractEvent.EntityInteract event) {
                if (Config.EVENT_EntityInteract.getAsBoolean()
                                && !event.getItemStack().is(Material.DENY_TIME_ITEM))
                        TimeWork.tryAddTime(event.getLevel(), event.getEntity(),
                                        LevelUtil.getRandomValue(
                                                        Config.MIN_VALUE_TIME.getAsInt() <= Config.MAX_VALUE_TIME
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
                                                        event.getLevel()));
        }

        @SubscribeEvent
        public void LeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
                if (Config.EVENT_LeftClickBlock.getAsBoolean()
                                && !event.getItemStack().is(Material.DENY_TIME_ITEM)
                                && !event.getLevel().getBlockState(event.getPos()).is(Material.DENY_TIME_BLOCK))
                        TimeWork.tryAddTime(event.getLevel(), event.getEntity(),
                                        LevelUtil.getRandomValue(
                                                        Config.MIN_VALUE_TIME.getAsInt() <= Config.MAX_VALUE_TIME
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
                                                        event.getLevel()));
        }

        @SubscribeEvent
        public void RightClickItem(PlayerInteractEvent.RightClickItem event) {
                if (Config.EVENT_RightClickItem.getAsBoolean()
                                && !event.getItemStack().is(Material.DENY_TIME_ITEM)
                                && !event.getLevel().getBlockState(event.getPos()).is(Material.DENY_TIME_BLOCK))
                        TimeWork.tryAddTime(event.getLevel(), event.getEntity(),
                                        LevelUtil.getRandomValue(
                                                        Config.MIN_VALUE_TIME.getAsInt() <= Config.MAX_VALUE_TIME
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
                                                        event.getLevel()));
        }

}
