package com.starnetmc.core.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
					if (Manager.getRank(player.getUniqueId().toString()).equals(
							"DEFAULT")) {
						player.sendMessage(F.error("Permissions", "No permission!"));
						return true;
					}
					if (Manager.getRank(player.getUniqueId().toString()).equals(
							"JRMOD")) {
						player.sendMessage(F.error("Permissions", "No permission!"));
						return true;
					}
					if (Manager.getRank(player.getUniqueId().toString()).equals(
							"MODERATOR")) {
						player.sendMessage(F.error("Permissions", "No permission!"));
						return true;
					}
					if (Manager.getRank(player.getUniqueId().toString()).equals(
							"BUILDER")) {
						player.sendMessage(F.error("Permissions", "No permission!"));
						return true;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (afkplayer.contains(player.getName())) {
					afkplayer.remove(player.getName());
					player.setGameMode(GameMode.SURVIVAL);
					player.setPlayerListName(player.getDisplayName());
					Bukkit.broadcastMessage(ChatColor.GREEN + ""
							+ ChatColor.STRIKETHROUGH + "===" + ChatColor.YELLOW
							+ " " + player.getName() + ChatColor.AQUA
							+ " is no longer afk. " + ChatColor.GREEN + ""
							+ ChatColor.STRIKETHROUGH + "===");
				} else {
					afkplayer.add(player.getName());
					player.setGameMode(GameMode.SPECTATOR);
					player.setPlayerListName(F.GRAY + "AFK " + player.getName());
					Bukkit.broadcastMessage(ChatColor.GREEN + ""
							+ ChatColor.STRIKETHROUGH + "===" + ChatColor.YELLOW
							+ " " + player.getName() + ChatColor.AQUA
							+ " is now afk. " + ChatColor.GREEN + ""
							+ ChatColor.STRIKETHROUGH + "===");
					return true;
				}
			}
			return false;
		}

	}