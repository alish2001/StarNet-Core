package com.starnetmc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class Broadcast implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("a")) {
			if (!(sender instanceof Player)) {
				String annc = "";
				for (String arg : args)
					annc = annc + arg + " ";

				if (annc.length() > 0) {
					annc = annc.substring(0, annc.length() - 1);
				}
				Bukkit.broadcastMessage(F.info("Server", annc));
			}

			if (sender instanceof Player) {

				Player player = (Player) sender;

				try {
					switch (Manager.getRank(player.getUniqueId().toString())) {

					case "DEFAULT":
						player.sendMessage(F.error("Permissions",
								"No permission!"));
						return true;
					case "VIP":
						player.sendMessage(F.error("Permissions",
								"No permission!"));
						return true;
					case "MVP":
						player.sendMessage(F.error("Permissions",
								"No permission!"));
						return true;
					case "HELPER":
						player.sendMessage(F.error("Permissions",
								"No permission!"));
						return true;

					default:

						if (args.length < 1) {
							player.sendMessage(F.error("Commands",
									"Not enough arguments!"));
							return true;

						} else {
							String annc = "";
							for (String arg : args)
								annc = annc + arg + " ";

							if (annc.length() > 0) {
								annc = annc.substring(0, annc.length() - 1);
							}
							Bukkit.broadcastMessage(F.BOLD + player.getName()
									+ " - " + F.boldAqua + annc);

							for (Player all : Bukkit.getOnlinePlayers()) {
								all.playSound(all.getLocation(),
										Sound.NOTE_PLING, 8F, 1F);
							}
						}
						return false;

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		return false;
	}

}
