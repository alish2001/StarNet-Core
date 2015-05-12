package com.starnetmc.core.modules;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.Gadget;
import com.starnetmc.core.util.StarMap;

public class Gadgets extends Module {
	
	
	
	private static StarMap<String, Gadget> playergadgets = new StarMap<String, Gadget>();
	
	public Gadgets(JavaPlugin plugin) {
		super("Gadgets",0.6,ModuleType.SERVER,plugin);
	}
	
	public static Gadget getGadgets(Player player) {

		return playergadgets.get(player.getUniqueId().toString());
	}

	public static void createUserGadget(Player player) {

		Gadget pf = new Gadget(player, false, false);
		getUsers().put(player.getUniqueId().toString(), pf);
	}

	public static StarMap<String, Gadget> getUsers() {

		return playergadgets;
	}

	public static void removeUser(Player player) {

		getUsers().remove(player.getUniqueId().toString());

	}
	

	@Override
	public void enable() {
		isEnabled = true;
		log("Enabled.");
		
	}

	@Override
	public void disable() {
		isEnabled = false;
		log("Disabled.");
	}

	public static boolean isEnabled;

	

}
