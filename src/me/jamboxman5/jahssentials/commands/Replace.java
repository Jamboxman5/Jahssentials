package me.jamboxman5.jahssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jamboxman5.jahssentials.main.Main;
import me.jamboxman5.jahssentials.runnables.ReplaceThread;
import me.jamboxman5.jahssentials.util.InfoStorage;
import net.md_5.bungee.api.ChatColor;

public class Replace implements CommandExecutor {
	
	Main plugin;
	
	public Replace(Main main) {
		plugin = main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("replace")) {

			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;

			if (!p.hasPermission("jahcore.edit")) {
				p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
				return true;
			}
			
			if (args.length != 2) {
				p.sendMessage(ChatColor.RED + "Usage: /set <material> <material>");
				return true;
			}
			
			if (Material.valueOf(args[0].toUpperCase()) == null) {
				p.sendMessage(ChatColor.RED + "Invalid material!");
				return true;
			}
			
			if (Material.valueOf(args[1].toUpperCase()) == null) {
				p.sendMessage(ChatColor.RED + "Invalid material!");
				return true;
			}
			
			Material m1 = Material.valueOf(args[0].toUpperCase());
			Material m2 = Material.valueOf(args[1].toUpperCase());
			
			if (!(InfoStorage.position1.containsKey(p) && InfoStorage.position2.containsKey(p))) {
				p.sendMessage(ChatColor.RED + "Make a selection first! (Golden Axe)");
				return true;
			}
			
			Bukkit.getScheduler().runTaskAsynchronously(plugin, new ReplaceThread(p, m1, m2, plugin));

			
		}

		return false;

	}

}
