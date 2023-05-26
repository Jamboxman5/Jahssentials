package me.jamboxman5.jahssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class SetterCommands implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("setdurability")) {

			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;
			
			if (!p.hasPermission("jahcore.admin")) {
				p.sendMessage(ChatColor.RED + "You don't have permission to do that");
				return true;
			}
			
			if (p.getInventory().getItemInMainHand().getType() == Material.AIR) {
				p.sendMessage(ChatColor.RED + "You must be holding an item!");
				return true;
			}
			
			if (!(p.getInventory().getItemInMainHand().getItemMeta() instanceof Damageable)) {
				p.sendMessage(ChatColor.RED + "You must be holding a damageable item!");
				return true;
			}
			
			if (args.length != 1) {
				p.sendMessage(ChatColor.RED + "Usage: /setdurability <int>");
				return true;
			}
			
			try {
				
				int newDurability = Integer.parseInt(args[0]);
				ItemStack i = p.getInventory().getItemInMainHand();
				Damageable meta = (Damageable) i.getItemMeta();
				meta.setDamage(i.getType().getMaxDurability() - newDurability);
				i.setItemMeta(meta);
				p.sendMessage(ChatColor.of("#49B3FF") + "Durability Updated.");
				
			} catch (Exception e) {
				p.sendMessage(ChatColor.RED + "Usage: /setdurability <int>");
				return true;
			}
			
		}
		
		if (label.equalsIgnoreCase("setmodeldata")) {

			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;
			
			if (!p.hasPermission("jahcore.admin")) {
				p.sendMessage(ChatColor.RED + "You don't have permission to do that");
				return true;
			}
			
			if (p.getInventory().getItemInMainHand().getType() == Material.AIR) {
				p.sendMessage(ChatColor.RED + "You must be holding an item!");
				return true;
			}
			
			if (args.length != 1) {
				p.sendMessage(ChatColor.RED + "Usage: /setmodeldata <int>");
				return true;
			}
			
			try {
				
				int modelData = Integer.parseInt(args[0]);
				ItemStack i = p.getInventory().getItemInMainHand();
				ItemMeta meta = i.getItemMeta();
				meta.setCustomModelData(modelData);
				i.setItemMeta(meta);
				p.sendMessage(ChatColor.of("#49B3FF") + "Model Data Updated.");
				
			} catch (Exception e) {
				p.sendMessage(ChatColor.RED + "Usage: /setmodeldata <int>");
				return true;
			}
			
		}
		
		if (label.equalsIgnoreCase("sethealth")) {
			
			if (sender.hasPermission("jahcore.admin")) {
				
				if (args.length == 2) {
					
					if (Bukkit.getServer().getPlayer(args[0]) != null) {
						
						Player target = Bukkit.getServer().getPlayer(args[0]);

						int level = Integer.parseInt(args[1]);
						
						if (level <= 20 && level >= 0) {
							
							target.setHealth(level);
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF")+ "Target &a&l" + target.getName() + ChatColor.of("#49B3FF") + "'s health has been set to &c&l" + level));
							return true;
							
						}
						
						sender.sendMessage(ChatColor.RED + "Level must be between 0 and 20!");
						return true;
						
					}
					
					sender.sendMessage(ChatColor.RED + "Target not found!");
					return true;
					
				}
				
				sender.sendMessage(ChatColor.RED + "Correct usage: /sethealth <player> <health-level>");
				return true;
				
			}
			
			sender.sendMessage(ChatColor.RED + "You do not have permission to set the health of other players!");
			return true;
			
		}
		
		//-------------------------------------------------------------------------
		
		if (label.equalsIgnoreCase("setfood")) {
			
			if (sender.hasPermission("jahcore.admin")) {
				
				if (args.length == 2) {
					
					if (Bukkit.getServer().getPlayer(args[0]) != null) {
						
						Player target = Bukkit.getServer().getPlayer(args[0]);

						int level = Integer.parseInt(args[1]);
						
						if (level <= 20 && level >= 0) {
							
							target.setFoodLevel(level);
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF")+ "Target &a&l" + target.getName() + ChatColor.of("#49B3FF") + "'s food level has been set to &6&l" + level));
							return true;
							
						}
						
						sender.sendMessage(ChatColor.RED + "Level must be between 0 and 20!");
						return true;
						
					}
					
					sender.sendMessage(ChatColor.RED + "Target not found!");
					return true;
					
				}
				
				sender.sendMessage(ChatColor.RED + "Correct usage: /setfood <player> <food-level>");
				return true;
				
			}
			
			sender.sendMessage(ChatColor.RED + "You do not have permission to set the food level of other players!");
			return true;
			
		}
		
		//-------------------------------------------------------------------------
		
		if (label.equalsIgnoreCase("setsaturation")) {
			
			if (sender.hasPermission("jahcore.admin")) {
				
				if (args.length == 2) {
					
					if (Bukkit.getServer().getPlayer(args[0]) != null) {
						
						Player target = Bukkit.getServer().getPlayer(args[0]);

						int level = Integer.parseInt(args[1]);
						
						if (level >= 0) {
							
							target.setSaturation(level);
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Target &a&l" + target.getName() + ChatColor.of("#49B3FF") + "'s saturation level has been set to &6&l" + level));
							return true;
							
						}
						
						sender.sendMessage(ChatColor.RED + "Level must be greater than 0!");
						return true;
						
					}
					
					sender.sendMessage(ChatColor.RED + "Target not found!");
					return true;
					
				}
				
				sender.sendMessage(ChatColor.RED + "Correct usage: /setsaturation <player> <saturation-level>");
				return true;
				
			}
			
			sender.sendMessage(ChatColor.RED + "You do not have permission to set the saturation level of other players!");
			return true;
			
		}

		return false;

	}

}
