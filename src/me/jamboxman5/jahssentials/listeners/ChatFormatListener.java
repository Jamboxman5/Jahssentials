package me.jamboxman5.jahssentials.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;

public class ChatFormatListener implements Listener {
	
	@EventHandler
	
	public void onChat(AsyncPlayerChatEvent event) {
	
	String message = event.getMessage();
		
	Player player = event.getPlayer();
	
	if (player.hasPermission("Plugindev.chatformat")) {
			
			String newmessage = message.replace(message, ChatColor.translateAlternateColorCodes('&', message));
			
			event.setMessage(newmessage);
			
	}
		
	}

}
