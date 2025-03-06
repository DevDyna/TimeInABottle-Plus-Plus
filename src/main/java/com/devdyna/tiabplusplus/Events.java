package com.devdyna.tiabplusplus;

import com.devdyna.tiabplusplus.core.Config;
import com.devdyna.tiabplusplus.core.LevelUtil;
import com.devdyna.tiabplusplus.core.TimeWork;

import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

public class Events {

    public static int MIN = 1000;
    public static int MAX = 10000;

    @SubscribeEvent
    public void RightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if(Config.EVENT_RightClickBlock.getAsBoolean())
        TimeWork.tryAddTime(event.getLevel(), event.getEntity(),
                LevelUtil.getRandomValue(MIN, MAX, event.getLevel()));
    }

    @SubscribeEvent
    public void BreakEvent(BlockEvent.BreakEvent event) {
        if(Config.EVENT_BreakEvent.getAsBoolean())
        TimeWork.tryAddTime((Level) event.getLevel(), event.getPlayer(),
                LevelUtil.getRandomValue(MIN, MAX, (Level) event.getLevel()));
    }

    @SubscribeEvent
    public void EntityInteract(PlayerInteractEvent.EntityInteract event) {
        if(Config.EVENT_EntityInteract.getAsBoolean())
        TimeWork.tryAddTime(event.getLevel(), event.getEntity(),
                LevelUtil.getRandomValue(MIN, MAX, event.getLevel()));
    }

    @SubscribeEvent
    public void LeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        if(Config.EVENT_LeftClickBlock.getAsBoolean())
        TimeWork.tryAddTime(event.getLevel(), event.getEntity(),
                LevelUtil.getRandomValue(MIN, MAX, event.getLevel()));
    }

    @SubscribeEvent
    public void RightClickItem(PlayerInteractEvent.RightClickItem event) {
        if(Config.EVENT_RightClickItem.getAsBoolean())
        TimeWork.tryAddTime(event.getLevel(), event.getEntity(),
                LevelUtil.getRandomValue(MIN, MAX, event.getLevel()));
    }

}
