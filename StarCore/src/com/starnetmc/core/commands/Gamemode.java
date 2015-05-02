package com.starnetmc.core.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.starnetmc.core.util.F;
import com.starnetmc.core.util.GamemodeUI;
import com.starnetmc.core.util.Manager;

public class Gamemode implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("gm")) {

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
					return true;
				case "MVP":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MVPPLUS":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "HELPER":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MODERATOR":
					GamemodeUI.openGMGUI(player);
					return false;
				case "ADMIN":
					GamemodeUI.openGMGUI(player);
					return false;
				case "BUILDER":
					GamemodeUI.openGMGUI(player);
					return false;
				case "DEVELOPER":
					GamemodeUI.openGMGUI(player);
					return false;
				case "OWNER":
					GamemodeUI.openGMGUI(player);
					return false;
				case "YOUTUBE":
					GamemodeUI.openGMGUI(player);
					return false;
				default:
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;

				}
			} catch (Exception e) {
				e.printStackTrace();
				return true;
			}

		}
		if (cmd.getName().equalsIgnoreCase("gms")) {

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
					return true;
				case "MVP":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MVPPLUS":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "HELPER":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MODERATOR":
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "ADMIN":
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "BUILDER":
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "DEVELOPER":
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "OWNER":
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "YOUTUBE":
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				default:
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;

				}
			} catch (Exception e) {
				e.printStackTrace();
				return true;
			}

		}
		if (cmd.getName().equalsIgnoreCase("gmc")) {

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
					return true;
				case "MVP":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MVPPLUS":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "HELPER":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MODERATOR":
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "ADMIN":
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "BUILDER":
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "DEVELOPER":
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "OWNER":
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "YOUTUBE":
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				default:
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;

				}
			} catch (Exception e) {
				e.printStackTrace();
				return true;
			}

		}
		if (cmd.getName().equalsIgnoreCase("gma")) {

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
					return true;
				case "MVP":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MVPPLUS":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "HELPER":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MODERATOR":
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "ADMIN":
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "BUILDER":
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "DEVELOPER":
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "OWNER":
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "YOUTUBE":
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				default:
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;

				}
			} catch (Exception e) {
				e.printStackTrace();
				return true;
			}

		}
		if (cmd.getName().equalsIgnoreCase("gmsp")) {

			if (!(sender instanceof Player)) {
				return true;
			}
			Player player = (Player) sender;

			
			try {
				switch (Manager.getRank(player.getUniqueId().toString())) {

				case "DEFAULT":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MVP":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MVPPLUS":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "HELPER":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MODERATOR":
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "ADMIN":
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "BUILDER":
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "DEVELOPER":
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "OWNER":
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				case "YOUTUBE":
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(F.info("Gamemode",
							"Your gamemode has been changed."));
					return false;
				default:
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;

				}
			} catch (Exception e) {
				e.printStackTrace();
				return true;
			}
			}
			
			
			
			

		

		return false;
	}

}
