package me.jamboxman5.jahssentials.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import me.jamboxman5.jahssentials.util.InfoStorage;

public class InvseeListener implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if (e.getInventory() == null) return;
		if (!InfoStorage.invseeActiveUsers.contains(e.getWhoClicked())) return;
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		
		if (e.getInventory() == null) return;
		if (!InfoStorage.invseeActiveUsers.contains(e.getPlayer())) return;
		
		InfoStorage.invseeActiveUsers.remove(e.getPlayer());
		
	}
	
}
