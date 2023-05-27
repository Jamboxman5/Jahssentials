package me.jamboxman5.jahssentials.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CraftingStorage {
	
	public static ArrayList<Integer> recipeFillerSlots = getRecipeFillerSlots();
	public static ArrayList<Integer> materialsFillerSlots = getMaterialsFillerSlots();
	public static ArrayList<Inventory> storedMenus = new ArrayList<>();
	public static HashMap<Player, ItemStack[]> recipeStorage = new HashMap<>();

	
	private static ArrayList<Integer> getRecipeFillerSlots() {
		
		ArrayList<Integer> slots = new ArrayList<>();
		
		slots.add(0);
		slots.add(1);
		slots.add(2);
		slots.add(6);
		slots.add(7);
		slots.add(8);
		slots.add(10);
		slots.add(11);
		slots.add(15);
		slots.add(16);
		slots.add(18);
		slots.add(19);
		slots.add(20);
		slots.add(24);
		slots.add(25);
		slots.add(26);
		
		return slots;
		
	}
	
	private static ArrayList<Integer> getMaterialsFillerSlots() {
		
		ArrayList<Integer> slots = new ArrayList<>();
		
		slots.add(52);
		slots.add(51);
		slots.add(50);
		slots.add(49);
		slots.add(48);
		slots.add(47);
		slots.add(46);
		
		return slots;
		
	}
	
}
