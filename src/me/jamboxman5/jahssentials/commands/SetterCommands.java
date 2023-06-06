package me.jamboxman5.jahssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
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

			setDurability(sender, args);
			
		}
		
		if (label.equalsIgnoreCase("setmodeldata")) {

			setModelData(sender, args);
			
		}
		
		if (label.equalsIgnoreCase("sethealth")) {
			
			setHealth(sender, args);
			
		}
		
		//-------------------------------------------------------------------------
		
		if (label.equalsIgnoreCase("setfood")) {
			
			setFood(sender, args);
			
		}
		
		//-------------------------------------------------------------------------
		
		if (label.equalsIgnoreCase("setsaturation")) {
			
			setSaturation(sender, args);
			
		}
		
		if (label.equalsIgnoreCase("setmaxhealth")) {
			
			setMaxHealth(sender, args);
			
		}

		return false;

	}

	private void setMaxHealth(CommandSender sender, String[] args) {
if (sender.hasPermission("jahcore.admin")) {
			
			if (args.length == 2) {
				
				if (Bukkit.getServer().getPlayer(args[0]) != null) {
					
					Player target = Bukkit.getServer().getPlayer(args[0]);

					int level = Integer.parseInt(args[1]);
					
					if (level <= 1000 && level >= 0) {
						
						target.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(level);
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF")+ "Target &a&l" + target.getName() + ChatColor.of("#49B3FF") + "'s max health has been set to &c&l" + level));
						return;
						
					}
					
					sender.sendMessage(ChatColor.RED + "Level must be between 0 and 1000!");
					return;
					
				}
				
				sender.sendMessage(ChatColor.RED + "Target not found!");
				return;
				
			}
			
			sender.sendMessage(ChatColor.RED + "Correct usage: /setmaxhealth <player> <health-level>");
			return;
			
		}
		
		sender.sendMessage(ChatColor.RED + "You do not have permission to set the max health of other players!");
		return;			
	}

	private void setSaturation(CommandSender sender, String[] args) {
		if (sender.hasPermission("jahcore.admin")) {
			
			if (args.length == 2) {
				
				if (Bukkit.getServer().getPlayer(args[0]) != null) {
					
					Player target = Bukkit.getServer().getPlayer(args[0]);

					int level = Integer.parseInt(args[1]);
					
					if (level >= 0) {
						
						target.setSaturation(level);
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF") + "Target &a&l" + target.getName() + ChatColor.of("#49B3FF") + "'s saturation level has been set to &6&l" + level));
						return;
						
					}
					
					sender.sendMessage(ChatColor.RED + "Level must be greater than 0!");
					return;
					
				}
				
				sender.sendMessage(ChatColor.RED + "Target not found!");
				return;
				
			}
			
			sender.sendMessage(ChatColor.RED + "Correct usage: /setsaturation <player> <saturation-level>");
			return;
			
		}
		
		sender.sendMessage(ChatColor.RED + "You do not have permission to set the saturation level of other players!");
		return;		
	}
	private void setFood(CommandSender sender, String[] args) {
		if (sender.hasPermission("jahcore.admin")) {
			
			if (args.length == 2) {
				
				if (Bukkit.getServer().getPlayer(args[0]) != null) {
					
					Player target = Bukkit.getServer().getPlayer(args[0]);

					int level = Integer.parseInt(args[1]);
					
					if (level <= 20 && level >= 0) {
						
						target.setFoodLevel(level);
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF")+ "Target &a&l" + target.getName() + ChatColor.of("#49B3FF") + "'s food level has been set to &6&l" + level));
						return;
						
					}
					
					sender.sendMessage(ChatColor.RED + "Level must be between 0 and 20!");
					return;
					
				}
				
				sender.sendMessage(ChatColor.RED + "Target not found!");
				return;
				
			}
			
			sender.sendMessage(ChatColor.RED + "Correct usage: /setfood <player> <food-level>");
			return;
			
		}
		
		sender.sendMessage(ChatColor.RED + "You do not have permission to set the food level of other players!");
		return;		
	}
	private void setHealth(CommandSender sender, String[] args) {
		if (sender.hasPermission("jahcore.admin")) {
			
			if (args.length == 2) {
				
				if (Bukkit.getServer().getPlayer(args[0]) != null) {
					
					Player target = Bukkit.getServer().getPlayer(args[0]);

					int level = Integer.parseInt(args[1]);
					
					if (level <= target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() && level >= 0) {
						target.setHealth(level);
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#49B3FF")+ "Target &a&l" + target.getName() + ChatColor.of("#49B3FF") + "'s health has been set to &c&l" + level));
						return;
						
					}
					
					sender.sendMessage(ChatColor.RED + "Health must be between 0 and " + target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() + "!");
					return;
					
				}
				
				sender.sendMessage(ChatColor.RED + "Target not found!");
				return;
				
			}
			
			sender.sendMessage(ChatColor.RED + "Correct usage: /sethealth <player> <health-level>");
			return;
			
		}
		
		sender.sendMessage(ChatColor.RED + "You do not have permission to set the health of other players!");
		return;		
	}
	private void setModelData(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) return;
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("jahcore.admin")) {
			p.sendMessage(ChatColor.RED + "You don't have permission to do that");
			return;
		}
		
		if (p.getInventory().getItemInMainHand().getType() == Material.AIR) {
			p.sendMessage(ChatColor.RED + "You must be holding an item!");
			return;
		}
		
		if (args.length != 1) {
			p.sendMessage(ChatColor.RED + "Usage: /setmodeldata <int>");
			return;
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
			return;
		}		
	}
	private void setDurability(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) return;
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("jahcore.admin")) {
			p.sendMessage(ChatColor.RED + "You don't have permission to do that");
			return;
		}
		
		if (p.getInventory().getItemInMainHand().getType() == Material.AIR) {
			p.sendMessage(ChatColor.RED + "You must be holding an item!");
			return;
		}
		
		if (!(p.getInventory().getItemInMainHand().getItemMeta() instanceof Damageable)) {
			p.sendMessage(ChatColor.RED + "You must be holding a damageable item!");
			return;
		}
		
		if (args.length != 1) {
			p.sendMessage(ChatColor.RED + "Usage: /setdurability <int>");
			return;
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
			return;
		}		
	}

}
