package org.minecraftcup.minecraftcup.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.minecraftcup.minecraftcup.menumanager.Menu;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        if(e.getClickedInventory() != null && e.getCurrentItem() != null) {
            InventoryHolder holder = e.getClickedInventory().getHolder();

            if (holder instanceof Menu) {

                e.setCancelled(true);

                Menu menu = (Menu) holder;
                menu.handleMenu(e);
            }
        }
    }
}
