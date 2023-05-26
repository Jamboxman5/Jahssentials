package me.jamboxman5.jahssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jamboxman5.jahssentials.main.Main;
import me.jamboxman5.jahssentials.runnables.NoMoreOresThread;
import net.md_5.bungee.api.ChatColor;

public class NoMoreOres implements CommandExecutor {
	
	Main plugin;
	Player target;
	
	public NoMoreOres(Main main) {
		plugin = main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("nomoreores")) {

			if (!(sender instanceof Player)) return true;
			
			if (!sender.hasPermission("jahcore.nomoreores")) {
				sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
				return true;
			}
			
			if (!(args.length == 1 || args.length == 2)) {
				sender.sendMessage(ChatColor.RED + "Usage: /nomoreores <radius>");
				return true;
			}
			
			int radius = 0;
			
			try {
				radius = Integer.parseInt(args[0]);
			} catch (Exception e) {
				sender.sendMessage(ChatColor.RED + "Invalid Radius! Must be an integer!");
				return true;
			}
			
			if (radius > 100) {
				sender.sendMessage(ChatColor.RED + "Radius too big! Maximum radius is 100!");
				return true;
			}
			
			if (args.length == 2) {
				if (Bukkit.getPlayer(args[1]) == null) {
					sender.sendMessage(ChatColor.RED + "Invalid player!");
					sender.sendMessage(ChatColor.RED + "Usage: /nomoreores <radius> [player]");
					return true;
				} else {
					target = Bukkit.getPlayer(args[1]);
				}
				
			} else {
				target = (Player) sender;
			}
			
			Bukkit.getScheduler().runTaskAsynchronously(plugin, new NoMoreOresThread((Player) sender, target, radius, plugin));
			return true;
			
		}

		return false;

	}

}
