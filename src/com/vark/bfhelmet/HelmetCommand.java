package com.vark.bfhelmet;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;



public class HelmetCommand implements CommandExecutor
{
	
	private Plugin plugin = Main.getPlugin(Main.class);
	

	@Override
	public boolean onCommand(CommandSender cs, Command arg1,
			 String arg2, String[] arg3) {
		
		
		
			if(cs instanceof Player)
			{
				
				Player p = (Player) cs;
				dataCreate(p);
				Inventory i = new HelmetGUI(plugin,p).getInv();
				p.openInventory(i);
				
				return true;
				
			}
		
		
			return false;
		
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void dataCreate(Player p)
	{
		
		File file = new File(plugin.getDataFolder()+"/data/" + p.getUniqueId() + ".yml");
		
		// creates a new file with the given path example: File file = new File("plugins/Test/" + player.getUniqueId() + ".yml");
    	if (!file.exists()) 
    	{ //Checks if the file doesn't exist
    		try {
    			file.createNewFile(); //Tries to create the file
    			FileConfiguration config = YamlConfiguration.loadConfiguration(file); //Creates a FileConfiguration for the file

    			for(int i = 0; i<99;i++)
    			{
        			config.set("helmet"+i, 0);

    			}
    			
    			
    			//Path, where the value is stored and Value, what gets stored example config.set("health",100); would put health: 100 in the plugins/Test/+player.getUniqueId().yml file
    			config.save(file); //So the changes are actually saved

    			System.out.println(ChatColor.RED+"Created New Data File For Player: "+p.getName());
    		} catch (IOException ex) {
    			p.sendMessage("Error 001 Contact An Admin");
    		} 
    	}

	}

	
	

}
