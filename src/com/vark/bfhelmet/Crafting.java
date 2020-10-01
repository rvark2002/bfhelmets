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

	private Plugin plugin = Main.getPlugin(Main.class);
	public Crafting(Main plugin) {
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
		createRecipe();
	}

	
	public void createRecipe() {
		
		//Stormtrooper Helmet
		
		ItemStack hst = new ItemStack(Material.FEATHER);
		
		
		ItemMeta hstm = hst.getItemMeta();		
		hstm.setDisplayName(ChatColor.RED+""+ChatColor.BOLD+"Stormtrooper Helmet");		
		hstm.setCustomModelData(101);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Right Click To Wear!"); 
		hstm.setLore(lore);		
		hst.setItemMeta(hstm);
		
		
		NamespacedKey key = new NamespacedKey(plugin, "stormtrooperhelmet");
		ShapedRecipe r = new ShapedRecipe(key, hst);
		r.shape("III", "I*I", "***");
	
		r.setIngredient('I', Material.IRON_BLOCK);
		r.setIngredient('*', Material.AIR);

		plugin.getServer().addRecipe(r);
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
