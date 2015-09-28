package com.starnetmc.core.serversorter.GUI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import com.starnetmc.core.Main;

public class ServerGUI implements Listener {
	
	protected Inventory gui;
	
	public ServerGUI(){
		this.gui = Bukkit.getServer().createInventory(null, 54);
	}
	
	public ServerGUI(String inventoryName, int inventorySize){
		this.gui = Bukkit.getServer().createInventory(null, inventorySize, inventoryName);
	}
	
	public ServerGUI(int inventorySize){
		this.gui = Bukkit.getServer().createInventory(null, inventorySize);
	}
	
	public void register(){
		Bukkit.getServer().getPluginManager().registerEvents(this, Main.getPlugin());
	}
	
	public void unRegister(){
		HandlerList.unregisterAll(this);
	}
	
	public void open(Player p){
		refresh();
		p.openInventory(gui);
	}
	
	public void refresh(){
		
	}
	
	public Inventory getInventory(){
		return gui;
	}

}