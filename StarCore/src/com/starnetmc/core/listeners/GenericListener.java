package com.starnetmc.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import com.starnetmc.core.events.ShardPickupEvent;

public class GenericListener implements Listener{

	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		e.setCancelled(true);
		
		if(e.getItem().getItemStack().getType() == Material.NETHER_STAR) {
			
			Bukkit.getServer().getPluginManager().callEvent(new ShardPickupEvent(e.getPlayer(), e.getItem()));
			
		}
		
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		e.getEntity().setHealth(20.0D);
	}
	
	@EventHandler
	public void onCompleteTab(PlayerChatTabCompleteEvent e) {
		e.getTabCompletions().clear();
	}
	
	
	
}
