package me.jamboxman5.jahssentials.listeners;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.jamboxman5.jahssentials.gui.MaterialsMenu;
import me.jamboxman5.jahssentials.gui.RecipeMenu;
import me.jamboxman5.jahssentials.util.CraftingStorage;
import net.md_5.bungee.api.ChatColor;

public class RecipeMenuListener implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if (e.getClickedInventory() == null) return;
		if (e.getCurrentItem() == null) return;
		if (e.getCurrentItem().getItemMeta() == null) return;
		if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		if (!e.getInventory().contains(RecipeMenu.i)) return;
		if (!CraftingStorage.storedMenus.contains(e.getClickedInventory())) return;
//		if (!e.getClickedInventory().getType().equals(InventoryType.CHEST)) return;
				
		if (CraftingStorage.recipeFillerSlots.contains(e.getSlot())) {
			e.setCancelled(true);
			return;
		}
		
		if (e.getSlot() == 9) {
			e.setCancelled(true);
			cancel(e);
			return;
		}
		
		if (e.getSlot() == 17) {
			e.setCancelled(true);
			confirm(e);
			return;

		}
				
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		
		Player p = (Player) e.getPlayer();
		World world = p.getLocation().getWorld();
		
		if (!e.getInventory().contains(RecipeMenu.i)) return;
		if (!CraftingStorage.storedMenus.contains(e.getInventory())) return;
		
		ItemStack[] matrix = new ItemStack[9];
		matrix[0] = e.getInventory().getItem(3);
		matrix[1] = e.getInventory().getItem(4);
		matrix[2] = e.getInventory().getItem(5);
		matrix[3] = e.getInventory().getItem(12);
		matrix[4] = e.getInventory().getItem(13);
		matrix[5] = e.getInventory().getItem(14);
		matrix[6] = e.getInventory().getItem(21);
		matrix[7] = e.getInventory().getItem(22);
		matrix[8] = e.getInventory().getItem(23);
		
		if (matrix[0] == null &&
			matrix[1] == null &&
			matrix[2] == null &&
			matrix[3] == null &&
			matrix[4] == null &&
			matrix[5] == null &&
			matrix[6] == null &&
			matrix[7] == null &&
			matrix[8] == null) return;
		
		for (ItemStack i : matrix) {
			if (i != null ) {
				if (p.getInventory().firstEmpty() == -1) {
					world.dropItemNaturally(p.getLocation(), i);
				} else {
					p.getInventory().addItem(i);
				}		
			}
		}
		
		CraftingStorage.storedMenus.remove(e.getInventory());
		
	}
	
	private void confirm(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		World world = p.getLocation().getWorld();
		
		ItemStack[] matrix = new ItemStack[9];
		matrix[0] = e.getInventory().getItem(3);
		matrix[1] = e.getInventory().getItem(4);
		matrix[2] = e.getInventory().getItem(5);
		matrix[3] = e.getInventory().getItem(12);
		matrix[4] = e.getInventory().getItem(13);
		matrix[5] = e.getInventory().getItem(14);
		matrix[6] = e.getInventory().getItem(21);
		matrix[7] = e.getInventory().getItem(22);
		matrix[8] = e.getInventory().getItem(23);
		
		if (matrix[0] == null &&
			matrix[1] == null &&
			matrix[2] == null &&
			matrix[3] == null &&
			matrix[4] == null &&
			matrix[5] == null &&
			matrix[6] == null &&
			matrix[7] == null &&
			matrix[8] == null) {
			return;
		}
		
		if (Bukkit.getCraftingRecipe(matrix, world) == null) {
			p.sendMessage(ChatColor.RED + "Invalid Recipe!");
			return;
		}
		
		for (ItemStack i : matrix) {
			if (i != null) {
				if (p.getInventory().firstEmpty() == -1) {
					world.dropItemNaturally(p.getLocation(), i);
				} else {
					p.getInventory().addItem(i);
				}
			}
		}
		
		for (ItemStack i : matrix) {
			if (i != null) {
				i.setAmount(1);
			}
		}
		
		CraftingStorage.recipeStorage.put(p, matrix);
		
		
		Inventory inv = MaterialsMenu.createInv();
		CraftingStorage.storedMenus.remove(e.getClickedInventory());
		CraftingStorage.storedMenus.add(inv);
		p.openInventory(inv);
		
	}

	private void cancel(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		World world = p.getLocation().getWorld();

		p.closeInventory();
		p.sendMessage(ChatColor.RED + "Mass Crafting Canceled!");
		CraftingStorage.storedMenus.remove(e.getClickedInventory());
		
		ItemStack[] matrix = new ItemStack[9];
		matrix[0] = e.getInventory().getItem(3);
		matrix[1] = e.getInventory().getItem(4);
		matrix[2] = e.getInventory().getItem(5);
		matrix[3] = e.getInventory().getItem(12);
		matrix[4] = e.getInventory().getItem(13);
		matrix[5] = e.getInventory().getItem(14);
		matrix[6] = e.getInventory().getItem(21);
		matrix[7] = e.getInventory().getItem(22);
		matrix[8] = e.getInventory().getItem(23);
		
		for (ItemStack i : matrix) {
			if (i != null) {
				if (p.getInventory().firstEmpty() == -1) {
					world.dropItemNaturally(p.getLocation(), i);
				} else {
					p.getInventory().addItem(i);
				}
			}
		}

	}

}
