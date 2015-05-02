package com.starnetmc.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.starnetmc.core.Main;
import com.starnetmc.core.util.F;

public class BlockCommands implements Listener {

	@EventHandler
	public void blockStop(PlayerCommandPreprocessEvent e) {

		if (!e.getPlayer().isOp())
			return;

		if (e.getMessage().startsWith("/stop")) {

			e.setCancelled(true);
			Bukkit.broadcastMessage(F.error("Server", "Server is going down for an update."));
			for (Player player : Bukkit.getOnlinePlayers()) {

				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("connect");
				out.writeUTF("Hub");
				player.sendPluginMessage(Main.getPlugin(), "BungeeCord",
						out.toByteArray());
			}
			
			new BukkitRunnable() {
				
				@Override
				public void run() {
					Bukkit.shutdown();
					
				}
			}.runTaskLater(Main.getPlugin(), 60L);
		}

	}

}
