package com.starnetmc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class Teleport implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("teleport")) {

			
			
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command is only player executable!");
				return true;
			}
			Player player = (Player) sender;
			String uuid = player.getUniqueId().toString();

			if (args.length == 0) {
				sender.sendMessage(F.error("Commands", "Not enough arguments!"));
				return true;
			}
			
			Player teleportee = Bukkit.getPlayer(args[0]);

			

			try {
				switch (Manager.getRank(uuid)) {

				case "DEFAULT":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;

				case "HELPER":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;

				case "NULL":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;

				case "YOUTUBE":
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;

				case "MODERATOR":
					if (args[0].equalsIgnoreCase(player.getName())
							&& args.length == 1) {
						player.sendMessage(F.error("Mirror",
								"You can't teleport to yourself!"));
						return true;
					}
					if (args.length == 1) {
						player.teleport(teleportee.getLocation());
						player.sendMessage(F.info("Teleport",
								"You have teleported to: " + F.GOLD
										+ teleportee.getName()));
						return false;
					} else if (args.length == 2) {
						Player teleport1 = Bukkit.getPlayer(args[1]);
						teleportee.teleport(teleport1.getLocation());
						player.sendMessage(F
								.info("Teleport",
										"You have teleported " + F.GOLD
												+ teleportee.getName()
												+ F.GREEN + " to " + F.GOLD
												+ teleport1.getName()));
						return false;
					}
					return false;
				case "DEVELOPER":
					if (args[0].equalsIgnoreCase(player.getName())
							&& args.length == 1) {
						player.sendMessage(F.error("Mirror",
								"You can't teleport to yourself!"));
						return true;
					}
					if (args.length == 1) {
						player.teleport(teleportee.getLocation());
						player.sendMessage(F.info("Teleport",
								"You have teleported to: " + F.GOLD
										+ teleportee.getName()));
						return false;
					} else if (args.length == 2) {
						Player teleport1 = Bukkit.getPlayer(args[1]);
						teleportee.teleport(teleport1.getLocation());
						player.sendMessage(F
								.info("Teleport",
										"You have teleported " + F.GOLD
												+ teleportee.getName()
												+ F.GREEN + " to " + F.GOLD
												+ teleport1.getName()));
						return false;
					}
					return false;
				case "BUILDER":
					if (args[0].equalsIgnoreCase(player.getName())
							&& args.length == 1) {
						player.sendMessage(F.error("Mirror",
								"You can't teleport to yourself!"));
						return true;
					}
					if (args.length == 1) {
						player.teleport(teleportee.getLocation());
						player.sendMessage(F.info("Teleport",
								"You have teleported to: " + F.GOLD
										+ teleportee.getName()));
						return false;
					} else if (args.length == 2) {
						Player teleport1 = Bukkit.getPlayer(args[1]);
						teleportee.teleport(teleport1.getLocation());
						player.sendMessage(F
								.info("Teleport",
										"You have teleported " + F.GOLD
												+ teleportee.getName()
												+ F.GREEN + " to " + F.GOLD
												+ teleport1.getName()));
						return false;
					}
					return false;
				case "ADMIN":
					if (args[0].equalsIgnoreCase(player.getName())
							&& args.length == 1) {
						player.sendMessage(F.error("Mirror",
								"You can't teleport to yourself!"));
						return true;
					}
					if (args.length == 1) {
						player.teleport(teleportee.getLocation());
						player.sendMessage(F.info("Teleport",
								"You have teleported to: " + F.GOLD
										+ teleportee.getName()));
						return false;
					} else if (args.length == 2) {
						Player teleport1 = Bukkit.getPlayer(args[1]);
						teleportee.teleport(teleport1.getLocation());
						player.sendMessage(F
								.info("Teleport",
										"You have teleported " + F.GOLD
												+ teleportee.getName()
												+ F.GREEN + " to " + F.GOLD
												+ teleport1.getName()));
						return false;
					}
					return false;
				case "OWNER":
					if (args[0].equalsIgnoreCase(player.getName())
							&& args.length == 1) {
						player.sendMessage(F.error("Mirror",
								"You can't teleport to yourself!"));
						return true;
					}
					if (args.length == 1) {
						player.teleport(teleportee.getLocation());
						player.sendMessage(F.info("Teleport",
								"You have teleported to: " + F.GOLD
										+ teleportee.getName()));
						return false;
					} else if (args.length == 2) {
						Player teleport1 = Bukkit.getPlayer(args[1]);
						teleportee.teleport(teleport1.getLocation());
						player.sendMessage(F
								.info("Teleport",
										"You have teleported " + F.GOLD
												+ teleportee.getName()
												+ F.GREEN + " to " + F.GOLD
												+ teleport1.getName()));
						return false;
					}
					return false;

				}
			} catch (Exception e) {
				System.err.println("An error occured: " + e.getCause());
			}

		}
		if (cmd.getName().equalsIgnoreCase("tpall")) {

			if (!(sender instanceof Player)) {
				return true;
			}

			Player player = (Player) sender;

			if (args.length > 0) {
				player.sendMessage(F.error("Commands", "Too many arguments!"));
			}

			String uuid = player.getUniqueId().toString();

			try {
				if (!Manager.getRank(uuid).equals("OWNER")) {
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				} else if (Manager.getRank(uuid).equals("DEVELOPER")) {
					player.sendMessage(F.error("Permissions", "No permission!"));
				} else {
					player.sendMessage(F.info("Teleport",
							"Teleporting all players..."));
					for (Player all : Bukkit.getOnlinePlayers()) {

						all.teleport(player.getLocation());
						
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return false;
	}

}
