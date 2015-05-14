package com.starnetmc.core.commands.util;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.util.Manager;
import com.starnetmc.core.util.Rank;
import com.starnetmc.core.util.StarMap;

public class CommandCenter implements Listener {

	public static CommandCenter cc;
	public StarMap<String, ICommand> commands;
	JavaPlugin plugin;
	Rank rank;

	public static void init(JavaPlugin plugin) {

		if (cc == null) {
			cc = new CommandCenter(plugin);
		}

	}

	public CommandCenter(JavaPlugin plugin) {
		this.plugin = plugin;
		this.commands = new StarMap<String, ICommand>();
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void runCommands(PlayerCommandPreprocessEvent e) throws Exception {

		String commandName = e.getMessage().substring(1);
		String[] args = null;
		
		if (commandName.contains(" ")) {
			commandName = commandName.split(" ")[0];
			args = e.getMessage().substring(e.getMessage().indexOf(' ') + 1)
					.split(" ");
		}
		ICommand command = (ICommand) this.commands.get(commandName
				.toLowerCase());

		if (command != null && getRank(e.getPlayer()).has(command.getRequiredRank())) {

			command.setAliasUsed(commandName.toLowerCase());
			command.execute(e.getPlayer(), args);

			e.setCancelled(true);

		}

	}

	public void addCommand(ICommand command) {
		for (String commandRoot : command.Aliases()) {
			this.commands.put(commandRoot.toLowerCase(), command);
			command.setCommandCenter(this);
		}
	}

	public void removeCommand(ICommand command) {
		for (String commandRoot : command.Aliases()) {
			this.commands.remove(commandRoot.toLowerCase());
			command.setCommandCenter(null);
		}
	}

	public Rank getRank(Player player) throws Exception {
		
		return Manager.getRank(player.getUniqueId().toString());
		
	}
	
}
