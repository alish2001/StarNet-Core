package com.starnetmc.core.events;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ShardPickupEvent extends Event {

	private static HandlerList handlers = new HandlerList();
	Player player;
	Item item;
	
	public ShardPickupEvent(Player player, Item item) {
		
		this.player = player;
		this.item = item;
	}
	
	public Item getItem() {
		return item;
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