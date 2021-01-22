package com.vark.bfhelmet;

import java.io.File;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class HelmetUtilities {

	
	
	private static Plugin plugin = Main.getPlugin(Main.class);
	
	
	
	
	
	public static boolean isUnlock(Player p, Material material, int cmd)
	{
		

		
		int level = 0;
		
		level = Levels.getLevels(p);

		

		
		//Helmets
		
		if(material == Material.FEATHER)
		{
			
			if(level >= 1)
			{
				
				if(cmd == 205)
					return true;

				
				if(cmd == 502)
					return true;
				
				if(cmd == 701)
					return true;
				

			}
			
			if(level >= 2)
			{
				
				if(cmd == 202)
					return true;

				
				if(cmd == 201)
					return true;
	
				

			}
			
			
			if(level >= 3)
			{
				
				if(cmd == 203)
					return true;

				
				if(cmd == 204)
					return true;
				

			}
			
			

			
			
			if(level >= 5)
			{
				
				if(cmd == 101)
					return true;

				
				if(cmd == 102)
					return true;
				
				if(cmd == 103)
					return true;
				

			}
			
			
			
			if(level >= 7)
			{
				
				if(cmd == 301)
					return true;

				
				if(cmd == 304)
					return true;
				
				if(cmd == 303)
					return true;
				
				if(cmd == 601)
					return true;
				
				if(cmd == 602)
					return true;
				

			}

			
			if(level >= 11)
			{
				
				if(cmd == 603)
					return true;

				
				if(cmd == 604)
					return true;
				
				if(cmd == 605)
					return true;


			}
			
			if(level >= 17)
			{
				
			
					
					if(cmd == 302)
						return true;

					
					if(cmd == 305)
						return true;
					
					if(cmd == 306)
						return true;


				
			}
			
			
			if(level >= 19)
			{
				
				if(cmd == 401)
					return true;

				
				if(cmd == 501)
					return true;
				
				if(cmd == 605)
					return true;


			}	
			
			
			if(level >= 20)
			{
				
				if(cmd == 104)
					return true;

				
				if(cmd == 105)
					return true;
				
				if(cmd == 106)
					return true;


			}	
			
			if(level >= 24)
			{
				
				if(cmd == 606)
					return true;

				
				if(cmd == 607)
					return true;
				
				if(cmd == 608)
					return true;


			}	
				
			
			
			if(level >= 27)
			{
				
				if(cmd == 609)
					return true;

				
				if(cmd == 610)
					return true;
				
				if(cmd == 611)
					return true;


			}	
			
			
			
			if(level >= 30)
			{
				
				if(cmd == 107)
					return true;

				
				if(cmd == 108)
					return true;
				
				if(cmd == 109)
					return true;


			}
			
			
			if(level >= 32)
			{
				
				if(cmd == 612)
					return true;

				
				if(cmd == 613)
					return true;
				
				if(cmd == 614)
					return true;


			}
			
			if(level >= 34)
			{
				
				if(cmd == 615)
					return true;

				
				if(cmd == 616)
					return true;
				
				if(cmd == 617)
					return true;
				
				if(cmd == 618)
					return true;


			}
			
			
			
			
			
			
			
			File file = new File(plugin.getDataFolder().getParentFile()+"/BFBounty/playerdata/"+p.getUniqueId() + ".yml");
			
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			
			int x = config.getInt("kills",0);
			
			
			if(cmd == 901 && x >= 50)
				return true;
			
			if(cmd == 902 && x >= 100)
				return true;			
			
			if(cmd == 903 && x >= 10)
				return true;			
			
			
			if(cmd == 904 && x >= 20)
				return true;
			
			if(cmd == 110 && x >= 150)
				return true;
			
			
			
		}
		//Extensions
		else if(material == Material.PAPER)
		{
			
			
			
			
			
			if(level >= 7)
			{

				
				if(cmd == 1201)
					return true;
				
				if(cmd == 2201)
					return true;
				
				if(cmd == 1501)
					return true;
				
				if(cmd == 2501)
					return true;
				
				if(cmd == 1510)
					return true;
				
				if(cmd == 2510)
					return true;
				
				
				

			}
			
			
			
			if(level >= 8)
			{
				
				if(cmd == 2401)
					return true;

				
				if(cmd == 2402)
					return true;
				
				if(cmd == 1202)
					return true;
				
				if(cmd == 2202)
					return true;
				
				

			}
			
			
			if(level >= 9)
			{
				
				if(cmd == 1502)
					return true;

				
				if(cmd == 2502)
					return true;
				
				if(cmd == 1503)
					return true;
				
				if(cmd == 2503)
					return true;

				
				if(cmd == 1511)
					return true;
				
				if(cmd == 2511)
					return true;
				
				if(cmd == 1512)
					return true;
				
				if(cmd == 2512)
					return true;
				
				

			}
			
			
			if(level >= 10)
			{
				
				if(cmd == 1001)
					return true;

				
				if(cmd == 2001)
					return true;
				

				if(cmd == 1301)
					return true;

				
				if(cmd == 2301)
					return true;
				

			}
			
			if(level >= 12)
			{
				
				if(cmd == 2403)
					return true;

				
				if(cmd == 2404)
					return true;
				

				if(cmd == 2405)
					return true;

				

			}
			
			
			if(level >= 14)
			{
				
				if(cmd == 1203)
					return true;

				
				if(cmd == 2203)
					return true;
				

				if(cmd == 1204)
					return true;

				
				if(cmd == 2204)
					return true;
				

			}
			
			
			if(level >= 16)
			{
				
				if(cmd == 1504)
					return true;

				
				if(cmd == 2504)
					return true;
				

				if(cmd == 1513)
					return true;

				
				if(cmd == 2513)
					return true;
				

			}
			
			
			if(level >= 18)
			{
				
				if(cmd == 1101)
					return true;

				
				if(cmd == 1302)
					return true;
				

				if(cmd == 1303)
					return true;

				
				if(cmd == 2302)
					return true;
				
				if(cmd == 2303)
					return true;
				

			}
			
			if(level >= 25)
			{
				
				if(cmd == 1505)
					return true;

				
				if(cmd == 1506)
					return true;
				

				if(cmd == 1507)
					return true;

				
				if(cmd == 1504)
					return true;
				
				
				if(cmd == 2505)
					return true;

				
				if(cmd == 2506)
					return true;
				

				if(cmd == 2507)
					return true;

				
				if(cmd == 2504)
					return true;
				
				
				
				if(cmd == 2508)
					return true;
				
				
				if(cmd == 1508)
					return true;
				
	

			}
			
			
			
			if(level >= 26)
			{
				
				if(cmd == 1515)
					return true;

				
				if(cmd == 1516)
					return true;
				

				if(cmd == 1517)
					return true;

				
				if(cmd == 2515)
					return true;

				
				if(cmd == 2516)
					return true;
				

				if(cmd == 2517)
					return true;

				
				if(cmd == 2514)
					return true;
				
	

			}
			
			
			
			
			
			if(level >= 28)
			{
				
				if(cmd == 1509)
					return true;

				
				if(cmd == 2509)
					return true;
				

				if(cmd == 1518)
					return true;
				

				if(cmd == 2518)
					return true;

				
				if(cmd == 2518)
					return true;
				
				
				if(cmd == 2406)
					return true;

				
				if(cmd == 1205)
					return true;
				

				if(cmd == 2205)
					return true;

				
				if(cmd == 2514)
					return true;
				
	

			}
			
			
			
			
			
			
			
		}
		else
		{
			
			
			return false;
			
		}
		
		
		
		return false;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
