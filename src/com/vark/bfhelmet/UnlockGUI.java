package com.vark.bfhelmet;



	import java.io.File;
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

import com.vark.bfhelmet.helmetsGui.AlienGUI;
import com.vark.bfhelmet.helmetsGui.CloneAGUI;
import com.vark.bfhelmet.helmetsGui.CloneBGUI;
import com.vark.bfhelmet.helmetsGui.ForceGUI;
import com.vark.bfhelmet.helmetsGui.ImperialGUI;
import com.vark.bfhelmet.helmetsGui.MandoGUI;
import com.vark.bfhelmet.helmetsGui.RebelGUI;
import com.vark.bfhelmet.helmetsGui.SpecialGUI;


	public class UnlockGUI implements Listener
	{

		//This is the GUI that will display all helmets

		private final Inventory inv;
		
		private Plugin plugin = Main.getPlugin(Main.class);
		
		public UnlockGUI()
		{

			inv = Bukkit.createInventory(null,54,"UnlockedHelmets");

		}
		
		//Initializes GUI
		
		public UnlockGUI(Plugin plugin, Player p)
		{
			

			plugin.getServer().getPluginManager().registerEvents(this, plugin);
			
			
			inv = Bukkit.createInventory(null,54,"UnlockedHelmets");
			
			initializeItems(p);
			
			
			
		}
		
		
		//Sets all the basic items in the gui
	    public void initializeItems(Player p) {

	    	
	    	inv.setItem(18,createGuiItem(101,Material.FEATHER, "§a§lForce Sensitive",false, ""));
	    	inv.setItem(20,createGuiItem(201,Material.FEATHER, "§b§lPhase I Clones",false, ""));
	    	inv.setItem(22,createGuiItem(301,Material.FEATHER, "§c§lPhase II Clones",false, ""));
	    	inv.setItem(24,createGuiItem(601,Material.FEATHER, "§7§lMandalorian",false, ""));
	    	
	    	inv.setItem(26,createGuiItem(1101,Material.PAPER, "§2§lAlien",false, ""));
	    	
	    	
	    	
	    	
	    	inv.setItem(28,createGuiItem(701,Material.FEATHER, "§6§lRebel",false, ""));
	    	
	    	inv.setItem(30,createGuiItem(502,Material.FEATHER, "§4§lImperial",false, ""));
	    	
	    	
	    	inv.setItem(32,createGuiItem(111,Material.FEATHER, "§e§lSpecial",false, ""));
	    	
	    	
	    	
	    	
	    	
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
	       
	       
	       
	      List<String> itemlore =  meta.getLore();
	      
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
	        
	        
	        
	        if(e.getRawSlot() == 18 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        {
	        	
	        	
	        	
	        	Inventory i = new ForceGUI(plugin,p).getInv();
	        	p.closeInventory();
	        	p.openInventory(i);
	        	
	        	
	        	
	        	
	        }
	        if(e.getRawSlot() == 20 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        {
	        	
	        	
	        	
	        	Inventory i = new CloneAGUI(plugin,p).getInv();
	        	p.closeInventory();
	        	p.openInventory(i);
	        	
	        	
	        	
	        	
	        }
	        
	        if(e.getRawSlot() == 22 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        {
	        	
	        	
	        	
	        	Inventory i = new CloneBGUI(plugin,p).getInv();
	        	p.closeInventory();
	        	p.openInventory(i);
	        	
	        	
	        	
	        	
	        }
	        
	        
	        if(e.getRawSlot() == 24 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        {
	        	
	        	
	        	
	        	Inventory i = new MandoGUI(plugin,p).getInv();
	        	p.closeInventory();
	        	p.openInventory(i);
	        	
	        	
	        	
	        	
	        }
	        
	        
	        if(e.getRawSlot() == 26 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        {
	        	
	        	
	        	
	        	Inventory i = new AlienGUI(plugin,p).getInv();
	        	p.closeInventory();
	        	p.openInventory(i);
	        	
      	
	        	
	        	
	        }
	        
	        
	        if(e.getRawSlot() == 28 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        {
	        	
	        	
	        	
	        	Inventory i = new RebelGUI(plugin,p).getInv();
	        	p.closeInventory();
	        	p.openInventory(i);
	        	
	        	
	        	
	        	
	        }
	        
	        if(e.getRawSlot() == 30 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        {
	        	
	        	
	        	
	        	Inventory i = new ImperialGUI(plugin,p).getInv();
	        	p.closeInventory();
	        	p.openInventory(i);
	        	
	        	
	        	
	        	
	        }
	        
	        if(e.getRawSlot() == 32 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        {
	        	
	        	
	        	
	        	Inventory i = new SpecialGUI(plugin,p).getInv();
	        	p.closeInventory();
	        	p.openInventory(i);
	        	
	        	
	        	
	        	
	        }
	        
	        if(e.getRawSlot() == 45 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
	        {
	        	
	        	
	        	
	        	Inventory i = new HelmetGUI(plugin,p).getInv();
	        	p.closeInventory();
	        	p.openInventory(i);
	        	
	        	
	        	
	        	
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


