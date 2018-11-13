package com.fallenflame.core.customgg.gui;

import com.fallenflame.fallenutil.chat.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select implements Listener, CommandExecutor {

    public Connection connection;
    private Statement statement;
    private String host, database, username, password;
    private int port;
    private List<String> isActive = new ArrayList<>();

    public Select() {
        host = "localhost";
        port = 3306;
        database = "customgg";
        username = "customgg";
        password = "C0Gwkk6tJiI7RN8J";
        try {
            openConnection();
            statement = connection.createStatement();

            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, "customgg", null);
            if(!rs.next()) {
                statement.executeQuery("CREATE TABLE customgg" +
                                            "(uuid VARCHAR(255) not NULL" +
                                            "ggid INTEGER not NULL" +
                                            "PRIMARY KEY ( uuid ))");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("customgg.use")) {
                isActive.add(((Player) sender).getUniqueId().toString());


               // ((Player) sender).openInventory(null);
            } else {
                ChatUtil.getPrefixedMessage(ChatUtil.replaceColorChars("&cYou do not have permissions to use this command."));
            }
        } else {
            ChatUtil.getPrefixedMessage(ChatUtil.replaceColorChars("&cOnly players in game can execute this command."));
        }
        return true;
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
            connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password);
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setMessage(ChatUtil.replaceColorChars(event.getMessage()));
    }

    @EventHandler
    public void onInventoryClosed(InventoryCloseEvent event) {
        if(isActive.contains(event.getPlayer().getUniqueId().toString())) {
            isActive.remove(event.getPlayer().getUniqueId().toString());
        }
    }
}
