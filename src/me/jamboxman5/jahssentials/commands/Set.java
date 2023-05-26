package me.jamboxman5.jahssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jamboxman5.jahssentials.main.Main;
import me.jamboxman5.jahssentials.runnables.SetThread;
import me.jamboxman5.jahssentials.util.InfoStorage;
import net.md_5.bungee.api.ChatColor;

public class Set implements CommandExecutor {

	Main plugin;
	
	public Set(Main main) {
		plugin = main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("set")) {

			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;

			if (!p.hasPermission("jahcore.edit")) {
				p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
				return true;
			}
			
			if (args.length != 1) {
				p.sendMessage(ChatColor.RED + "Usage: /set <material>");
				return true;
			}
			
			if (Material.valueOf(args[0].toUpperCase()) == null) {
				p.sendMessage(ChatColor.RED + "Invalid material!");
				return true;
			}
			
			Material m = Material.valueOf(args[0].toUpperCase());
			
			if (!(InfoStorage.position1.containsKey(p) && InfoStorage.position2.containsKey(p))) {
				p.sendMessage(ChatColor.RED + "Make a selection first! (Golden Axe)");
				return true;
			}
			
			Bukkit.getScheduler().runTaskAsynchronously(plugin, new SetThread(p, m, plugin));
			return true;
		}

		return false;

	}
	
}
