package com.starnetmc.core.util;

import org.bukkit.entity.Player;

public enum Rank {

	OWNER, DEVELOPER, ADMIN, BUILDER, YOUTUBE, MODERATOR, HELPER, MVP, VIP, DEFAULT;

	public boolean has(Rank rt) {
		return has(null, rt);
	}

	public boolean has(Player player, Rank rt) {

		if (compareTo(rt) <= 0) {
			return true;
		} else {
			player.sendMessage(F.error("Permissions", "No permission!"));
			return false;
		}

	}


	
}
