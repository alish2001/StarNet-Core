package com.starnetmc.core.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class AFK implements CommandExecutor {

	private static List<String> afkplayer = new ArrayList<String>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("afk")) {

			if (!(sender instanceof Player))
				return true;

			Player player = (Player) sender;

			try {
				switch (Manager.getRank(player.getUniqueId().toString())) {

				case "DEFAULT":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;

				case "VIP":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MVP":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "HELPER":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MODERATOR":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;

				default:
					if (afkplayer.contains(player.getName())) {
						afkplayer.remove(player.getName());
						player.setGameMode(GameMode.SURVIVAL);
						player.setPlayerListName(player.getDisplayName());

					} else {
						afkplayer.add(player.getName());
						player.setGameMode(GameMode.SPECTATOR);
						player.setPlayerListName(F.GRAY + "AFK "
								+ player.getName());

						return true;
					}
					return false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}

}