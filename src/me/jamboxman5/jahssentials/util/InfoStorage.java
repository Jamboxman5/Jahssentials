package me.jamboxman5.jahssentials.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class InfoStorage {
	
	public static ArrayList<Player> invseeActiveUsers = new ArrayList<Player>();
	
	public static HashMap<Player, Location> position1 = new HashMap<>();
	public static HashMap<Player, Location> position2 = new HashMap<>();
	public static HashMap<Player, Stack<HashMap<Block, Material>>> editHistory = new HashMap<>();

	
	public ArrayList<String> getAdmins() {
		
		ArrayList<String> admins = new ArrayList<String>();
		admins.add("Jamboxman5");
		admins.add("SlickNick73");
		
		return admins;
		
	}
	
}
