package com.starnetmc.core.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.starnetmc.core.modules.manager.Module;
import com.starnetmc.core.modules.manager.ModuleType;

public class ModuleStateChangeEvent extends Event {

	private static HandlerList handlers = new HandlerList();
	private Module module;
	private ModuleType mt;

	public ModuleStateChangeEvent(Module module, String name, ModuleType mt) {
		this.module = module;
		this.mt = mt;

	}

	public ModuleStateChangeEvent(Module module, ModuleType mt) {
		this.module = module;
		this.mt = mt;

	}
	
	public ModuleStateChangeEvent(){
		
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public Module getModule() {
		return module;
	}

	public ModuleType getModuleType() {
		return mt;
	}


}