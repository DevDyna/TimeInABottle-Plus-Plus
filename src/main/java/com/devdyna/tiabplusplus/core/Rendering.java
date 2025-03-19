package com.devdyna.tiabplusplus.core;

import com.devdyna.tiabplusplus.Config;
import com.haoict.tiab.common.core.ItemRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Rendering {

        public static String convertTicks(int ticks) {
                return String.format((ticks < 0 ? "-" : "+") + "%02d:%02d", (Math.abs(ticks) / 20) / 60,
                                (Math.abs(ticks) / 20) % 60);
        }

        public static void renderToast(Component text) {

                Minecraft.getInstance().getToasts().addToast(new Toast() {
                        @SuppressWarnings("null")
                        @Override
                        public Visibility render(GuiGraphics gui, ToastComponent comp, long delta) {

                                gui.blit(TEXTURE, 0, 0, 0, 0, 160, 32);
                                gui.renderFakeItem(new ItemStack(ItemRegistry.timeInABottleItem.get()), 8, 8);
                                gui.drawString(Minecraft.getInstance().font,
                                                text, 24, 12, 0);
                                return delta >= 1000L * comp.getNotificationDisplayTimeMultiplier()
                                                ? Toast.Visibility.HIDE
                                                : Toast.Visibility.SHOW;
                        }
                });
        }

        public static void outputSelect(Component text, Player player, Level level) {
                if (Config.SHOW_ACTION.get())
                        player.displayClientMessage(text, true);
                if (Config.SHOW_CHAT.get())
                        player.displayClientMessage(text, false);
                if (Config.SHOW_TOAST.get())
                        renderToast(text);
        }

}
