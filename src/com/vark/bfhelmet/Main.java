package com.vark.bfhelmet;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;



public class Main extends JavaPlugin
{

	
	
	public void onEnable()
	{
		
		//Main stuff, no need to bother
		

		new HelmetListener(this);
		getCommand("helmets").setExecutor(new HelmetCommand());
		File userFolder = new File(this.getDataFolder(), "data");
		userFolder.mkdirs();
		new Crafting(this);
	}
	
	

}