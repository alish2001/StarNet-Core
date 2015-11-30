package com.starnetmc.core.util;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class UPlayer {
	
	/*
	 * DO NOT USE THIS CLASS
	 * It is being kept for legacy support.
	 * Please do not write new methods using this.
	 */
	
	public static void hidePlayerFromAll(Player hider){
		
		for (Player p : Bukkit.getServer().getOnlinePlayers()){
			p.hidePlayer(hider);
		}
	}
	
	public static void showPlayerToAll(Player unHider){
		
		for (Player p : Bukkit.getServer().getOnlinePlayers()){
			p.showPlayer(unHider);
		}
	}
	
	public static Player getOnlinePlayerFromName(String p){
		Player sp = Bukkit.getServer().getPlayer(p);
		if (sp == null){
			return null;
		}
		else{
			return sp;
		}
	}
	
	@SuppressWarnings("deprecation")
	public static OfflinePlayer getOfflinePlayerFromName(String p){
		OfflinePlayer sp = Bukkit.getServer().getOfflinePlayer(p);
		if (sp == null){
			return null;
		}
		else{
			return sp;
		}
	}
	
	public static Player getPlayerFromUUID(UUID uid){
		return Bukkit.getServer().getPlayer(uid);
	}
	
	public static boolean isOnline(String name){
		if (getOnlinePlayerFromName(name) == null){
			return false;
		}
		else { return true; }
	}

}
