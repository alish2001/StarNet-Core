package com.starnetmc.core.util;

import org.bukkit.entity.Player;

public enum Rank {

	OWNER, DEVELOPER, ADMIN, YOUTUBE, BUILDER, MODERATOR, HELPER, MVP, VIP, DEFAULT;

	public boolean has(Rank rt) {
		return has(null, rt);
	}

	public boolean has(Player player, Rank rt) {

		if (compareTo(rt) <= 0) {
			return true;
		}
		return false;

	}

}
