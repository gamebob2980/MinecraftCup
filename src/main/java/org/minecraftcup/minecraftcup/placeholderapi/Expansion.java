package org.minecraftcup.minecraftcup.placeholderapi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.minecraftcup.minecraftcup.utils.NickUtil;
import org.minecraftcup.minecraftcup.utils.VanishUtil;

public class Expansion extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "MinecraftCup";
    }

    @Override
    public @NotNull String getAuthor() {
        return "gamebob2980";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player p, String params){
        if(p == null){
            return "";
        }
        if(params == null){
            return "";
        }
        if(params.equals("vanish_tag")){
            return VanishUtil.requestTag(p);
        }
        if(params.equals("nick")){
            return NickUtil.nickRequest(p);
        }
        return null;
    }
}
