package com.starnetmc.core.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.starnetmc.core.util.F;

public class Join implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public void onLogin(PlayerJoinEvent e) throws Exception {
		Player player = e.getPlayer();
		player.setMaxHealth(20D);
		player.setFoodLevel(20);
		player.setHealthScale(20D);
		player.setGameMode(GameMode.SURVIVAL);
		
		e.setJoinMessage(F.boldAqua + "<" + F.boldGreen + "+" + F.boldAqua + ">" + ChatColor.RESET + F.YELLOW + " " + player.getName());
	}

}