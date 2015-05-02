package com.starnetmc.core.npc.command;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;

import com.starnetmc.core.Main;
import com.starnetmc.core.npc.NPCPig;
import com.starnetmc.core.npc.NPCSkeleton;
import com.starnetmc.core.npc.NPCSlime;
import com.starnetmc.core.npc.NPCVillager;
import com.starnetmc.core.npc.NPCZombie;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;
import com.starnetmc.core.util.NMS;

public class NPCCommand implements CommandExecutor {

	public NPCCommand(Main main) {
	}

	NMS nms = new NMS();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(F.error("Command",
					"This command is only for player use!"));
			return true;
		}

		String s;
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i < args.length; i++) {
			sb.append(args[i]).append(" ");
		}
		s = sb.toString();

		if (cmd.getName().equalsIgnoreCase("npc")) {

			if (nms.isEnabled()) {

				Player player = (Player) sender;
				Location loc = player.getLocation();
				if (args.length < 2) {
					player.sendMessage(F
							.error("Commands",
									"Invalid Syntax. Please use /npc <skeleton | zombie | zombiebaby | villager | villagerbaby | slime | pig | pigbaby | skeletonwither> <name>"));
					return true;
				}

				try {
					if (Manager.getRank(player.getUniqueId().toString())
							.equals("OWNER")) {

						if (args[0].equalsIgnoreCase("zombie")) {
							Zombie b = NPCZombie.spawn(loc);
							b.setCustomName(ChatColor.GOLD + " " + s);
							b.setCustomNameVisible(true);
							player.sendMessage(F.info("NPC",
									"NPC Summoned Successfully"));
						}
						if (args[0].equalsIgnoreCase("skeleton")) {
							Skeleton b = NPCSkeleton.spawn(loc);
							b.setCustomName(ChatColor.GOLD + " " + s);
							b.setCustomNameVisible(true);
							player.sendMessage(F.info("NPC",
									"NPC Summoned Successfully"));
						}
						if (args[0].equalsIgnoreCase("skeletonwither")) {
							Skeleton b = NPCSkeleton.spawn(loc);
							b.setSkeletonType(SkeletonType.WITHER);
							b.setCustomName(ChatColor.GOLD + " " + s);
							b.setCustomNameVisible(true);
							player.sendMessage(F.info("NPC",
									"NPC Summoned Successfully"));
						}
						if (args[0].equalsIgnoreCase("villager")) {
							Villager b = NPCVillager.spawn(loc);
							b.setCustomName(ChatColor.GOLD + " " + s);
							b.setCustomNameVisible(true);
							player.sendMessage(F.info("NPC",
									"NPC Summoned Successfully"));
						}
						if (args[0].equalsIgnoreCase("zombiebaby")) {

							Zombie b = NPCZombie.spawn(loc);
							b.setBaby(true);
							b.setCustomName(ChatColor.GOLD + " " + s);
							b.setCustomNameVisible(true);
							player.sendMessage(F.info("NPC",
									"NPC Summoned Successfully"));

						}
						if (args[0].equalsIgnoreCase("villagerbaby")) {

							Villager b = NPCVillager.spawn(loc);
							b.setBaby();
							b.setCustomName(ChatColor.GOLD + " " + s);
							b.setCustomNameVisible(true);
							player.sendMessage(F.info("NPC",
									"NPC Summoned Successfully"));

						}

						if (args[0].equalsIgnoreCase("slime")) {
							Slime b = NPCSlime.spawn(loc);
							b.setCustomName(ChatColor.GOLD + " " + s);
							b.setCustomNameVisible(true);
							player.sendMessage(F.info("NPC",
									"NPC Summoned Successfully"));
						}
						if (args[0].equalsIgnoreCase("pig")) {
							Pig b = NPCPig.spawn(loc);
							b.setCustomName(ChatColor.GOLD + " " + s);
							b.setCustomNameVisible(true);
							player.sendMessage(F.info("NPC",
									"NPC Summoned Successfully"));
						}
						if (args[0].equalsIgnoreCase("pigbaby")) {
							Pig b = NPCPig.spawn(loc);
							b.setCustomName(ChatColor.GOLD + " " + s);
							b.setCustomNameVisible(true);
							b.setBaby();
							player.sendMessage(F.info("NPC",
									"NPC Summoned Successfully"));
							return true;
						}
					} else {
						return true;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			sender.sendMessage(F.error("NPC AI",
					"This module is not currently enabled."));
			return true;
		}

		return false;
	}

}
