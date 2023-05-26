package me.jamboxman5.jahssentials.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.jamboxman5.jahssentials.util.InfoStorage;
import net.md_5.bungee.api.ChatColor;

public class WandListener implements Listener {
	
	@EventHandler
	public void BlockClick(PlayerInteractEvent e) {
		
		if (!e.getPlayer().hasPermission("jahcore.edit")) return;
		if (e.getPlayer().getInventory().getItemInMainHand().getType() != Material.GOLDEN_AXE) return;
		if (!(e.getAction().equals(Action.LEFT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) return;
		
		e.setCancelled(true);
		
		if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			if (InfoStorage.position1.containsKey(e.getPlayer()) && InfoStorage.position1.get(e.getPlayer()).equals(e.getClickedBlock().getLocation())) return;
			InfoStorage.position1.put(e.getPlayer(), e.getClickedBlock().getLocation());
			e.getPlayer().sendMessage(ChatColor.of("#00E8FF") + "Position 1 set. (" + getBlockCount(e.getPlayer()) + " blocks)");
			return;
		}
		
		if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (InfoStorage.position2.containsKey(e.getPlayer()) && InfoStorage.position2.get(e.getPlayer()).equals(e.getClickedBlock().getLocation())) return;
			InfoStorage.position2.put(e.getPlayer(), e.getClickedBlock().getLocation());
			e.getPlayer().sendMessage(ChatColor.of("#00E8FF") + "Position 2 set. (" + getBlockCount(e.getPlayer()) + " blocks)");
			return;
		}
		
	}
	
	private int getBlockCount(Player p) {
		
		if (!(InfoStorage.position1.containsKey(p) && InfoStorage.position2.containsKey(p))) return 0;
		
		int x = (int) Math.abs((int) Math.abs(InfoStorage.position1.get(p).getX()) - Math.abs(InfoStorage.position2.get(p).getX())) + 1;
		int y = (int) Math.abs((int) Math.abs(InfoStorage.position1.get(p).getY()) - Math.abs(InfoStorage.position2.get(p).getY())) + 1;
		int z = (int) Math.abs((int) Math.abs(InfoStorage.position1.get(p).getZ()) - Math.abs(InfoStorage.position2.get(p).getZ())) + 1;
		
		return ((x*y)*z);
	}
	
}
