package com.starnetmc.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class Time implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("t")) {

			if (!(sender instanceof Player)) {
				return true;
			}

			Player player = (Player) sender;

			if (args.length == 0) {
				try {
					switch (Manager.getRank(player.getUniqueId().toString())) {

					case "DEFAULT":
						player.sendMessage(F.error("Permissions",
								"No permission!"));
						return true;
					case "MVP":
						player.sendMessage(F.error("Permissions",
								"No permission!"));
						return true;
					case "MVPPLUS":
						player.sendMessage(F.error("Permissions",
								"No permission!"));
						return true;
					case "HELPER":
						player.sendMessage(F.error("Permissions",
								"No permission!"));
						return true;
					case "MODERATOR":
						player.sendMessage(F.error("Permissions",
								"No permission!"));
						return true;
					case "YOUTUBE":
						player.sendMessage(F.error("Permissions",
								"No permission!"));
						return true;
					case "BUILDER":
						player.sendMessage(F.error("Permissions",
								"No permission!"));
						return true;

					case "ADMIN":
						com.starnetmc.core.util.Time.openTimeGUI(player);
						return false;
					case "OWNER":
						com.starnetmc.core.util.Time.openTimeGUI(player);
						return false;
					case "DEVELOPER":
						com.starnetmc.core.util.Time.openTimeGUI(player);
						return false;
					default:
						player.sendMessage(F.error("Permissions",
								"No permission!"));
						return true;

					}
				} catch (Exception e) {
					e.printStackTrace();
					return true;
				}
			} else
				return true;

		}

		return false;

	}

}
