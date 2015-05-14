package com.starnetmc.core.modules;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.events.GamemodeChangeEvent;
import com.starnetmc.core.gamemode.GamemodeCommand;
import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;

public class Gamemode extends Module {

	public Gamemode(JavaPlugin plugin) {
		super("Gamemode Manager",1.0,ModuleType.SERVER,plugin);
	}
	
	public Gamemode() {
		
	}
	
	public void addCommands() {
		addCommand(new GamemodeCommand(this));
	}
	
	public static boolean isEnabled;
	
	public void enable() {
		isEnabled = true;
		log("Enabled.");
	}
	
	public void disable() {
		isEnabled = false;
		log("Disabled.");
	}
	
	@EventHandler
	public void onGMChange(GamemodeChangeEvent e) {
		
		Player player = e.getPlayer();
		
		if(isEnabled == false) {
			
			e.setCancelled(true);
			player.sendMessage(F.error("Gamemode", "You may not currently change gamemodes."));
		}
		else {
			return;
		}
		
	}
	
}
