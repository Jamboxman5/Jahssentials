package me.jamboxman5.jahssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class Jahsay implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("jahsay")){
			StringBuilder message = new StringBuilder("");
		    for (String part : args) {
		        if (!message.toString().equals(""))
		            message.append(" ");
		 
		        message.append(part);
		    }
			if (sender.hasPermission("jahcraft.admin")) {
				Bukkit.getServer().broadcastMessage(ChatColor.of("#49B3FF") + "[" + ChatColor.of("#FF0000") + "" + ChatColor.BOLD + "Overlord" + ChatColor.of("#49B3FF") + "] " + ChatColor.RED + "" + ChatColor.BOLD + "JahsehOnfroy" + ChatColor.GRAY + ": " + ChatColor.WHITE + message.toString());
				return true;
				
				}
			else { 
				sender.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
				return true; 
			}
		}
		
		return false; 
		
	}
	
}
