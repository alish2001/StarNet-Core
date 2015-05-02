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

		Gadget pf = new Gadget(player, false);
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
	public void enable() {
		System.out.println(getName()+" enabled.");
		
	}

	@Override
	public void disable() {
		System.out.println(getName()+" disabled.");
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean setEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		return isEnabled() == arg0;
	}

}
