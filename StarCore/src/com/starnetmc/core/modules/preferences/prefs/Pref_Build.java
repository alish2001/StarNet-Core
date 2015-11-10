package com.starnetmc.core.modules.preferences.prefs;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import com.starnetmc.core.modules.preferences.Pref;
import com.starnetmc.core.modules.preferences.Preferences;
import com.starnetmc.core.util.F;

public class Pref_Build extends Pref {

	public Pref_Build(){
		super("Building", false, Material.GRASS, Arrays.asList(" ",
				F.WHITE + "Toggle Bulding",
				F.WHITE + "to be able to build in the Hub!",
				F.WHITE + "WARNING: Changes cannot be reverted",
				F.WHITE + "Unless a full world reset is performed."));
	}
	

	@EventHandler(priority = EventPriority.LOW)
	public void onBreak(BlockBreakEvent e) throws Exception {
		
		Player p = e.getPlayer();
		
		if (!Preferences.getPref(p, this).isActive()) e.setCancelled(true);
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void onPlace(BlockPlaceEvent e) throws Exception {
		
		Player p = e.getPlayer();
		
		if (!Preferences.getPref(p, this).isActive()) e.setCancelled(true);
	}
	
}