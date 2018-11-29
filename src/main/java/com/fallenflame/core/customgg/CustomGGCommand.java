package com.fallenflame.core.customgg;

import com.fallenflame.fallenutil.chat.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CustomGGCommand implements CommandExecutor {

    private CustomGG plugin;

    public CustomGGCommand() {
        plugin = CustomGG.instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("customgg.admin")) {
            switch (args.length) {
                case 1:
                    if(args[0].equalsIgnoreCase("reload")) {
                        sender.sendMessage(ChatUtil.getPrefixedMessage(ChatUtil.replaceColorChars("Reloading config.")));
                        plugin.reload();
                        sender.sendMessage(ChatUtil.getPrefixedMessage(ChatUtil.replaceColorChars("Reload complete.")));
                    }
                    break;
                default:
                    sender.sendMessage(ChatUtil.getPrefixedMessage(ChatUtil.replaceColorChars("&b&lCustomGG &7by JoeZwet")));
            }
        } else {
            sender.sendMessage(ChatUtil.getPrefixedMessage(ChatUtil.replaceColorChars("&b&lCustomGG &7by JoeZwet")));        }
        return true;
    }
}
