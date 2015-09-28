package com.starnetmc.core.serversorter;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.starnetmc.core.events.UpdateEvent;
import com.starnetmc.core.modules.manager.Module;
import com.starnetmc.core.modules.manager.ModuleType;
import com.starnetmc.core.serversorter.GUI.GameServerGUI;
import com.starnetmc.core.serversorter.GUI.ServerGUI;
import com.starnetmc.core.serversorter.getters.UServer;
import com.starnetmc.core.serversorter.serverinfo.GameServerInfo;
import com.starnetmc.core.serversorter.serverinfo.ServerInfo;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Logger;
import com.starnetmc.core.util.StarMap;
import com.starnetmc.core.util.Tickifier;
import com.starnetmc.core.util.Tickifier.Time;
import com.starnetmc.core.util.UpdateType;

public class ServerSorter extends Module {
	
	public ServerSorter(JavaPlugin plugin) {
		super("Server Sorter", 1.0, ModuleType.SERVER, plugin);
	}
	

	public ServerSorter() {
	}

	@Override
	public void enable() {
		Bukkit.getServer().getMessenger().registerIncomingPluginChannel(getPlugin(), "BungeeCord", new ServerInfoReciever());
		initServerGUIs();
		
		if (Bukkit.getServer().getOnlinePlayers().size() != 0){
		  refresh();
		  isReady = true;
		} else {
			isReady = false;
			log("Refraining from Sending fetch requests since no players are online.");
			return;
		}
		
		isEnabled = true;
		log("Enabled.");
	}

	@Override
	public void disable() {
		unInitServerGUIs();
		isEnabled = false;
		log("Disabled.");
	}

	public static boolean isEnabled;
	public static boolean isReady = false;
	
	public static StarMap<ServerInfo, ServerType> servers = new StarMap<ServerInfo, ServerType>();
	public static StarMap<String, InetSocketAddress> serverIPs = new StarMap<String, InetSocketAddress>();
    public static List<String> allServerNames = new ArrayList<String>();
    public static ArrayList<GameServerGUI> serverGUIs = new ArrayList<GameServerGUI>();
	
    public static void initServerGUIs(){
    	for (ServerGUI gui : serverGUIs){
    		gui.unRegister();
    	}
    	
    	serverGUIs.clear();
    	
    	for (GameType type : GameType.getAllGameTypes()){
    		GameServerGUI gui = new GameServerGUI(type);
    		gui.register();
    		serverGUIs.add(gui);
    	}
    }
    
    public static void unInitServerGUIs(){
    	for (ServerGUI gui : serverGUIs){
    		gui.unRegister();
    	}
    }
    
    public static void refresh(){
    	fetchServers();
    	
    	new BukkitRunnable() {
			
			@Override
			public void run() {
				fetchServerIPs();
			}
		}.runTaskLater(getPlugin(), Tickifier.tickify(10, Time.SECONDS));
    }
    
	public static void fetchServerIPs(){
		  Logger.log("<Server Sorter> Fetching ServerIP Map...");
		  serverIPs.clear();
		  for (String name : allServerNames){
		   ByteArrayDataOutput ipFetcher = ByteStreams.newDataOutput();
		   ipFetcher.writeUTF("ServerIP");
		   ipFetcher.writeUTF(name);
		   Iterables.getFirst(Bukkit.getOnlinePlayers(), null).sendPluginMessage(getPlugin(), "BungeeCord", ipFetcher.toByteArray());
		  }
	}
	
	public static void fetchServers(){
		  Logger.log("<Server Sorter> Fetching Server list...");
		  allServerNames.clear();
		  ByteArrayDataOutput serverFetcher = ByteStreams.newDataOutput();
		  serverFetcher.writeUTF("GetServers");
		  Iterables.getFirst(Bukkit.getOnlinePlayers(), null).
		  sendPluginMessage(getPlugin(), "BungeeCord", serverFetcher.toByteArray());
	}
	
	public void sortServers(){
		servers.clear();
		
		for (Entry<String, InetSocketAddress> server : serverIPs.entrySet()){
			String ip = Bukkit.getServer().getIp();
			int port = Bukkit.getServer().getPort();
			if (server.getValue().getHostString().equalsIgnoreCase(ip) && server.getValue().getPort() == port) continue;
		     ServerInfo data = UServer.getServerInfo(server.getKey(), server.getValue());
		     servers.put(data, data.getType());
		}
	}
	
	public static ArrayList<GameServerInfo> getGameServers(GameType type){
		ArrayList<GameServerInfo> gameServers = new ArrayList<GameServerInfo>();
		
		for (Entry<ServerInfo, ServerType> server : servers.entrySet()){
			if (server.getValue() != ServerType.GAME) continue;
			GameServerInfo data = UServer.convertServerInfoToGame(server.getKey());
			
			if (data.getGameType() != type) continue;
			gameServers.add(data);
		}
		
		return gameServers;
	}
	
	public static GameServerGUI getGameGUI(GameType type){
		GameServerGUI rGUI = serverGUIs.get(0);
		
		for (ServerGUI gui : serverGUIs){
			if (!(gui instanceof GameServerGUI)) continue;
			GameType gType = GameType.getGameTypeFromName(ChatColor.stripColor(gui.getInventory().getName()));
			if (gType != type) continue;
			
			rGUI = (GameServerGUI) gui;
		}
		
		return rGUI;
	}
	
	@EventHandler
	public void serverData(ServerListPingEvent e){
		e.setMotd(F.AQUA + "LOBBY|" + Bukkit.getServer().getName().split("-")[1].trim());
	}
	
	@EventHandler
	public void serverListUpdater(UpdateEvent e){
		if (e.getType() != UpdateType.SECOND) return;
		sortServers();
		
		for (ServerGUI gui : serverGUIs){
			gui.refresh();
		}
	}
	
	@EventHandler
	public void onReady(PlayerJoinEvent e){
		if (isReady) return;
		
		log("Player logged in, fetching data in 5 seconds...");
		isReady = true;
		new BukkitRunnable() {
			
			@Override
			public void run() {
				refresh();
			}
		}.runTaskLater(getPlugin(), Tickifier.tickify(5, Time.SECONDS));
	}

}