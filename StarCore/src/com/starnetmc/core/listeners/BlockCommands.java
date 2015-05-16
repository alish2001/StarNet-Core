package com.starnetmc.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

import com.starnetmc.core.commands.HelpCommand;
import com.starnetmc.core.util.F;

public class BlockCommands implements Listener {

	@EventHandler(priority = EventPriority.HIGH)
	public void blockCommands(PlayerCommandPreprocessEvent e) throws Exception {

		if ((!e.isCancelled())) {
			String command = e.getMessage().split(" ")[0];
			HelpTopic htopic = Bukkit.getServer().getHelpMap()
					.getHelpTopic(command);
			if (htopic == null) {
				
				e.setCancelled(true);
			}
		}

		if (e.getMessage().startsWith("/stop")) {

			e.setCancelled(true);
			Bukkit.broadcastMessage(F.error("Server",
					"Server is going down for an update."));
			try {
				for (Entity en : e.getPlayer().getWorld().getEntities()) {

					if (en instanceof Player) {
						return;
					}

					en.remove();

				}
			} finally {
				Bukkit.getServer().shutdown();
			}

		}

		if (e.getMessage().startsWith("/me")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(
					F.error("Permissions", "Much deny permissions, so wow."));
		}

		if (e.getMessage().startsWith("/help")
				|| e.getMessage().startsWith("/?")) {
			e.setCancelled(true);
			HelpCommand.sendHelp(e.getPlayer());
		}

	}

}
