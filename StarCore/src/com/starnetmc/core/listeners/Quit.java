package com.starnetmc.core.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.starnetmc.core.commands.message.Message;
import com.starnetmc.core.modules.Settings;
import com.starnetmc.core.objects.OfflinePlayerCache;
import com.starnetmc.core.util.F;

public class Quit implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public void onLeave(PlayerQuitEvent e) {
		Player player = e.getPlayer();

		e.setQuitMessage(F.BLUE + "<" + F.RED + "-" + F.BLUE + "> " + F.GRAY
				+ player.getName());

		Settings.removeUser(player);
		OfflinePlayerCache.players.remove(player);
		if(OfflinePlayerCache.staff.contains(player.getName())) {
			OfflinePlayerCache.staff.remove(player.getName());
		}
		if(Message.conversation.containsKey(player)) {
			Message.conversation.remove(player);
		}
	}

}
