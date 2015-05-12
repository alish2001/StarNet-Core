package com.starnetmc.core.modules;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;

public class Border extends Module {

	public Border(JavaPlugin plugin) {
		super("World Border",1.0,ModuleType.SERVER,plugin);
	}
	

	@Override
	public void enable() {
		isEnabled = true;
		log("enabled.");
	}

	@Override
	public void disable() {
		isEnabled = false;
		log("disabled.");

	}

	public static boolean isEnabled;

	

	@EventHandler(priority = EventPriority.LOW)
	public void onCross(PlayerMoveEvent e) {

		if(isEnabled = true) {
		
		Player player = e.getPlayer();
		Location _spawn = player.getWorld().getSpawnLocation();
		if (player.getLocation().distance(_spawn) > 150) {
			player.teleport(_spawn);

		} else {
			return;
		}

		}
		else {
			return;
		}
	}

}
