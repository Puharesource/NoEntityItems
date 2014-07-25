package io.puharesource.mc.noentityitems.commands;

import io.puharesource.mc.noentityitems.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandNEI implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("nei")) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("reload")) {
                    Main.plugin.reloadConfig();
                    Main.plugin.loadConfigOptions();
                    sender.sendMessage(ChatColor.GREEN + "You've reloaded the config!");
                } else {
                    syntaxError(sender);
                }
            } else {
                syntaxError(sender);
            }
            return true;
        }
        return false;
    }

    private void syntaxError(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "Wrong usage! Correct usage:");
        sender.sendMessage(ChatColor.GRAY + "    /nei " + ChatColor.RED + "reload");
    }
}
