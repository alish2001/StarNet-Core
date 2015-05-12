package com.starnetmc.core.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;
import com.starnetmc.core.util.StarMap;

public class Chat implements Listener {

	public static StarMap<String, String> _playerLastMessage = new StarMap<String, String>();

	@EventHandler(priority = EventPriority.LOW)
	public void listenToChat(AsyncPlayerChatEvent e) throws Exception {
		Player player = e.getPlayer();

		e.setFormat(player.getDisplayName() + F.GRAY + ": " + F.RESET
				+ e.getMessage());

		if(e.getMessage().contains("%s")) {
			e.setMessage(e.getMessage().replace("%s", "s"));
		}
		
		if (_playerLastMessage.containsKey(player.getName())
				&& _playerLastMessage.get(player.getName()).equalsIgnoreCase(
						e.getMessage())) {

			if (Manager.getRank(player.getUniqueId().toString())
					.equals("OWNER")) {
				return;
			} else {
				player.sendMessage(F.error("Chat",
						"You can't send the same message twice!"));
				e.setCancelled(true);
			}
		} else {
			_playerLastMessage.put(player.getName(), e.getMessage());
		}

	}

}
