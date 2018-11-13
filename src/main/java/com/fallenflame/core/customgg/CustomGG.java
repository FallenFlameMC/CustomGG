package com.fallenflame.core.customgg;

import com.fallenflame.core.customgg.gui.Select;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public class CustomGG extends JavaPlugin {

    private Select selectGUI;

    @Override
    public void onEnable() {
        this.getLogger().info(String.format("%s _____ _____", ChatColor.BLUE));
        this.getLogger().info(String.format("%s|  __ \\  __ \\", ChatColor.BLUE));
        this.getLogger().info(String.format("%s| |  \\/ |  \\/", ChatColor.BLUE));
        this.getLogger().info(String.format("%s| | __| | __          %sCustomGG", ChatColor.BLUE, ChatColor.AQUA));
        this.getLogger().info(String.format("%s| |_\\ \\ |_\\ \\        by %sJoeZwet", ChatColor.BLUE, ChatColor.RED));
        this.getLogger().info(String.format("%s \\____/\\____/", ChatColor.BLUE));
        this.getLogger().info("");

        selectGUI = new Select();
        this.getServer().getPluginManager().registerEvents(selectGUI, this);
        this.getCommand("gg").setExecutor(selectGUI);
    }

    @Override
    public void onDisable() {
        try {
            selectGUI.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
