package me.jamboxman5.jahssentials.main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import me.jamboxman5.jahssentials.commands.Blockme;
import me.jamboxman5.jahssentials.commands.DirectMessage;
import me.jamboxman5.jahssentials.commands.Enchant;
import me.jamboxman5.jahssentials.commands.Feed;
import me.jamboxman5.jahssentials.commands.Fly;
import me.jamboxman5.jahssentials.commands.Gamemode;
import me.jamboxman5.jahssentials.commands.InfoCommands;
import me.jamboxman5.jahssentials.commands.Invsee;
import me.jamboxman5.jahssentials.commands.Jahsay;
import me.jamboxman5.jahssentials.commands.Login;
import me.jamboxman5.jahssentials.commands.Logoff;
import me.jamboxman5.jahssentials.commands.MassCraft;
import me.jamboxman5.jahssentials.commands.NoMoreOres;
import me.jamboxman5.jahssentials.commands.Replace;
import me.jamboxman5.jahssentials.commands.Set;
import me.jamboxman5.jahssentials.commands.SetterCommands;
import me.jamboxman5.jahssentials.commands.Spectate;
import me.jamboxman5.jahssentials.commands.Teleport;
import me.jamboxman5.jahssentials.commands.Tpask;
import me.jamboxman5.jahssentials.commands.Undo;
import me.jamboxman5.jahssentials.listeners.ChatFormatListener;
import me.jamboxman5.jahssentials.listeners.EXAntiBuildListener;
import me.jamboxman5.jahssentials.listeners.InvseeListener;
import me.jamboxman5.jahssentials.listeners.MaterialsMenuListener;
import me.jamboxman5.jahssentials.listeners.RecipeMenuListener;
import me.jamboxman5.jahssentials.listeners.WandListener;
import me.jamboxman5.jahssentials.util.InfoStorage;

public class Main extends JavaPlugin {
	
	public static InfoStorage infoStorage = new InfoStorage();
	public static Main plugin;

	@Override
	public void onEnable() {
		
		plugin = this;
		
		try {
			
			//SETUP USERDATA ON RELOADS
//			for (Player p : Bukkit.getOnlinePlayers()) {
//				UserData.activate(p);
//			}
			
			//COMMANDS
			getCommand("fly").setExecutor((CommandExecutor) new Fly());
			getCommand("flyspeed").setExecutor((CommandExecutor) new Fly());
			getCommand("creative").setExecutor((CommandExecutor) new Gamemode());
			getCommand("spectator").setExecutor((CommandExecutor) new Gamemode());
			getCommand("survival").setExecutor((CommandExecutor) new Gamemode());
			getCommand("adventure").setExecutor((CommandExecutor) new Gamemode());
			getCommand("feed").setExecutor((CommandExecutor) new Feed());
			getCommand("teleport").setExecutor((CommandExecutor) new Teleport());
			getCommand("tphere").setExecutor((CommandExecutor) new Teleport());
			getCommand("sethealth").setExecutor((CommandExecutor) new SetterCommands());
			getCommand("setmaxhealth").setExecutor((CommandExecutor) new SetterCommands());
			getCommand("setfood").setExecutor((CommandExecutor) new SetterCommands());
			getCommand("setsaturation").setExecutor((CommandExecutor) new SetterCommands());
			getCommand("gamemode").setExecutor((CommandExecutor) new Gamemode());
			getCommand("help").setExecutor((CommandExecutor) new InfoCommands());
			getCommand("links").setExecutor((CommandExecutor) new InfoCommands());
			getCommand("discord").setExecutor((CommandExecutor) new InfoCommands());
			getCommand("ranks").setExecutor((CommandExecutor) new InfoCommands());
			getCommand("login").setExecutor((CommandExecutor) new Login());
			getCommand("logoff").setExecutor((CommandExecutor) new Logoff());
			getCommand("jahsay").setExecutor((CommandExecutor) new Jahsay());
			getCommand("map").setExecutor((CommandExecutor) new InfoCommands());
			getCommand("apply").setExecutor((CommandExecutor) new InfoCommands());
			getCommand("buy").setExecutor((CommandExecutor) new InfoCommands());
			getCommand("invsee").setExecutor((CommandExecutor) new Invsee(this));
			getCommand("jahcolors").setExecutor((CommandExecutor) new InfoCommands());
			getCommand("setmodeldata").setExecutor((CommandExecutor) new SetterCommands());
			getCommand("nomoreores").setExecutor((CommandExecutor) new NoMoreOres(this));
			getCommand("blockme").setExecutor((CommandExecutor) new Blockme());
			getCommand("set").setExecutor((CommandExecutor) new Set(this));
			getCommand("undue").setExecutor((CommandExecutor) new Undo(this));
			getCommand("replace").setExecutor((CommandExecutor) new Replace(this));
			getCommand("enchant").setExecutor((CommandExecutor) new Enchant());
			getCommand("tppos").setExecutor((CommandExecutor) new Teleport());
			getCommand("setdurability").setExecutor((CommandExecutor) new SetterCommands());
			getCommand("masscraft").setExecutor((CommandExecutor) new MassCraft());
//			getCommand("nick").setExecutor((CommandExecutor) new Nick());

			//MULTICOMMAND EXECUTORS
			CommandExecutor spectateExecutor = new Spectate();
			getCommand("spec").setExecutor(spectateExecutor);
			getCommand("unspec").setExecutor(spectateExecutor);
			CommandExecutor messageExecutor = new DirectMessage();
			getCommand("msg").setExecutor(messageExecutor);
			getCommand("reply").setExecutor(messageExecutor);
			CommandExecutor tpaExecutor = new Tpask();
			getCommand("tpask").setExecutor(tpaExecutor);
			getCommand("tpaccept").setExecutor(tpaExecutor);
			getCommand("tpahere").setExecutor(tpaExecutor);
			getCommand("tpdeny").setExecutor(tpaExecutor);
			
			//LISTENERS
			getServer().getPluginManager().registerEvents(new ChatFormatListener(), this);
//			getServer().getPluginManager().registerEvents(new JoinQuitListener(), this);
			getServer().getPluginManager().registerEvents(new EXAntiBuildListener(), this);
			getServer().getPluginManager().registerEvents(new InvseeListener(), this);
			getServer().getPluginManager().registerEvents(new WandListener(), this);
			getServer().getPluginManager().registerEvents(new RecipeMenuListener(), this);
			getServer().getPluginManager().registerEvents(new MaterialsMenuListener(), this);
		} catch (Exception e) {
			
			Bukkit.getLogger().warning("Failed to load Jahssentials!");
			e.printStackTrace();
		}
	}
	
	@Override 
	public void onDisable() {
		//SAVE USERDATA ON UNLOADS
//		Bukkit.getScheduler().runTask(Main.plugin, new Runnable() {
//			@Override
//			public void run() {
//				for (UUID id : UserData.onlineUsers.keySet()) {
//					UserData.deactivate(id);
//				}
//			}
//		});
		
		Bukkit.getLogger().info("Jahssentials Unloaded and Disabled!");
		
	}

}
