package com.starnetmc.core.modules;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;

public class DoubleJump implements Module, Listener {

	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
		Player player = event.getPlayer();
		if (player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE) {
			player.setFlying(false);
			Location loc = player.getLocation().clone();
			loc.setPitch(0.0F);
			Vector vel = player.getVelocity().clone();

			int strength = 5;

			Vector jump = vel.multiply(0.1D).setY(0.20D * strength);
			Vector look = loc.getDirection().normalize().multiply(1.5D);

			player.setVelocity(jump.add(look));
			player.playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
			player.setAllowFlight(false);

			event.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (player.getGameMode() == GameMode.SURVIVAL) {
			if (!player.getAllowFlight()) {
				Location loc = player.getLocation();
				Block block = loc.getBlock().getRelative(BlockFace.DOWN);
				if (block.getType() != Material.AIR) {
					player.setAllowFlight(true);
				}
			}
		}
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Double Jump";
	}

	@Override
	public ModuleType getType(ModuleType mt) {
		// TODO Auto-generated method stub
		return ModuleType.SERVER;
	}

	@Override
	public double getVersion() {
		// TODO Auto-generated method stub
		return 0.1;
	}

	@Override
	public void enable() {
		setEnabled(true);
		System.out.println("<Double Jump> version "+getVersion()+" enabled.");
		
	}

	@Override
	public void disable() {

		setEnabled(false);
		System.out.println("<Double Jump> version "+getVersion()+ " disabled.");
		
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

}
