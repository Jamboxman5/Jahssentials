package me.jamboxman5.jahssentials.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jamboxman5.jahssentials.main.Main;
import net.md_5.bungee.api.ChatColor;

public class DirectMessage implements CommandExecutor {
	
	HashMap<String, String> replyStorage = new HashMap<>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if (label.equalsIgnoreCase("msg") || label.equalsIgnoreCase("m") || 
				label.equalsIgnoreCase("dm") || label.equalsIgnoreCase("pm") || 
				label.equalsIgnoreCase("tell") || label.equalsIgnoreCase("whisper") || 
				label.equalsIgnoreCase("w")) {
			
			String message = "";
									
			if (args.length == 0) {
				
				sender.sendMessage(ChatColor.RED + "Usage: /msg <player> <message>");
				return true;
				
			}
						
			if (Bukkit.getServer().getPlayer(args[0]) == null) {
				
				sender.sendMessage(ChatColor.RED + "Player not found!");
				return true;
				
			}
			
			if (args.length == 1) {
				
				if (Bukkit.getServer().getPlayer(args[0]) != null) {
					
					sender.sendMessage(ChatColor.RED + "Please type your message!");
					return true;
					
				}
				
				sender.sendMessage(ChatColor.RED + "Usage: /msg <player> <message>");
				return true;
				
			}
			
			if (args.length > 1 && Bukkit.getServer().getPlayer(args[0]) != null) {
				
				Player target = (Player) Bukkit.getServer().getPlayer(args[0]);
				
				for (int i = 1; i < args.length; i++) {
					
					message = message + args[i] + " ";
					
				}
				
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "[ME -> " + ChatColor.of("#FFD700") + "&l" + target.getName() + ChatColor.of("#49B3FF") + "] ") + ChatColor.GRAY + message);
				target.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "[" + ChatColor.of("#FFD700") + "&l" + sender.getName() + ChatColor.of("#49B3FF")+ " -> ME] ") + ChatColor.GRAY + message);
						
				for (String n : Main.infoStorage.getAdmins()) {
					if (Bukkit.getPlayer(n) != null && 
						sender.getName() != Bukkit.getPlayer(n).getName() &&
						target.getName() != Bukkit.getPlayer(n).getName()) {
						Bukkit.getPlayer(n).sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#FFD700") + "&lJahSpy " + 
					    ChatColor.of("#00E8FF") + "» [&b" + sender.getName() + ChatColor.of("#00E8FF") +" -> &b" + target.getName() + ChatColor.of("#00E8FF") +"] ") + ChatColor.GRAY + message);
					}
				}
				
				replyStorage.put(target.getName(), sender.getName());

				return true;
				
			}
			
			sender.sendMessage(ChatColor.RED + "Error! Please contact Jamboxman5 to report this!");
			return true;
			
		}
		
		if (label.equalsIgnoreCase("reply") || label.equalsIgnoreCase("r")) {
			
			if (args.length == 0) {
				
				sender.sendMessage(ChatColor.RED + "Usage: /r <message>");
				return true;
				
			}
			
			if (replyStorage.get(sender.getName()) == null) {
				
				sender.sendMessage(ChatColor.RED + "Nobody to reply to!");
				return true;
				
			}
			
			if (Bukkit.getServer().getPlayer(replyStorage.get(sender.getName())) == null) {
				
				sender.sendMessage(ChatColor.RED + "Player not found!");
				return true;
				
			}
			
			Player newTarget = Bukkit.getServer().getPlayer(replyStorage.get(sender.getName()));
			
			String message = "";
			
			for (int i = 0; i < args.length; i++) {
				
				message = message + args[i] + " ";
				
			}
			
			newTarget.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "[" + ChatColor.of("#FFD700") + "&l" + sender.getName() + ChatColor.of("#49B3FF") + " -> ME] ") + ChatColor.GRAY + message);
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "[ME -> " + ChatColor.of("#FFD700") + "&l" + newTarget.getName() + ChatColor.of("#49B3FF") + "] ") + ChatColor.GRAY + message);
			
			for (String n : Main.infoStorage.getAdmins()) {
				if (Bukkit.getPlayer(n) != null && 
					sender.getName() != Bukkit.getPlayer(n).getName() &&
					newTarget.getName() != Bukkit.getPlayer(n).getName()) {
					Bukkit.getPlayer(n).sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#FFD700") + "&lJahSpy " + 
				    ChatColor.of("#00E8FF") + "» [&b" + sender.getName() + ChatColor.of("#00E8FF") +" -> &b" + newTarget.getName() + ChatColor.of("#00E8FF") +"] ") + ChatColor.GRAY + message);
				}
			}
			
			replyStorage.put(newTarget.getName(), sender.getName());
			return true;
			
		}
		
		
		return false;
		
	}

}
