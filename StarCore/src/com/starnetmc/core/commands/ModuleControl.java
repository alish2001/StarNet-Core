package com.starnetmc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.starnetmc.core.Main;
import com.starnetmc.core.events.ModuleStateChangeEvent;
import com.starnetmc.core.modules.Border;
import com.starnetmc.core.modules.ChatFilter;
import com.starnetmc.core.modules.DoubleJump;
import com.starnetmc.core.modules.Gadgets;
import com.starnetmc.core.modules.LScoreboard;
import com.starnetmc.core.modules.News;
import com.starnetmc.core.modules.Settings;
import com.starnetmc.core.modules.Tutorial;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class ModuleControl implements CommandExecutor {

	Border border = new Border(Main.getPlugin());
	ChatFilter cf = new ChatFilter(Main.getPlugin());
	DoubleJump dj = new DoubleJump(Main.getPlugin());
	Gadgets gadgets = new Gadgets(Main.getPlugin());
	LScoreboard sc = new LScoreboard(Main.getPlugin());
	News news = new News(Main.getPlugin());
	com.starnetmc.core.modules.Settings set = new com.starnetmc.core.modules.Settings(Main.getPlugin());
	Tutorial tut = new Tutorial(Main.getPlugin());
	com.starnetmc.core.modules.Chat c = new com.starnetmc.core.modules.Chat(Main.getPlugin());

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (!(sender instanceof Player)) {
			return true;
		}

		Player player = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("enable")) {

			try {
				if (!Manager.getRank(player.getUniqueId().toString()).equals(
						"OWNER")) {
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				} else {
					Bukkit.getServer().getPluginManager().callEvent(new ModuleStateChangeEvent());

					if (args.length == 0) {
						player.sendMessage(F.error("Commands",
								"Not enough arguments!"));
						return true;
					}
					if (args.length > 1) {
						player.sendMessage(F.error("Commands",
								"Too many arguments!"));
						return true;
					}

					String module = args[0];
					switch (module) {
					case "filter":
						if (ChatFilter.isEnabled == false) {
							cf.enable();
							Bukkit.broadcastMessage(F.BOLD + "<SERVER> "
									+ F.boldGreen
									+ "The CHAT FILTER has been enabled by "
									+ player.getName());
						} else {
							player.sendMessage(F.error("Modules",
									"That module is already enabled."));
							return true;
						}

						return false;
						
					case "chat":
						if (com.starnetmc.core.modules.Chat.isEnabled == true) {
							c.enable();
							Bukkit.broadcastMessage(F.BOLD + "<SERVER> "
									+ F.boldRed
									+ "CHAT has been enabled by "
									+ player.getName());
						} else {
							player.sendMessage(F.error("Modules",
									"That module is already enabled."));
							return true;
						}

						return false;
						

					case "doublejump":
						if (DoubleJump.isEnabled == false) {
							dj.enable();
							Bukkit.broadcastMessage(F.BOLD + "<SERVER> "
									+ F.boldGreen
									+ "DOUBLE JUMP has been enabled by "
									+ player.getName());
						} else {
							player.sendMessage(F.error("Modules",
									"That module is already enabled."));
							return true;
						}
						return false;
					case "scoreboard":
						if (LScoreboard.isEnabled == false) {
							sc.enable();
							Bukkit.broadcastMessage(F.BOLD
									+ "<SERVER> "
									+ F.boldGreen
									+ "The SCOREBOARD has been enabled by "
									+ player.getName());
						} else {
							player.sendMessage(F.error("Modules",
									"That module is already enabled."));
							return true;
						}
						return false;
					case "news":
						if (News.isEnabled == false) {
							news.enable();
							Bukkit.broadcastMessage(F.BOLD + "<SERVER> "
									+ F.boldGreen
									+ "The NEWS MODULE has been enabled by "
									+ player.getName());
						} else {
							player.sendMessage(F.error("Modules",
									"That module is already enabled."));
							return true;
						}
						return false;
					case "settings":
						if (Settings.isEnabled == false) {
							set.enable();
							Bukkit.broadcastMessage(F.BOLD + "<SERVER> "
									+ F.boldGreen
									+ "SETTINGS have been enabled by "
									+ player.getName());
						} else {
							player.sendMessage(F.error("Modules",
									"That module is already enabled."));
							return true;
						}
						return false;
					case "gadgets":
						if (Gadgets.isEnabled == false) {
							gadgets.enable();
							Bukkit.broadcastMessage(F.BOLD + "<SERVER> "
									+ F.boldGreen
									+ "GADGETS have been enabled by "
									+ player.getName());
						} else {
							player.sendMessage(F.error("Modules",
									"That module is already enabled."));
							return true;
						}
						return false;
					default:
						player.sendMessage(F.error("Modules",
								"Modules not recognized."));
						return true;
					}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (cmd.getName().equalsIgnoreCase("disable")) {

			try {
				if (!Manager.getRank(player.getUniqueId().toString()).equals(
						"OWNER")) {
					player.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				} else {

					if (args.length == 0) {
						player.sendMessage(F.error("Commands",
								"Not enough arguments!"));
						return true;
					}
					if (args.length > 1) {
						player.sendMessage(F.error("Commands",
								"Too many arguments!"));
						return true;
					}

					String module = args[0];
					switch (module) {
					case "filter":
						if (ChatFilter.isEnabled == true) {
							cf.disable();
							Bukkit.broadcastMessage(F.BOLD + "<SERVER> "
									+ F.boldRed
									+ "The CHAT FILTER has been disabled by "
									+ player.getName());
						} else {
							player.sendMessage(F.error("Modules",
									"That module is already disabled."));
							return true;
						}

						return false;
						case "chat":
							if (com.starnetmc.core.modules.Chat.isEnabled == true) {
								c.disable();
								Bukkit.broadcastMessage(F.BOLD + "<SERVER> "
										+ F.boldRed
										+ "CHAT has been disabled by "
										+ player.getName());
							} else {
								player.sendMessage(F.error("Modules",
										"That module is already disabled."));
								return true;
							}

							return false;

					case "doublejump":
						if (DoubleJump.isEnabled == true) {
							dj.disable();
							Bukkit.broadcastMessage(F.BOLD + "<SERVER> "
									+ F.boldRed
									+ "DOUBLE JUMP has been disabled by "
									+ player.getName());
						} else {
							player.sendMessage(F.error("Modules",
									"That module is already disabled."));
							return true;
						}
						return false;
					case "scoreboard":
						if (LScoreboard.isEnabled == true) {
							sc.disable();
							Bukkit.broadcastMessage(F.BOLD
									+ "<SERVER> "
									+ F.boldRed
									+ "The SCOREBOARD has been disabled by "
									+ player.getName());
						} else {
							player.sendMessage(F.error("Modules",
									"That module is already disabled."));
							return true;
						}
						return false;
					case "news":
						if (News.isEnabled == true) {
							news.disable();
							Bukkit.broadcastMessage(F.BOLD + "<SERVER> "
									+ F.boldRed
									+ "The NEWS module has been disabled by "
									+ player.getName());
						} else {
							player.sendMessage(F.error("Modules",
									"That module is already disabled."));
							return true;
						}
						return false;
					case "settings":
						if (Settings.isEnabled == true) {
							set.disable();
							Bukkit.broadcastMessage(F.BOLD + "<SERVER> "
									+ F.boldRed
									+ "SETTINGS have been disabled by "
									+ player.getName());
						} else {
							player.sendMessage(F.error("Modules",
									"That module is already disabled."));
							return true;
						}
						return false;
					case "gadgets":
						if (Gadgets.isEnabled == true) {
							gadgets.disable();
							Bukkit.broadcastMessage(F.BOLD + "<SERVER> "
									+ F.boldRed
									+ "GADGETS have been disabled by "
									+ player.getName());
						} else {
							player.sendMessage(F.error("Modules",
									"That module is already disabled."));
							return true;
						}
						return false;
					default:
						player.sendMessage(F.error("Modules",
								"Module not recognized."));
						return true;

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
