package com.fallenflame.core.customgg.gui;

import com.fallenflame.fallenutil.chat.ChatUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
    public static class Colors {
        public static ItemStack black() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)15);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sBlack", ChatColor.BLACK));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack darkBlue() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)11);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sDark Blue", ChatColor.DARK_BLUE));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack darkGreen() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)13);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sDark Green", ChatColor.DARK_GREEN));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack darkAqua() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)9);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sDark Aqua", ChatColor.DARK_AQUA));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack darkRed() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)14);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sDark Red", ChatColor.DARK_RED));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack purple() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)10);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sPurple", ChatColor.DARK_PURPLE));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack gold() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)4);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sGold", ChatColor.GOLD));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack gray() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)8);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sGray", ChatColor.GRAY));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack darkGray() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)7);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sDark Gray", ChatColor.DARK_GRAY));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack blue() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)11);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sBlue", ChatColor.BLUE));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack green() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)5);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sGreen", ChatColor.GREEN));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack aqua() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)3);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sAqua", ChatColor.AQUA));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack red() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)14);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sRed", ChatColor.RED));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack lightPurple() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)2);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sLight Purple", ChatColor.LIGHT_PURPLE));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack yellow() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)4);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sYellow", ChatColor.YELLOW));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack white() {
            ItemStack stack = new ItemStack(Material.WOOL, (short)1, (short)0);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sWhite", ChatColor.WHITE));
            stack.setItemMeta(stackMeta);
            return stack;
        }
    }
    public static class Styles {
        public static ItemStack bars() {
            ItemStack stack = new ItemStack(Material.BLAZE_ROD);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%s%s!%sBars%s!%s", ChatColor.RESET, ChatColor.MAGIC, ChatColor.RESET, ChatColor.MAGIC, ChatColor.RESET));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack bold() {
            ItemStack stack = new ItemStack(Material.MAGMA_CREAM);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%s%sBold", ChatColor.RESET, ChatColor.BOLD));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack underline() {
            ItemStack stack = new ItemStack(Material.BLAZE_POWDER);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%s%sUnderline", ChatColor.RESET, ChatColor.UNDERLINE));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack italic() {
            ItemStack stack = new ItemStack(Material.SPECKLED_MELON);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%s%sItalic", ChatColor.RESET, ChatColor.ITALIC));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack strike() {
            ItemStack stack = new ItemStack(Material.GOLDEN_CARROT);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%s%sStrikethrough", ChatColor.RESET, ChatColor.STRIKETHROUGH));
            stack.setItemMeta(stackMeta);
            return stack;
        }
    }
    public static class Other {
        public static ItemStack back() {
            ItemStack stack = new ItemStack(Material.ARROW);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sBack", ChatColor.LIGHT_PURPLE));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack preview() {
            ItemStack stack = new ItemStack(Material.NAME_TAG);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(ChatUtil.replaceColorChars("&r&lPerview [WIP]"));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack cancel() {
            ItemStack stack = new ItemStack(Material.BARRIER);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(ChatUtil.replaceColorChars("&c&lCancel"));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack save() {
            ItemStack stack = new ItemStack(Material.INK_SACK, (short)1, (short)10);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sSave", ChatColor.GREEN));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack styles() {
            ItemStack stack = new ItemStack(Material.END_CRYSTAL);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sStyles", ChatColor.LIGHT_PURPLE));
            stack.setItemMeta(stackMeta);
            return stack;
        }
        public static ItemStack colors() {
            ItemStack stack = new ItemStack(Material.FEATHER);
            ItemMeta stackMeta = stack.getItemMeta();
            stackMeta.setDisplayName(String.format("%sColors", ChatColor.LIGHT_PURPLE));
            stack.setItemMeta(stackMeta);
            return stack;
        }
    }
}
