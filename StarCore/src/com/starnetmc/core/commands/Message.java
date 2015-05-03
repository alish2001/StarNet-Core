package com.starnetmc.core.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.starnetmc.core.util.F;

public class Message implements CommandExecutor {

	public static HashMap<Player, Player> conversation = new HashMap<Player, Player>();

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (!(sender instanceof Player))
			return true;

		Player target = Bukkit.getPlayer(args[0]);

		if (cmd.getName().equalsIgnoreCase("message")) {


			if (args.length < 2) {

				sender.sendMessage(F.error("Commands", "Not enough arguments!"));
				sender.sendMessage(ChatColor.RED
						+ "Try /msg <player> <your message>");

				return true;
			}

			Player player = (Player) sender;

			String msg = "";

			for (int i = 1; i < args.length; i++) {
				msg += " " + args[i];
			}
			msg = msg.substring(1);

			player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "You > "
					+ target.getName() + ": " + ChatColor.GOLD + msg);
			target.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD
					+ player.getName() + " > You" + ": " + ChatColor.GOLD + msg);
			target.playSound(player.getLocation(), Sound.ITEM_PICKUP, 10, 1F);
			conversation.put(player, target);

		}

		if (cmd.getName().equalsIgnoreCase("reply")) {

			Player player = (Player) sender;
			Player target1 = conversation.get(target);
			String msg = "";
			for (String arg : args)
				msg = msg + arg + " ";

			if (msg.length() > 0) {
				msg = msg.substring(0, msg.length() - 1);
			}

			if (args.length == 0) {
				player.sendMessage(F.error("Commands", "Not enough arguments!"));
				return true;
			}

			if (!conversation.containsKey(player)) {
				player.sendMessage(F.error("Message",
						"You have not replied to anyone recently."));
				return true;
			}

			if (!target1.isOnline()) {
				player.sendMessage(F.error("Message",
						"That player is no longer online."));
				return true;
			}

			player.sendMessage(F.boldBlue + "You > " + target1.getName() + ": "
					+ F.GOLD + msg);
			player.sendMessage(F.boldBlue + player.getName() + " > You" + ": "
					+ F.GOLD + msg);
			target1.playSound(target1.getLocation(), Sound.ITEM_PICKUP, 10, 1F);

		}
		return false;

	}

}
