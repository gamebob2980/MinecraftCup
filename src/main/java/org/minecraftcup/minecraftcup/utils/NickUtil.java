package org.minecraftcup.minecraftcup.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class NickUtil {

    public static ArrayList<Player> nicked = new ArrayList<>();

    public static void nick(Player p, String name){

        if(!(nicked.contains(p))) {
            if(name.length() <= 16) {
                if(name.length() >= 3) {
                    p.setCustomName(name);
                    p.setCustomNameVisible(true);

                    nicked.add(p);
                    p.sendMessage(ChatColor.GREEN + "Now nicked as " + name);
                }else{
                    p.sendMessage(ChatColor.RED + "Name must be 3 or more characters.");
                }
            }else{
                p.sendMessage(ChatColor.RED + "Name must be less 16 or less characters.");
            }
        }else{
            p.setCustomNameVisible(false);

            nicked.remove(p);
            p.sendMessage(ChatColor.GREEN + "No longer nicked.");
        }
    }

    public static String nickRequest(Player p){

        if(nicked.contains(p)){
            return p.getCustomName();
        }
        return p.getName();
    }
}
