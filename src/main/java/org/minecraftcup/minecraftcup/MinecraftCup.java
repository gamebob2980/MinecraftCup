package org.minecraftcup.minecraftcup;

import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftCup extends JavaPlugin {

    private static MinecraftCup plugin;

    @Override
    public void onEnable() {
        getLogger().info("Enabled!");

        plugin = this;

        if(getConfig().getBoolean("lobby")){
            // events that should only be registered when lobby is true
        }
        if(!(getConfig().getBoolean("lobby"))){
            // events that should only be registered when lobby is false
        }

    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled!");
    }

    public static MinecraftCup getPlugin() {
        return plugin;
    }
}
