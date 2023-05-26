package me.jamboxman5.jahssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jamboxman5.jahssentials.gui.InvseeMenu;
import me.jamboxman5.jahssentials.main.Main;
import me.jamboxman5.jahssentials.util.InfoStorage;
import net.md_5.bungee.api.ChatColor;

public class Invsee implements CommandExecutor {
	
	private Main plugin;
	
	public Invsee(Main main) {
		plugin = main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("invsee")) {

			if (!(sender instanceof Player)) return true;
			Player p = (Player) sender;
			if (!p.hasPermission("group.moderator")) {
				p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
				return true;
			}
			if (args.length != 1) {
				p.sendMessage(ChatColor.RED + "Usage: /invsee <player>");
				return true;
			}
			if (Bukkit.getServer().getPlayer(args[0]) == null) {
				p.sendMessage(ChatColor.RED + "Player not found!");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			
			if (Main.infoStorage.getAdmins().contains(target.getName())) {
				p.sendMessage(ChatColor.RED + "You cannot open their inventory!");
				return true;
			}
			
			InfoStorage.invseeActiveUsers.add(p);
			
			p.openInventory(InvseeMenu.createInv(plugin, p, target));
			
			
			
		}

		return false;

	}

}
