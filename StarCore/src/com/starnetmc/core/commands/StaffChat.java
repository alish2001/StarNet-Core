package com.starnetmc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import com.starnetmc.core.commands.util.CommandBase;
import com.starnetmc.core.modules.Chat;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;
import com.starnetmc.core.util.Rank;

public class StaffChat extends CommandBase<Chat> {

	public StaffChat(Chat plugin) {
		super(plugin, Rank.HELPER, new String[] { "staffchat", "sc" });
		// TODO Auto-generated constructor stub
	}

	public void execute(Player player, String[] args) {

		if (args.length == 0) {
			player.sendMessage(F.error("Commands", "Please use: /sc <Message>"));
			return;
		}

		String annc = "";
		StringBuilder sb = new StringBuilder();
		for (String arg : args) {
			sb.append(arg + " ");
		}
		annc = sb.toString();

		try {
			String rank = Manager.getRank(player.getUniqueId().toString())
					+ " ";

			for (Player all : Bukkit.getOnlinePlayers()) {

				switch (Manager.getRank(player.getUniqueId().toString())) {

				case HELPER:
					all.sendMessage(F.GOLD + rank + player.getName() + " "
							+ annc);
					all.playSound(all.getLocation(), Sound.NOTE_PLING, 8F, 2F);
					return;
				case MODERATOR:
					all.sendMessage(F.GOLD + rank + player.getName() + " "
							+ annc);
					all.playSound(all.getLocation(), Sound.NOTE_PLING, 8F, 2F);
					return;
				case ADMIN:
					all.sendMessage(F.GOLD + rank + player.getName() + " "
							+ annc);
					all.playSound(all.getLocation(), Sound.NOTE_PLING, 8F, 2F);
					return;
				case OWNER:
					all.sendMessage(F.GOLD + rank + player.getName() + " "
							+ annc);
					all.playSound(all.getLocation(), Sound.NOTE_PLING, 8F, 2F);
					return;
				case DEVELOPER:
					all.sendMessage(F.GOLD + rank + player.getName() + " "
							+ annc);
					all.playSound(all.getLocation(), Sound.NOTE_PLING, 8F, 2F);
					return;
				case BUILDER:
					all.sendMessage(F.GOLD + rank + player.getName() + " "
							+ annc);
					all.playSound(all.getLocation(), Sound.NOTE_PLING, 8F, 2F);
					return;
				default:
					break;

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
