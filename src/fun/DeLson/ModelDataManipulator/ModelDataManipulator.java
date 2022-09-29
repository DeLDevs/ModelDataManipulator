package fun.DeLson.ModelDataManipulator;

import org.bukkit.plugin.java.JavaPlugin;

import fun.DeLson.ModelDataManipulator.Commands.Model;

public class ModelDataManipulator extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		getCommand("model").setExecutor(new Model());
		
	}

}
