package fun.DeLson.ModelDataManipulator.Commands;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import fun.DeLson.ModelDataManipulator.Utils.Utils;

public class Model implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		PlayerInventory inventory = player.getInventory();
		ItemStack selectedItem = inventory.getItemInMainHand();
		if (selectedItem.getType().equals(Material.AIR)) {
			return false;
		}
		ItemMeta selectedMeta = selectedItem.getItemMeta();
		
		if (args.length > 0) {
			
			if (args[0].equalsIgnoreCase("get")) {
				player.sendMessage(Utils.chat("Custom Model Data: " + selectedMeta.getCustomModelData()));
				return true;
			} else if (args.length >= 1 && args[0].equalsIgnoreCase("set")) {
				if (args.length >= 2 && args[1].length() <= 6) {
					try {
						selectedMeta.setCustomModelData(Integer.parseInt(args[1]));
					} catch (NumberFormatException e) {
						player.sendMessage(Utils.chat("&6Custom model data must be an integer between -999999 and 999999."));
					}
				} else if (args.length == 1) {
					selectedMeta.setCustomModelData(ThreadLocalRandom.current().nextInt(-1000000,1000000));
				}
				selectedItem.setItemMeta(selectedMeta);
				player.sendMessage(Utils.chat("Custom Model Data set to " + selectedMeta.getCustomModelData()));
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}

}
