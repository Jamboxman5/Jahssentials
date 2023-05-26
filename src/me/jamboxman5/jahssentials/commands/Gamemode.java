package me.jamboxman5.jahssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Gamemode implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if (label.equalsIgnoreCase("gamemode") || label.equalsIgnoreCase("gm")) {
			
			if (sender instanceof Player) {
				
				if (player.hasPermission("jahcore.gamemode") && !player.hasPermission("jahcore.gamemode.others")) {
					
					if (args.length == 1) {
						
						if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0")) {
							
							player.setGameMode(GameMode.SURVIVAL);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lSURVIVAL"));
							return true;
							
						}
						
						if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1")) {
							
							player.setGameMode(GameMode.CREATIVE);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lCREATIVE"));
							return true;
							
						}
						
						if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2")) {
							
							
							
							player.setGameMode(GameMode.ADVENTURE);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lADVENTURE"));
							return true;
							
						}
						
						if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3")) {
							
							player.setGameMode(GameMode.SPECTATOR);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lSPECTATOR"));
							return true;
							
						}
						
						player.sendMessage(ChatColor.RED + "That game mode does not exist!");
						return true;
						
					}
					
					player.sendMessage(ChatColor.RED + "Usage: /gamemode <mode>");
					return true;
					
				}
				
				if (player.hasPermission("spc.gamemode.others") && !player.hasPermission("spc.gamemode")) {
					
					if (args.length == 2) {
						
						if (Bukkit.getServer().getPlayer(args[1]) != null) {
							
							Player target = Bukkit.getPlayer(args[1]);
							
							if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0")) {
								
								target.setGameMode(GameMode.SURVIVAL);
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lSURVIVAL " + ChatColor.of("#49B3FF") + "for &c&l" + target.getName()));
								return true;
								
							}
							
							if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1")) {
								
								target.setGameMode(GameMode.CREATIVE);
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lCREATIVE " + ChatColor.of("#49B3FF") + "for &c&l" + target.getName()));
								return true;
								
							}
							
							if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2")) {
								
								target.setGameMode(GameMode.ADVENTURE);
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lADVENTURE " + ChatColor.of("#49B3FF") + "for &c&l" + target.getName()));
								return true;
								
							}
							
							if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3")) {
								
								target.setGameMode(GameMode.SPECTATOR);
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lSPECTATOR " + ChatColor.of("#49B3FF") + "for &c&l" + target.getName()));
								return true;
								
							}
							
							player.sendMessage(ChatColor.RED + "That game mode does not exist!");
							return true;
							
						}
						
						player.sendMessage(ChatColor.RED + "Target not found!");
						return true;
						
					}
					
					player.sendMessage(ChatColor.RED + "Usage: /gamemode <mode> <player>");
					return true;
					
				}
				
				if (player.hasPermission("spc.gamemode") && player.hasPermission("spc.gamemode.others")) {
					
					if (args.length == 1) {
						
						if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0")) {
							
							player.setGameMode(GameMode.SURVIVAL);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lSURVIVAL"));
							return true;
							
						}
						
						if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1")) {
							
							player.setGameMode(GameMode.CREATIVE);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lCREATIVE"));
							return true;
							
						}
						
						if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2")) {
							
							player.setGameMode(GameMode.ADVENTURE);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lADVENTURE"));
							return true;
							
						}
						
						if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3")) {
							
							player.setGameMode(GameMode.SPECTATOR);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lSPECTATOR"));
							return true;
							
						}
						
						player.sendMessage(ChatColor.RED + "That game mode does not exist!");
						return true;
						
					}
					
					if (args.length == 2) {
						
						if (Bukkit.getServer().getPlayer(args[1]) != null) {
							
							Player target = Bukkit.getPlayer(args[1]);
							
							if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0")) {
								
								target.setGameMode(GameMode.SURVIVAL);
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lSURVIVAL " + ChatColor.of("#49B3FF") + "for &c&l" + target.getName()));
								return true;
								
							}
							
							if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1")) {
								
								target.setGameMode(GameMode.CREATIVE);
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lCREATIVE " + ChatColor.of("#49B3FF") + "for &c&l" + target.getName()));
								return true;
								
							}
							
							if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2")) {
								
								target.setGameMode(GameMode.ADVENTURE);
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lADVENTURE " + ChatColor.of("#49B3FF") + "for &c&l" + target.getName()));
								return true;
								
							}
							
							if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3")) {
								
								target.setGameMode(GameMode.SPECTATOR);
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lSPECTATOR " + ChatColor.of("#49B3FF") + "for &c&l" + target.getName()));
								return true;
								
							}
							
							player.sendMessage(ChatColor.RED + "That game mode does not exist!");
							return true;
							
						}
						
						player.sendMessage(ChatColor.RED + "Target not found!");
						return true;
						
					}
					
					player.sendMessage(ChatColor.RED + "Usage: /gamemode <mode> [player]");
					return true;
					
				}
				
				player.sendMessage(ChatColor.RED + "You do not have permission to change game modes!");
				return true;
				
			}
			
			sender.sendMessage("Consoles can't change gamemode!");
			return true;
			
		}
		
		if (label.equalsIgnoreCase("gmc") || label.equalsIgnoreCase("creative")) {
			
			if (sender instanceof Player) {
				
				if (player.hasPermission("spc.gamemode") || player.hasPermission("spc.gamemode.creative")) {
					
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lCREATIVE"));
					
					return true;
					
				}
				
				player.sendMessage(ChatColor.RED + "You do not have permission to change gamemodes!");
				
				return true;
				
			}
			
			sender.sendMessage("Consoles can't change gamemode!");
			
			return true;
			
		}
		
		if (label.equalsIgnoreCase("gms") || label.equalsIgnoreCase("survival")) {
			
			if (sender instanceof Player) {
				
				if (player.hasPermission("spc.gamemode") || player.hasPermission("spc.gamemode.survival")) {
					
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lSURVIVAL"));
					
					return true;
					
				}
				
				player.sendMessage(ChatColor.RED + "You do not have permission to change gamemodes!");
				
				return true;
				
			}
			
			sender.sendMessage("Consoles can't change gamemode!");
			
			return true;
			
		}

		if (label.equalsIgnoreCase("gmsp") || label.equalsIgnoreCase("spectator")) {
			
			if (sender instanceof Player) {
				
				if (player.hasPermission("spc.gamemode") || player.hasPermission("spc.gamemode.spectator")) {
					
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lSPECTATOR"));
					
					return true;
					
				}
				
				player.sendMessage(ChatColor.RED + "You do not have permission to change gamemodes!");
				
				return true;
				
			}
			
			sender.sendMessage("Consoles can't change gamemode!");
			
			return true;
			
		}
		
		if (label.equalsIgnoreCase("gma") || label.equalsIgnoreCase("adventure")) {
			
			if (sender instanceof Player) {
				
				if (player.hasPermission("spc.gamemode") || player.hasPermission("spc.gamemode.adventure")) {
					
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Gamemode updated to " + ChatColor.of("#FFD700") + "&lADVENTURE"));
					
					return true;
					
				}
				
				player.sendMessage(ChatColor.RED + "You do not have permission to change gamemodes!");
				
				return true;
				
			}
			
			sender.sendMessage("Consoles can't change gamemode!");
			
			return true;
			
		}
		
		return false;
	}

}
