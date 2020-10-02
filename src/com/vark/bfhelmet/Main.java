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
		Crafting Crafting = new Crafting(null);
		Crafting.Stormtrooper1Recipe();
		Crafting.Stormtrooper2Recipe();
		Crafting.Stormtrooper3Recipe();
		Crafting.Stormtrooper4Recipe();
		Crafting.Stormtrooper5Recipe();
		
	}
	
	
	public void onDisable() {}
	
	
	
	
	
	
	
	
	
}
