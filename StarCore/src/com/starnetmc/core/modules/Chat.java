package com.starnetmc.core.modules;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.commands.AFK;
import com.starnetmc.core.commands.Broadcast;
import com.starnetmc.core.commands.ChatClear;
import com.starnetmc.core.commands.SetSpawn;
import com.starnetmc.core.commands.Spawn;
import com.starnetmc.core.commands.StaffChat;
import com.starnetmc.core.commands.Test;
import com.starnetmc.core.commands.Time;
import com.starnetmc.core.commands.modulecontrol.DisableModule;
import com.starnetmc.core.commands.modulecontrol.EnableModule;
import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;

public class Chat extends Module {

	JavaPlugin plugin;
	
	public Chat(JavaPlugin plugin) {
		super("Chat", 0.5, ModuleType.INFO, plugin);
		this.plugin = plugin;
	}

public Chat() {
	
}
	
	@Override
	public void enable() {
		isEnabled = true;
		log("Enabled.");

	}

	@Override
	public void addCommands() {
		addCommand(new AFK(this));
		addCommand(new Broadcast(this));
		addCommand(new ChatClear(this));
		addCommand(new SetSpawn(this));
		addCommand(new Spawn(this));
		addCommand(new StaffChat(this));
		addCommand(new Test(this));
		addCommand(new Time(this));
		addCommand(new EnableModule(this));
		addCommand(new DisableModule(this));
	}
	
	@Override
	public void disable() {
		isEnabled = false;
		log("Disabled.");
	}

	public static boolean isEnabled;

	@EventHandler
	public void silence(AsyncPlayerChatEvent e) {
		
		if(isEnabled = true) {
			return;
		}
		if(isEnabled = false) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(F.error("Chat", "Chat is currently silenced."));
		}
		
	}

}
