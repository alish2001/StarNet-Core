package com.starnetmc.core.modules.preferences.GUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.starnetmc.core.modules.preferences.Pref;
import com.starnetmc.core.modules.preferences.Preferences;
import com.starnetmc.core.util.USound;

public class PrefUI implements Listener {
	
	@EventHandler
	public void prefUI(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName() == null) return;
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Preferences")) return;
		if (e.getCurrentItem() == null) return;
		if (e.getCurrentItem().getType() == null) return;
		if (e.getCurrentItem().getType() == Material.AIR) return;
		e.setCancelled(true);
		
		for (Pref pref : Preferences.getPrefs(p)){
				   
			//Check for pref nullness.
			if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getLore().get(1)).equalsIgnoreCase(ChatColor.stripColor(pref.getName()))) {
				   System.out.println("lore[1]=prefname");
				   if (Preferences.getPref(p, pref).isActive()){
					   System.out.println("pref=active");
					   Preferences.setPrefState(p, pref, false);
					   USound.PSound(p, Sound.NOTE_PLING, -0.75f, 1);
				     } else {
					   System.out.println("pref!=active");
					   Preferences.setPrefState(p, pref, true);
					   USound.PSound(p, Sound.ORB_PICKUP, 7F, 1F);
				    }
					   
			         p.closeInventory();
				     PrefGUI.openPrefGUI(p);
				   }
			}
	}

}