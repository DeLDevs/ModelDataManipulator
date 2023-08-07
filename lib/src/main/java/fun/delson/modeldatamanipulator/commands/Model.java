package fun.delson.modeldatamanipulator.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.StringUtil;

import fun.delson.modeldatamanipulator.utils.Chat;

public class Model implements TabExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		PlayerInventory inventory = player.getInventory();
		ItemStack selectedItem = inventory.getItemInMainHand();
		if (selectedItem.getType().equals(Material.AIR)) {
			return false;
		}
		ItemMeta selectedMeta = selectedItem.getItemMeta();
		String customModelData;
		
		if (selectedMeta.hasCustomModelData()) {
			customModelData = String.valueOf(selectedMeta.getCustomModelData());
		} else {
			customModelData = "[None]";
		}
		
		if (args.length > 0) {
			
			if (args[0].equalsIgnoreCase("get")) {
				player.sendMessage(Chat.color("Custom Model Data: " + customModelData));
				return true;
			} else if (args.length >= 1 && args[0].equalsIgnoreCase("set")) {
				if (args.length >= 2 && args[1].length() <= 6) {
					try {
						selectedMeta.setCustomModelData(Integer.parseInt(args[1]));
					} catch (NumberFormatException e) {
						player.sendMessage(Chat.color("&6Custom model data must be an integer between -999999 and 999999."));
					}
				} else if (args.length == 1) {
					selectedMeta.setCustomModelData(ThreadLocalRandom.current().nextInt(-1000000,1000000));
				}
				selectedItem.setItemMeta(selectedMeta);
				player.sendMessage(Chat.color("Custom Model Data set to " + selectedMeta.getCustomModelData()));
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}
	
	
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		
		List<String> completions = new ArrayList<>();
		List<String> commands = new ArrayList<>();
		
		switch (args.length) {
			case 1:
				commands.add("get");
				commands.add("set");
				StringUtil.copyPartialMatches(args[0], commands, completions);
				break;
		}
		
		Collections.sort(completions);
		return completions;
		
	}

}