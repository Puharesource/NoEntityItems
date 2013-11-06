package com.mineactivity.noentityitems;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.mineactivity.noentityitems.listeners.ExpBottleListener;
import com.mineactivity.noentityitems.listeners.ItemSpawnListener;
import com.mineactivity.noentityitems.misc.Vars;

public class Main extends JavaPlugin
{
	public void onEnable()
	{
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		pluginConfig();
		this.getServer().getPluginManager().registerEvents(new ItemSpawnListener(), this);
		this.getServer().getPluginManager().registerEvents(new ExpBottleListener(), this);
	}

	public void onDisable()
	{

	}
	
	@SuppressWarnings("unchecked")
	private void pluginConfig()
	{
		this.reloadConfig();
		
		Vars.itemGlobal		=		this.getConfig().getBoolean("Items.Global");
		Vars.orbGlobal		=		this.getConfig().getBoolean("Orbs.Global");
		
		Vars.itemList		=		(List<String>) this.getConfig().getList("Items.Worlds");
		Vars.orbList		=		(List<String>) this.getConfig().getList("Orbs.Worlds");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("nei"))
		{
			if(args.length == 0)
			{
				sender.sendMessage("§cCorrect Usage: §4/nei reload §f- This reloads NoEntityItems.");
				return true;
			}
			else if(args[0].equalsIgnoreCase("reload"))
			{
				pluginConfig();
				sender.sendMessage("§2[§aNoEntityItems§2] §ahas been reloaded.");
				return true;
			}
			else
			{
				sender.sendMessage("§cCorrect Usage: §4/nei reload §f- This reloads NoEntityItems.");
				return true;
			}
		}
		return false;
	}
}
