package com.starnetmc.core.modules.scoreboards;

import org.bukkit.entity.Player;

import com.starnetmc.core.util.F;

public class HubStarBoard extends StarBoard {

	public HubStarBoard(Player player, String displayName) {
		super(player, "HUB");
		setDisplayName(F.boldAqua + "The Star Network");
		setLine(16, F.boldAqua + "RANK");
		setLine(15, F.RED + "NOPE!");
		setBlank(14);
		build();
		send();
	}
	
}