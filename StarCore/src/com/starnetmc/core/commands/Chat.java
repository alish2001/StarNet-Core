package com.starnetmc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.starnetmc.core.Main;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class Chat implements CommandExecutor {

	public Chat(Main main) {
		// TODO Auto-generated constructor stub
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("chat")) {

			if (args.length == 0) {
				sender.sendMessage(F.error("Commands", "Not enough arguments!"));
				return true;
			}

			if (args.length != 2) {
				sender.sendMessage(F.error("Commands", "Not enough arguments!"));
				return true;
			}

			if (args[0].equalsIgnoreCase("clear")) {

				try {
					switch (Manager.getRank(p.getUniqueId().toString())) {

					case "ADMIN":
						if (args[1].equalsIgnoreCase("-a")) {
							clearChat();
							Bukkit.broadcastMessage(F.info("Chat",
									"The chat was cleared."));
						}

						else if (args[1].equalsIgnoreCase("-s")) {
							clearChat();
						}

						else if (args[1].equalsIgnoreCase("-n")) {
							clearChat();

							Bukkit.broadcastMessage(F.info("Chat",
									"The chat was cleared by "
											+ sender.getName().trim()));
						} else {
							p.sendMessage(F.error("Commands",
									"Argument not recognized. Try again :)"));
						}
						return false;
					case "YOUTUBE":

						if (args[1].equalsIgnoreCase("-a")) {
							clearChat();
							Bukkit.broadcastMessage(F.info("Chat",
									"The chat was cleared."));
						}

						else if (args[1].equalsIgnoreCase("-s")) {
							clearChat();
						}

						else if (args[1].equalsIgnoreCase("-n")) {
							clearChat();

							Bukkit.broadcastMessage(F.info("Chat",
									"The chat was cleared by "
											+ sender.getName().trim()));
						} else {
							p.sendMessage(F.error("Commands",
									"Argument not recognized. Try again :)"));
						}
						return false;
					case "OWNER":

						if (args[1].equalsIgnoreCase("-a")) {
							clearChat();
							Bukkit.broadcastMessage(F.info("Chat",
									"The chat was cleared."));
						}

						else if (args[1].equalsIgnoreCase("-s")) {
							clearChat();
						}

						else if (args[1].equalsIgnoreCase("-n")) {
							clearChat();

							Bukkit.broadcastMessage(F.info("Chat",
									"The chat was cleared by "
											+ sender.getName().trim()));
						} else {
							p.sendMessage(F.error("Commands",
									"Argument not recognized. Try again :)"));
						}
						return false;

					case "DEVELOPER":

						if (args[1].equalsIgnoreCase("-a")) {
							clearChat();
							Bukkit.broadcastMessage(F.info("Chat",
									"The chat was cleared."));
						}

						else if (args[1].equalsIgnoreCase("-s")) {
							clearChat();
						}

						else if (args[1].equalsIgnoreCase("-n")) {
							clearChat();

							Bukkit.broadcastMessage(F.info("Chat",
									"The chat was cleared by "
											+ sender.getName().trim()));
						} else {
							p.sendMessage(F.error("Commands",
									"Argument not recognized. Try again :)"));
						}
						return false;

					default:
						p.sendMessage(F.error("Permissions", "No permission!"));
						return true;

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		return false;
	}

	public void clearChat() {

		for (Player all : Bukkit.getOnlinePlayers()) {

			for (int i = 0; i < 150; i++) {
				all.sendMessage("   ");
			}

		}

	}
}
