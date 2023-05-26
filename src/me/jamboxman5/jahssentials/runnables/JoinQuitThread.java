package me.jamboxman5.jahssentials.runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class JoinQuitThread implements Runnable {

	Player p;
	String prefix;
	String suffix;
	String plus;
	String joined;	
	
	public JoinQuitThread(Player p, String prefix, String suffix, String plus, String joined) {
		this.p = p;
		this.prefix = prefix;
		this.suffix = suffix;
		this.plus = plus;
		this.joined = joined;
		
	}

	@Override
	public void run() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Bukkit.broadcastMessage(plus + " " + suffix + prefix + " " + p.getDisplayName() + " " + joined);
		
	}

}
