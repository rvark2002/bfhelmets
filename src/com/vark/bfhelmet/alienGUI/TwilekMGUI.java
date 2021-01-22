package com.vark.bfhelmet.alienGUI;



	import java.io.File;
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

import com.vark.bfhelmet.HelmetGUI;
import com.vark.bfhelmet.HelmetUtilities;
import com.vark.bfhelmet.Main;
import com.vark.bfhelmet.UnlockGUI;
import com.vark.bfhelmet.helmetsGui.AlienGUI;


	public class TwilekMGUI implements Listener
	{

		//This is the GUI that will display all helmets

		private final Inventory inv;
		
		private Plugin plugin = Main.getPlugin(Main.class);
		
		public TwilekMGUI()
		{

			inv = Bukkit.createInventory(null,54,"UnlockedHelmets");

		}
		
		//Initializes GUI
		
		public TwilekMGUI(Plugin plugin, Player p)
		{
			

			plugin.getServer().getPluginManager().registerEvents(this, plugin);
			
			
			inv = Bukkit.createInventory(null,54,"UnlockedHelmets");
			
			initializeItems(p);
			
			
			
		}
		
		
		//Sets all the basic items in the gui
	    public void initializeItems(Player p) {

	    	
    		String unlocked = "§a§lUnlocked";
    		String unlockedLore = "Click To Wear!";
    		String locked = "§c§lLocked";
    		String lockedLore = "Level Up To Unlock This!";

	    	for(int i = 1510; i < 1519; i++)
	    	{

	    		if(HelmetUtilities.isUnlock(p, Material.PAPER,i))
	    			inv.setItem(i-1510,createGuiItem(i,Material.PAPER, unlocked,false, unlockedLore));
	    		else
		    	inv.setItem(i-1510,createGuiItem(i,Material.PAPER, locked,false, lockedLore));
		    	
	    		
	    		
	    	}
	    	
	    	

	    	for(int i = 2510; i < 2519; i++)
	    	{

	    		if(HelmetUtilities.isUnlock(p, Material.PAPER,i))
	    			inv.setItem(i-2510+18,createGuiItem(i,Material.PAPER, unlocked,false, unlockedLore));
	    		else
		    	inv.setItem(i-2510+18,createGuiItem(i,Material.PAPER, locked,false, lockedLore));
		    	
	    		
	    		
	    	}

	    	
	    	
	    	inv.setItem(45,createGuiItem(101,Material.REDSTONE_TORCH, "§c§lBack",false, ""));
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
		
		

		
		//How we add a gui item to a certain slot
		
	    private ItemStack createGuiItem(int n,final Material material, final String name, boolean enchanted, String lore) {
	        ItemStack item = new ItemStack(material, 1);
	         ItemMeta meta = item.getItemMeta();

	        if(n != 0)
	        {
	        	
	        	meta.setCustomModelData(n);
	        }
	        // Set the name of the item
	        meta.setDisplayName(name);

	        // Set the lore of the item
	        
	       if(enchanted)
	       {
	    	   
	    	   item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	       }
	       
	       
	       
	      List<String> itemlore =  new ArrayList<String>();
	      
	      if(!lore.equals(""))
	    	  itemlore.add(lore);
	      
	      

	        
	      item.setItemMeta(meta);

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
	        
//	        if(e.getRawSlot() == 19 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
//	        {
//			
//				Inventory i = new UtilityGUI(plugin,p).getInv();
//				p.closeInventory();
//				p.openInventory(i);
//				
//				
//	        }
//	
//	 
	        
	        
	        if(e.getRawSlot() == 45 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        {
	        	
	        	
	        	
	        	Inventory i = new AlienGUI(plugin,p).getInv();
	        	p.closeInventory();
	        	p.openInventory(i);
	        	
	        	
	        	
	        	
	        }
	        
	        else if(e.getRawSlot() != 45 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        {
	        	
	        	
	        	ItemStack i = e.getInventory().getItem(e.getRawSlot());
	        	if(i.hasItemMeta())
	        	{
	        		
	        		
	        		if(!(i.getItemMeta().getDisplayName().equals("§a§lUnlocked")))
	        		{
	        			return;
	        		}
	        		
	        	}
	        	else
	        	{
	        		return;
	        	}
	        			
	        	
	        	if(p.getInventory().getHelmet() != null)
	        	{
	        		
	        		if(p.getInventory().getHelmet().getType() == Material.PAPER || p.getInventory().getHelmet().getType() == Material.FEATHER)
	        		{
	        			p.getInventory().setHelmet(i);
	        			p.sendMessage(ChatColor.GOLD+"Updated Helmet!");
	        		}
	        		else
	        		{
	        		
	        			p.sendMessage(ChatColor.RED+"Could Not Place Helmet! Something is in its Place Already!");
	        		
	        		
	        		}
	        		
	        	}
	        	else {
	        		
        			p.getInventory().setHelmet(i);
        			p.sendMessage(ChatColor.GOLD+"Updated Helmet!");
	        	
	        	
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
			
			int x = config.getInt(force);
	    	
	    	return x;
	    	
	    	
	    	
	    }
	    

		
	}


