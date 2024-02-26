package org.minecraftcup.minecraftcup;

import org.bukkit.plugin.java.JavaPlugin;
import org.minecraftcup.minecraftcup.commands.NickCommand;
import org.minecraftcup.minecraftcup.commands.VanishCommand;
import org.minecraftcup.minecraftcup.placeholderapi.Expansion;

public final class MinecraftCup extends JavaPlugin {

    private static MinecraftCup plugin;

    @Override
    public void onEnable() {
        getLogger().info("Enabled!");

        plugin = this;

        if(getConfig().getBoolean("lobby")){
            // events that should only be registered when lobby is true
            getCommand("vanish").setExecutor(new VanishCommand());
            getCommand("nick").setExecutor(new NickCommand());
        }
        if(!(getConfig().getBoolean("lobby"))){
            // events that should only be registered when lobby is false
        }

        new Expansion().register();
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled!");
    }

    public static MinecraftCup getPlugin() {
        return plugin;
    }
}
