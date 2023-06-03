package me.jamboxman5.jahssentials.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import me.jamboxman5.jahssentials.main.Main;

public class UserData {
	
	static File udataFolder = new File(Main.plugin.getDataFolder(), "userData");

	
	public static HashMap<UUID, User> onlineUsers = new HashMap<>();
	
	public static User getUser(UUID id) {
		if (!onlineUsers.containsKey(id)) return null;
		return onlineUsers.get(id);
	}
	
	public static void activate(Player player) {
		udataFolder.mkdirs();
		JsonObject obj;
		
		File jsonFile = new File(udataFolder, player.getUniqueId().toString() + ".json");
		
		if (!jsonFile.exists()) {
			User newUser = new User(player);
			onlineUsers.put(player.getUniqueId(), newUser);
			return;
		}
		
		try {
			FileReader fileR = new FileReader(jsonFile);
			JsonReader jsonR = new JsonReader(fileR);
            JsonElement element = JsonParser.parseReader(jsonR);
            obj = element.getAsJsonObject();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
           return;
        }
		
		User newUser = new User(player, obj);
		onlineUsers.put(player.getUniqueId(), newUser);
	}
	
	public static void deactivate(UUID id) {
		JsonObject obj = onlineUsers.get(id).getJson();
		writeJson(obj, id);
		onlineUsers.remove(id);
	}
	
	public static void writeJson(JsonObject obj, UUID id) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		File json = new File(udataFolder, id + ".json");
		try {
			FileWriter writer = new FileWriter(json);
			gson.toJson(obj, writer);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("Failed to write userdata for " + getUser(id) + "(" + id + ")");
			e.printStackTrace();
		}
	}
	


}
