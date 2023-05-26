package me.jamboxman5.jahssentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Feed implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("feed")) {
			
			if (sender instanceof Player) {
				
				Player player = (Player) sender;
				
				if (player.hasPermission("spc.feed")) {
					
					player.setFoodLevel(20);
					player.setSaturation(10);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bYou have been fed!"));
					return true;
					
				}
				
				player.sendMessage(ChatColor.RED + "You do not have permission to feed yourself!");
				return true;
				
			}
			
			sender.sendMessage("Consoles don't need food!");
			return true;
			
		}
		
		return false;
		
	}
	
	

}
