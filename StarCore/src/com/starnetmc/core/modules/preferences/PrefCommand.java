package com.starnetmc.core.modules.preferences;

import org.bukkit.entity.Player;

import com.starnetmc.core.commands.util.CommandBase;
import com.starnetmc.core.modules.preferences.GUI.PrefGUI;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Rank;

public class PrefCommand extends CommandBase<Preferences> {

	public PrefCommand(Preferences plugin) {
		super(plugin, Rank.DEFAULT, new String[] { "preference", "preferences", "pref", "prefs" });
	}

	public void execute(Player player, String[] args) {

		if (Preferences.isEnabled == false) {
			player.sendMessage(F.error("Modules", "Settings have been disabled by an owner."));
			return;
		}
		
		PrefGUI.openPrefGUI(player);
	}
}