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


		if (cmd.getName().equalsIgnoreCase("message")) {

			if (args.length == 0 || args.length < 1) {

				sender.sendMessage(F.error("Commands", "Not enough arguments!"));
				return true;

			}

			if (!(sender instanceof Player)) {
				return true;
			}

			Player player = (Player) sender;

			Player target = Bukkit.getPlayer(args[0]);

			if (args.length > 1) {

				String msg = "";
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i < args.length; i++) {
					sb.append(args[i]+" ");
				}
				msg = sb.toString();
				
				if(target == null) {
					player.sendMessage(F.error("Player Search", "That player is not online."));
					return true;
				}
				
				if(!target.isOnline()) {
					player.sendMessage(F.error("Player Search", "That player is not online."));
					return true;
				}
				

				player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD
						+ "You > " + target.getName() + ": " + ChatColor.GOLD
						+ msg);
				target.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD
						+ player.getName() + " > You" + ": " + ChatColor.GOLD
						+ msg);
				target.playSound(player.getLocation(), Sound.LEVEL_UP, 10F, 0F);
				conversation.put(player, target);
				return false;
			}
			player.sendMessage(F.error("Commands", "Not enough arguments!"));
		}

		if (cmd.getName().equalsIgnoreCase("reply")) {

			if (args.length == 0 || args.length < 1) {

				sender.sendMessage(F.error("Commands", "Not enough arguments!"));
				return true;

			}

			if (!(sender instanceof Player)) {
				return true;
			}

			Player player = (Player) sender;
			Player rtarget = conversation.get(player);

			if (args.length > 0) {

				if (!conversation.containsKey(player)) {
					player.sendMessage(F.error("Message",
							"You have not messaged anyone recently."));
					return true;
				}

				if (!rtarget.isOnline()) {
					player.sendMessage(F.error("Message",
							"That player is no longer online."));
					conversation.remove(player);
					return true;
				}

				StringBuilder sb = new StringBuilder();
				for (String arg : args) {
					sb.append(arg+" ");
				}
				String message = sb.toString();

				player.sendMessage(F.boldBlue + "You > " + rtarget.getName()
						+ ": " + F.GOLD + message);
				rtarget.sendMessage(F.boldBlue + player.getName() + " > You: "
						+ F.GOLD + message);
				rtarget.playSound(player.getLocation(), Sound.LEVEL_UP, 10F, 0F);
				return false;
			}
		}
		return false;

	}
}
