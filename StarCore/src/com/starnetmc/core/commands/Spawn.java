package com.starnetmc.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.starnetmc.core.modules.Tutorial;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class Spawn implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("spawn")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;

				if (args.length != 0) {
					player.sendMessage(F.error("Commands",
							"Too many arguments!"));
					return true;
				}

				if(Tutorial.intut.contains(player.getName())) {
					return true;
				}
				
				player.teleport(player.getWorld().getSpawnLocation());
				player.sendMessage(F.info("World",
						"You were teleported to spawn."));

			} else {
				return true;
			}
		}

		if (cmd.getName().equalsIgnoreCase("setspawn")) {

			if (!(sender instanceof Player)) {
				return true;
			}

			Player player = (Player) sender;
			if (args.length != 0) {
				player.sendMessage(F.error("Commands", "Too many arguments!"));
				return true;
			}

			try {

				switch (Manager.getRank(player.getUniqueId().toString())) {

				case "DEFAULT":
					player.sendMessage(F.error("Permissions", "No permission!"));
					break;

				case "MVP":
					player.sendMessage(F.error("Permissions", "No permission!"));
					break;
				case "VIP":
					player.sendMessage(F.error("Permissions", "No permission!"));
					break;
				case "HELPER":
					player.sendMessage(F.error("Permissions", "No permission!"));
					break;
				case "MODERATOR":
					player.sendMessage(F.error("Permissions", "No permission!"));
					break;
				case "YOUTUBE":
					player.sendMessage(F.error("Permissions", "No permission!"));
					break;
				case "ADMIN":
					player.getWorld().setSpawnLocation(
							player.getLocation().getBlockX(),
							(player.getLocation().getBlockY() + 2),
							player.getLocation().getBlockZ());
					player.sendMessage(F.info("World", "Spawn updated."));
					break;

				case "DEVELOPER":
					player.getWorld().setSpawnLocation(
							player.getLocation().getBlockX(),
							(player.getLocation().getBlockY() + 2),
							player.getLocation().getBlockZ());
					player.sendMessage(F.info("World", "Spawn updated."));
					break;
				case "OWNER":
					player.getWorld().setSpawnLocation(
							player.getLocation().getBlockX(),
							(player.getLocation().getBlockY() + 2),
							player.getLocation().getBlockZ());
					player.sendMessage(F.info("World", "Spawn updated."));
					break;

				case "BUILDER":
					player.getWorld().setSpawnLocation(
							player.getLocation().getBlockX(),
							(player.getLocation().getBlockY() + 2),
							player.getLocation().getBlockZ());
					player.sendMessage(F.info("World", "Spawn updated."));
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return false;
		}
		return false;
	}
}
