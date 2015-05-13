package com.starnetmc.core.modules;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class ChatFilter extends Module {

	private static List<String> _blockedWords = new ArrayList<String>();

	public ChatFilter(JavaPlugin plugin) {
		super("Chat Filter",1.0,ModuleType.INFO,plugin);
	}

	public ChatFilter() {
		
	}
	
	@EventHandler
	public void filterChat(AsyncPlayerChatEvent e) {

		if (isEnabled == true) {

			String[] message = e.getMessage().toLowerCase().split(" ");
			for (String s : message) {
				if (_blockedWords.contains(s)) {
					e.setCancelled(true);
					e.getPlayer()
							.sendMessage(
									F.error("Filter",
											"WARNING! Your last message contained a word that is blocked by our swear filter. If you believe this is in error, please contact a server admin."));

				}
			}

		} else {
			return;
		}
	}

	@Override
	public void enable() {
		isEnabled = true;
		try {
			_blockedWords = Manager.downloadFilter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log("Enabled.");

	}

	@Override
	public void disable() {
		isEnabled = false;
		log("Disabled.");

	}

	public static boolean isEnabled;

	

}
