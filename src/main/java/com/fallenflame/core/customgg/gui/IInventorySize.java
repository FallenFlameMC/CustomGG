package com.fallenflame.core.customgg.gui;

public interface IInventorySize {
    int ROW = 9;
    int CHEST = 27;

    static int getRows(int rows) {
        return ROW * rows;
    }
}
