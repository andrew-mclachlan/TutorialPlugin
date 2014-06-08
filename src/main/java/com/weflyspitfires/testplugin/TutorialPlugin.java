package com.weflyspitfires.testplugin;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TutorialPlugin extends JavaPlugin {

	@Override
    public void onEnable() {
		getLogger().info("onEnable has been invoked!");
	}
 
    @Override
    public void onDisable() {
    	getLogger().info("onDisable has been invoked!");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("foo")) { // If the player typed /ignite then do the following...
    		
            if (sender instanceof Player) {
            	Player player = (Player) sender;
                
                World currentWorld = player.getWorld();
                
                if (args.length > 0) {
                	try {
                		Integer time = Integer.parseInt(args[0]);
                		currentWorld.setTime(time);
                		return true;
                	}
                	catch (NumberFormatException e) {
                		getLogger().info("Arg!!");
                	}
                }
            }
    		
    		return false;
    	}
    	return false; 
    }
}
