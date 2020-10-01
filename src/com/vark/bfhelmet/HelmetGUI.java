package com.vark.bfhelmet;

import java.io.File;

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


public class HelmetGUI implements Listener
{

//This is the work in progress Helmet GUI, Here you may see some stuff unrelated to helmets
//This is because I copy and pasted another gui we had in here
//Almost all of this will be changed

private final Inventory inv;
	
	private Plugin plugin = Main.getPlugin(Main.class);
	
	public HelmetGUI()
	{

		inv = Bukkit.createInventory(null,9,"Helmets");

	}
	
	//Initializes GUI
	
	public HelmetGUI(Plugin plugin, Player p)
	{
		

		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
		
		inv = Bukkit.createInventory(null,54,"Helmets");
		
		initializeItems(p);
		
		
		
	}
	
	
	//Sets all the basic items in the gui
    public void initializeItems(Player p) {
    	String s = ""+getSkillPoints(p);
    	
    	
        inv.setItem(19,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Utility",false));
        
        if(getPowerLevel(p, "forcepush") >= 1)
        {
        	inv.setItem(22,createGuiItem(131,Material.MUSIC_DISC_FAR, "§4Offense",false));
                
        	inv.setItem(25,createGuiItem(141,Material.MUSIC_DISC_FAR, "§aDefense",false));
        	
        	
        	inv.setItem(49,createGuiItem(100,Material.DIAMOND, "§cForce Power Discs",true));
        
        }

        
        
        
        
        boolean b = false;
        if(getSkillPoints(p) >= 1)
        	b = true;
        
        inv.setItem(53, createGuiItem(0, Material.MAGENTA_GLAZED_TERRACOTTA, "§lSkill Points "+s,b) );
        

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
        
        if(e.getRawSlot() == 19 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
		
			Inventory i = new UtilityGUI(plugin,p).getInv();
			p.closeInventory();
			p.openInventory(i);
			
			
        }
        
        if(e.getRawSlot() == 22 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
		
			Inventory i = new OffenseGUI(plugin,p).getInv();
			p.closeInventory();
			p.openInventory(i);
			
			
        }
        
        if(e.getRawSlot() == 25 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
		
			Inventory i = new DefenseGUI(plugin,p).getInv();
			p.closeInventory();
			p.openInventory(i);
			
			
        }
        
        if(e.getRawSlot() == 49 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
		
			Inventory i = new ItemGUI(plugin,p).getInv();
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
