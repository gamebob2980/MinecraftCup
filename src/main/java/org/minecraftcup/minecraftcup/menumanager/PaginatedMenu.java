package org.minecraftcup.minecraftcup.menumanager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class PaginatedMenu extends Menu {

    protected int page = 0;
    protected int maxItemsPerPage = 45;
    protected int index = 0;

    public PaginatedMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    public void addMenuItems(){

        ItemStack back = new ItemStack(Material.ARROW, 1);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.GREEN + "Back");
        back.setItemMeta(backMeta);

        ItemStack close = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        ItemStack next = new ItemStack(Material.ARROW, 1);
        ItemMeta nextMeta = next.getItemMeta();
        nextMeta.setDisplayName(ChatColor.GREEN + "Next");
        next.setItemMeta(nextMeta);

        inventory.setItem(47, back);
        inventory.setItem(49, close);
        inventory.setItem(51, next);
    }
}
