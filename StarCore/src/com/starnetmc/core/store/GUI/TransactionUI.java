package com.starnetmc.core.store.GUI;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class TransactionUI implements Listener {
	
	@EventHandler
	public void transactiate(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		
	}

}