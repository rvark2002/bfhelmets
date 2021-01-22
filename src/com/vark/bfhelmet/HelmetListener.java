package com.vark.bfhelmet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import net.md_5.bungee.api.ChatColor;

public class HelmetListener implements Listener
{
	
	private Plugin plugin = Main.getPlugin(Main.class);
	
	public HelmetListener(Main plugin)
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}


	
	//Prevents removal
	@EventHandler
	public void onHelmetRemove(InventoryClickEvent event)
	{
		if(event.getSlotType() == SlotType.ARMOR)
		{
			if(event.getCurrentItem().getType() == Material.FEATHER || event.getCurrentItem().getType() == Material.PAPER)
			if(event.getCurrentItem().hasItemMeta())
				if(event.getCurrentItem().getItemMeta().hasCustomModelData())
					if(event.getCurrentItem().getItemMeta().getCustomModelData() >= 1)
					{
						
						event.getWhoClicked().sendMessage(ChatColor.GOLD+"To Change Your Helmet, Please Use /helmets");
						event.setCancelled(true);
	
					}
		}
	}
	
	
	
	
	
	
	
	
	
	//Handles when they die
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event)
	{
		
		
		
		List<ItemStack> drops = event.getDrops();
		
		List<ItemStack> removed = new ArrayList<ItemStack>();
		
		
		for(ItemStack item: drops)
		{
			if(item.getType() == Material.FEATHER || item.getType() == Material.PAPER)
			{
				if(item.hasItemMeta())
					if(item.getItemMeta().hasCustomModelData())
						if(item.getItemMeta().getCustomModelData() >= 1)
						{
							removed.add(item);
							
						}
			}
		}
		
		
		for(ItemStack item:removed)
		{
			if(drops.contains(item))
			{
				drops.remove(item);
				//System.out.println("Purged Helmet");
			}
		}
		
		
		
		
		
		
		
		
	}
	

	
	
	
	@EventHandler
	public void helmetBlock(EntityDamageByEntityEvent event)
	{
		
		
		
		if(event.getEntity() instanceof Player)
		{
			Player p = (Player) event.getEntity();
			if(p.getInventory().getHelmet() != null){
				
			if(p.getInventory().getHelmet().getType() == Material.FEATHER || p.getInventory().getHelmet().getType() == Material.PAPER)
			{
			//	p.sendMessage(""+event.getDamage());
//				
//				p.sendMessage(""+(event.getDamage()-event.getDamage()*0.4));
				
				
				if(p.getWorld().getName().equals("minigame"))
				{
					return;
				}
				
				int x = getPowerLevel(p, "helmet");
				
				if(x == 1)
				{
					event.setDamage(event.getDamage()-event.getDamage()*0.08);
					//p.sendMessage(""+(event.getDamage()-event.getDamage()*0.08));
				}
				
				if(x == 2)
				{
					event.setDamage(event.getDamage()-event.getDamage()*0.16);
					//p.sendMessage(""+(event.getDamage()-event.getDamage()*0.16));
				}
				
				if(x == 3)
				{
				event.setDamage(event.getDamage()-event.getDamage()*0.28);
				//p.sendMessage(""+(event.getDamage()-event.getDamage()*0.28));
				}
				
				
			}
			
			
			}
		}
		
		
	}
	
	
	
	
	
	
	

	public void FileUpdate(PlayerJoinEvent event)
	{
		
		Player p = event.getPlayer();
		File file = new File(plugin.getDataFolder().getParentFile()+"/BFHelmets/data/"+p.getUniqueId() + ".yml");
		
		if(!file.exists())
		{
			System.out.println("Generating Helmet Config");
			
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			config.set("helmetlvl", 0);
			config.set("hu1", 0);
			config.set("hu2", 0);
			config.set("hu3", 0);
			config.set("hu4", 0);
			config.set("hu5", 0);//For future use
			config.set("hu6", 0);
			config.set("hu7", 0);
			config.set("hu8", 0);
			config.set("hu9", 0);

			
			try {
				config.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
    public int getPowerLevel(Player p, String id)
    {

    	File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
    	
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		int x = config.getInt(id,-1);
    	
    	return x;
    	
    	
    	
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
