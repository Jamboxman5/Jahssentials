package me.jamboxman5.jahssentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jamboxman5.jahssentials.util.Colors;
import net.md_5.bungee.api.ChatColor;

public class InfoCommands implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("help")) {
						
			sendHelp(sender, args);
			return true;
			
		}
		
		if (label.equalsIgnoreCase("jahcolors")) {
			
			sendColors(sender);
			return true;
			
		}
		
		if (label.equalsIgnoreCase("discord")) {
			
			sendDiscord(sender);
			return true;
			
		}
		
		if (label.equalsIgnoreCase("buy")) {
			
			sendBuy(sender);
			return true;
			
		}
		
		if (label.equalsIgnoreCase("apply")) {
			
			sendApply(sender);
			return true;
			
		}
		
		if (label.equalsIgnoreCase("links")) {
			
			sendLinks(sender);
			return true;
			
		}
		
		if (label.equalsIgnoreCase("ranks")) {
			
			sendRanks(sender);
			return true;
			
		}
		
		if (label.equalsIgnoreCase("map")) {
			
			sendMap(sender);
			return true;
			
		}
		
		return false;

	}
	
	private void sendColors(CommandSender sender) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "---=====" + ChatColor.translateAlternateColorCodes('&', "&7&l[ " + ChatColor.of("#FFD700") + "&lJahColors &7&l]") + ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=====---");
			p.sendMessage(ChatColor.GRAY + "[" + ChatColor.of("#00E8FF") + "#FFD700" + ChatColor.GRAY + "]" + " - " + 
			Colors.GOLD + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.UNDERLINE + "||||||||||||||||||");
			p.sendMessage(ChatColor.GRAY + "[" + ChatColor.of("#00E8FF") + "#49B3FF" + ChatColor.GRAY + "]" + " - " + 
			Colors.BLUE + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.UNDERLINE + "||||||||||||||||||");
			p.sendMessage(ChatColor.GRAY + "[" + ChatColor.of("#00E8FF") + "#00E8FF" + ChatColor.GRAY + "]" + " - " + 
			Colors.BRIGHTBLUE + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.UNDERLINE + "||||||||||||||||||");
			p.sendMessage(ChatColor.GRAY + "[" + ChatColor.of("#00E8FF") + "#76B9E6" + ChatColor.GRAY + "]" + " - " + 
			Colors.PALEBLUE + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.UNDERLINE + "||||||||||||||||||");
		} else return;
		
	}

	private void sendMap(CommandSender sender) {
		if (sender instanceof Player) {
			// player
			Player player = (Player) sender;
			if (player.hasPermission("jahcraft.info")) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#FFD700") + "" + ChatColor.BOLD + ">> " + ChatColor.GREEN + "&aCheck out the dynmap! &7&nmc.jahcraft.net:8123"));
				return;
			}
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
			return;
		}
		else {
			//console
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aCheck out the dynmap! &7&nmc.jahcraft.net:8123"));
			return;
		}
		
	}

	private void sendRanks(CommandSender sender) {
		if (sender instanceof Player) {
			// player
			Player player = (Player) sender;
			if (player.hasPermission("jahcraft.info")) {
				player.sendMessage(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "---=====" + ChatColor.translateAlternateColorCodes('&', "&7&l[ " + ChatColor.of("#FFD700") + "&lRanks &7&l]") + ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=====---");
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[" + ChatColor.of("#FFFFFF") + "Beginner" + ChatColor.translateAlternateColorCodes('&', "&7] - ") + ChatColor.of("#779AD8") + "Default rank."));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[" + ChatColor.of("#A0FF7C") + "Resident" + ChatColor.translateAlternateColorCodes('&', "&7] - ") + ChatColor.of("#779AD8") + "Earned after playing " + ChatColor.of("#00E8FF") + "2 hours" + ChatColor.of("#779AD8") + "."));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[" + ChatColor.of("#50FFA0") + "Citizen" + ChatColor.translateAlternateColorCodes('&', "&7] - ") + ChatColor.of("#779AD8") + "Earned after playing " + ChatColor.of("#00E8FF") + "15 hours" + ChatColor.of("#779AD8") + "."));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[" + ChatColor.of("#93FFFF") + "Veteran" + ChatColor.translateAlternateColorCodes('&', "&7] - ") + ChatColor.of("#779AD8") + "Earned after playing " + ChatColor.of("#00E8FF") + "50 hours" + ChatColor.of("#779AD8") + "."));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[" + ChatColor.of("#93C0FF") + "Decorated" + ChatColor.translateAlternateColorCodes('&', "&7] - ") + ChatColor.of("#779AD8") + "Earned after playing " + ChatColor.of("#00E8FF") + "100 hours" + ChatColor.of("#779AD8") + "."));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[" + ChatColor.of("#9F9BEF") + "Nobility" + ChatColor.translateAlternateColorCodes('&', "&7] - ") + ChatColor.of("#779AD8") + "Earned after playing " + ChatColor.of("#00E8FF") + "250 hours" + ChatColor.of("#779AD8") + "."));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[" + ChatColor.of("#A47FD8") + "Scholar" + ChatColor.translateAlternateColorCodes('&', "&7] - ") + ChatColor.of("#779AD8") + "Earned after playing " + ChatColor.of("#00E8FF") + "500 hours" + ChatColor.of("#779AD8") + "."));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[" + ChatColor.of("#B058E2") + "Hero" + ChatColor.translateAlternateColorCodes('&', "&7] - ") + ChatColor.of("#779AD8") + "Earned after playing " + ChatColor.of("#00E8FF") + "1000 hours" + ChatColor.of("#779AD8") + "."));
				player.sendMessage(ChatColor.of("#00E8FF") + "[" + ChatColor.of("#E05779") + "" + ChatColor.BOLD + "Legacy" + ChatColor.of("#00E8FF") + "]" + ChatColor.translateAlternateColorCodes('&', " &7- ") + ChatColor.of("#779AD8") + "Rewarded to " + ChatColor.of("#00E8FF") + "legacy donors" + ChatColor.of("#779AD8") + "." + ChatColor.of("#AAAAAA") + " (No longer available)");
				player.sendMessage(ChatColor.of("#00E8FF") + "[" + ChatColor.of("#FFD700") + "" + ChatColor.BOLD + "Jah+" + ChatColor.of("#00E8FF") + "]" + ChatColor.translateAlternateColorCodes('&', " &7- ") + ChatColor.of("#779AD8") + "Subscription donor rank " + ChatColor.of("#00E8FF") + "($15/month)" + ChatColor.of("#779AD8") + "." + ChatColor.of("#AAAAAA") + " (/buy)");
				player.sendMessage(ChatColor.of("#49B3FF") + "Use " + ChatColor.of("#00E8FF") + "/playtime" + ChatColor.of("#49B3FF") + " to check your time, and " + ChatColor.of("#00E8FF") + "/rankup" + ChatColor.of("#49B3FF") + " to rank up!");
				return;
			}
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
			return; 
		}
		else {
			//console
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lJahCraft Rank List:"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&fBeginner&7] - &6Default Rank."));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2Resident&7] - &6Earned after playing for &b2 hours&r &6or completing the &bsurvey&r&6"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&bCitizen&7] - &6Earned after playing &b15 hours&r&6."));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&dVeteran&7] - &6Earned after playing &b50 hours&r&6."));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&a&lDecorated&r&7] - &6Earned after playing &b100 hours&r&6."));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&5Nobility&7] - &6Earned after playing &b250 hours&r&6."));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2&lScholar&7] - &6Earned after playing &b500 hours&r&6."));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6Hero&7] - &6Earned after playing &b1000 hours&r&6."));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[&e&lMember&b] &7- &6Can be purchased for &b$10.00&r&6 with &b/donate&r&6."));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[&6&lElite&b] &7- &6Can be purchased for &b$15.00&r&6 with &b/donate&r&6."));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[&4&lLegend&b] &7- &6Can be purchased for &b$25.00&r&6 with &b/donate&r&6."));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aUse /playtime to check your time, and /rankup to rank up!"));
			return;
		}
		
	}

	private void sendLinks(CommandSender sender) {
		if (sender instanceof Player) {
			// player
			Player player = (Player) sender;
			if (player.hasPermission("jahcraft.info")) {
				player.sendMessage(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "---=====" + ChatColor.translateAlternateColorCodes('&', "&7&l[ " + ChatColor.of("#FFD700") + "&lLinks &7&l]") + ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=====---");
				player.sendMessage(ChatColor.of("#779AD8") + "Website " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#00E8FF") + " http://www.jahcraft.net");
				player.sendMessage(ChatColor.of("#779AD8") + "Store " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#00E8FF") + " http://store.jahcraft.net");
				player.sendMessage(ChatColor.of("#779AD8") + "Dynmap " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#00E8FF") + " http://mc.jahcraft.net:8123");
				player.sendMessage(ChatColor.of("#779AD8") + "Discord " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#00E8FF") + " http://discord.gg/WfmYbH9knT§r");
				player.sendMessage(ChatColor.of("#779AD8") + "Staff Application " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#00E8FF") + " https://forms.gle/16zgA6RnFzND85U27");
				return;
			}
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
			return; 
		}
		else {
			//console
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lJahCraft Links:"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Website - &bwww.jahcraft.net"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Donation store - &bwww.jahcraft.net/shop"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Dynmap - &bhttp://mc.jahcraft.info:8123"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Instagram - &bhttps://www.instagram.com/jahcraft_official/"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Discord - &bdiscord.gg/aajjupC"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Youtube - &bhttps://www.youtube.com/channel/UCNvYGL9I97ftDOw3YBcrspw"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Staff Application - &bhttps://forms.gle/vvAwQ3pLdYoRji5t7"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Resident Survey - &bhttps://forms.gle/uoJWxJxzmdn3gt7j7"));
			return;
		}
		
	}

	private void sendApply(CommandSender sender) {
		if (!sender.hasPermission("jahcraft.info")) {
			
			sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
			return;
			
		} else {
			
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#FFD700") + "" + ChatColor.BOLD + ">> " + ChatColor.of("#49B3FF") + "Apply for Staff! &7&nhttps://forms.gle/16zgA6RnFzND85U27"));
			return;
			
		}
		
	}

	private void sendBuy(CommandSender sender) {
		if (sender.hasPermission("jahcraft.info")) {
			
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&nhttp://store.jahcraft.net"));
			return;
			
		} else {
			
			sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
			return;
			
		}
		
	}

	private void sendDiscord(CommandSender sender) {

		if (sender instanceof Player) {
			// player
			Player player = (Player) sender;
			if (player.hasPermission("jahcraft.info")) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#7543ab") + "" + ChatColor.BOLD + ">> " + ChatColor.of("#c187ff") + "Join our Discord! &7&nhttps://discord.gg/WfmYbH9knT"));
				return;
			}
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
			return;
		}
		else {
			//console
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.of("#c187ff") + "Join our Discord! &7&nhttps://discord.gg/WfmYbH9knT"));
			return;
		}
		
	}

	private void sendHelp(CommandSender sender, String[] args) {
		
		if (sender instanceof Player) {
			// player
			Player player = (Player) sender;
			if (player.hasPermission("jahcraft.info")) {
				if (args.length == 0) {
					player.sendMessage(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "---=====" + ChatColor.translateAlternateColorCodes('&', "&7&l[ " + ChatColor.of("#FFD700") + "&lHelp 1/4 &7&l]") + ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=====---");
					player.sendMessage(ChatColor.of("#00E8FF") + "/towny " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Refers to various towny help commands.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/ranks " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows a list of ranks and requirements.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/playtime " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows you your playtime.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/rankup " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Boosts you to the next rank if you've met the requirements.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/kits " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows your available kits.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/kit <kitname> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Gives you the named kit.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/sethome <homename> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Saves the current location as a home.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/home <homename> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Teleports to the named home.");
					player.sendMessage(ChatColor.of("#49B3FF") + "Use " + ChatColor.of("#00E8FF") + "/help 2" + ChatColor.of("#49B3FF") + " to view the next page.");
					return;
				}
				
				if (args.length == 1 && args[0].equalsIgnoreCase("1")) {
					player.sendMessage(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "---=====" + ChatColor.translateAlternateColorCodes('&', "&7&l[ " + ChatColor.of("#FFD700") + "&lHelp 1/4 &7&l]") + ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=====---");
					player.sendMessage(ChatColor.of("#00E8FF") + "/towny " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Refers to various towny help commands.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/ranks " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows a list of ranks and requirements.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/playtime " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows you your playtime.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/rankup " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Boosts you to the next rank if you've met the requirements.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/kits " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows your available kits.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/kit <kitname> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Gives you the named kit.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/sethome <homename> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Saves the current location as a home.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/home <homename> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Teleports to the named home.");
					player.sendMessage(ChatColor.of("#49B3FF") + "Use " + ChatColor.of("#00E8FF") + "/help 2" + ChatColor.of("#49B3FF") + " to view the next page.");
					return;
				}
				
				if (args.length == 1 && args[0].equalsIgnoreCase("2")) {
					player.sendMessage(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "---=====" + ChatColor.translateAlternateColorCodes('&', "&7&l[ " + ChatColor.of("#FFD700") + "&lHelp 2/4 &7&l]") + ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=====---");
					player.sendMessage(ChatColor.of("#00E8FF") + "/donate " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows the various donator perks and their prices.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/warps " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows a list of available warps.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/warp <warpname> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Teleports to the named warp.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/vote " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows the available websites to vote on.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/votetop " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Displays the top voters of the month.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/balance " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows your current balance.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/baltop " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows the top players with the most money.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/msg <player> <msg> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Sends a private message to the named player.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/ignore <player> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Blocks chats and messages from the named player.");
					player.sendMessage(ChatColor.of("#49B3FF") + "Use " + ChatColor.of("#00E8FF") + "/help 3" + ChatColor.of("#49B3FF") + " to view the next page.");
					return;
				}
				
				if (args.length == 1 && args[0].equalsIgnoreCase("3")) {
					player.sendMessage(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "---=====" + ChatColor.translateAlternateColorCodes('&', "&7&l[ " + ChatColor.of("#FFD700") + "&lHelp 3/4 &7&l]") + ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=====---");
					player.sendMessage(ChatColor.of("#00E8FF") + "/duel <player> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Sends a duel request to the named player.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/duel stats " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows your dueling stats.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/ticket " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows ticket management commands.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/ticket create <message> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Creates a support ticket and sends the message to staff.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/sell " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Instantly teleports you to the trading post.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/mall " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Instantly teleports you to the mall.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/tpa <player> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Sends a teleport request to the named player.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/tpahere <player> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Sends a request to teleport the named player to you.");
					player.sendMessage(ChatColor.of("#49B3FF") + "Use " + ChatColor.of("#00E8FF") + "/help 3" + ChatColor.of("#49B3FF") + " to view the next page.");
					return;
				}
				
				if (args.length == 1 && args[0].equalsIgnoreCase("4")) {
					player.sendMessage(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "---=====" + ChatColor.translateAlternateColorCodes('&', "&7&l[ " + ChatColor.of("#FFD700") + "&lHelp 4/4 &7&l]") + ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=====---");
					player.sendMessage(ChatColor.of("#00E8FF") + "/links " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Shows links to various JahCraft websites.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/map " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Gives a link to the DynMap.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/discord " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Gives a link to join the discord.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/apply " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Gives a link to a staff application.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/me <action> " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Used to convey the performance of an action. (/me is eating a taco.)");
					player.sendMessage(ChatColor.of("#00E8FF") + "/sit " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Sits you down.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/spawn " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Teleports you to spawn.");
					player.sendMessage(ChatColor.of("#00E8FF") + "/afk " + ChatColor.of("#AAAAAA") + " - " + ChatColor.of("#779AD8") + " Marks you as afk / not afk.");
					player.sendMessage(ChatColor.of("#49B3FF") + "This is the final page.");
					return;
				}
				else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThat page does not exist."));
					return;
				}
			
			}
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
			return; 
		}
		
	}

}
