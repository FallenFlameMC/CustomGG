package com.fallenflame.core.customgg;

import com.fallenflame.core.customgg.gui.GUIHandler;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public class CustomGG extends JavaPlugin {

    private GUIHandler GUIHandlerGUI;
    public static CustomGG instance;

    @Override
    public void onEnable() {
        instance = this;
        this.getLogger().info(String.format("%s _____ _____", ChatColor.BLUE));
        this.getLogger().info(String.format("%s|  __ \\  __ \\", ChatColor.BLUE));
        this.getLogger().info(String.format("%s| |  \\/ |  \\/", ChatColor.BLUE));
        this.getLogger().info(String.format("%s| | __| | __    %sCustomGG %sv%s", ChatColor.BLUE, ChatColor.AQUA, ChatColor.GOLD, this.getDescription().getVersion()));
        this.getLogger().info(String.format("%s| |_\\ \\ |_\\ \\   by %sJoeZwet", ChatColor.BLUE, ChatColor.RED));
        this.getLogger().info(String.format("%s \\____/\\____/", ChatColor.BLUE));
        this.getLogger().info("");

        checkAndSaveDefaultConfig();

        GUIHandlerGUI = new GUIHandler();
        this.getServer().getPluginManager().registerEvents(GUIHandlerGUI, this);
        this.getCommand("gg").setExecutor(GUIHandlerGUI);
        this.getCommand("customgg").setExecutor(new CustomGGCommand());
    }

    @Override
    public void onDisable() {
        this.saveConfig();
    }

    private void checkAndSaveDefaultConfig() {
        File file = new File(this.getDataFolder(), "config.yml");
        if(file.exists()) {
            this.getLogger().info("Found existing config file, using it. If you want to reset the config file, just delete it and CustomGG will generate a new one.");
        } else {
            this.getLogger().warning("Failed to find config.yml, generating one.");
            this.saveDefaultConfig();
            this.getLogger().info("Saved default config to 'plguins/CustomGG/config.yml'");
        }
    }


}
