package com.vark.bfhelmet;



	import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
	import org.bukkit.ChatColor;
	import org.bukkit.Material;
	import org.bukkit.configuration.file.FileConfiguration;
	import org.bukkit.configuration.file.YamlConfiguration;
	import org.bukkit.enchantments.Enchantment;
	import org.bukkit.entity.ArmorStand;
	import org.bukkit.entity.Entity;
	import org.bukkit.entity.Player;
	import org.bukkit.entity.Wolf;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
	import org.bukkit.event.inventory.InventoryClickEvent;
	import org.bukkit.event.inventory.InventoryDragEvent;
	import org.bukkit.inventory.Inventory;
	import org.bukkit.inventory.ItemStack;
	import org.bukkit.inventory.meta.ItemMeta;
	import org.bukkit.plugin.Plugin;




	public class UpgradeGUI implements Listener
	{

		//This is the GUI that will display all helmets

		private final Inventory inv;
		
		private Plugin plugin = Main.getPlugin(Main.class);
		
		public UpgradeGUI()
		{

			inv = Bukkit.createInventory(null,54,"UnlockedHelmets");

		}
		
		//Initializes GUI
		
		public UpgradeGUI(Plugin plugin, Player p)
		{
			

			plugin.getServer().getPluginManager().registerEvents(this, plugin);
			
			
			inv = Bukkit.createInventory(null,54,"UnlockedHelmets");
			
			initializeItems(p);
			
			
			
		}
		
		
		//Sets all the basic items in the gui
	    public void initializeItems(Player p) {

	    		
	    		if(getPowerLevel(p, "helmet") == -1)
	    		{
	    			
	    			setPowerLevel(p, "helmet", 0);
	    			inv.setItem(4,createGuiItem(1,Material.DIAMOND_HELMET, "§cHelmet Defense I",false));
	    			
	    		}
	    		
	    		if(getPowerLevel(p, "helmet") == 0)
	    		{
	    			
	    			inv.setItem(4,createGuiItem(1,Material.DIAMOND_HELMET, "§cHelmet Defense I",false));
	    			
	    		}
	    		
	    		
	    		if(getPowerLevel(p, "helmet") == 1)
	    		{
	    			
	    			inv.setItem(4,createGuiItem(1,Material.DIAMOND_HELMET, "§cHelmet Defense I",true));
	    			
	    			
	    			inv.setItem(13,createGuiItem(1,Material.DIAMOND_HELMET, "§cHelmet Defense II",false));
	    		}
	    		
	    		
	    		if(getPowerLevel(p, "helmet") == 2)
	    		{
	    			
	    			inv.setItem(4,createGuiItem(1,Material.DIAMOND_HELMET, "§cHelmet Defense I",true));
	    			
	    			inv.setItem(13,createGuiItem(1,Material.DIAMOND_HELMET, "§cHelmet Defense II",true));
	    			
	    			inv.setItem(22,createGuiItem(1,Material.DIAMOND_HELMET, "§cHelmet Defense III",false));
	    		}
	    		
	    		
	    	
	    	
	    		if(getPowerLevel(p, "helmet") == 3)
	    		{
	    			
	    			
	    			inv.setItem(4,createGuiItem(1,Material.DIAMOND_HELMET, "§cHelmet Defense I",true));
	    			
	    			inv.setItem(13,createGuiItem(1,Material.DIAMOND_HELMET, "§cHelmet Defense II",true));
	    			
	    			inv.setItem(22,createGuiItem(1,Material.DIAMOND_HELMET, "§cHelmet Defense III",true));
	    			
	    			
	    			
	    			
	    			
	    		}
	    		
	    		
	            
	            boolean b = false;
	            
	            int s = getSkillPoints(p);
	            
	            if(s > 0)
	            {
	            	b = true;
	            }
	            
	          
	            
	            inv.setItem(53, createGuiItem(0, Material.MAGENTA_GLAZED_TERRACOTTA, "§lSkill Points "+s , b) );
	    		

	    }
		
		

		
		
		
		public Inventory getInv()
		{
			return inv;
		}
		
		
		
		
		public int getSkillPoints(Player p)
		{
			
			File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
			
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			int x = config.getInt("skillpoints");
						
			return x;
			
		}
		
		

		
	    private ItemStack createGuiItem(int n,final Material material, final String name, boolean enchanted) {
	        ItemStack item = new ItemStack(material, 1);
	         ItemMeta meta = item.getItemMeta();

	        if(n != 0)
	        {
	        	
	        	meta.setCustomModelData(n);
	        }
	        // Set the name of the item
	        meta.setDisplayName(name);

	        // Set the lore of the item
	        item.setItemMeta(meta);
	       if(enchanted)
	       {
	    	   
	    	   item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	       }

	        
	       

	        return item;
	    }
		
	    //Handling clicking items in inventory
		
	    @EventHandler
	    public void onInventoryClick(final InventoryClickEvent e) {
	        if (e.getInventory() != inv) return;

	        e.setCancelled(true);

	        final ItemStack clickedItem = e.getCurrentItem();

	        // verify current item is not null
	        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

	        final Player p = (Player) e.getWhoClicked();

	        // Using slots click is a best option for your inventory click's
	       // p.sendMessage("You clicked at slot " + e.getRawSlot());

	        if(e.getRawSlot() == 4 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        {
	        	
	        	if(getPowerLevel(p, "helmet") == 0 && Levels.getSkillpoints(p) >= 1)
	        	{
	        		setPowerLevel(p, "helmet", 1);
	        	
	        		Levels.addSkillpoins(p, -1);
	        	
	        		initializeItems(p);
	        		
	        		
	        		p.sendMessage(ChatColor.BLUE+"You Upgraded an Ability!");
	        		
	        	}
	        }
	        	
	        
	        if(e.getRawSlot() == 13 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        {
	        	if(getPowerLevel(p, "helmet") == 1 && Levels.getSkillpoints(p) >= 1)
	        	{
	        		setPowerLevel(p, "helmet", 2);
	        	
	        		Levels.addSkillpoins(p, -1);
	        	
	        		initializeItems(p);
	        		
	        		
	        		p.sendMessage(ChatColor.BLUE+"You Upgraded an Ability!");
	        		
	        	}
	        	
	        }
	        	
	        	
	        if(e.getRawSlot() == 22 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        { 	
	        	if(getPowerLevel(p, "helmet") == 2 && Levels.getSkillpoints(p) >= 1)
	        	{
	        		setPowerLevel(p, "helmet", 3);
	        	
	        		Levels.addSkillpoins(p, -1);
	        	
	        		initializeItems(p);
	        		
	        		
	        		p.sendMessage(ChatColor.BLUE+"You Upgraded an Ability!");
	        		
	        	}
	        	
	        }
	        
	    }
	    
	    
	    //preventing dragging
	  

		@EventHandler
	    public void onInventoryClick(final InventoryDragEvent e) {
	        if (e.getInventory() == inv) {
	          e.setCancelled(true);
	        }
	    }
		
	    
	    
	    
	    
	    public int getPowerLevel(Player p, String force)
	    {
	    	
	    
	    	
	    	
	    	File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
	    	
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			int x = config.getInt(force,-1);
	    	
	    	return x;
	    	
	    	
	    	
	    }
	    
	    
	    
	    
	    public void setPowerLevel(Player p, String force,int x)
	    {
	    	
	    
	    	
	    	
	    	File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
	    	
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			config.set(force,x);


			try {
				config.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

		
	}


