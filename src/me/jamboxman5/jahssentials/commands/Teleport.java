package me.jamboxman5.jahssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Teleport implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("teleport") || label.equalsIgnoreCase("tp")) {
			
			if (sender instanceof Player) {
				
				Player player = (Player) sender;
				
				if (player.hasPermission("jahssentials.teleport")) {
					
					if (args.length == 2) {
						
						if ((Bukkit.getServer().getPlayer(args[0]) != null) && (Bukkit.getServer().getPlayer(args[1]) != null)) {
							
							Player target1 = (Player) Bukkit.getServer().getPlayer(args[0]);
							Player target2 = (Player) Bukkit.getServer().getPlayer(args[1]);
							
							target1.teleport(target2);
							player.sendMessage(ChatColor.of("#49B3FF") + "Teleported " + ChatColor.of("#FFD700") + "" + ChatColor.BOLD + target1.getDisplayName() 
							+ ChatColor.of("#49B3FF") + " to " + ChatColor.of("#FFD700") + "" + ChatColor.BOLD + target2.getDisplayName() + ChatColor.of("#49B3FF") + "!");
							target1.sendMessage(ChatColor.of("#49B3FF") + "You have been teleported to " + ChatColor.of("#FFD700") + "" + ChatColor.BOLD + target2.getDisplayName() + ChatColor.of("#49B3FF") + "!");
							target2.sendMessage(ChatColor.of("#FFD700") + "" + ChatColor.BOLD + target1.getDisplayName() + ChatColor.of("#49B3FF") + " has been summoned to your location!");
							return true;
							
						}
						
						player.sendMessage(ChatColor.RED + "One or more of the specified targets not found!");
						return true;
						
					}
					
					if (args.length == 1) {
					
						if ((Bukkit.getServer().getPlayer(args[0]) != null) && (Bukkit.getServer().getPlayer(args[0]).getName() != player.getName())) {
						
							Player target = (Player) Bukkit.getServer().getPlayer(args[0]);
						
							player.teleport(target);
							player.sendMessage(ChatColor.of("#49B3FF") + "Teleported to " + ChatColor.of("#FFD700") + "" + ChatColor.BOLD + target.getDisplayName() + ChatColor.of("#49B3FF") + "!");
							return true;
						
						} else if ((Bukkit.getServer().getPlayer(args[0]) != null) && (Bukkit.getServer().getPlayer(args[0]).getName() == player.getName())) {
							
							player.sendMessage(ChatColor.RED + "You can't teleport to yourself!");
							return true;
							
						} else {
							
							player.sendMessage(ChatColor.RED + "Target not found!");
							return true;

						}
					
					}
					
					if (args.length == 0) {
						
						player.sendMessage(ChatColor.RED + "You must specify a target!");
						return true;
						
					}
					
					player.sendMessage(ChatColor.RED + "You may only specify up to two targets!");
					return true;
					
				}
				
				player.sendMessage(ChatColor.RED + "You do not have permission to directly teleport!");
				return true;
				
			}
			
			sender.sendMessage("Consoles can't teleport!");
			return true;
			
		}
		
		if (label.equalsIgnoreCase("tphere") || label.equalsIgnoreCase("tph") || label.equalsIgnoreCase("summonplayer")) {
			
			if (sender instanceof Player) {
				
				Player player = (Player) sender;
				
				if (player.hasPermission("jahssentials.teleport")) {
					
					if (args.length == 1) {
					
						if ((Bukkit.getServer().getPlayer(args[0]) != null) && (Bukkit.getServer().getPlayer(args[0]).getName() != player.getName())) {
						
							Player target = (Player) Bukkit.getServer().getPlayer(args[0]);
						
							target.teleport(player);
							player.sendMessage(ChatColor.of("#49B3FF") + "Summoned " + ChatColor.of("#FFD700") + "" + ChatColor.BOLD + target.getName() + ChatColor.of("#49B3FF") + " to your location!");
							return true;
						
						} else if ((Bukkit.getServer().getPlayer(args[0]) != null) && (Bukkit.getServer().getPlayer(args[0]).getName() == player.getName())) {
							
							player.sendMessage(ChatColor.RED + "You can't summon yourself!");
							return true;
							
						} else {
					
						player.sendMessage(ChatColor.RED + "Target not found!");
						return true;	
						
						}
					
					}
					
					if (args.length == 0) {
						
						player.sendMessage(ChatColor.RED + "You must specify a target!");
						return true;
						
					}
					
					if (args.length > 1) {
						
						int playercounter = 0;
						
						String tplist = "&bSuccessfully summoned the following players: ";
						
						for (int i = 0; i < args.length; i++) {
							
							if ((Bukkit.getServer().getPlayer(args[i]) != null) && (Bukkit.getServer().getPlayer(args[i]).getName() != player.getName())) {
								
								playercounter = playercounter + 1;
								
								Player target = (Player) Bukkit.getServer().getPlayer(args[i]);
							
								target.teleport(player);
								target.sendMessage(ChatColor.of("#49B3FF") + "You have been summoned by " + ChatColor.of("#FFD700") + "" + ChatColor.BOLD + player.getName() + ChatColor.of("#49B3FF") + "!");
								tplist = tplist + ChatColor.of("#49B3FF") + ", " + ChatColor.of("#FFD700") + "" + ChatColor.BOLD + target.getName();
							
							}
							
						}
						
						if (playercounter > 0) {
						
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', tplist));
							return true;
						
						}
						
						player.sendMessage(ChatColor.RED + "No applicable players were found in your list!");
						return true;
						
					}
					
				}
				
				player.sendMessage(ChatColor.RED + "You do not have permission to summon players!");
				return true;
				
			}
			
			sender.sendMessage("Consoles can't summon players!");
			return true;
			
		}
		
		if (label.equalsIgnoreCase("tppos")) {
			if (!sender.hasPermission("jahssential.tppos")) {
				sender.sendMessage(ChatColor.RED + "You don't have permission to do that");
				return true;
			}
			boolean isTargeted = false;
			if (args.length < 3) {
				sender.sendMessage(ChatColor.RED + "Usage: /tppos [player] <x> <y> <z>");
				return true;
			}
			if (Bukkit.getPlayer(args[0]) != null) isTargeted = true;
			
			int x;
			int y;
			int z;
						
			Player p = null;
			
			if (sender instanceof Player) {
				p = (Player) sender;
			}
			
			if (isTargeted) {
				p = Bukkit.getPlayer(args[0]);
				try {
					x = Integer.parseInt(args[1]);
					y = Integer.parseInt(args[2]);
					z = Integer.parseInt(args[3]);
				} catch (Exception e) {
					sender.sendMessage(ChatColor.RED + "Invalid Coordinates!");
					return true;
				}
			} else {
				try {
					x = Integer.parseInt(args[0]);
					y = Integer.parseInt(args[1]);
					z = Integer.parseInt(args[2]);
				} catch (Exception e) {
					sender.sendMessage(ChatColor.RED + "Invalid Coordinates!");
					return true;
				}
			}
			
			if (p == null) {
				sender.sendMessage("You can't do that!");
				return true;
			}
			p.teleport(new Location(p.getWorld(), x, y, z));
			sender.sendMessage(ChatColor.of("#49B3FF") + "Teleported to " + ChatColor.of("#FFD700") + x + ChatColor.of("#49B3FF") + ", " +
																			ChatColor.of("#FFD700") + y + ChatColor.of("#49B3FF") + ", " +
																			ChatColor.of("#FFD700") + z + ChatColor.of("#49B3FF") + ". ");
			return true;
		}
		
		return false;
		
	}

}
