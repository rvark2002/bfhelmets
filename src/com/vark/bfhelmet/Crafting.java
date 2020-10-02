package com.vark.bfhelmet;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
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
		
		ItemStack hst = new ItemStack(Material.FEATHER);	
		ItemMeta hstm = hst.getItemMeta();		
		hstm.setDisplayName(ChatColor.WHITE+""+ChatColor.BOLD+"Stormtrooper Helmet");	
		hstm.setCustomModelData(101);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("This is the basic stormtrooper helmet!");
		lore.add("Right Click To Wear!"); 
		hstm.setLore(lore);		
		hst.setItemMeta(hstm);
		NamespacedKey key = new NamespacedKey(plugin, "stormtrooperhelmet");
		ShapedRecipe r = new ShapedRecipe(key, hst);
		r.shape("III", "IGI", "   ");
		r.setIngredient('I', Material.IRON_BLOCK);
		r.setIngredient('G', Material.GLASS_PANE);
		plugin.getServer().addRecipe(r);	
	}
	
	
	
	
	
	
	
	
	
}
