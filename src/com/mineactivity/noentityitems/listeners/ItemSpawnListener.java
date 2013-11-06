package com.mineactivity.noentityitems.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;

import com.mineactivity.noentityitems.misc.Vars;

public class ItemSpawnListener implements Listener
{
	@EventHandler
	public void AntiItems(ItemSpawnEvent event)
	{
		String world = event.getLocation().getWorld().getName().trim();
		if (Vars.itemGlobal)
		{
			event.getEntity().remove();
		}

		for (String str : Vars.itemList)
		{
			if (world.equalsIgnoreCase(str))
			{
				event.getEntity().remove();
			}
		}
	}
}
