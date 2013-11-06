package com.mineactivity.noentityitems.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

import com.mineactivity.noentityitems.misc.Vars;

public class ExpBottleListener implements Listener
{
	@EventHandler
	public void AntiExperience(ExpBottleEvent event)
	{
		String world = event.getEntity().getWorld().getName().trim();
		
		if(Vars.orbGlobal)
		{
			event.setExperience(0);
		}
		else
		{
			for(String str : Vars.orbList)
			{
				if(world.equalsIgnoreCase(str))
				{
					event.setExperience(0);
				}
			}
		}
	}
}
