package com.vark.bfhelmet;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;

public class HelmetListener implements Listener
{
	
	private Plugin plugin = Main.getPlugin(Main.class);
	
	public HelmetListener(Main plugin)
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	
	//When right clicked with a feather that has a custom model data
	//It will palce it on your head as long as you dont have any other items on
	
	@EventHandler
	public void putHelm(PlayerInteractEvent event)
	{
		if(event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			Player p = event.getPlayer();
			
			if(p.getInventory().getItemInMainHand().getType().equals(Material.FEATHER));
			{
				if(checkHelm(p.getInventory().getItemInMainHand()))
				{
							
					if(p.getInventory().getHelmet() == null || p.getInventory().getHelmet().getType().equals(Material.AIR))
					{
						if(p.getInventory().getItemInMainHand().getAmount() == 1)
						{
						p.getInventory().setHelmet(p.getInventory().getItemInMainHand());
						p.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
						helmetEffects(p);
						event.setCancelled(true);
						}
						else {
							p.sendMessage(ChatColor.RED+"Only One Helmet in Hand!");
						}
					}
					else {
						p.sendMessage(ChatColor.RED+"Remove Helmet!");
					}
				}
			}
			
			
		}
	}
	
	
	//Checks if its a helmet or not
	
	public boolean checkHelm(ItemStack is)
	{
		if(is.getType() == Material.FEATHER)
			if(is.hasItemMeta())
				if(is.getItemMeta().hasCustomModelData())
					if(is.getItemMeta().getCustomModelData() >= 100)
						return true;
		
			
		return false;
	}

	
	public void helmetEffects(Player p) 
	{
		new BukkitRunnable() 
			{
			
				@Override
				public void run() 
				{
					
					
					if (p.getInventory().getHelmet() == null) 
						cancel();	

					if(!p.getInventory().getHelmet().hasItemMeta())
						cancel();
					
					if(!(p.getInventory().getHelmet().getItemMeta().hasCustomModelData()))
						cancel();
					
								
				 		ItemStack item = p.getInventory().getHelmet();
				 		
				 		int modelData = p.getInventory().getHelmet().getItemMeta().getCustomModelData();
				 		
				 		//Yellow
				 		if(modelData == 106)				 			
				 		{
				 			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 1, true));
							p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20, 1, true));				 			
				 			
				 		}
				 		//Red
				 		if(modelData == 105)
				 		{
				 			
			            	p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20, 1, true));
			            	p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20, 1, true));	
				 		}
				 		
				 		//Green
				 		if(modelData == 104)
				 		{
				 			p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20, 60, true));
							if (p.isSneaking()) 
							{
								p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20, 1, true));
							}
							else
							{
								
								if(p.hasPotionEffect(PotionEffectType.INVISIBILITY))
								{
									p.removePotionEffect(PotionEffectType.INVISIBILITY);
									
								}
								
							}
							
				 		}
				 		
				 		//Blue
				 		
				 		if(modelData == 103)
				 		{
				 			
							p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 1, true));
							p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20, 1, true));
				 			

				 		}
				 		

				}
			}.runTaskTimer(plugin, 0, 1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
