package com.starnetmc.core.modules;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;

public class Chat implements Module, Listener {

	private String name;
	private ModuleType mt;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}


	@Override
	public ModuleType getType(ModuleType mt) {
		// TODO Auto-generated method stub
		return this.mt;
	}

	@Override
	public double getVersion() {
		
		return 0.5;
		
	}
	

	@Override
	public void enable() {
		isEnabled = true;
		System.out.println("<Chat> "+getVersion()+" enabled.");

	}

	@Override
	public void disable() {
		isEnabled = false;
		System.out.println("<Chat> "+getVersion()+" disabled.");
	}

	public static boolean isEnabled;

	@EventHandler
	public void silence(AsyncPlayerChatEvent e) {
		
		if(isEnabled = true) {
			return;
		}
		if(isEnabled = false) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(F.error("Chat", "Chat is currently silenced."));
		}
		
	}

}
