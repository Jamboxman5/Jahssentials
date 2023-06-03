package me.jamboxman5.jahssentials.util;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import com.google.gson.JsonObject;

public class User {
	
	boolean flying;
	boolean muted;
	boolean jail;
	boolean spy;
	boolean godMode;
	String nickname;
	String gameMode;
	
	Player player;
	
	public User(Player p, JsonObject obj) {
		player = p;
		muted = obj.get("muted").getAsBoolean();
		flying = obj.get("flying").getAsBoolean();
		jail = obj.get("jail").getAsBoolean();
		spy = obj.get("spy").getAsBoolean();
		godMode = obj.get("godMode").getAsBoolean();
		nickname = obj.get("nickname").getAsString();
		gameMode = obj.get("gameMode").getAsString();
		setupPlayer();
	}
	
	public User(Player p) {
		player = p;
		muted = false;
		jail = false;
		spy = false;
		godMode = false;
		nickname = p.getDisplayName();
		gameMode = "SURVIVAL";
		setupPlayer();
	}
	
	void setupPlayer() {
		System.out.println(GameMode.valueOf(gameMode));
		player.setGameMode(GameMode.valueOf(gameMode));
		player.setDisplayName(nickname);
		player.setPlayerListName(nickname);
		player.setFlying(flying);
	}
	
	public GameMode getMode() { return GameMode.valueOf(gameMode); }
	public String getNick() { return nickname; }
	public String toString() { return player.getName(); }
	public void toggleSpy() { spy = !spy; }
	public void toggleGod() { godMode = !godMode; }
	public void toggleMute() { muted = !muted; }
	public void toggleJail() { jail = !jail; }
	public boolean isSpying() { return spy; }
	public boolean isGod() { return godMode; }
	public boolean isMuted() { return muted; }
	public boolean isJailed() { return jail; }

	public JsonObject getJson() {
		JsonObject obj = new JsonObject();
		obj.addProperty("muted", muted);
		obj.addProperty("flying", player.getAllowFlight());
		obj.addProperty("jail", jail);
		obj.addProperty("spy", spy);
		obj.addProperty("godMode", godMode);
		obj.addProperty("lastX", player.getLocation().getX());
		obj.addProperty("lastY", player.getLocation().getY());
		obj.addProperty("lastZ", player.getLocation().getZ());
		obj.addProperty("lastPitch", player.getLocation().getPitch());
		obj.addProperty("lastYaw", player.getLocation().getYaw());
		obj.addProperty("lastSeen", System.currentTimeMillis());
		obj.addProperty("lastWorld", player.getLocation().getWorld().toString());
		obj.addProperty("address", player.getAddress().getHostName());
		obj.addProperty("nickname", player.getDisplayName());
		obj.addProperty("gameMode", player.getGameMode().toString());
		return obj;

	}

}
