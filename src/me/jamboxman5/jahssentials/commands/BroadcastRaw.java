package me.jamboxman5.jahssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.jamboxman5.jahssentials.util.Colors;
import net.md_5.bungee.api.ChatColor;

public class BroadcastRaw implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!label.endsWith("bcraw")) return false;
		if (!sender.hasPermission("jahssentials.bcraw")) {
			sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
			return true;
		}
		
		if (args.length == 0) {
			sender.sendMessage(ChatColor.RED + "You need to specify something to be broadcasted!");
			return true;
		}
		
		String msg = "";
		for (int i = 0; i < args.length; i++) {
			msg += args[i];
			if (i+1 < args.length) msg += " ";
		}
		
		Bukkit.broadcastMessage(Colors.formatHex(msg));
		
		return true;
	}

}
