package com.vark.bfhelmet;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;



public class Crafting implements Listener
{

	
//This just provides an instance of the plugin
	private Plugin plugin = Main.getPlugin(Main.class);
	
	//This is the constructor which sets up the Crafting Listeners
	public Crafting(Main plugin) {
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
		createRecipe();
	}

	
	public void createRecipe() {
		
		//Stormtrooper Helmet Example
		//Helmets will be tied to feathers
		
		ItemStack hst = new ItemStack(Material.FEATHER);
		
		
		ItemMeta hstm = hst.getItemMeta();		
		hstm.setDisplayName(ChatColor.RED+""+ChatColor.BOLD+"Stormtrooper Helmet");	
		
		//This is how you set custom model data to items,
		//Check resource pack to see what id's match what, 101 is storm trooper helmet
		hstm.setCustomModelData(101);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Right Click To Wear!"); 
		
		//Make sure you set the Lore and the Item meta or it will not save!
		hstm.setLore(lore);		
		hst.setItemMeta(hstm);
		
		//This is how we create a crafting recipe, do not know if we will continue this!
		NamespacedKey key = new NamespacedKey(plugin, "stormtrooperhelmet");
		ShapedRecipe r = new ShapedRecipe(key, hst);
		r.shape("III", "I*I", "***");
	
		r.setIngredient('I', Material.IRON_BLOCK);
		r.setIngredient('*', Material.AIR);

		plugin.getServer().addRecipe(r);
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
