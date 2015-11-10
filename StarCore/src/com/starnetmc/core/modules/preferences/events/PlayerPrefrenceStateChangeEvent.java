package com.starnetmc.core.modules.preferences.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.starnetmc.core.modules.preferences.Pref;

public class PlayerPrefrenceStateChangeEvent extends Event {

	private static final HandlerList handlers = new HandlerList();

	public Player player;
    public Pref pref;
	
	public PlayerPrefrenceStateChangeEvent(Player player, Pref pref) {
		this.player = player;
		this.pref = pref;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public Pref getPref(){
		return pref;
	}

	public HandlerList getHandlers() {
	    return handlers;
	}
	 
	public static HandlerList getHandlerList() {
	    return handlers;
	}

}