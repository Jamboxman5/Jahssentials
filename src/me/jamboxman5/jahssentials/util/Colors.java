package me.jamboxman5.jahssentials.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.md_5.bungee.api.ChatColor;

public class Colors {
	
	private static final Pattern pattern = Pattern.compile("&#[a-fA-F0-9]{6}");
	
	public static final String GOLD = ChatColor.of("#FFD700") + "";
	public static final String YELLOW = ChatColor.of("#FFFF00") + "";
	public static final String BLUE = ChatColor.of("#49B3FF") + "";
	public static final String PALEBLUE = ChatColor.of("#76B9E6") + "";
	public static final String BRIGHTBLUE = ChatColor.of("#00E8FF") + "";
	public static final String BRIGHTRED = ChatColor.of("#FF0000") + "";
	public static String format(String before) {
		return ChatColor.translateAlternateColorCodes('&', before);
	}
	public static String formatHex(String before) {
		Matcher match = pattern.matcher(before);
		while (match.find()) {
			String color = before.substring(match.start()+1, match.end());
			String toReplace = before.substring(match.start(), match.end());
			before = before.replace(toReplace, ChatColor.of(color) + "");
			match = pattern.matcher(before);
		}
		return ChatColor.translateAlternateColorCodes('&', before);
	}
}
