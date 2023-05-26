package me.jamboxman5.jahssentials.runnables;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import me.jamboxman5.jahssentials.main.Main;
import net.md_5.bungee.api.ChatColor;

public class NoMoreOresThread implements Runnable {

	private Player sender;
	private Player target;
	private int radius;
	
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
	
	public NoMoreOresThread(Player p, Player t, int r, Main main) {
		
		plugin = main;
		
		sender = p;
		target = t;
		radius = r;

		startx = (int) (target.getLocation().getX() - radius);
		starty = (int) (target.getLocation().getY() - radius);
		startz = (int) (target.getLocation().getZ() - radius);
		
		endx = (int) (target.getLocation().getX() + radius);
		endy = (int) (target.getLocation().getY() + radius);
		endz = (int) (target.getLocation().getZ() + radius);
		
	}
	
	@Override
	public void run() {
		
		sender.sendMessage(ChatColor.of("#49B3FF") + "Finding ores...");
		
		for (x = startx; x < endx; x++) {
			for (y = starty; y < endy; y++) {
				for (z = startz; z < endz; z++) {
					if (getBlockAtLocation(x, y, z).getType().toString().contains("ORE")) {
						blocks.add(getBlockAtLocation(x, y, z));
					}
				}
			}
		}
		
		if (blocks.size() == 0) {
			sender.sendMessage(ChatColor.of("#49B3FF") + "No ores found.");
			return;
		}
		
		
		sender.sendMessage(ChatColor.of("#FFD700") + "" + blocks.size() + ChatColor.of("#49B3FF") + " ores found! Removing...");
		
		Bukkit.getLogger().info(sender.getName() + ": removing " + blocks.size() + " ores...");
		
		for (Block b : blocks) {
			
			Bukkit.getScheduler().runTask(plugin, new Runnable() {

				@Override
				public void run() {

					if (b.getType().toString().contains("DEEPSLATE")) {
						b.setType(Material.DEEPSLATE);
					} else if (b.getType().toString().contains("QUARTZ")) {
						b.setType(Material.NETHERRACK);
					} else {
						b.setType(Material.STONE);
					}					
				}
				
			});
			
			try {
				Thread.sleep(1000/blocks.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		sender.sendMessage(ChatColor.of("#49B3FF") + "Done!");
		Bukkit.getLogger().info(sender.getName() + ": removed " + blocks.size() + " ores.");

	}

	private Block getBlockAtLocation(int x2, int y2, int z2) {
		return target.getWorld().getBlockAt(new Location(target.getWorld(), x2, y2, z2));
	}

}
