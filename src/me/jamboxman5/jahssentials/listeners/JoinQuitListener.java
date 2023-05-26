package me.jamboxman5.jahssentials.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.jamboxman5.jahssentials.main.Main;
import me.jamboxman5.jahssentials.runnables.JoinQuitThread;
import net.md_5.bungee.api.ChatColor;

public class JoinQuitListener implements Listener {

	Main plugin;
	
	public JoinQuitListener(Main main) {
		
		plugin = main;
		
	}
	
	@EventHandler 
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String prefix = "";
		String suffix = "";
		String plus = ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "]";
		String joined = ChatColor.GREEN + "has logged in!";		
		
		if (p.hasPermission("group.default")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#FFFFFF") + "Beginner" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.resident")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#A0FF7C") + "Resident" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.citizen")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#50FFA0") + "Citizen" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.veteran")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#93FFFF") + "Veteran" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.decorated")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#93C0FF") + "Decorated" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.nobility")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#9F9BEF") + "Nobility" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.scholar")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#A47FD8") + "Scholar" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.hero")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#B058E2") + "Hero" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.legacy")) {
			prefix = ChatColor.of("#00E8FF") + "[" + ChatColor.of("#E05779") + "" + ChatColor.BOLD + "Legacy" + ChatColor.of("#00E8FF") + "]";
		}
		if (p.hasPermission("group.moderator")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.BLUE + "Moderator" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.jah+")) {
			suffix = ChatColor.of("#00E8FF") + "[" + ChatColor.of("#FFD700") + "" + ChatColor.BOLD + "Jah+" + ChatColor.of("#00E8FF") + "]";
		}
		
		if (p.hasPermission("group.admin") || p.hasPermission("group.owner")) {
			e.setJoinMessage("");
		} else {
			Bukkit.getScheduler().runTaskAsynchronously(plugin, new JoinQuitThread(p, prefix, suffix, plus, joined));
		}

	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		String prefix = "";
		String suffix = "";
		String minus = ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "]";
		String quit = ChatColor.RED + "has left the game.";
		
		
		if (p.hasPermission("group.default")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#FFFFFF") + "Beginner" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.resident")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#A0FF7C") + "Resident" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.citizen")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#50FFA0") + "Citizen" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.veteran")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#93FFFF") + "Veteran" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.decorated")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#93C0FF") + "Decorated" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.nobility")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#9F9BEF") + "Nobility" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.scholar")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#A47FD8") + "Scholar" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.hero")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.of("#B058E2") + "Hero" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.legacy")) {
			prefix = ChatColor.of("#00E8FF") + "[" + ChatColor.of("#E05779") + "" + ChatColor.BOLD + "Legacy" + ChatColor.of("#00E8FF") + "]";
		}
		if (p.hasPermission("group.moderator")) {
			prefix = ChatColor.GRAY + "[" + ChatColor.BLUE + "Moderator" + ChatColor.GRAY + "]";
		}
		if (p.hasPermission("group.jah+")) {
			suffix = ChatColor.of("#00E8FF") + "[" + ChatColor.of("#FFD700") + "" + ChatColor.BOLD + "Jah+" + ChatColor.of("#00E8FF") + "]";
		}
		
		if (p.hasPermission("group.admin") || p.hasPermission("group.owner")) {
			e.setQuitMessage(null);
		} else {
			Bukkit.getScheduler().runTaskAsynchronously(plugin, new JoinQuitThread(p, prefix, suffix, minus, quit));
		}

	}
	
}
