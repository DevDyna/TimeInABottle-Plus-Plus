package com.devdyna.tiabplusplus;

import com.devdyna.tiabplusplus.core.RandomTime;
import com.devdyna.tiabplusplus.core.TimeWork;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

public class Events {

        // block placed/clicked
        @SubscribeEvent
        public void RightClickBlock(PlayerInteractEvent.RightClickBlock event) {
                Level level = event.getLevel();
                Player player = event.getEntity();
                ItemStack item = event.getItemStack();
                BlockState state = level.getBlockState(event.getPos());

                if (Config.EVENT_RightClickBlock.getAsBoolean()
                                && (!Config.EVENT_RightClickBlock_AIR.getAsBoolean() || item.isEmpty())
                                && !item.is(Material.DENY_TIME_ITEM)
                                && !state.is(Material.DENY_TIME_BLOCK))
                        TimeWork.tryAddTime(level, player,
                                        RandomTime.randomTimeValue(level));
        }

        // block broken
        @SubscribeEvent
        public void BreakEvent(BlockEvent.BreakEvent event) {
                Level level = (Level) event.getLevel();
                Player player = event.getPlayer();
                ItemStack item = player.getMainHandItem();
                BlockState state = level.getBlockState(event.getPos());

                if (Config.EVENT_BreakEvent.getAsBoolean()
                                && (!Config.EVENT_BreakEvent_AIR.getAsBoolean() || item.isEmpty())
                                && !state.is(Material.DENY_TIME_BLOCK)
                                && !item.is(Material.DENY_TIME_ITEM))
                        TimeWork.tryAddTime(level, player,
                                        RandomTime.randomTimeValue(level));
        }

        // entity interact
        @SubscribeEvent
        public void EntityInteract(PlayerInteractEvent.EntityInteract event) {
                Level level = event.getLevel();
                Player player = event.getEntity();
                ItemStack item = event.getItemStack();
                // BlockState state = level.getBlockState(event.getPos());

                if (Config.EVENT_EntityInteract.getAsBoolean()
                                && (!Config.EVENT_EntityInteract_AIR.getAsBoolean() || item.isEmpty())
                                && !item.is(Material.DENY_TIME_ITEM))
                        TimeWork.tryAddTime(level, player,
                                        RandomTime.randomTimeValue(level));
        }

        // breaking stage
        @SuppressWarnings("unused")
        @SubscribeEvent
        public void LeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
                Level level = event.getLevel();
                Player player = event.getEntity();
                ItemStack item = event.getItemStack();
                BlockState state = level.getBlockState(event.getPos());

                if (Config.EVENT_LeftClickBlock.getAsBoolean()
                                && (!Config.EVENT_LeftClickBlock_AIR.getAsBoolean() || item.isEmpty())
                                && !item.is(Material.DENY_TIME_ITEM)
                                && !state.is(Material.DENY_TIME_BLOCK))
                        ;
        }

        // item use
        @SubscribeEvent
        public void RightClickItem(PlayerInteractEvent.RightClickItem event) {
                Level level = event.getLevel();
                Player player = event.getEntity();
                ItemStack item = event.getItemStack();
                BlockState state = level.getBlockState(event.getPos());

                if (Config.EVENT_RightClickItem.getAsBoolean()
                                && (!Config.EVENT_RightClickBlock_AIR.getAsBoolean() || item.isEmpty())
                                && !item.is(Material.DENY_TIME_ITEM)
                                && !state.is(Material.DENY_TIME_BLOCK))
                        TimeWork.tryAddTime(level, player,
                                        RandomTime.randomTimeValue(level));
        }

}
