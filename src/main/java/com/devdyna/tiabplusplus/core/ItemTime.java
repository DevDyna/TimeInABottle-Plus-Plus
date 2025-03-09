package com.devdyna.tiabplusplus.core;

import java.util.List;

import com.devdyna.tiabplusplus.Config;
import com.devdyna.tiabplusplus.Main;
import com.devdyna.tiabplusplus.utils.LevelUtil;

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
        if(usedHand.equals(InteractionHand.MAIN_HAND))
        TimeWork.verifyTIAB(level, player,
                LevelUtil.getRandomValue(Config.MIN_VALUE_TIME.getAsInt() <= Config.MAX_VALUE_TIME
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
                                                .getAsInt(), level) * (state ? 1 : -1));
        return InteractionResultHolder.pass(player.getItemInHand(usedHand));

    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
            TooltipFlag tooltipFlag) {

        tooltipComponents.add(Component.translatable(
                "tip.item." + Main.MODID + "." + (state ? "plus" : "less")));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

}
