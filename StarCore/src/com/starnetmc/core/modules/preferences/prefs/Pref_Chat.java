package com.starnetmc.core.modules.preferences.prefs;

import java.util.Arrays;

import org.bukkit.Material;

import com.starnetmc.core.modules.preferences.Pref;
import com.starnetmc.core.util.F;

public class Pref_Chat extends Pref {

	public Pref_Chat(){
		super("Chat", true, Material.PAPER, Arrays.asList(" ",
				F.WHITE + "Toggle Chat Visibility",
				F.WHITE + "To not see chat messages"));
	}
	
}