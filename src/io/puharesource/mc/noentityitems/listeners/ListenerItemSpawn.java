package io.puharesource.mc.noentityitems.listeners;

import io.puharesource.mc.noentityitems.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;

public class ListenerItemSpawn implements Listener {

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent event) {
        if(Main.isDropsGlobal)
            event.getEntity().remove();
        else {
            for(String world : Main.noDropWorlds) {
                if(event.getEntity().getWorld().getName().equalsIgnoreCase(world)) {
                    event.getEntity().remove();
                    break;
                }
            }
        }
    }
}
