package me.jamboxman5.jahssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Logoff implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("logoff")) {
			if (sender instanceof Player) {
				// player
				Player player = (Player) sender;
				String name = player.getDisplayName();
				String prefix = "";
				
				if (player.hasPermission("group.owner") && name.contains("Jamboxman5")) {
					prefix = ChatColor.translateAlternateColorCodes('&', "&7[" + ChatColor.of("#49B3FF") + "&lOwner&7]");
				} else if (player.hasPermission("group.admin")) {
					prefix = ChatColor.translateAlternateColorCodes('&', "&7[&cAdmin&7]");
				}
				
				if (player.hasPermission("jahcraft.admin")) {
					Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c-&7] ") + prefix + " " + name + ChatColor.translateAlternateColorCodes('&', " &chas left the game."));
					return true;
				}
				player.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
				return true; 
			}
			else {
				//console
				sender.sendMessage("You can't do that, silly!");
				return true;
			}
		}
		
		return false;
		
	}

}
