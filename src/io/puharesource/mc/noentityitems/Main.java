package io.puharesource.mc.noentityitems;

import io.puharesource.mc.noentityitems.commands.CommandNEI;
import io.puharesource.mc.noentityitems.listeners.ListenerExp;
import io.puharesource.mc.noentityitems.listeners.ListenerItemSpawn;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Main extends JavaPlugin {

    public static Main plugin;
    public static boolean isDropsGlobal;
    public static boolean isOrbsGlobal;
    public static List<String> noDropWorlds;
    public static List<String> noOrbWorlds;

    public void onEnable() {
        plugin = this;

        loadConfig();
        loadConfigOptions();

        getCommand("nei").setExecutor(new CommandNEI());

        getServer().getPluginManager().registerEvents(new ListenerExp(), this);
        getServer().getPluginManager().registerEvents(new ListenerItemSpawn(), this);
    }

    public void loadConfig() {
        if (!getDataFolder().exists()) getDataFolder().mkdir();

        File config = new File(getDataFolder(), "config.yml");

        try {
            if (!config.exists()) Files.copy(getResource("config.yml"), config.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        getConfig();
        saveConfig();
    }

    public void loadConfigOptions() {
        isDropsGlobal = getConfig().getBoolean("Items.Global");
        isOrbsGlobal = getConfig().getBoolean("Orbs.Global");

        noDropWorlds = getConfig().getStringList("Items.Worlds");
        noOrbWorlds = getConfig().getStringList("Orbs.Worlds");
    }
}
