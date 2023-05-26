package me.jamboxman5.jahssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Enchant implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("enchant")) {

			if (!sender.hasPermission("jahssentials.enchant")) {
				sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
				return true;
			}
			
			if (!(sender instanceof Player) || args.length > 2) {
				
				enchantConsole(sender, args);
				return true;
			} else {
				Player p = (Player) sender;
				enchantPlayer(p, args);
				return true;
			}
			
		}

		return false;

	}

	private void enchantPlayer(Player p, String[] args) {
		if (args.length == 0 || args.length > 2) {
			p.sendMessage(ChatColor.RED + "Usage: /enchant <enchant> [level]");
			return;
		}
		Enchantment e = Enchantment.getByKey(NamespacedKey.minecraft(args[0]));
		if (e == null) {
			p.sendMessage(ChatColor.RED + "Invalid enchantment!");
			return;
		}
		int level;
		if (args.length < 2) {
			level = 1;
		} else {
			try {
				level = Integer.parseInt(args[1]);
			} catch (Exception ex) {
				level = 1;
			}
		}
		if (p.getInventory().getItemInMainHand().getType() == Material.AIR ) {
			p.sendMessage(ChatColor.RED + "You have nothing in your hand!");
			return;
		}
		ItemStack toEnchant = p.getInventory().getItemInMainHand();
		ItemMeta meta = toEnchant.getItemMeta();
		meta.addEnchant(e, level, true);
		toEnchant.setItemMeta(meta);
		p.sendMessage(ChatColor.of("#49B3FF") + "Enchantment added.");
		
	}

	private void enchantConsole(CommandSender sender, String[] args) {

		if (args.length < 2) {
			sender.sendMessage("Usage: /enchant <player> <enchant> [level]");
			return;
		}
		if (Bukkit.getServer().getPlayer(args[0]) == null) {
			sender.sendMessage("Player not found!");
			return;
		}
		Player target = Bukkit.getServer().getPlayer(args[0]);
		Enchantment e = Enchantment.getByKey(NamespacedKey.minecraft(args[1]));
		if (e == null) {
			sender.sendMessage(ChatColor.RED + "Invalid enchantment!");
			return;
		}
		int level;
		if (args.length < 3) {
			level = 1;
		} else {
			try {
				level = Integer.parseInt(args[2]);
			} catch (Exception ex) {
				level = 1;
			}
		}
		if (target.getInventory().getItemInMainHand().getType() == Material.AIR ) {
			sender.sendMessage("Target has nothing in their hand!");
			return;
		}
		ItemStack toEnchant = target.getInventory().getItemInMainHand();
		ItemMeta meta = toEnchant.getItemMeta();
		meta.addEnchant(e, level, true);
		
		toEnchant.setItemMeta(meta);
		
	}

}
