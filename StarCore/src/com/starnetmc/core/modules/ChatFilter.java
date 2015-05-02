package com.starnetmc.core.modules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.starnetmc.core.Main;
import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;

public class ChatFilter implements Listener, Module {

	private static List<String> blocked = new ArrayList<String>();

	@EventHandler
	public void filterChat(AsyncPlayerChatEvent e) {

		if (isEnabled()) {

			String[] message = e.getMessage().toLowerCase().split(" ");
			for (String s : message) {
				if (blocked.contains(s)) {
					e.setCancelled(true);
					e.getPlayer()
							.sendMessage(
									F.error("Filter",
											"WARNING! Your last message contained a word that is blocked by our swear filter."));
					e.getPlayer()
							.sendMessage(
									ChatColor.RED
											+ "If you believe this is in error, please contact a server admin.");
				}
			}

		} else {
			return;
		}
	}

	public static void init() {

		Iterator<String> o = Main.getConfiguration().getStringList("filtered").iterator();

		while (o.hasNext()) {
			blocked.add(o.next());
		}

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Chat Filter";
	}

	@Override
	public void setName(String name) {

		name = "Chat Filter";

	}

	@Override
	public ModuleType getType(ModuleType mt) {
		// TODO Auto-generated method stub
		return ModuleType.CHAT;
	}

	@Override
	public void setType(ModuleType mt) {

		mt = ModuleType.CHAT;

	}

	@Override
	public void enable() {
		setEnabled(true);
		ChatFilter.init();
		System.out.println(getName()+" enabled.");

	}

	@Override
	public void disable() {
		setEnabled(false);
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
