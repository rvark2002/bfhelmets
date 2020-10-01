package com.vark.bfhelmet;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class HelmetListener implements Listener
{
	
	
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
	
	
	
}
