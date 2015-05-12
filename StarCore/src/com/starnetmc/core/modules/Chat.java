package com.starnetmc.core.modules;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;

public class Chat extends Module implements Listener {

	public Chat(JavaPlugin plugin) {
		super("Chat", 0.5, ModuleType.INFO, plugin);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void enable() {
		isEnabled = true;
		log("Enabled.");

	}

	@Override
	public void disable() {
		isEnabled = false;
		log("Disabled.");
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
