package me.jamboxman5.jahssentials.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;

public class Tpask implements CommandExecutor {
	
	HashMap<Player, Player> reqStorage = new HashMap<>();
	HashMap<Player, Boolean> isHere = new HashMap<>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("tpask") ||
			label.equalsIgnoreCase("tpa")) {
			
			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;
			
			if (args.length != 1) {
				p.sendMessage(ChatColor.RED + "Usage: /tpa <player>");
				return true;
			}
			
			if (Bukkit.getPlayer(args[0]) == null) {
				p.sendMessage(ChatColor.RED + "Player not found!");
				return true;
			}
			
			Player target = Bukkit.getPlayer(args[0]);
			
			if (reqStorage.get(target) == p) {
				p.sendMessage(ChatColor.RED + "You have already sent a request to that player!");
				return true;
			} else {
				reqStorage.put(target, p);
				isHere.put(target, false);
				sendReq(target, p);
				return true;
			}
		}
		
		if (label.equalsIgnoreCase("tpahere")) {
				
				if (!(sender instanceof Player)) return true;
				
				Player p = (Player) sender;
				
				if (args.length != 1) {
					p.sendMessage(ChatColor.RED + "Usage: /tpahere <player>");
					return true;
				}
				
				if (Bukkit.getPlayer(args[0]) == null) {
					p.sendMessage(ChatColor.RED + "Player not found!");
					return true;
				}
				
				Player target = Bukkit.getPlayer(args[0]);
				
				if (reqStorage.get(target) == p) {
					p.sendMessage(ChatColor.RED + "You have already sent a request to that player!");
					return true;
				} else {
					reqStorage.put(target, p);
					isHere.put(target, true);
					sendHereReq(target, p);
					return true;
				}
			}
		
		if (label.equalsIgnoreCase("tpaccept")) {
			
			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;
			
			if (!reqStorage.containsKey(p)) {
				p.sendMessage(ChatColor.RED + "You have no active requests!");
				return true;
			}
			
			Player OG = reqStorage.get(p);
			
			p.sendMessage(ChatColor.of("#49B3FF") + "Teleport request accepted...");
			OG.sendMessage(ChatColor.of("#FFD700") + p.getDisplayName() + ChatColor.of("#49B3FF") + " accepted your teleport request...");
			if (isHere.get(p)) {
				p.teleport(OG);
			} else {
				OG.teleport(p);
			}
			reqStorage.remove(p);
			isHere.remove(p);
			
		}
		
		if (label.equalsIgnoreCase("tpdeny")) {
			
			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;
			
			if (!reqStorage.containsKey(p)) {
				p.sendMessage(ChatColor.RED + "You have no active requests!");
				return true;
			}
			
			Player OG = reqStorage.get(p);
			
			p.sendMessage(ChatColor.of("#49B3FF") + "Teleport request denied.");
			OG.sendMessage(ChatColor.of("#FFD700") + p.getDisplayName() + ChatColor.of("#49B3FF") + " denied your teleport request.");
			reqStorage.remove(p);
			isHere.remove(p);
			
		}
		
		return false;
		
	}
	
	private void sendHereReq(Player target, Player sender) {

		TextComponent click = new TextComponent("Click here to ");
		TextComponent accept = new TextComponent("ACCEPT ");
		TextComponent or = new TextComponent("or ");
		TextComponent deny = new TextComponent("DENY");
		TextComponent request = new TextComponent(" this request.");
		
		TextComponent[] comps = {click, accept, or, deny, request};
		
		request.setColor(ChatColor.of("#49B3FF"));
		click.setColor(ChatColor.of("#49B3FF"));
		or.setColor(ChatColor.of("#49B3FF"));
		accept.setColor(ChatColor.GREEN);
		deny.setColor(ChatColor.RED);
		click.setBold(false);
		accept.setBold(true);
		deny.setBold(true);
		accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept"));
		deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpdeny"));
		accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(
				ChatColor.translateAlternateColorCodes('&', ChatColor.GRAY + "Click to &aaccept " + ChatColor.GRAY + "this request."))));
		deny.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(
				ChatColor.translateAlternateColorCodes('&', ChatColor.GRAY + "Click to &cdeny " + ChatColor.GRAY + "this request."))));
		sender.sendMessage(ChatColor.of("#49B3FF") + "Teleport request sent.");
		target.sendMessage(ChatColor.of("#FFD700") + sender.getDisplayName() + ChatColor.of("#49B3FF") + " has requested you teleport to them.");
		target.spigot().sendMessage(comps);
		
	}

	public static void sendReq(Player target, Player sender) {
		
		TextComponent click = new TextComponent("Click here to ");
		TextComponent accept = new TextComponent("ACCEPT ");
		TextComponent or = new TextComponent("or ");
		TextComponent deny = new TextComponent("DENY");
		TextComponent request = new TextComponent(" this request.");
		
		TextComponent[] comps = {click, accept, or, deny, request};
		
		request.setColor(ChatColor.of("#49B3FF"));
		click.setColor(ChatColor.of("#49B3FF"));
		or.setColor(ChatColor.of("#49B3FF"));
		accept.setColor(ChatColor.GREEN);
		deny.setColor(ChatColor.RED);
		click.setBold(false);
		accept.setBold(true);
		deny.setBold(true);
		accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept"));
		deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpdeny"));
		accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(
				ChatColor.translateAlternateColorCodes('&', ChatColor.GRAY + "Click to &aaccept " + ChatColor.GRAY + "this request."))));
		deny.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(
				ChatColor.translateAlternateColorCodes('&', ChatColor.GRAY + "Click to &cdeny " + ChatColor.GRAY + "this request."))));
		sender.sendMessage(ChatColor.of("#49B3FF") + "Teleport Request Sent.");
		target.sendMessage(ChatColor.of("#49B3FF") + "Teleport Request Received From " + ChatColor.of("#FFD700") + sender.getDisplayName() + ChatColor.of("#49B3FF") + ".");
		target.spigot().sendMessage(comps);
		
	}

}

