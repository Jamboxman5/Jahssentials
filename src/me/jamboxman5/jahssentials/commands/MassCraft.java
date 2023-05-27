package me.jamboxman5.jahssentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.jamboxman5.jahssentials.gui.RecipeMenu;
import me.jamboxman5.jahssentials.util.CraftingStorage;
import net.md_5.bungee.api.ChatColor;

public class MassCraft implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("masscraft")) {
			
			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;
			
			if (!p.hasPermission("jahcraft.masscraft")) {
				p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
				return true;
			}
			
			Inventory inv = RecipeMenu.createInv();
			CraftingStorage.storedMenus.add(inv);
			p.openInventory(inv);
			return true;

		}

		return false;

	}
	
}
