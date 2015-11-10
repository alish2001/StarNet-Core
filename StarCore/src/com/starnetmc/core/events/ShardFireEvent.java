package com.starnetmc.core.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ShardFireEvent extends Event {

	private static HandlerList handlers = new HandlerList();
	
	Player player;
	
	public ShardFireEvent(Player player) {
		this.player = player;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	public Player getPlayer() {
		
		return player;
	}
	
}