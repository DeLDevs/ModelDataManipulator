package fun.DeLson.ModelDataManipulator.Utils;

import org.bukkit.ChatColor;

/**
 * The Utils class adds utilities used by the plugin.
 */

public class Utils {

	/**
	 * Applies color codes to text.
	 * @param s String of text to apply color codes to
	 * @return Inputted string with color codes applied.
	 */
	public static String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
}
