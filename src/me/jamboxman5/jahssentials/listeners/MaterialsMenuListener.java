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

public class MaterialsMenuListener implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if (e.getClickedInventory() == null) return;
		if (e.getCurrentItem() == null) return;
		if (e.getCurrentItem().getItemMeta() == null) return;
		if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		if (!e.getInventory().contains(MaterialsMenu.i)) return;
		if (!CraftingStorage.storedMenus.contains(e.getClickedInventory())) return;
//		if (!e.getClickedInventory().getType().equals(InventoryType.CHEST)) return;
				
		if (CraftingStorage.materialsFillerSlots.contains(e.getSlot())) {
			e.setCancelled(true);
			return;
		}
		
		if (e.getSlot() == 45) {
			e.setCancelled(true);
			cancel(e);
			return;
		}
		
		if (e.getSlot() == 53) {
			e.setCancelled(true);
			finish(e);
			return;

		}
		
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		
		Player p = (Player) e.getPlayer();
		World world = p.getLocation().getWorld();
		
		if (!e.getInventory().contains(MaterialsMenu.i)) return;
		if (!CraftingStorage.storedMenus.contains(e.getInventory())) return;
		
		if (e.getView().getTitle().contains("Enter your materials:")) {
			for (int i = 0; i < 45; i++) {
				if (e.getInventory().getItem(i) != null) {
					if (p.getInventory().firstEmpty() == -1) {
						world.dropItemNaturally(p.getLocation(), e.getInventory().getItem(i));
					} else {
						p.getInventory().addItem(e.getInventory().getItem(i));
					}
				}
			}
		}
		
		CraftingStorage.storedMenus.remove(e.getInventory());

		
	}
	
	private void cancel(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		World world = p.getLocation().getWorld();

		p.closeInventory();
		CraftingStorage.recipeStorage.remove(p);
		CraftingStorage.storedMenus.remove(e.getClickedInventory());

		Inventory inv = RecipeMenu.createInv();
		
		CraftingStorage.storedMenus.add(inv);
		p.openInventory(inv);
		
		for (int i = 0; i < 45; i++) {
			if (e.getClickedInventory().getItem(i) != null) {
				if (p.getInventory().firstEmpty() == -1) {
					world.dropItemNaturally(p.getLocation(), e.getClickedInventory().getItem(i));
				} else {
					p.getInventory().addItem(e.getClickedInventory().getItem(i));
				}
			}
		}

	}
	
	private void finish(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		World world = p.getLocation().getWorld();
		
		CraftingStorage.storedMenus.remove(e.getClickedInventory());
		ItemStack[] recipe = CraftingStorage.recipeStorage.get(p);
		
		ItemStack product = Bukkit.getCraftingRecipe(recipe, world).getResult();
		int amountCrafted = 0;
		
		
		while (checkMats(e.getClickedInventory(), recipe)) {
			
			for (ItemStack i : recipe) {
				if (i != null) {
					e.getClickedInventory().removeItem(i);
				}
			}
			amountCrafted++;
		}
		
		if (amountCrafted == 0) {
			p.sendMessage(ChatColor.RED + "Insufficient Materials!");
			return;
		}
		
		for (int i = 0; i < amountCrafted; i++) {
			if (p.getInventory().firstEmpty() == -1) {
				world.dropItemNaturally(p.getLocation(), product);
			} else {
				p.getInventory().addItem(product);
			}
		}
		
		for (int i = 0; i < 45; i++) {
			if (e.getClickedInventory().getItem(i) != null) {
				if (p.getInventory().firstEmpty() == -1) {
					world.dropItemNaturally(p.getLocation(), e.getClickedInventory().getItem(i));
				} else {
					p.getInventory().addItem(e.getClickedInventory().getItem(i));
				}
			}
		}
		p.closeInventory();
		
	}

	private boolean checkMats(Inventory clickedInventory, ItemStack[] recipe) {
		
		Inventory temp = Bukkit.createInventory(null, clickedInventory.getSize());
		temp.setContents(clickedInventory.getContents());
		
		
		for (ItemStack i : recipe) {
			if (i != null) {
				if (!temp.containsAtLeast(i, 1)) {
					return false;
				}
				temp.removeItem(i);
			}
		}
		
		return true;
		
	}

}
