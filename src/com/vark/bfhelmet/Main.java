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
		runnable();
	}
	
	public void runnable() {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Player p : Bukkit.getServer().getOnlinePlayers()){	
					if (p.getInventory().getHelmet() != null) {
				 		ItemStack item = p.getInventory().getHelmet();
			            if (item.getItemMeta().getDisplayName().equals(ChatColor.RED +""+ChatColor.BOLD+"Stormtrooper Helmet")) {
			            	p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1005, 1, true));
			            	p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1005, 1, true));
				}else {
					if (item.getItemMeta().getDisplayName().equals(ChatColor.YELLOW +""+ChatColor.BOLD+"Stormtrooper Helmet")) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1005, 1, true));
						p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1005, 1, true));
					}else {
						if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE +""+ChatColor.BOLD+"Stormtrooper Helmet")) {
							p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1005, 1, true));
						}else {
							if (item.getItemMeta().getDisplayName().equals(ChatColor.BLUE +""+ChatColor.BOLD+"Stormtrooper Helmet")) {
								p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1005, 1, true));
								p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1005, 1, true));
							}else {
								if (item.getItemMeta().getDisplayName().equals(ChatColor.GREEN+""+ChatColor.BOLD+"Stormtrooper Helmet")) {
									p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1005, 60, true));
									if (p.isSneaking()) {
										p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1005, 1, true));
									}
								}
							}
						}
					}
				}
			}
				
			}
			
	}
}.runTaskTimer(this, 0, 1);
}
}