package me.jamboxman5.jahssentials.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jamboxman5.jahssentials.main.Main;
import me.jamboxman5.jahssentials.util.InfoStorage;
import net.md_5.bungee.api.ChatColor;

public class Undo implements CommandExecutor {

	Main plugin;
	
	public Undo(Main main) {
		plugin = main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("undue")) {

			if (!(sender instanceof Player)) return true;
			Player p = (Player) sender;
			if (!p.hasPermission("jahcore.edit")) {
				p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
				return true;
			}
			if (!InfoStorage.editHistory.containsKey(p)) {
				p.sendMessage(ChatColor.RED + "You haven't made any edits!");
				return true;
			}
			if (InfoStorage.editHistory.get(p).size() == 0) {
				p.sendMessage(ChatColor.RED + "Nothing left to undo!");
				return true;
			}
			HashMap<Block, Material> edit = InfoStorage.editHistory.get(p).pop();
			
			Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {

				@Override
				public void run() {

					for (Block b : edit.keySet()) {
						
						Bukkit.getScheduler().runTask(plugin, new Runnable() {
							@Override
							public void run() {
								b.setType(edit.get(b));
							}
						});
						
						try {
							Thread.sleep((long).1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
					p.sendMessage(ChatColor.of("#49B3FF") + "Undo successful.");
					
				}
				
			});
			return true;
			
		}

		return false;

	}
	
}
