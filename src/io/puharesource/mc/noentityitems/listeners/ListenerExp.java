package io.puharesource.mc.noentityitems.listeners;

import io.puharesource.mc.noentityitems.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ExpBottleEvent;

public class ListenerExp implements Listener {

    @EventHandler
    public void onExpBottle(ExpBottleEvent event) {
        if(Main.isOrbsGlobal)
            event.setExperience(0);
        else {
            for(String world : Main.noOrbWorlds) {
                if(event.getEntity().getWorld().getName().equalsIgnoreCase(world)) {
                    event.setExperience(0);
                    break;
                }
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(Main.isOrbsGlobal)
            event.setExpToDrop(0);
        else {
            for(String world : Main.noOrbWorlds) {
                if(event.getBlock().getWorld().getName().equalsIgnoreCase(world)) {
                    event.setExpToDrop(0);
                    break;
                }
            }
        }
    }
}
