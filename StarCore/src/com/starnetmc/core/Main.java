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
import com.starnetmc.core.commands.ModuleControl;
import com.starnetmc.core.commands.Settings;
import com.starnetmc.core.commands.Spawn;
import com.starnetmc.core.commands.StaffChat;
import com.starnetmc.core.commands.Teleport;
import com.starnetmc.core.commands.Test;
import com.starnetmc.core.commands.Time;
import com.starnetmc.core.listeners.Block;
import com.starnetmc.core.listeners.BlockCommands;
import com.starnetmc.core.listeners.Damage;
import com.starnetmc.core.listeners.GenericListener;
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
import com.starnetmc.core.util.MemoryFix;
import com.starnetmc.core.util.NMS;

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

	Chat chat = new Chat(this);
	Tutorial tutorial = new Tutorial(this);
	ChatFilter filter = new ChatFilter(this);
	NMS nms = new NMS(this);
	com.starnetmc.core.modules.Settings settings = new com.starnetmc.core.modules.Settings(this);
	Gadgets gadgets = new Gadgets(this);
	Border border = new Border(this);
	LScoreboard sb = new LScoreboard(this);
	News news = new News(this);
	DoubleJump dj = new DoubleJump(this);
	
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

		new NMS(this).registerEntity("Zombie", 54, EntityZombie.class,
				NPCZombie.class);
		new NMS(this).registerEntity("Skeleton", 51, EntitySkeleton.class,
				NPCSkeleton.class);
		new NMS(this).registerEntity("Villager", 120, EntityVillager.class,
				NPCVillager.class);
		new NMS(this)
				.registerEntity("Slime", 55, EntitySlime.class, NPCSlime.class);
		new NMS(this).registerEntity("Pig", 90, EntityPig.class, NPCPig.class);

		getConfig().options().copyDefaults(true);
		registerCommands();
		registerListeners();
		enableModules();
		new MemoryFix(this);
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
		getCommand("enable").setExecutor(new ModuleControl());
		getCommand("disable").setExecutor(new ModuleControl());
	}

	private void registerListeners() {
		Bukkit.getServer().getPluginManager().registerEvents(new Join(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Quit(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Block(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BlockCommands(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new GadgetsUI(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new GamemodeUI(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new Weather(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new com.starnetmc.core.util.Time(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new Damage(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new com.starnetmc.core.listeners.Chat(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new GenericListener(), this);
	}

	private void enableModules() {

		chat.enable();
		settings.enable();
		filter.enable();
		gadgets.enable();
		border.enable();
		tutorial.enable();
		sb.enable();
		news.enable();
		dj.enable();
		nms.enable();

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