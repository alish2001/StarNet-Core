package com.starnetmc.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.starnetmc.core.Main;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class BlockCommands implements Listener {

	@EventHandler
	public void blockStop(PlayerCommandPreprocessEvent e) throws Exception {


		if (e.getMessage().startsWith("/stop")) {

			e.setCancelled(true);
			
			for(Entity en : e.getPlayer().getWorld().getEntities()) {
				
				if(en instanceof LivingEntity) {
					if(en instanceof Player) {
						return;
					}
					else {
					en.remove();
					}
				}
				else {
					return;
				}
				
			}
			
			Bukkit.broadcastMessage(F.error("Server",
					"Server is going down for an update."));

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
				}
			});
			
		}
		if (e.getMessage().startsWith("/help")
				|| e.getMessage().startsWith("/?")) {

			e.setCancelled(true);
			Player player = e.getPlayer();
			switch (Manager.getRank(player.getUniqueId().toString())) {

			case "DEFAULT":
				player.sendMessage(F.strikeGreen + "=====");
				player.sendMessage(F.boldGold + "/spawn" + F.AQUA
						+ " - Teleports you to spawn.");
				player.sendMessage(F.boldGold + "/msg" + F.AQUA
						+ " - Allows you to message a player privately.");
				player.sendMessage(F.boldGold + "/settings" + F.AQUA
						+ " - Opens the settings menu.");
				player.sendMessage(F.strikeGreen + "=====");
				break;
			case "VIP":
				player.sendMessage(F.strikeGreen + "=====");
				player.sendMessage(F.boldGold + "/spawn" + F.AQUA
						+ " - Teleports you to spawn.");
				player.sendMessage(F.boldGold + "/msg" + F.AQUA
						+ " - Allows you to message a player privately.");
				player.sendMessage(F.boldGold + "/settings" + F.AQUA
						+ " - Opens the settings menu.");
				player.sendMessage(F.boldGold + "/test" + F.AQUA
						+ " - Does whatever Spark has put in it!");

				player.sendMessage(F.strikeGreen + "=====");
				break;
			case "MVP":

				player.sendMessage(F.strikeGreen + "=====");
				player.sendMessage(F.boldGold + "/spawn" + F.AQUA
						+ " - Teleports you to spawn.");
				player.sendMessage(F.boldGold + "/msg" + F.AQUA
						+ " - Allows you to message a player privately.");
				player.sendMessage(F.boldGold + "/settings" + F.AQUA
						+ " - Opens the settings menu.");
				player.sendMessage(F.boldGold + "/test" + F.AQUA
						+ " - Does whatever Spark has put in it!");

				player.sendMessage(F.strikeGreen + "=====");
				break;
			case "HELPER":
				player.sendMessage(F.strikeGreen + "=====");
				player.sendMessage(F.boldGold + "/help" + F.AQUA
						+ " - Shows this text.");
				player.sendMessage(F.boldGold + "/punish" + F.AQUA
						+ " - Opens the player punishment menu.");
				player.sendMessage(F.boldGold
						+ "/sc"
						+ F.AQUA
						+ " - Allows you to send a message to all online staff.");
				player.sendMessage(F.boldGold + "/spawn" + F.AQUA
						+ " - Teleports you to spawn.");
				player.sendMessage(F.boldGold + "/msg" + F.AQUA
						+ " - Allows you to message a player privately.");
				player.sendMessage(F.boldGold + "/settings" + F.AQUA
						+ " - Opens the settings menu.");
				player.sendMessage(F.boldGold + "/test" + F.AQUA
						+ " - Does whatever Spark has put in it!");

				player.sendMessage(F.strikeGreen + "=====");
				break;
			case "MODERATOR":
				player.sendMessage(F.strikeGreen + "=====");
				player.sendMessage(F.boldGold + "/help" + F.AQUA
						+ " - Shows this text.");
				player.sendMessage(F.boldGold + "/punish" + F.AQUA
						+ " - Opens the player punishment menu.");
				player.sendMessage(F.boldGold
						+ "/sc"
						+ F.AQUA
						+ " - Allows you to send a message to all online staff.");
				player.sendMessage(F.boldGold + "/b" + F.AQUA
						+ " - Broadcasts a message to the whole server!");
				player.sendMessage(F.boldGold + "/gm" + F.AQUA
						+ " - Opens the Gamemode Management menu.");
				player.sendMessage(F.boldGold + "/tp" + F.AQUA
						+ " - Allows for you to teleport players!");
				player.sendMessage(F.boldGold + "/spawn" + F.AQUA
						+ " - Teleports you to spawn.");
				player.sendMessage(F.boldGold + "/msg" + F.AQUA
						+ " - Allows you to message a player privately.");
				player.sendMessage(F.boldGold + "/settings" + F.AQUA
						+ " - Opens the settings menu.");
				player.sendMessage(F.boldGold + "/test" + F.AQUA
						+ " - Does whatever Spark has put in it!");

				player.sendMessage(F.strikeGreen + "=====");
				break;
			case "ADMIN":
				player.sendMessage(F.strikeGreen + "=====");
				player.sendMessage(F.boldGold + "/help" + F.AQUA
						+ " - Shows this text.");
				player.sendMessage(F.boldGold + "/punish" + F.AQUA
						+ " - Opens the player punishment menu.");
				player.sendMessage(F.boldGold
						+ "/sc"
						+ F.AQUA
						+ " - Allows you to send a message to all online staff.");
				player.sendMessage(F.boldGold + "/gm" + F.AQUA
						+ " - Opens the Gamemode Management menu.");
				player.sendMessage(F.boldGold + "/b" + F.AQUA
						+ " - Broadcasts a message to the whole server!");
				player.sendMessage(F.boldGold + "/tp" + F.AQUA
						+ " - Allows for you to teleport players!");
				player.sendMessage(F.boldGold + "/tpall" + F.AQUA
						+ " - Teleports all players to your location");
				player.sendMessage(F.boldGold + "/t" + F.AQUA
						+ " - Opens the Time Management menu.");
				player.sendMessage(F.boldGold
						+ "/afk"
						+ F.AQUA
						+ " - Allows you to set the \"Away From Keyboard\" status.");
				player.sendMessage(F.boldGold + "/spawn" + F.AQUA
						+ " - Teleports you to spawn.");
				player.sendMessage(F.boldGold + "/setspawn" + F.AQUA
						+ " - Allows for you to set the spawn location.");
				player.sendMessage(F.boldGold + "/msg" + F.AQUA
						+ " - Allows you to message a player privately.");
				player.sendMessage(F.boldGold + "/settings" + F.AQUA
						+ " - Opens the admin settings menu.");
				player.sendMessage(F.boldGold + "/test" + F.AQUA
						+ " - Does whatever Spark has put in it!");

				player.sendMessage(F.strikeGreen + "=====");
				break;
			case "OWNER":
				player.sendMessage(F.strikeGreen + "=====");
				player.sendMessage(F.boldGold + "/help" + F.AQUA
						+ " - Shows this text.");
				player.sendMessage(F.boldGold + "/punish" + F.AQUA
						+ " - Opens the player punishment menu.");
				player.sendMessage(F.boldGold + "/enable" + F.AQUA
						+ " - Enables a specific module.");
				player.sendMessage(F.boldGold + "/enable" + F.AQUA
						+ " - Disables a specific module.");
				player.sendMessage(F.boldGold + "/npc" + F.AQUA
						+ " - Allows you to create an NPC.");
				player.sendMessage(F.boldGold + "/chat <-n | -s | -a>" + F.AQUA
						+ " - Allows you to clear the chat.");
				player.sendMessage(F.boldGold
						+ "/sc"
						+ F.AQUA
						+ " - Allows you to send a message to all online staff.");
				player.sendMessage(F.boldGold + "/gm" + F.AQUA
						+ " - Opens the Gamemode Management menu.");
				player.sendMessage(F.boldGold + "/b" + F.AQUA
						+ " - Broadcasts a message to the whole server!");
				player.sendMessage(F.boldGold + "/tp" + F.AQUA
						+ " - Allows for you to teleport players!");
				player.sendMessage(F.boldGold + "/tpall" + F.AQUA
						+ " - Teleports all players to your location");
				player.sendMessage(F.boldGold + "/t" + F.AQUA
						+ " - Opens the Time Management menu.");
				player.sendMessage(F.boldGold
						+ "/afk"
						+ F.AQUA
						+ " - Allows you to set the \"Away From Keyboard\" status.");
				player.sendMessage(F.boldGold + "/spawn" + F.AQUA
						+ " - Teleports you to spawn.");
				player.sendMessage(F.boldGold + "/setspawn" + F.AQUA
						+ " - Allows for you to set the spawn location.");
				player.sendMessage(F.boldGold + "/msg" + F.AQUA
						+ " - Allows you to message a player privately.");
				player.sendMessage(F.boldGold + "/settings" + F.AQUA
						+ " - Opens the admin settings menu.");
				player.sendMessage(F.boldGold + "/test" + F.AQUA
						+ " - Does whatever Spark has put in it!");

				player.sendMessage(F.strikeGreen + "=====");
				break;
			case "DEVELOPER":
				player.sendMessage(F.strikeGreen + "=====");
				player.sendMessage(F.boldGold + "/help" + F.AQUA
						+ " - Shows this text.");
				player.sendMessage(F.boldGold + "/punish" + F.AQUA
						+ " - Opens the player punishment menu.");
				player.sendMessage(F.boldGold
						+ "/sc"
						+ F.AQUA
						+ " - Allows you to send a message to all online staff.");
				player.sendMessage(F.boldGold + "/gm" + F.AQUA
						+ " - Opens the Gamemode Management menu.");
				player.sendMessage(F.boldGold + "/b" + F.AQUA
						+ " - Broadcasts a message to the whole server!");
				player.sendMessage(F.boldGold + "/tp" + F.AQUA
						+ " - Allows for you to teleport players!");
				player.sendMessage(F.boldGold + "/tpall" + F.AQUA
						+ " - Teleports all players to your location");
				player.sendMessage(F.boldGold + "/t" + F.AQUA
						+ " - Opens the Time Management menu.");
				player.sendMessage(F.boldGold
						+ "/afk"
						+ F.AQUA
						+ " - Allows you to set the \"Away From Keyboard\" status.");
				player.sendMessage(F.boldGold + "/spawn" + F.AQUA
						+ " - Teleports you to spawn.");
				player.sendMessage(F.boldGold + "/setspawn" + F.AQUA
						+ " - Allows for you to set the spawn location.");
				player.sendMessage(F.boldGold + "/msg" + F.AQUA
						+ " - Allows you to message a player privately.");
				player.sendMessage(F.boldGold + "/settings" + F.AQUA
						+ " - Opens the admin settings menu.");
				player.sendMessage(F.boldGold + "/test" + F.AQUA
						+ " - Does whatever Spark has put in it!");

				player.sendMessage(F.strikeGreen + "=====");
				break;

			case "YOUTUBE":
				player.sendMessage(F.strikeGreen + "=====");
				player.sendMessage(F.boldGold + "/spawn" + F.AQUA
						+ " - Teleports you to spawn.");
				player.sendMessage(F.boldGold + "/msg" + F.AQUA
						+ " - Allows you to message a player privately.");
				player.sendMessage(F.boldGold + "/settings" + F.AQUA
						+ " - Opens the settings menu.");
				player.sendMessage(F.boldGold + "/gm" + F.AQUA
						+ " - Opens the Gamemode Management menu.");
				player.sendMessage(F.boldGold + "/test" + F.AQUA
						+ " - Does whatever Spark has put in it!");

				player.sendMessage(F.strikeGreen + "=====");
				break;

			case "BUILDER":
				player.sendMessage(F.strikeGreen + "=====");
				player.sendMessage(F.boldGold + "/spawn" + F.AQUA
						+ " - Teleports you to spawn.");
				player.sendMessage(F.boldGold + "/msg" + F.AQUA
						+ " - Allows you to message a player privately.");
				player.sendMessage(F.boldGold + "/settings" + F.AQUA
						+ " - Opens the admin settings menu.");
				player.sendMessage(F.boldGold + "/gm" + F.AQUA
						+ " - Opens the Gamemode Management menu.");
				player.sendMessage(F.boldGold + "/test" + F.AQUA
						+ " - Does whatever Spark has put in it!");

				player.sendMessage(F.strikeGreen + "=====");
				break;

			}

		}
		if(e.getMessage().startsWith("/me")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(F.error("Permissions", "Much deny permissions, so wow."));
		}

	}

}
