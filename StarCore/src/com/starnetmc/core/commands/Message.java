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

			if (!(sender instanceof Player)) {
				return true;
			}

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

			if (!(sender instanceof Player)) {
				return true;
			}

			Player player = (Player) sender;
			Player rtarget = conversation.get(player);

			if (args.length == 0) {
				player.sendMessage(F.error("Commands",
						"Try adding a message :)"));
				return true;
			}

			if (!conversation.containsKey(player)) {
				player.sendMessage(F.error("Message",
						"You have not messaged anyone recently."));
				return true;
			}

			if (!rtarget.isOnline()) {
				player.sendMessage(F.error("Message",
						"That player is no longer online."));
			}

			String message = "";
			
			for(int i = 0; i < args.length; i++) {
				
				message += " " + args[i];
				
			}
			message = message.substring(0);

			player.sendMessage(F.boldBlue + "You > " + rtarget.getName() + ": "
					+ F.GOLD + message);
			rtarget.sendMessage(F.boldBlue + player.getName() + " > You: "
					+ F.GOLD + message);
			rtarget.playSound(player.getLocation(), Sound.ITEM_PICKUP, 10, 1F);

		}
		return false;

	}

}
