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
		Stormtrooper1Recipe();
		Stormtrooper2Recipe();
		Stormtrooper3Recipe();
		Stormtrooper4Recipe();
		Stormtrooper5Recipe();
	}

	
	public void Stormtrooper2Recipe() {
		ItemStack hst = new ItemStack(Material.FEATHER);	
		ItemMeta hstm = hst.getItemMeta();		
		hstm.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"Yellow Stormtrooper Helmet");	
		hstm.setCustomModelData(106);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("This is the yellow stormtrooper helmet!");
		lore.add("It makes you faster! Providing speed and haste!");
		lore.add("Right Click To Wear!"); 
		hstm.setLore(lore);		
		hst.setItemMeta(hstm);
		NamespacedKey key = new NamespacedKey(plugin, "stormtrooperhelmet");
		ShapedRecipe r = new ShapedRecipe(key, hst);
		r.shape("III", "IGI", " R ");
		r.setIngredient('I', Material.IRON_BLOCK);
		r.setIngredient('G', Material.GLASS_PANE);
		r.setIngredient('R', Material.REDSTONE_BLOCK);
		plugin.getServer().addRecipe(r);	
	}
	
	public void Stormtrooper3Recipe() {
		ItemStack hst = new ItemStack(Material.FEATHER);	
		ItemMeta hstm = hst.getItemMeta();		
		hstm.setDisplayName(ChatColor.RED+""+ChatColor.BOLD+"Stormtrooper Helmet");	
		hstm.setCustomModelData(105);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("This is the red stormtrooper helmet!");
		lore.add("Makes you stronger but is very heavy! Provides strength and slowness!");
		lore.add("Right Click To Wear!"); 
		hstm.setLore(lore);		
		hst.setItemMeta(hstm);
		NamespacedKey key = new NamespacedKey(plugin, "stormtrooperhelmet");
		ShapedRecipe r = new ShapedRecipe(key, hst);
		r.shape("III", "IGI", " B ");
		r.setIngredient('I', Material.IRON_BLOCK);
		r.setIngredient('G', Material.GLASS_PANE);
		r.setIngredient('B', Material.BLAZE_ROD);
		plugin.getServer().addRecipe(r);	
	}
	
	public void Stormtrooper4Recipe() {
		ItemStack hst = new ItemStack(Material.FEATHER);	
		ItemMeta hstm = hst.getItemMeta();		
		hstm.setDisplayName(ChatColor.GREEN+""+ChatColor.BOLD+"Stealthtrooper Helmet");	
		hstm.setCustomModelData(104);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("This is the green stealthtrooper helmet!");
		lore.add("Provides permanant night vision and you become invisible when crouching!");
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
	
	public void Stormtrooper5Recipe() {
		ItemStack hst = new ItemStack(Material.FEATHER);	
		ItemMeta hstm = hst.getItemMeta();		
		hstm.setDisplayName(ChatColor.AQUA+""+ChatColor.BOLD+"Stormtrooper Helmet");	
		hstm.setCustomModelData(103);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("This is the basic stormtrooper helmet!");
		lore.add("Toughens all you armor so you take less damage but its very heavy! Provides resistance and slowness!");
		lore.add("Right Click To Wear!"); 
		hstm.setLore(lore);		
		hst.setItemMeta(hstm);
		NamespacedKey key = new NamespacedKey(plugin, "stormtrooperhelmet");
		ShapedRecipe r = new ShapedRecipe(key, hst);
		r.shape("III", "IGI", "XDX");
		r.setIngredient('I', Material.IRON_BLOCK);
		r.setIngredient('G', Material.GLASS_PANE);
		r.setIngredient('X', Material.GLASS);
		r.setIngredient('D', Material.DIAMOND);
		plugin.getServer().addRecipe(r);	
	}
	
	public void Stormtrooper1Recipe() {
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
