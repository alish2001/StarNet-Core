package com.starnetmc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class StaffChat implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(F.error("Command",
					"This command is only for player use!"));
			return true;
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("sc")) {
			if (args.length == 0) {
				p.sendMessage(F.error("Commands", "Please use: /sc <Message>"));
				return true;
			}

			try {
				switch (Manager.getRank(p.getUniqueId().toString())) {
				case "DEFAULT":
					p.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "VIP":
					p.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "MVP":
					p.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "BUILDER":
					p.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "YOUTUBE":
					p.sendMessage(F.error("Permissions", "No permission!"));
					return true;
				case "(NULL)":
					p.sendMessage(F.error("Permissions", "No permission!"));
					p.kickPlayer(F.error("Server",
							"Err... Something went wrong?"));
					return true;
				default:
					String annc = "";
					StringBuilder sb = new StringBuilder();
					for (String arg : args) {
						sb.append(arg+" ");
				}
					annc = sb.toString();
					
				String rank = Manager.getRank(p.getUniqueId().toString())+" ";

					for (Player player : Bukkit.getOnlinePlayers()) {

						try {
							switch (Manager.getRank(player.getUniqueId()
									.toString())) {

							case "HELPER":
								player.sendMessage(F.GOLD+rank+p.getName()+" "+annc);
								player.playSound(player.getLocation(), Sound.NOTE_PLING, 8F, 2F);
								return false;
							case "MODERATOR":
								player.sendMessage(F.GOLD+rank+p.getName()+" "+annc);
								player.playSound(player.getLocation(), Sound.NOTE_PLING, 8F, 2F);
								return false;
							case "ADMIN":
								player.sendMessage(F.GOLD+rank+p.getName()+" "+annc);
								player.playSound(player.getLocation(), Sound.NOTE_PLING, 8F, 2F);
								return false;
							case "OWNER":
								player.sendMessage(F.GOLD+rank+p.getName()+" "+annc);
								player.playSound(player.getLocation(), Sound.NOTE_PLING, 8F, 2F);
								return false;
							case "DEVELOPER":
								player.sendMessage(F.GOLD+rank+p.getName()+" "+annc);
								player.playSound(player.getLocation(), Sound.NOTE_PLING, 8F, 2F);
								return false;
							case "BUILDER":
								player.sendMessage(F.GOLD+rank+p.getName()+" "+annc);
								player.playSound(player.getLocation(), Sound.NOTE_PLING, 8F, 2F);
								return false;
							default:
								player.sendMessage(F.error("Permissions", "No permission!"));
								return true;

							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			} catch (Exception e) {

			}

			return true;
		}
		return false;
	}

}
