package me.jamboxman5.jahssentials.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Blockme implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("blockme")) {

			if (!sender.hasPermission("jahcore.blockme")) {
				sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
				return true;
			}
			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;
			
			p.getWorld().getBlockAt(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()-1, p.getLocation().getZ())).setType(Material.STONE);
			p.sendMessage(ChatColor.of("#49B3FF") + "You have been blocked!");
			return true;
		}

		return false;

	}
	
}
