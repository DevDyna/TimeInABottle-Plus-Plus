package com.devdyna.tiabplusplus.core;

import java.util.List;

import javax.annotation.Nullable;

import com.devdyna.tiabplusplus.Config;
import com.devdyna.tiabplusplus.Main;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

@SuppressWarnings("null")
public class ItemTime extends Item {

    private boolean state;

    /**
     * Create an item that allow to debug your TIAB time stored
     * 
     * @param state define increase/decrease state [True|False]
     */
    public ItemTime(boolean state) {
        super(new Item.Properties().stacksTo(16));
        this.state = state;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (usedHand.equals(InteractionHand.MAIN_HAND))
            TimeProcess.AddTimeByItem(level, player, lib.randomTimeValue(level) * (state ? 1 : -1));

        if (Config.CONSUME_ITEM.get() && !player.isCreative())
            player.getItemInHand(usedHand).shrink(1);

        return InteractionResultHolder.pass(player.getItemInHand(usedHand));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {

        tooltipComponents.add(Component.translatable(
                "tip.item." + Main.MODID + "." + (state ? "plus" : "less")));

        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }

}
