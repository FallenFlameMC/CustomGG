package com.fallenflame.core.customgg;

import com.fallenflame.core.customgg.gg.GGHandler;
import com.fallenflame.core.customgg.gui.GUIHandler;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CustomGG extends JavaPlugin {

    private GUIHandler GUIHandlerGUI;
    public static CustomGG instance;
    public static GGHandler gghandler;
    public static Connection connection;
    public String host, username, password, database;
    public int port;

    @Override
    public void onEnable() {
        instance = this;
        gghandler = new GGHandler();
        this.saveDefaultConfig();

        this.host = getConfig().getConfigurationSection("mysql").getString("hostname");
        this.username = getConfig().getConfigurationSection("mysql").getString("username");
        this.database = getConfig().getConfigurationSection("mysql").getString("database");
        this.password = getConfig().getConfigurationSection("mysql").getString("password");
        this.port = getConfig().getConfigurationSection("mysql").getInt("port");

        this.getLogger().info(String.format("%s _____ _____", ChatColor.BLUE));
        this.getLogger().info(String.format("%s|  __ \\  __ \\", ChatColor.BLUE));
        this.getLogger().info(String.format("%s| |  \\/ |  \\/", ChatColor.BLUE));
        this.getLogger().info(String.format("%s| | __| | __    %sCustomGG %sv%s", ChatColor.BLUE, ChatColor.AQUA, ChatColor.GOLD, this.getDescription().getVersion()));
        this.getLogger().info(String.format("%s| |_\\ \\ |_\\ \\   by %sJoeZwet", ChatColor.BLUE, ChatColor.RED));
        this.getLogger().info(String.format("%s \\____/\\____/", ChatColor.BLUE));
        this.getLogger().info("");

        GUIHandlerGUI = new GUIHandler();
        this.getServer().getPluginManager().registerEvents(GUIHandlerGUI, this);
        this.getCommand("gg").setExecutor(GUIHandlerGUI);
        this.getCommand("customgg").setExecutor(new CustomGGCommand());

        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS CustomGG (UUID VARCHAR(255) UNIQUE,Bold INTEGER(1) DEFAULT 0,Underline INTEGER(1) DEFAULT 0,Italic INTEGER(1) DEFAULT 0,Strike INTEGER(1) DEFAULT 0,Bars INTEGER(1) DEFAULT 0,Color VARCHAR(1) DEFAULT 'f');");
            gghandler.initGG();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            this.getLogger().severe(e.getMessage());
            this.getLogger().warning("Shit went down, disabling CustomGG.");
           // this.getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        if(connection != null) {
            gghandler.save();
            try {
                connection.close();
            } catch (SQLException e) {}
        }
    }

    public void reload() {
        this.reloadConfig();
        this.host = getConfig().getConfigurationSection("mysql").getString("hostname");
        this.username = getConfig().getConfigurationSection("mysql").getString("username");
        this.database = getConfig().getConfigurationSection("mysql").getString("database");
        this.password = getConfig().getConfigurationSection("mysql").getString("password");
        this.port = getConfig().getConfigurationSection("mysql").getInt("port");
    }

    public void openConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
            return;
        }

        synchronized (this) {
            if (connection != null && !connection.isClosed()) {
                return;
            }
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s/?user=%s&password=%s", this.host, this.port, this.database, this.username, this.password));
        }
    }

    @Override
    public void saveDefaultConfig() {
        File file = new File(this.getDataFolder(), "config.yml");
        if(file.exists()) {
            this.getLogger().info("Found existing config file, using it.");
        } else {
            this.getLogger().warning("Failed to find config.yml, generating one.");
            super.saveDefaultConfig();
            this.getLogger().info("Done.");
        }
    }
}
