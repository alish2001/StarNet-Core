package com.starnetmc.core.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.starnetmc.core.commands.message.Message;
import com.starnetmc.core.util.F;

public class Quit implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public void onLeave(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		
		if(Message.conversation.containsKey(player)) {
			Message.conversation.remove(player);
		}
		
		e.setQuitMessage(F.boldAqua + "<" + F.boldRed + "-" + F.boldAqua + ">" + ChatColor.RESET + F.YELLOW + " " + player.getName());
	}

}