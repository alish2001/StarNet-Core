package com.starnetmc.core.util;

import org.bukkit.entity.Player;

public class Gadget {

	
	boolean fireworks;
	boolean eggs;
	Player player;
	
	
	public Gadget(Player player, boolean fireworks,boolean eggs) {
		
		this.player = player;
		this.fireworks = fireworks;
		this.eggs = eggs;
		
	}
	
	
	public Player getPlayer() {
		return player;
	}
	
	public boolean fireworksEnabled() {
		
		if(fireworks == true) {
			return true;
		}
		
		if(fireworks == false) {
			return false;
		}
		
		return false;
		
	}
	
	public void setFWEnabled(boolean endis) {
		
		fireworks = endis;
		
	}
	
	public boolean eggsEnabled() {
		
		if(eggs == true) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void setEggsEnabled(boolean endis) {
		
		eggs = endis;
		
	}
			
	
	
}
