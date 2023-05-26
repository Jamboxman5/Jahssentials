package me.jamboxman5.jahssentials.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.jamboxman5.jahssentials.main.Main;
import me.jamboxman5.jahssentials.util.InfoStorage;


public class InvseeMenu {
	
	static Inventory inv;
	
	public static Inventory createInv(Main plugin, Player p, Player target) {

		String name = target.getName() + "'s Inventory:";
		
		inv = Bukkit.createInventory(p, 45, name);
		
		inv.setContents(target.getInventory().getContents());
		
		Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(100);
					while (InfoStorage.invseeActiveUsers.contains(p)) {
						inv.setContents(target.getInventory().getContents());
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		return inv;
		
	}

}
