package fun.delson.modeldatamanipulator.utils;

import net.md_5.bungee.api.ChatColor;

/**
 * The Chat utilities class adds utilities used by the plugin for the in-game chat.
 */

public class Chat {

	/**
	 * Applies color codes to text.
	 * @param s String of text to apply color codes to
	 * @return Inputted string with color codes applied.
	 */
	public static String color(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
}