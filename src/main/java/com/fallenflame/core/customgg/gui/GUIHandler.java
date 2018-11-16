package com.fallenflame.core.customgg.gui;

import com.fallenflame.core.customgg.CustomGG;
import com.fallenflame.fallenutil.chat.ChatUtil;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.UUID;

public class GUIHandler implements Listener, CommandExecutor {
    private HashMap<UUID, Boolean> isOpen = new HashMap<>();
    private CustomGG plugin;

    public GUIHandler() {
        plugin = CustomGG.instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("customgg.use")) {
                isOpen.put(((Player) sender).getUniqueId(), false);
                if(plugin.getConfig().getBoolean("open-sound")) {
                    ((Player) sender).playSound(((Player) sender).getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                }
                ((Player) sender).openInventory(GUI.gg());
            } else {
                ChatUtil.getPrefixedMessage(ChatUtil.replaceColorChars("&cYou do not have permissions to use this command."));
            }
        } else {
            ChatUtil.getPrefixedMessage(ChatUtil.replaceColorChars("&cOnly players in game can execute this command."));
        }
        return true;
    }


    @EventHandler(priority =  EventPriority.LOWEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setMessage(ChatUtil.replaceColorChars(event.getMessage()));
        if(event.getMessage().equalsIgnoreCase("gg")) {
            event.setMessage("gg");
        }
    }

    @EventHandler
    public void onInventoryClosed(InventoryCloseEvent event) {
        isOpen.remove(event.getPlayer().getUniqueId());
    }
}
