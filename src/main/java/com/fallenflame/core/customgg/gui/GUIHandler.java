package com.fallenflame.core.customgg.gui;

import com.fallenflame.core.customgg.CustomGG;
import com.fallenflame.core.customgg.gg.GG;
import com.fallenflame.core.customgg.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.UUID;

public class GUIHandler implements Listener, CommandExecutor {

    private HashMap<UUID, Boolean> isOpen = new HashMap<>();
    private HashMap<UUID, Integer> guiId = new HashMap<>();

    private CustomGG plugin;

    public GUIHandler() {
        this.plugin = CustomGG.instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("customgg.use")) {
                isOpen.put(((Player) sender).getUniqueId(), false);
                if(plugin.getConfig().getBoolean("open-sound")) {
                    ((Player) sender).playSound(((Player) sender).getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                }
                Inventory inv = GUI.gg();
                ((Player) sender).openInventory(inv);
                isOpen.put(((Player) sender).getUniqueId(), false);
                guiId.put(((Player) sender).getUniqueId(), IInventoryId.home);
                if(!CustomGG.gghandler.hasGG((Player)sender)) {
                    CustomGG.gghandler.register((Player)sender);
                }
                updatePreview((HumanEntity)sender, inv);
            } else {
                sender.sendMessage(ChatUtil.getPrefixedMessage(ChatUtil.replaceColorChars("&cYou do not have permissions to use this command.")));
            }
        } else {
            sender.sendMessage(ChatUtil.getPrefixedMessage(ChatUtil.replaceColorChars("&cOnly players in game can execute this command.")));
        }
        return true;
    }


    @EventHandler(priority =  EventPriority.LOWEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setMessage(ChatUtil.replaceColorChars(event.getMessage()));
        if(event.getMessage().equalsIgnoreCase("gg") && event.getPlayer().hasPermission("customgg.use")) {
            event.setMessage(event.getMessage().replaceAll("gg", CustomGG.gghandler.genGG(event.getPlayer())));
        }
    }

    @EventHandler
    public void onInventoryClosed(InventoryCloseEvent event) {
        if(isOpen.containsKey(event.getPlayer().getUniqueId())) {
            if(isOpen.get(event.getPlayer().getUniqueId())) {
                isOpen.remove(event.getPlayer().getUniqueId());
            }
            if(event.getPlayer().getOpenInventory() == null) {
                isOpen.remove(event.getPlayer().getUniqueId());
            }
        }
    }

    @EventHandler
    public void onItemClick(InventoryClickEvent event) {
        if(!isOpen.containsKey(event.getWhoClicked().getUniqueId())) {
            return;
        }
        event.setCancelled(true);
       // event.getWhoClicked().sendMessage(event.getCurrentItem().getItemMeta().getDisplayName());
        GG gg = CustomGG.gghandler.getGG(Bukkit.getPlayer(event.getWhoClicked().getUniqueId()));
        ItemStack clickedItem = event.getCurrentItem();
        if(clickedItem.equals(Items.Other.cancel())) {
            isOpen.put(event.getWhoClicked().getUniqueId(), true);
            event.getWhoClicked().closeInventory();
            guiId.put(event.getWhoClicked().getUniqueId(), IInventoryId.closed);
        }
        if(clickedItem.equals(Items.Other.back())) {
            if(guiId.get(event.getWhoClicked().getUniqueId()).equals(IInventoryId.color) || guiId.get(event.getWhoClicked().getUniqueId()).equals(IInventoryId.style)) {
                Inventory inv = GUI.gg();
                openInv(event.getWhoClicked(), inv);
                guiId.put(event.getWhoClicked().getUniqueId(), IInventoryId.home);
                updatePreview(event.getWhoClicked(), inv);
            }
        }
        if(clickedItem.equals(Items.Other.styles())) {
            Inventory inv = GUI.styles();
            openInv(event.getWhoClicked(), GUI.styles());
            guiId.put(event.getWhoClicked().getUniqueId(), IInventoryId.style);
            updatePreview(event.getWhoClicked(), inv);
        }
        if(clickedItem.equals(Items.Other.colors())) {
            Inventory inv = GUI.colors();
            openInv(event.getWhoClicked(), inv);
            guiId.put(event.getWhoClicked().getUniqueId(), IInventoryId.color);
            updatePreview(event.getWhoClicked(), inv);
        }
        if(clickedItem.equals(Items.Styles.bars())) {
            if(gg.isHasBars()) gg.setHasBars(false);
            else gg.setHasBars(true);
        }
        if(clickedItem.equals(Items.Styles.bold())) {
            if(gg.isBold()) gg.setBold(false);
            else gg.setBold(true);
        }
        if(clickedItem.equals(Items.Styles.italic())) {
            if(gg.isItalic()) gg.setItalic(false);
            else gg.setItalic(true);
        }
        if(clickedItem.equals(Items.Styles.strike())) {
            if(gg.isStrike()) gg.setStrike(false);
            else gg.setStrike(true);
        }
        if(clickedItem.equals(Items.Styles.underline())) {
            if(gg.isUnderline()) gg.setUnderline(false);
            else gg.setUnderline(true);
        }
        if(clickedItem.equals(Items.Colors.black())) gg.setColor('0');
        if(clickedItem.equals(Items.Colors.darkBlue())) gg.setColor('1');
        if(clickedItem.equals(Items.Colors.darkGreen())) gg.setColor('2');
        if(clickedItem.equals(Items.Colors.darkAqua())) gg.setColor('3');
        if(clickedItem.equals(Items.Colors.darkRed())) gg.setColor('4');
        if(clickedItem.equals(Items.Colors.purple())) gg.setColor('5');
        if(clickedItem.equals(Items.Colors.gold())) gg.setColor('6');
        if(clickedItem.equals(Items.Colors.gray())) gg.setColor('7');
        if(clickedItem.equals(Items.Colors.darkGray())) gg.setColor('8');
        if(clickedItem.equals(Items.Colors.blue())) gg.setColor('9');
        if(clickedItem.equals(Items.Colors.green())) gg.setColor('a');
        if(clickedItem.equals(Items.Colors.aqua())) gg.setColor('b');
        if(clickedItem.equals(Items.Colors.red())) gg.setColor('c');
        if(clickedItem.equals(Items.Colors.lightPurple())) gg.setColor('d');
        if(clickedItem.equals(Items.Colors.yellow())) gg.setColor('e');
        if(clickedItem.equals(Items.Colors.white())) gg.setColor('f');

        if(clickedItem.equals(Items.Other.save())) {
            CustomGG.gghandler.updateGG(Bukkit.getPlayer(event.getWhoClicked().getUniqueId()), gg);
            isOpen.put(event.getWhoClicked().getUniqueId(), true);
            event.getWhoClicked().closeInventory();
            guiId.put(event.getWhoClicked().getUniqueId(), IInventoryId.closed);
        }

        updatePreview(event.getWhoClicked(), event.getClickedInventory());
    }

    private void openInv(HumanEntity he, Inventory inv) {
        Bukkit.getPlayer(he.getUniqueId()).openInventory(inv);
    }

    private void updatePreview(HumanEntity h, Inventory inv) {
        ItemStack preview = Items.Other.preview();
        ItemMeta previewMeta = preview.getItemMeta();
        previewMeta.setDisplayName(CustomGG.gghandler.genGG(Bukkit.getPlayer(h.getUniqueId())));
        preview.setItemMeta(previewMeta);

        inv.setItem(4, preview);
    }

}
