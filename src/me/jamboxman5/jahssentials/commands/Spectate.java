package me.jamboxman5.jahssentials.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Spectate implements CommandExecutor {
	
	HashMap<Player, Location> locationStorage = new HashMap<>();
	HashMap<Player, Player> targetStorage = new HashMap<>();
	HashMap<Player, GameMode> gameModeStorage = new HashMap<>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("spec")) {
			
			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;
			
			if (!p.hasPermission("jahcraft.spectate")) {
				p.sendMessage(ChatColor.RED + "You don't have permission to spectate players!");
				return true;
			}
			
			if (!(args.length == 1)) {
				p.sendMessage(ChatColor.RED + "You must specify a player! (Usage: /spec <name>)");
				return true;
			}
			
			if (p.getGameMode() == GameMode.SPECTATOR) {
				p.sendMessage(ChatColor.RED + "You are already spectating a player! Use \"/unspec\" first!");
				return true;
			}
						
			if ((Bukkit.getServer().getPlayer(args[0]) != null) && (Bukkit.getServer().getPlayer(args[0]).getName() != p.getName())) {
				
				Location originalLocation = p.getLocation();
				
				Player target = (Player) Bukkit.getServer().getPlayer(args[0]);

				if (target.hasPermission("jahcraft.spectate.immune")) {
					p.sendMessage(ChatColor.RED + "You cannot spectate that player!");
					return true;
				}
				
				locationStorage.put(p, originalLocation);
				gameModeStorage.put(p, p.getGameMode());
				
			
				targetStorage.put(p, target);
				
				p.setGameMode(GameMode.SPECTATOR);
				p.teleport(target);
				p.teleport(target);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bNow spectating &a&l" + target.getDisplayName() + "&b!"));
				return true;
			
			} else if ((Bukkit.getServer().getPlayer(args[0]) != null) && (Bukkit.getServer().getPlayer(args[0]).getName() == p.getName())) {
				
				p.sendMessage(ChatColor.RED + "You can't spectate yourself!");
				return true;
				
			} else {
				
				p.sendMessage(ChatColor.RED + "Target not found!");
				return true;

			}
			
			
			
			
		}
		
		if (label.equalsIgnoreCase("unspec")) {
			
			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;
			
			if (!p.hasPermission("jahcraft.spectate")) {
				p.sendMessage(ChatColor.RED + "You don't have permission to spectate players!");
				return true;
			}
				
			if (p.getGameMode() != GameMode.SPECTATOR) {
				p.sendMessage(ChatColor.RED + "You're not spectating anyone!");
				return true;
			}
			
			//RESTORE GAMEMODE
			
			if (gameModeStorage.get(p) != null) {
				p.setGameMode(gameModeStorage.get(p));
			} else {
				p.setGameMode(GameMode.SURVIVAL);
			}
			
			//RESTORE LOCATION
			
			if (locationStorage.get(p) != null) {
				p.teleport(locationStorage.get(p));
				p.teleport(locationStorage.get(p));
			} else {
				p.teleport(Bukkit.getServer().getWorld("world").getSpawnLocation());
				p.sendMessage(ChatColor.AQUA + "No previous location found, sending you to spawn!");
			}
			
			//GET TARGET
			
			if (targetStorage.get(p) != null) {
				Player target = targetStorage.get(p);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bYou are no longer spectating &a&l" + target.getDisplayName() + "&b!"));
			} else {
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage(ChatColor.AQUA + "You are no longer spectating!");
			}
			
			return true;
			
		}
		
		return false;
		
	}

}
