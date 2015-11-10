package com.starnetmc.core.modules.preferences.prefs;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import com.starnetmc.core.modules.preferences.Pref;
import com.starnetmc.core.modules.preferences.Preferences;
import com.starnetmc.core.modules.preferences.events.PlayerPrefrenceStateChangeEvent;
import com.starnetmc.core.util.F;

public class Pref_Visiblity extends Pref {
	
	public Pref_Visiblity(){
		super("Player Visibility", true, Material.ARMOR_STAND, Arrays.asList(" ",
				F.WHITE + "Toggle the visibility of",
				F.WHITE + "Other players!"));
	}
	
	@EventHandler
	public void onPrefChange(PlayerPrefrenceStateChangeEvent e){
		if (e.getPref().isActive()){
			for (Player p : Bukkit.getOnlinePlayers()){
				e.getPlayer().hidePlayer(p);
			}
			
		} else {
			
			for (Player p : Bukkit.getOnlinePlayers()){
				e.getPlayer().showPlayer(p);
			}
		}
		
		//Don't forget to add players that join and a method to Preferences that gives you all players with a certain setting on a certain mode.
	}
	
	@EventHandler
	public void onJoinVanish(PlayerJoinEvent e){
		for (Player p : Preferences.getPrefPlayers(this, false)){
			e.getPlayer().hidePlayer(p);
		}
	}
	
}