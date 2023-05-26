package me.jamboxman5.jahssentials.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import me.jamboxman5.jahssentials.main.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;

public class EXAntiBuildListener implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		if (!(e.getPlayer() instanceof Player)) return;
		
		if (e.getBlock().getType() == Material.DEEPSLATE_DIAMOND_ORE ^
			e.getBlock().getType() == Material.DIAMOND_ORE ^
			e.getBlock().getType() == Material.ANCIENT_DEBRIS) {
			
			String name = getName(e.getBlock().getBlockData().getAsString());
			
			for (String n : Main.infoStorage.getAdmins()) {
				if (Bukkit.getPlayer(n) != null && 
					e.getPlayer() != Bukkit.getServer().getPlayer(n)) {
					
					Player p = Bukkit.getServer().getPlayer(n);
					
					TextComponent playername = new TextComponent(e.getPlayer().getName());
					TextComponent broke = new TextComponent(" broke ");
					TextComponent blockname = new TextComponent(getName(e.getBlock().getBlockData().getAsString()));
					TextComponent at = new TextComponent("at ");
					TextComponent location = new TextComponent(getLocation(e.getBlock()));
					
					TextComponent[] comps = {playername, broke, blockname, at, location};
					
					playername.setColor(ChatColor.RED);
					broke.setColor(ChatColor.DARK_RED);
					blockname.setColor(ChatColor.RED);
					at.setColor(ChatColor.DARK_RED);
					location.setColor(ChatColor.RED);
					
					playername.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + e.getPlayer().getName()));
					location.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tppos " + getLocationRaw(e.getBlock())));
					playername.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(
							ChatColor.translateAlternateColorCodes('&', "&7Click to teleport to &b" + e.getPlayer().getName()))));
					location.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(
							ChatColor.translateAlternateColorCodes('&', "&7Click to teleport to &ethis block"))));
					p.spigot().sendMessage(comps);
					
					
				}
				
			}
			
			Bukkit.getServer().getLogger().info(ChatColor.RED + e.getPlayer().getName() + ChatColor.DARK_RED + " broke " + ChatColor.RED + name
					+ ChatColor.DARK_RED + " at " + ChatColor.RED + e.getBlock().getX() + ", " + e.getBlock().getY() + ", " + e.getBlock().getZ());
			
		}
		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		if (e.getPlayer() == null) return;
		if (!(e.getPlayer() instanceof Player)) return;
		
		if (e.getBlock().getType() == Material.TNT ^
			e.getBlock().getType() == Material.LAVA) {
			
			String name = getName(e.getBlock().getBlockData().getAsString());
			
			for (String n : Main.infoStorage.getAdmins()) {
				if (Bukkit.getPlayer(n) != null && 
					e.getPlayer() != Bukkit.getServer().getPlayer(n)) {
					
					Player p = Bukkit.getServer().getPlayer(n);
					
					TextComponent playername = new TextComponent(e.getPlayer().getName());
					TextComponent placed = new TextComponent(" placed ");
					TextComponent blockname = new TextComponent(getName(e.getBlockPlaced().getBlockData().getAsString()));
					TextComponent at = new TextComponent("at ");
					TextComponent location = new TextComponent(getLocation(e.getBlockPlaced()));
					
					TextComponent[] comps = {playername, placed, blockname, at, location};
					
					playername.setColor(ChatColor.RED);
					placed.setColor(ChatColor.DARK_RED);
					blockname.setColor(ChatColor.RED);
					at.setColor(ChatColor.DARK_RED);
					location.setColor(ChatColor.RED);
					
					playername.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + e.getPlayer().getName()));
					location.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tppos " + getLocationRaw(e.getBlockPlaced())));
					playername.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(
							ChatColor.translateAlternateColorCodes('&', "&7Click to teleport to &b" + e.getPlayer().getName()))));
					location.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(
							ChatColor.translateAlternateColorCodes('&', "&7Click to teleport to &ethis block"))));
					p.spigot().sendMessage(comps);
					
					
				}
				
			}
			
			Bukkit.getServer().getLogger().info(ChatColor.RED + e.getPlayer().getName() + ChatColor.DARK_RED + " placed " + ChatColor.RED + name
					+ ChatColor.DARK_RED + " at " + ChatColor.RED + e.getBlock().getX() + ", " + e.getBlock().getY() + ", " + e.getBlock().getZ());
			
		}
		
	}
	
	private String getLocationRaw(Block block) {

		String loc = block.getX() + " " +
					 block.getY() + " " +
					 block.getZ();
		
		return loc;
		
	}

	private String getLocation(Block block) {

		String loc = block.getWorld().getName() + ", " +
					 block.getX() + ", " +
					 block.getY() + ", " +
					 block.getZ();
		
		return loc;
		
	}

	private String getName(String base) {

		if (base.contains("tnt")) {
			return "TNT ";
		}
		
		String newNameBase;
		String nameSpaced = "";
		
		newNameBase = base.substring(10);
		
		for (String s : newNameBase.split("_")) {
			nameSpaced = nameSpaced + s.substring(0,1).toUpperCase() + s.substring(1) + " ";
		}
		
		return nameSpaced;
		
	}
	
}
