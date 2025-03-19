package com.devdyna.tiabplusplus.core;

import com.devdyna.tiabplusplus.Config;
import com.devdyna.tiabplusplus.Material;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.AnvilRepairEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.BonemealEvent;
import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;
import net.neoforged.neoforge.event.entity.player.ItemFishedEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEnchantItemEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.entity.player.UseItemOnBlockEvent;

public class Events {

    @SubscribeEvent
    public void e(AnvilRepairEvent e) {
        f(false, Config.E_ANVIL.getAsBoolean(), e.getEntity().level(), e.getEntity(), e.getOutput());
    }

    @SubscribeEvent
    public void e(AttackEntityEvent e) {
        f(true, Config.E_ATTACK_ENTITY.getAsBoolean(), e.getEntity().level(), e.getEntity(),
                e.getEntity().getItemInHand(e.getEntity().getUsedItemHand()));
    }

    @SubscribeEvent
    public void e(BonemealEvent e) {
        f(true, Config.E_BONEMEAL.getAsBoolean(), e.getLevel(), e.getPlayer(), e.getState(),
                e.getPlayer().getItemInHand(e.getPlayer().getUsedItemHand()));
    }

    @SubscribeEvent
    public void e(CriticalHitEvent e) {
        f(false, Config.E_CRIT_ATTACK.getAsBoolean(), e.getEntity().level(), e.getEntity(),
                e.getEntity().getItemInHand(e.getEntity().getUsedItemHand()));
    }

    @SubscribeEvent
    public void e(ItemFishedEvent e) {
        f(true, Config.E_FISHING.getAsBoolean(), e.getEntity().level(), e.getEntity(),
                e.getEntity().getItemInHand(e.getEntity().getUsedItemHand()));
    }

    @SubscribeEvent
    public void e(PlayerEnchantItemEvent e) {
        f(false, Config.E_ENCHANTING.getAsBoolean(), e.getEntity().level(), e.getEntity(), e.getEnchantedItem());
    }

    @SubscribeEvent
    public void e(UseItemOnBlockEvent e) {
        f(true, Config.E_ITEM_USE_BLOCK.getAsBoolean(), e.getLevel(), e.getPlayer(),
                e.getLevel().getBlockState(e.getPos()));
    }

    @SubscribeEvent
    public void e(PlayerInteractEvent.EntityInteract e) {
        f(true, Config.EP_ENTITY_INTERACT.getAsBoolean(), e.getLevel(), e.getEntity(), e.getItemStack());
    }

    // breaking block
    @SubscribeEvent
    public void e(PlayerInteractEvent.LeftClickBlock e) {
        f(true, Config.EP_LEFT_CLICK_BLOCK.getAsBoolean(), e.getLevel(), e.getEntity(), e.getItemStack(),
                e.getLevel().getBlockState(e.getPos()));
    }

    // item attack
    @SubscribeEvent
    public void e(PlayerInteractEvent.LeftClickEmpty e) {
        f(true, Config.EP_LEFT_CLICK_EMPTY.getAsBoolean(), e.getLevel(), e.getEntity(), e.getItemStack());
    }

    // block place / use
    @SubscribeEvent
    public void e(PlayerInteractEvent.RightClickBlock e) {
        f(true, Config.EP_RIGHT_CLICK_BLOCK.getAsBoolean(), e.getLevel(), e.getEntity(), e.getItemStack(),
                e.getLevel().getBlockState(e.getPos()));
    }

    // item used / eated
    @SubscribeEvent
    public void e(PlayerInteractEvent.RightClickEmpty e) {
        f(true, Config.EP_RIGHT_CLICK_EMPTY.getAsBoolean(), e.getLevel(), e.getEntity(), e.getItemStack(),
                e.getLevel().getBlockState(e.getPos()));
    }

    // item used / eated
    @SubscribeEvent
    public void e(PlayerInteractEvent.RightClickItem e) {
        f(true, Config.EP_RIGHT_CLICK_ITEM.getAsBoolean(), e.getLevel(), e.getEntity(), e.getItemStack());
    }

    @SubscribeEvent
    public void e(PlayerEvent.ItemCraftedEvent e) {
        f(true, Config.EP_CRAFTING.getAsBoolean(), e.getEntity().level(), e.getEntity(), e.getCrafting());
    }

    @SubscribeEvent
    public void e(PlayerEvent.ItemSmeltedEvent e) {
        f(false, Config.EP_SMELTING.getAsBoolean(), e.getEntity().level(), e.getEntity(), e.getSmelting());
    }

    public void f(Boolean s, Boolean c, Level l, Player p) {
        if (c && p.getUsedItemHand() == InteractionHand.MAIN_HAND)
            TimeProcess.addTime(s, l, p,
                    lib.randomTimeValue(l));
    }

    public void f(Boolean s, Boolean c, Level l, Player p, ItemStack i) {
        f(s, c && !i.is(Material.DENY_TIME_ITEM), l, p);
    }

    public void f(Boolean s, Boolean c, Level l, Player p, BlockState b) {
        f(s, c && !b.is(Material.DENY_TIME_BLOCK), l, p);
    }

    public void f(Boolean s, Boolean c, Level l, Player p, ItemStack i, BlockState b) {
        f(s, c && !b.is(Material.DENY_TIME_BLOCK), l, p, i);
    }

    public void f(Boolean s, Boolean c, Level l, Player p, BlockState b, ItemStack i) {
        f(s, c, l, p, i, b);
    }

}
