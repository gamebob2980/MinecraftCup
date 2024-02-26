package org.minecraftcup.minecraftcup.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.minecraftcup.minecraftcup.MinecraftCup;
import org.minecraftcup.minecraftcup.utils.VanishUtil;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;

            VanishUtil.vanish(p);
        }else{
            MinecraftCup.getPlugin().getLogger().warning("Console cannot run that command.");
        }
        return true;
    }
}
