package me.jamboxman5.jahssentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Repair implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("repair")) {

			if (sender instanceof Player) {
				repairPlayer();
				return true;
			} else {
				repairConsole();
				return true;
			}
			
			
		}

		return false;

	}

	private void repairConsole() {
		// TODO Auto-generated method stub
		
	}

	private void repairPlayer() {
		// TODO Auto-generated method stub
		
	}
	
}
