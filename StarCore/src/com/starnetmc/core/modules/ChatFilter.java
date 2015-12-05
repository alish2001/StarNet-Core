package com.starnetmc.core.modules;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.database.Databaser;
import com.starnetmc.core.modules.manager.Module;
import com.starnetmc.core.modules.manager.ModuleType;

public class ChatFilter extends Module {

	private static List<String> blockedWords = new ArrayList<String>();

	public ChatFilter(JavaPlugin plugin) {
		super("Chat Filter", 1.0, ModuleType.INTERNAL, plugin);
	}

	public ChatFilter() {
		
	}
	
	@EventHandler
	public void filterChat(AsyncPlayerChatEvent e) {

		if (!isEnabled) return;

			String[] message = e.getMessage().toLowerCase().split(" ");
			for (int i = message.length - 1; i != -1; i--) {
				if (blockedWords.contains(message[i])) {
					StringBuilder builder = new StringBuilder();
					for(int x = message[i].length(); x != 0; x--){
						builder.append("#");
					}
					
					message[i] = builder.toString();
				}
			}
			
			StringBuilder msg = new StringBuilder();
			for (String s : message) {
				msg.append(s);
				msg.append(" ");
			}
			
			e.setMessage(msg.toString());
	}

	@Override
	public void enable() {
		isEnabled = true;
		try {
			blockedWords = Databaser.downloadFilter();
		} catch (Exception e) {
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