package com.devdyna.tiabplusplus.core;

import org.mangorage.tiab.neoforge.core.Registration;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class Rendering {


    public static void renderToast(Component text) {

        Minecraft.getInstance().getToasts().addToast(new Toast() {
            @SuppressWarnings("null")
            @Override
            public Visibility render(GuiGraphics gui, ToastComponent comp, long delta) {
                gui.blitSprite(ResourceLocation.parse("toast/advancement"), 0, 0, 160, 32);
                gui.renderFakeItem(new ItemStack(Registration.TIAB_ITEM.get()), 8, 8);
                gui.drawString(Minecraft.getInstance().font,
                        text, 24, 12, 0);
                return delta >= 1000L * comp.getNotificationDisplayTimeMultiplier()
                        ? Toast.Visibility.HIDE
                        : Toast.Visibility.SHOW;
            }
        });
    }

}
