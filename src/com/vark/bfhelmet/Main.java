package com.vark.bfhelmet;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin
{

	
	
	public void onEnable()
	{
		
		//Main stuff, no need to bother
		
		//new Crafting(this);
		new HelmetListener(this);
		
		
		
		getCommand("helmets").setExecutor(new HelmetCommand());
		
		File userFolder = new File(this.getDataFolder(), "data");
		userFolder.mkdirs();
		
		//Hi this is a test!
		
	}
	
	
	public void onDisable() {}
	
	
	
	
	
	
	
	
	
}
