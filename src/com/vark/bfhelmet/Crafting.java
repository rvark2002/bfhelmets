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
		StormtrooperRecipe();
		cloneYellowRecipe();
		cloneRedRecipe();
		cloneBlueRecipe();
		cloneGreenRecipe();
	}

	
	public void StormtrooperRecipe() {
		ItemStack hst = new ItemStack(Material.FEATHER);	
		ItemMeta hstm = hst.getItemMeta();		
		hstm.setDisplayName(ChatColor.WHITE+""+ChatColor.BOLD+"Stormtrooper Helmet");	
		hstm.setCustomModelData(101);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("This is the Basic Stormtrooper helmet!");
		lore.add("Right Click To Wear!"); 
		hstm.setLore(lore);		
		hst.setItemMeta(hstm);
		NamespacedKey key = new NamespacedKey(plugin, "stormtrooperhelmet");
		ShapedRecipe r = new ShapedRecipe(key, hst);
		r.shape("III", "IGI", "***");
		r.setIngredient('I', Material.IRON_BLOCK);
		r.setIngredient('G', Material.GLASS_PANE);
		r.setIngredient('*', Material.AIR);
		plugin.getServer().addRecipe(r);	
	}
	
	public void cloneYellowRecipe() {
		ItemStack hst = new ItemStack(Material.FEATHER);	
		ItemMeta hstm = hst.getItemMeta();		
		hstm.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"Yellow Clone Helmet");	
		hstm.setCustomModelData(106);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("This is the Yellow Clone helmet!");
		lore.add("It makes you faster! Providing speed and haste!");
		lore.add("Right Click To Wear!"); 
		hstm.setLore(lore);		
		hst.setItemMeta(hstm);
		NamespacedKey key = new NamespacedKey(plugin, "cloney");
		ShapedRecipe r = new ShapedRecipe(key, hst);
		r.shape("III", "IGI", "*R*");
		r.setIngredient('I', Material.IRON_BLOCK);
		r.setIngredient('G', Material.GLASS_PANE);
		r.setIngredient('R', Material.REDSTONE_BLOCK);
		r.setIngredient('*', Material.AIR);
		plugin.getServer().addRecipe(r);	
	}

	public void cloneRedRecipe() {
		ItemStack hst = new ItemStack(Material.FEATHER);	
		ItemMeta hstm = hst.getItemMeta();		
		hstm.setDisplayName(ChatColor.RED+""+ChatColor.BOLD+"Red Clone Helmet");	
		hstm.setCustomModelData(105);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("This is the Red Clone helmet!");
		lore.add("Makes you stronger but is very heavy! Provides strength and slowness!");
		lore.add("Right Click To Wear!"); 
		hstm.setLore(lore);		
		hst.setItemMeta(hstm);
		NamespacedKey key = new NamespacedKey(plugin, "cloner");
		ShapedRecipe r = new ShapedRecipe(key, hst);
		r.shape("III", "IGI", "*B*");
		r.setIngredient('I', Material.IRON_BLOCK);
		r.setIngredient('G', Material.GLASS_PANE);
		r.setIngredient('B', Material.BLAZE_ROD);
		r.setIngredient('*', Material.AIR);
		plugin.getServer().addRecipe(r);	
	}
	
	public void cloneGreenRecipe() {
		ItemStack hst = new ItemStack(Material.FEATHER);	
		ItemMeta hstm = hst.getItemMeta();		
		hstm.setDisplayName(ChatColor.GREEN+""+ChatColor.BOLD+"Green Clone Helmet");	
		hstm.setCustomModelData(104);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("This is the Green Clone helmet!");
		lore.add("Provides permanant night vision and you become invisible when crouching!");
		lore.add("Right Click To Wear!"); 
		hstm.setLore(lore);		
		hst.setItemMeta(hstm);
		NamespacedKey key = new NamespacedKey(plugin, "cloneg");
		ShapedRecipe r = new ShapedRecipe(key, hst);
		r.shape("III", "IGI", "X*X");
		r.setIngredient('I', Material.IRON_BLOCK);
		r.setIngredient('G', Material.GLASS_PANE);
		r.setIngredient('X', Material.GREEN_STAINED_GLASS_PANE);
		r.setIngredient('*', Material.AIR);
		plugin.getServer().addRecipe(r);
	}
	
	public void cloneBlueRecipe() {
		ItemStack hst = new ItemStack(Material.FEATHER);	
		ItemMeta hstm = hst.getItemMeta();		
		hstm.setDisplayName(ChatColor.AQUA+""+ChatColor.BOLD+"Blue Clone Helmet");	
		hstm.setCustomModelData(103);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("This is a Blue Clone helmet!");
		lore.add("Toughens all you armor so you take less damage but its very heavy! Provides resistance and slowness!");
		lore.add("Right Click To Wear!"); 
		hstm.setLore(lore);		
		hst.setItemMeta(hstm);
		NamespacedKey key = new NamespacedKey(plugin, "cloneb");
		ShapedRecipe r = new ShapedRecipe(key, hst);
		r.shape("III", "IGI", "*D*");
		r.setIngredient('I', Material.IRON_BLOCK);
		r.setIngredient('G', Material.GLASS_PANE);
		r.setIngredient('D', Material.DIAMOND);
		r.setIngredient('*', Material.AIR);
		plugin.getServer().addRecipe(r);	
	}

}
