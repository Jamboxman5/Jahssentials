package me.jamboxman5.jahssentials.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jamboxman5.jahssentials.util.CraftingStorage;
import net.md_5.bungee.api.ChatColor;

public class RecipeMenu {

	public static Inventory inv;
	public static ItemStack i;
	
	public static Inventory createInv() {
		
		inv = Bukkit.createInventory(null, 27, "Enter a recipe:");
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		
		for (int i : CraftingStorage.recipeFillerSlots) {
			inv.setItem(i, item);
		}
		
		item.setType(Material.RED_STAINED_GLASS_PANE);
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Cancel");
		item.setItemMeta(meta);
		inv.setItem(9, item);
		
		item.setType(Material.LIME_STAINED_GLASS_PANE);
		meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Confirm");
		item.setItemMeta(meta);
		inv.setItem(17, item);
		
		i = item;
		return inv;
		
	}
	
}
