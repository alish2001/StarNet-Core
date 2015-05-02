package com.starnetmc.core.util;

import org.bukkit.entity.Player;

public class Gadget {

	
	boolean fireworks;
	Player player;
	
	
	public Gadget(Player player, boolean fireworks) {
		
		this.player = player;
		this.fireworks = fireworks;
		
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
			
	
	
}
