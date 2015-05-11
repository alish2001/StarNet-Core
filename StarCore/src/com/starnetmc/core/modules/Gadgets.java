package com.starnetmc.core.modules;

import java.util.HashMap;

import org.bukkit.entity.Player;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.Gadget;

public class Gadgets implements Module{
	
	private static HashMap<String, Gadget> playergadgets = new HashMap<String, Gadget>();
	
	public static Gadget getGadgets(Player player) {

		return playergadgets.get(player.getUniqueId().toString());
	}

	public static void createUserGadget(Player player) {

		Gadget pf = new Gadget(player, false, false);
		getUsers().put(player.getUniqueId().toString(), pf);
	}

	public static HashMap<String, Gadget> getUsers() {

		return playergadgets;
	}

	public static void removeUser(Player player) {

		getUsers().remove(player.getUniqueId().toString());

	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Gadget Manager";
	}

	
	@Override
	public ModuleType getType(ModuleType mt) {
		// TODO Auto-generated method stub
		return ModuleType.SERVER;
	}

	@Override
	public double getVersion() {
		
		return 0.9;
		
	}

	@Override
	public void enable() {
		isEnabled = true;
		System.out.println("<Gadgets> "+getVersion()+" enabled.");
		
	}

	@Override
	public void disable() {
		isEnabled = false;
		System.out.println("<Gadgets> "+getVersion()+" disabled.");
		
	}

	public static boolean isEnabled;

	

}
