package me.jamboxman5.jahssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Fly implements CommandExecutor {
	
	@Override
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if (label.equalsIgnoreCase("fly")) {
		
			if (sender instanceof Player) {
			
				if (player.hasPermission("jahssentials.fly")) {
					
					if (player.hasPermission("jahssentials.fly.others")) {
						
						if (args.length == 1) {
						
							if (Bukkit.getServer().getPlayer(args[0]) != null) {
							
								Player target = Bukkit.getServer().getPlayer(args[0]);
								
								if (target instanceof Player) {
							
									if (target.getAllowFlight() == false) {
									
										target.setAllowFlight(true);
										target.sendMessage(ChatColor.translateAlternateColorCodes( '&' , "&bFly mode &aON"));
									
										return true;

									}
								
									target.setAllowFlight(false);
									target.sendMessage(ChatColor.translateAlternateColorCodes( '&' , "&bFly mode &cOFF"));

									return true;
									
								}

							}
								
							player.sendMessage(ChatColor.RED + "Player not found!");
								
							return true;
							
						}	
							
					}	
				
					if (player.getAllowFlight() == false) {
					
						player.setAllowFlight(true);
						player.sendMessage(ChatColor.translateAlternateColorCodes( '&' , "&bFly mode &aON"));
						
						return true;

					}
					
					player.setAllowFlight(false);
					player.sendMessage(ChatColor.translateAlternateColorCodes( '&' , "&bFly mode &cOFF"));

					return true;
					
				}
				
				player.sendMessage(ChatColor.RED + "You do not have permission to fly!");
				
				return true;
			}
			
			sender.sendMessage("Fly mode toggled for the console!");
		}
		
		if (label.equalsIgnoreCase("flyspeed")) {
			
			if (sender instanceof Player) {
				
				if (player.hasPermission("plugindev.fly")) {
					
					if (!(args.length == 0)) {
						
						if (isNum(args[0])) {
							
							int speed = (Integer.parseInt(args[0]) / 10);
							
							if (speed <= 1 && speed >= 0) {
								
								player.setFlySpeed((float) (Integer.parseInt(args[0]) / 10.00));
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bFlyspeed set to " + ChatColor.GREEN + "" + ChatColor.BOLD + args[0]));
								return true;
								
							}
							
							player.sendMessage(ChatColor.RED + "Speed must be a value between 0 and 10! " + ChatColor.GRAY + "(Default: 2)");
							return true;
							
						}
						
						player.sendMessage(ChatColor.RED + "Usage: /flyspeed <#>");
						return true;
						
					}
						
					player.sendMessage(ChatColor.RED + "Please specify your desired speed!");
					return true;

				}
				
				player.sendMessage(ChatColor.RED + "You do not have permission to change your flyspeed!");
				return true;
				
			}
				
			player.sendMessage(ChatColor.RED + "Consoles can't fly!");		
			return true;
			
		}
		
		return false;
			
	}
	
	public boolean isNum(String num) {

		try {
			
			Integer.parseInt(num);
		} catch (Exception e) {
			
			return false;
			
		}
		
		return true;
			
		}
	
	

}
