package com.fallenflame.core.customgg.gui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
//[ 0][ 1][ 2][ 3][ 4][ 5][ 6][ 7][ 8]
//[ 9][10][11][12][13][14][15][16][17]
//[18][19][20][21][22][23][24][25][26]
public class GUI {

    public static Inventory gg() {
        Inventory inv = Bukkit.createInventory(null, 9, "Custom GG");
        inv.setItem(0, Items.Other.save());
        inv.setItem(2, Items.Other.styles());
        inv.setItem(4, Items.Other.preview());
        inv.setItem(6, Items.Other.colors());
        inv.setItem(8, Items.Other.cancel());

        return inv;
    }
    public static Inventory styles() {
        Inventory inv = Bukkit.createInventory(null, IInventorySize.ROW*2, "Custom GG - Styles");
        inv.setItem(0, Items.Other.back());
        inv.setItem(4, Items.Other.preview());
        inv.setItem(8, Items.Other.cancel());

        inv.setItem(11, Items.Styles.bars());
        inv.setItem(12, Items.Styles.bold());
        inv.setItem(13, Items.Styles.underline());
        inv.setItem(14, Items.Styles.italic());
        inv.setItem(15, Items.Styles.strike());

        return inv;
    }

    public static Inventory colors() {
        Inventory inv = Bukkit.createInventory(null, IInventorySize.ROW*2, "Custom GG - Colors");
        inv.setItem(0, Items.Other.back());
        inv.setItem(4, Items.Other.preview());
        inv.setItem(8, Items.Other.cancel());

        inv.setItem(9, Items.Colors.black());
        inv.setItem(10, Items.Colors.darkBlue());
        inv.setItem(11, Items.Colors.darkGreen());
        inv.setItem(12, Items.Colors.darkAqua());
        inv.setItem(13, Items.Colors.darkRed());
        inv.setItem(14, Items.Colors.purple());
        inv.setItem(15, Items.Colors.gold());
        inv.setItem(16, Items.Colors.gray());
        inv.setItem(17, Items.Colors.darkGray());
        inv.setItem(19, Items.Colors.blue());
        inv.setItem(20, Items.Colors.green());
        inv.setItem(21, Items.Colors.aqua());
        inv.setItem(22, Items.Colors.red());
        inv.setItem(23, Items.Colors.lightPurple());
        inv.setItem(24, Items.Colors.yellow());
        inv.setItem(25, Items.Colors.white());

        return inv;
    }


}
