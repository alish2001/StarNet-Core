package com.starnetmc.core.objects;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.util.F;

public abstract class Module implements Listener {

	String name = "Modules";
	double version;
	ModuleType mt;
	JavaPlugin plugin;

	public Module(String name, double version, ModuleType mt, JavaPlugin plugin) {

		this.plugin = plugin;
		this.name = name;
		this.version = version;
		this.mt = mt;

		onEnable();
		registerListener(this);

	}

	private void onEnable() {
		enable();
	}

	public PluginManager getPluginManager() {
		return this.plugin.getServer().getPluginManager();
	}

	public JavaPlugin getPlugin() {
		return this.plugin;
	}

	public void enable() {

	}

	public void disable() {

	}

	public void registerListener(Listener listener) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
	}

	protected void log(String message) {
		System.out.println(F.info(this.name, message));

	}

}
