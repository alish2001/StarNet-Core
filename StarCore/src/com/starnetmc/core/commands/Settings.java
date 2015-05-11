package com.starnetmc.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.starnetmc.core.Main;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;
import com.starnetmc.core.util.SettingsGUI;

public class Settings implements CommandExecutor {

	public Settings(Main main) {
		// TODO Auto-generated constructor stub
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("settings")) {

			if (args.length != 0) {
				sender.sendMessage(F.error("Commands", "Too many arguments!"));
			}
			if (!(sender instanceof Player)) {
				sender.sendMessage(F.error("Commands",
						"This command is only player-executable!"));

			}
			Player player = (Player) sender;
			if (com.starnetmc.core.modules.Settings.isEnabled == false) {
				player.sendMessage(F.error("Modules",
						"Settings have been disabled by an owner."));
				return true;
			} else {

				try {

					switch (Manager.getRank(player.getUniqueId().toString())) {

					case "DEFAULT":
						SettingsGUI.openSettingsGUI(player);
						break;
					case "MVP":
						SettingsGUI.openSettingsGUI(player);
						break;
					case "VIP":
						SettingsGUI.openSettingsGUI(player);
						break;
					case "HELPER":
						SettingsGUI.openSettingsGUI(player);
						break;
					case "MODERATOR":
						SettingsGUI.openSettingsGUI(player);
						break;
					case "YOUTUBE":
						SettingsGUI.openSettingsGUI(player);
						break;
					case "BUILDER":
						SettingsGUI.openSettingsAGUI(player);
						break;
					case "ADMIN":
						SettingsGUI.openSettingsAGUI(player);
						break;
					case "OWNER":
						SettingsGUI.openSettingsAGUI(player);
						break;
					case "DEVELOPER":
						SettingsGUI.openSettingsAGUI(player);
						break;

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
