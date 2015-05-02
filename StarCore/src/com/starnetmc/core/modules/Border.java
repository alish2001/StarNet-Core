package com.starnetmc.core.modules;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;

public class Border implements Module, Listener {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "World Border";
	}

	

	@Override
	public ModuleType getType(ModuleType mt) {
		// TODO Auto-generated method stub
		return ModuleType.SERVER;
	}


	@Override
	public void enable() {
		setEnabled(true);
		System.out.println(getName()+" enabled.");

	}

	@Override
	public void disable() {
		setEnabled(false);
		System.out.println(getName()+" enabled.");

	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean setEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		return isEnabled() == arg0;
	}

	@EventHandler(priority = EventPriority.LOW)
	public void onCross(PlayerMoveEvent e) {

		
		
		Player player = e.getPlayer();
		Location _spawn = player.getWorld().getSpawnLocation();
		if (player.getLocation().distance(_spawn) > 150) {
			player.teleport(_spawn);

		} else {
			return;
		}

	}

}
