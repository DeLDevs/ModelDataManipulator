package fun.delson.modeldatamanipulator;

import org.bukkit.plugin.java.JavaPlugin;

import fun.delson.modeldatamanipulator.commands.Model;

public class ModelDataManipulator extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		getCommand("model").setExecutor(new Model());
		getCommand("model").setTabCompleter(new Model());
		
	}

}