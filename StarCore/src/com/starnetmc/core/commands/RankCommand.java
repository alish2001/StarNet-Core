package com.starnetmc.core.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.starnetmc.core.commands.util.CommandBase;
import com.starnetmc.core.database.Databaser;
import com.starnetmc.core.modules.Chat;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Rank;

public class RankCommand extends CommandBase<Chat> {

	public RankCommand(Chat plugin) {
		super(plugin, Rank.ADMIN, new String[] { "rank", "setrank", "updaterank" });
	}

	public void execute(Player player, String[] args) {

		if (args.length < 2) {
			player.sendMessage(F.error("Commands", "Please specify a player and a rank."));
			return;
		}

		try {
			
			String uuid = Databaser.getUUID(args[0]).trim();
			
			if (!Databaser.hasAccount(uuid)) {
				player.sendMessage(F.error("Database Search", "Player not found."));
				return;
			}
			
			Rank rank = Rank.getRankFromString(args[1]);
			
			Databaser.setRank(uuid, rank);
			player.sendMessage(F.info("Ranks", args[0] + "'s Rank has been changed to " + rank.getTag(false)));
			
			if (Bukkit.getServer().getPlayer(UUID.fromString(uuid)) != null){
				Bukkit.getServer().getPlayer(UUID.fromString(uuid)).sendMessage(F.info("Ranks", "Your Rank has been changed to " + rank.getTag(false)));
			}
			
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}