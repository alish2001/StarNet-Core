package com.starnetmc.core.modules;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class ChatFilter implements Listener, Module {

	private static List<String> _blockedWords = new ArrayList<String>();

	@EventHandler
	public void filterChat(AsyncPlayerChatEvent e) {

		if (isEnabled()) {

			String[] message = e.getMessage().toLowerCase().split(" ");
			for (String s : message) {
				if (_blockedWords.contains(s)) {
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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Chat Filter";
	}

	@Override
	public ModuleType getType(ModuleType mt) {
		// TODO Auto-generated method stub
		return ModuleType.CHAT;
	}

	@Override
	public double getVersion() {
		
		return 0.7;
		
	}
	
	@Override
	public void enable() {
		setEnabled(true);
		try {
			_blockedWords = Manager.downloadFilter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("<Chat Filter> "+getVersion()+" enabled.");

	}

	@Override
	public void disable() {
		setEnabled(false);
		System.out.println("<Chat Filter> "+getVersion()+" disabled.");

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
