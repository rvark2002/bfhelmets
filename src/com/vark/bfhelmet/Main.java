package com.vark.bfhelmet;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin
{

	
	
	public void onEnable()
	{
		
		//Main stuff, no need to bother
		

		new HelmetListener(this);
		getCommand("helmets").setExecutor(new HelmetCommand());
		File userFolder = new File(this.getDataFolder(), "data");
		userFolder.mkdirs();
	
	}
	
	

}