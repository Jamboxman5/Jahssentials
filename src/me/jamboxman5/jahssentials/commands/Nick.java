package me.jamboxman5.jahssentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jamboxman5.jahssentials.util.Colors;
import net.md_5.bungee.api.ChatColor;

public class Nick implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) consoleNick();
		
		Player p = (Player) sender;
		
		if (args.length == 1) changeSelfNickname(p, args[0]);
		
		return true;
	}

	private void changeSelfNickname(Player p, String name) {
		if (!p.hasPermission("jahssentials.nick")) {
			noPermission(p);
			return;
		}
		if (p.hasPermission("jahssentials.nick.colors")) {
			p.setDisplayName(Colors.formatHex(name));
		} else {
			p.setDisplayName(name);
		}
		
	}

	private void noPermission(Player p) {
		p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
	}

	private void consoleNick() {
		// TODO Auto-generated method stub
		
	}
	
}
