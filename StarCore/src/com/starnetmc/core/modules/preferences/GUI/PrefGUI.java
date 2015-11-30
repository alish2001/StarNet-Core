package com.starnetmc.core.modules.preferences.GUI;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.starnetmc.core.accounts.AccountManager;
import com.starnetmc.core.modules.preferences.Pref;
import com.starnetmc.core.modules.preferences.Preferences;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Logger;
import com.starnetmc.core.util.Rank;

public class PrefGUI {

	public static void openPrefGUI(Player p) {

		Inventory prefgui = Bukkit.createInventory(null, 45, F.boldAqua + "Preferences");
		
		ArrayList<Pref> prefCache = Preferences.getPrefs(p);
		
		System.out.println(p.getName() + prefCache);
		
		if (!(AccountManager.getAccount(p).getRank() == Rank.OWNER || AccountManager.getAccount(p).getRank() == Rank.DEVELOPER || AccountManager.getAccount(p).getRank() == Rank.ADMIN)){
		   Logger.log("Rank != Admin, removing admin prefs.");
		for (Iterator<Pref> pref = prefCache.iterator(); pref.hasNext();){
			   Logger.log("Looping through prefCache..");
			for (Pref uP : Preferences.getAdminPrefs()){
				   Logger.log("Looping through AdminPrefs..");
				if (ChatColor.stripColor(pref.next().getName()).equalsIgnoreCase(ChatColor.stripColor(uP.getName()))){
					Logger.log("Name matched. Pref=" + pref.next().getName() + " uP=" + uP.getName());
					prefCache.remove(pref.next());
					continue;
				}
			  }
		   }
		}
		
		Logger.log("Rank check done.");
		
		int centerPosition = 22;
		int position = centerPosition;
		
		for (Pref pref : prefCache){
				
				if (position == centerPosition){
					setPref(prefgui, pref, position);
					position++;
					continue;
				}
			    
				if (position > centerPosition){
					
					for (int i = position; prefgui.getItem(i) != null && prefgui.getItem(i).getType() != Material.AIR; i--){
						position--;
					}
					
					setPref(prefgui, pref, position);
					continue;
				}
					
				if (position < centerPosition){
					
					for (int i = position; prefgui.getItem(i) != null && prefgui.getItem(i).getType() != Material.AIR; i--){
						position++;
					}
					
					setPref(prefgui, pref, position);
					continue;
				}
          }
		
		p.openInventory(prefgui);
	}
	
	public static void setPref(Inventory gui, Pref pref, int position){
		gui.setItem(position, pref.getIcon());
		gui.setItem(position + 9, pref.getStatusIcon(pref.isActive()));
	}

}