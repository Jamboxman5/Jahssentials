package me.jamboxman5.jahssentials.runnables;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class OreReplacerThread implements Runnable {

	Block b;
	
	public OreReplacerThread(Block toRemove) {
		b = toRemove;
	}
	
	@Override
	public void run() {
		
		if (b.getType().toString().contains("DEEPSLATE")) {
			b.setType(Material.DEEPSLATE);
		} else if (b.getType().toString().contains("QUARTZ")) {
			b.setType(Material.NETHERRACK);
		} else {
			b.setType(Material.STONE);
		}		
	}

}
