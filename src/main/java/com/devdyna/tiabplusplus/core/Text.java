package com.devdyna.tiabplusplus.core;

public class Text {
    public static String convertTicks(int ticks) {
        return String.format((ticks < 0 ? "-" : "+") + "%02d:%02d", (Math.abs(ticks) / 20) / 60,
                (Math.abs(ticks) / 20) % 60);
    }
}
