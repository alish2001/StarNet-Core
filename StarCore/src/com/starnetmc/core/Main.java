package com.starnetmc.core;

import java.sql.SQLException;

import net.minecraft.server.v1_8_R1.EntityPig;
import net.minecraft.server.v1_8_R1.EntitySkeleton;
import net.minecraft.server.v1_8_R1.EntitySlime;
import net.minecraft.server.v1_8_R1.EntityVillager;
import net.minecraft.server.v1_8_R1.EntityZombie;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.commands.AFK;
import com.starnetmc.core.commands.Broadcast;
import com.starnetmc.core.commands.Gamemode;
import com.starnetmc.core.commands.Message;
import com.starnetmc.core.commands.Settings;
import com.starnetmc.core.commands.Spawn;
import com.starnetmc.core.commands.StaffChat;
import com.starnetmc.core.commands.Teleport;
import com.starnetmc.core.commands.Test;
import com.starnetmc.core.commands.Time;
import com.starnetmc.core.listeners.Block;
import com.starnetmc.core.listeners.BlockCommands;
import com.starnetmc.core.listeners.Damage;
import com.starnetmc.core.listeners.Join;
import com.starnetmc.core.listeners.Quit;
import com.starnetmc.core.listeners.Weather;
import com.starnetmc.core.modules.Border;
import com.starnetmc.core.modules.Chat;
import com.starnetmc.core.modules.ChatFilter;
import com.starnetmc.core.modules.DoubleJump;
import com.starnetmc.core.modules.Gadgets;
import com.starnetmc.core.modules.LScoreboard;
import com.starnetmc.core.modules.News;
import com.starnetmc.core.modules.Tutorial;
import com.starnetmc.core.npc.NPCPig;
import com.starnetmc.core.npc.NPCSkeleton;
import com.starnetmc.core.npc.NPCSlime;
import com.starnetmc.core.npc.NPCVillager;
import com.starnetmc.core.npc.NPCZombie;
import com.starnetmc.core.npc.command.NPCCommand;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.GadgetsUI;
import com.starnetmc.core.util.GamemodeUI;
import com.starnetmc.core.util.Manager;
import com.starnetmc.core.util.NMS;
import com.starnetmc.core.util.Updater;

/**
 * 
 * @author SparkWings
 * <p><b>This plugin is intended for use by The Star Network ONLY.</b></p>
 * <p><b>Unauthorized use or access to this plugin will result in immediate legal action.</b></p>
 * <p>Copyright 2015 ©StarNetwork.LTD</p>
 *
 */

public class Main extends JavaPlugin {

	// Util
	private static Main plugin;
	public Manager mysql = new Manager(this);

	// Modules
	/**
	 * @param Modules
	 *            from the plugin. They are enabled below
	 * @see java.lang.Object
	 */

	Chat chat = new Chat();
	Tutorial tutorial = new Tutorial();
	ChatFilter filter = new ChatFilter();
	NMS nms = new NMS();
	com.starnetmc.core.modules.Settings settings = new com.starnetmc.core.modules.Settings();
	Gadgets gadgets = new Gadgets();
	Border border = new Border();
	LScoreboard sb = new LScoreboard();
	News news = new News();
	DoubleJump dj = new DoubleJump();
	

	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {

		plugin = this;
		


		try {
			this.mysql.setupDB();
			getLogger().info(F.info("Database", "Connected!"));
		} catch (ClassNotFoundException | SQLException e) {
			getLogger()
					.info(F.error("Database", "Unable to connect to MySQL."));
			e.printStackTrace();
		}
		
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

		new NMS().registerEntity("Zombie", 54, EntityZombie.class,
				NPCZombie.class);
		new NMS().registerEntity("Skeleton", 51, EntitySkeleton.class,
				NPCSkeleton.class);
		new NMS().registerEntity("Villager", 120, EntityVillager.class,
				NPCVillager.class);
		new NMS()
				.registerEntity("Slime", 55, EntitySlime.class, NPCSlime.class);
		new NMS().registerEntity("Pig", 90, EntityPig.class, NPCPig.class);

		getConfig().options().copyDefaults(true);
		registerCommands();
		registerListeners();
		enableModules();
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Updater(this), 1L, 1L);
		getLogger().info(F.info("Plugin", "All modules enabled."));
	}

	@Override
	public void onDisable() {

		disableModules();
		saveDefaultConfig();
		getLogger()
				.info(F.info("Plugin",
						"All modules disabled. Plugin shutting down."));

	}

	private void registerCommands() {
		getCommand("npc").setExecutor(new NPCCommand(this));
		getCommand("chat").setExecutor(
				new com.starnetmc.core.commands.Chat(this));
		getCommand("settings").setExecutor(new Settings(this));
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("setspawn").setExecutor(new Spawn());
		getCommand("test").setExecutor(new Test());
		getCommand("gm").setExecutor(new Gamemode());
		getCommand("gms").setExecutor(new Gamemode());
		getCommand("gma").setExecutor(new Gamemode());
		getCommand("gmc").setExecutor(new Gamemode());
		getCommand("gmsp").setExecutor(new Gamemode());
		getCommand("t").setExecutor(new Time());
		getCommand("message").setExecutor(new Message());
		getCommand("reply").setExecutor(new Message());
		getCommand("teleport").setExecutor(new Teleport());
		getCommand("tpall").setExecutor(new Teleport());
		getCommand("afk").setExecutor(new AFK());
		getCommand("sc").setExecutor(new StaffChat());
		getCommand("a").setExecutor(new Broadcast());
	}

	private void registerListeners() {
		Bukkit.getServer().getPluginManager().registerEvents(new Join(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Quit(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Block(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Border(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BlockCommands(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new News(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DoubleJump(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new GadgetsUI(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new GamemodeUI(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new Weather(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new com.starnetmc.core.util.Time(), this);
		Bukkit.getServer()
				.getPluginManager()
				.registerEvents(new com.starnetmc.core.modules.Settings(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new Damage(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new NMS(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new ChatFilter(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new com.starnetmc.core.listeners.Chat(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new LScoreboard(), this);
	}

	private void enableModules() {

		chat.enable();
		settings.enable();
		filter.enable();
		gadgets.enable();
		border.enable();
		tutorial.enable();
		nms.enable();
		sb.enable();
		news.enable();
		dj.enable();

	}

	private void disableModules() {

		chat.disable();
		settings.disable();
		filter.disable();
		gadgets.disable();
		border.disable();
		tutorial.disable();
		nms.disable();
		sb.disable();
		news.disable();
		dj.disable();
	}


	public static Main getPlugin() {
		return Main.plugin;
	}

}