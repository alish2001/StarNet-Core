package com.starnetmc.core.modules.manager;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.commands.util.CommandCenter;
import com.starnetmc.core.commands.util.ICommand;
import com.starnetmc.core.util.F;

public abstract class Module implements Listener {

	String name = "Modules";
	double version;
	ModuleType mt;
	static JavaPlugin plugin;

	public Module(String name, double version, ModuleType mt, JavaPlugin plugin) {

		Module.plugin = plugin;
		this.name = name;
		this.version = version;
		this.mt = mt;

		onEnable();
		registerListener(this);

	}

	public Module() {

	}

	private void onEnable() {
		enable();
		addCommands();
	}

	public static PluginManager getPluginManager() {
		return plugin.getServer().getPluginManager();
	}

	public static JavaPlugin getPlugin() {
		return plugin;
	}

	public void enable() {

	}

	public void disable() {

	}

	public void addCommands() {

	}

	public void registerListener(Listener listener) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
	}

	public final void addCommand(ICommand command) {
		CommandCenter.cc.addCommand(command);
	}

	public final void removeCommand(ICommand command) {
		CommandCenter.cc.removeCommand(command);
	}

	protected void log(String message) {
		System.out.println(F.info(this.name, message));

	}

}
