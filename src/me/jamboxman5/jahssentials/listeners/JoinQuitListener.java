package me.jamboxman5.jahssentials.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.jamboxman5.jahssentials.util.Colors;

public class JoinQuitListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
//		UserData.activate(p);
		e.setJoinMessage(p.getDisplayName() + Colors.BLUE + " has joined the server!");				

			
			
//		Bukkit.getScheduler().runTaskAsynchronously(Main.plugin, new Runnable() {
//			@Override
//			public void run() {
//				
//
//			}
//		});
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(p.getDisplayName() + Colors.BRIGHTRED + " has left the server!");
//		Bukkit.getScheduler().runTaskAsynchronously(Main.plugin, new Runnable() {
//			@Override
//			public void run() {
//				UserData.deactivate(p.getUniqueId());
//			}
//		});
	}
	
}
