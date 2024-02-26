package org.minecraftcup.minecraftcup.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.minecraftcup.minecraftcup.MinecraftCup;

import java.util.ArrayList;

public class VanishUtil {

    public static ArrayList<Player> vanished = new ArrayList<>();

    public static void vanish(Player p){

        if(!(vanished.contains(p))) {
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                if (!(all.hasPermission("vanish.yeah"))) {
                    all.hidePlayer(MinecraftCup.getPlugin(), p);
                } else {
                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSTAFF &f" + p.getName() + " is now vanished."));
                }
            }
            new BukkitRunnable(){

                @Override
                public void run() {

                    if(vanished.contains(p)){
                        String vanished = ChatColor.WHITE + "You are currently " + ChatColor.RED + "VANISHED";
                        ActionBarUtil.sendActionBar(p, vanished);
                    }else{
                        this.cancel();
                    }
                }
            }.runTaskTimer(MinecraftCup.getPlugin(), 0, 20);

            p.sendMessage(ChatColor.GREEN + "Now vanished!");
            vanished.add(p);
        }else{
            for(Player all : Bukkit.getServer().getOnlinePlayers()){
                if (!(all.hasPermission("vanish.yeah"))) {
                    all.showPlayer(MinecraftCup.getPlugin(), p);
                } else {
                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSTAFF &f" + p.getName() + " is no longer vanished."));
                }
            }

            p.sendMessage(ChatColor.GREEN + "No longer vanished!");
            vanished.remove(p);
        }
    }

    public static String requestTag(Player p){

        if(vanished.contains(p)){
            return ChatColor.GRAY + " [V]";
        }
        return "";
    }
}
