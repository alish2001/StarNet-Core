package com.starnetmc.core.gadgets;

import org.bukkit.entity.Player;

public class Gadget {

	
	boolean fireworks;
	boolean eggs;
	boolean shard;
	Player player;
	
	
	public Gadget(Player player, boolean fireworks,boolean eggs, boolean shard) {
		
		this.player = player;
		this.fireworks = fireworks;
		this.eggs = eggs;
		this.shard = shard;
		
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
	
	public boolean isShardEnabled() {
		if(shard == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setShardEnabled(boolean endis) {
		
		shard = endis;
		
	}
			
	
	
}
