package me.jamboxman5.jahssentials.runnables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import me.jamboxman5.jahssentials.main.Main;
import me.jamboxman5.jahssentials.util.InfoStorage;
import net.md_5.bungee.api.ChatColor;

public class ReplaceThread implements Runnable {

	private Player sender;
	private Material material1;
	private Material material2;
	
	String displayName1;
	String displayName2;
	
	int startx;
	int starty;
	int startz;
	
	int x;
	int y;
	int z;
	
	int endx;
	int endy;
	int endz;
	
	Main plugin;
	
	ArrayList<Block> blocks = new ArrayList<>();
	
	public ReplaceThread(Player p, Material m1, Material m2, Main main) {
		
		plugin = main;
		
		sender = p;
		material1 = m1;
		material2 = m2;

		startx = (int) InfoStorage.position1.get(sender).getX();
		starty = (int) InfoStorage.position1.get(sender).getY();
		startz = (int) InfoStorage.position1.get(sender).getZ();
		
		endx = (int) InfoStorage.position2.get(sender).getX();
		endy = (int) InfoStorage.position2.get(sender).getY();
		endz = (int) InfoStorage.position2.get(sender).getZ();
		
		displayName1 = getName(m1.toString());
		displayName2 = getName(m2.toString());
		
	}
	
	@Override
	public void run() {
		
		sender.sendMessage(ChatColor.of("#49B3FF") + "Adding blocks to queue...");
		
		if (startx >= endx) {
			for (x = startx; x >= endx; x--) {
				if (starty >= endy) {
					for (y = starty; y >= endy; y--) {
						if (startz >= endz) {
							for (z = startz; z >= endz; z--) {
								if (getBlockAtLocation(x, y, z).getType() == material1) {
									blocks.add(getBlockAtLocation(x, y, z));
								}
							}
						}
						if (startz < endz) {
							for (z = startz; z <= endz; z++) {
								if (getBlockAtLocation(x, y, z).getType() == material1) {
									blocks.add(getBlockAtLocation(x, y, z));
								}							
							}
						}
						
					}
				}
				if (starty < endy) {
					for (y = starty; y <= endy; y++) {
						if (startz >= endz) {
							for (z = startz; z >= endz; z--) {
								if (getBlockAtLocation(x, y, z).getType() == material1) {
									blocks.add(getBlockAtLocation(x, y, z));
								}							
							}
						}
						if (startz < endz) {
							for (z = startz; z <= endz; z++) {
								if (getBlockAtLocation(x, y, z).getType() == material1) {
									blocks.add(getBlockAtLocation(x, y, z));
								}							
							}
						}
					}
				}
				
			}
		}
		if (startx < endx) {
			for (x = startx; x <= endx; x++) {
				if (starty >= endy) {
					for (y = starty; y >= endy; y--) {
						if (startz >= endz) {
							for (z = startz; z >= endz; z--) {
								if (getBlockAtLocation(x, y, z).getType() == material1) {
									blocks.add(getBlockAtLocation(x, y, z));
								}							
							}
						}
						if (startz < endz) {
							for (z = startz; z <= endz; z++) {
								if (getBlockAtLocation(x, y, z).getType() == material1) {
									blocks.add(getBlockAtLocation(x, y, z));
								}							
							}
						}
						
					}
				}
				if (starty < endy) {
					for (y = starty; y <= endy; y++) {
						if (startz >= endz) {
							for (z = startz; z >= endz; z--) {
								if (getBlockAtLocation(x, y, z).getType() == material1) {
									blocks.add(getBlockAtLocation(x, y, z));
								}							
							}
						}
						if (startz < endz) {
							for (z = startz; z <= endz; z++) {
								if (getBlockAtLocation(x, y, z).getType() == material1) {
									blocks.add(getBlockAtLocation(x, y, z));
								}							
							}
						}
					}
				}
			}
		}
		
		if (blocks.size() >= 10000) {
			sender.sendMessage(ChatColor.RED + "Edit too large! Choose a smaller area!");
			return;
		}
		
		sender.sendMessage(ChatColor.of("#49B3FF") + "Initializing edit...");
		
		Bukkit.getLogger().info(sender.getName() + ": replacing " + blocks.size() + " " + displayName1 + " for " + displayName2 + "...");
		
		HashMap<Block, Material> undoStorage = new HashMap<>();
		
		for (Block b : blocks) {
			
			Bukkit.getScheduler().runTask(plugin, new Runnable() {
				
				@Override
				public void run() {
					
					undoStorage.put(b, b.getType());
					b.setType(material2);
					
				}
				
			});
			
			try {
				Thread.sleep((1000/(2*blocks.size())) + 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		if (!InfoStorage.editHistory.containsKey(sender)) {
			InfoStorage.editHistory.put(sender, new Stack<HashMap<Block, Material>>());
		}
		
		InfoStorage.editHistory.get(sender).push(undoStorage);
		sender.sendMessage(ChatColor.of("#49B3FF") + "Done! " + ChatColor.of("#FFD700") + blocks.size() + ChatColor.of("#49B3FF") + " blocks modified.");
		Bukkit.getLogger().info(sender.getName() + ": set " + blocks.size() + " " + displayName2 + ".");

	}

	private Block getBlockAtLocation(int x2, int y2, int z2) {
		return sender.getWorld().getBlockAt(new Location(sender.getWorld(), x2, y2, z2));
	}
	
	private String getName(String base) {

		if (base.contains("tnt")) {
			return "TNT ";
		}
		
		String nameSpaced = "";
		
		for (String s : base.split("_")) {
			nameSpaced = nameSpaced + s.substring(0,1).toUpperCase() + s.substring(1) + " ";
		}
		
		return nameSpaced;
		
	}

}
