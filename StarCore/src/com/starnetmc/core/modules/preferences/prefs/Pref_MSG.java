package com.starnetmc.core.modules.preferences.prefs;

import java.util.Arrays;

import org.bukkit.Material;

import com.starnetmc.core.modules.preferences.Pref;
import com.starnetmc.core.util.F;

public class Pref_MSG extends Pref {

	public Pref_MSG(){
		super("Private Messaging", true, Material.BOOK_AND_QUILL, Arrays.asList(" ",
				F.WHITE + "Toggle Private Messaging",
				F.WHITE + "Others wont be able to send you",
			    F.WHITE + "Messages but you will be able to",
			    F.WHITE + "Send messages to players who are accepting them!"));
	}
		
}