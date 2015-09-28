package com.starnetmc.core.serversorter.getters;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.starnetmc.core.serversorter.serverinfo.GameServerInfo;
import com.starnetmc.core.serversorter.serverinfo.ServerInfo;

public class UServer {
	
	public static ServerInfo getServerInfo(String name, String ip, int port){
		InetSocketAddress address = new InetSocketAddress(ip, port);
		return getServerInfo(name, address);
	}
	
	public static ServerInfo getServerInfo(String name, InetSocketAddress address){
		ServerFetcher fetcher = new ServerFetcher(address);
		
		ServerResponse response = null;
		
		try {
			response = fetcher.fetchData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String motd = response.getDescription();
		int onlinePlayers = response.getPlayers().getOnline();
		int maxPlayers = response.getPlayers().getMax();
		
		ServerInfo info = new ServerInfo(name, motd, onlinePlayers, maxPlayers);
		return info;
	}
	
  
	public static GameServerInfo convertServerInfoToGame(ServerInfo inf){
		return new GameServerInfo(inf.getName(), inf.getMOTD(), inf.getPlayerCount(), inf.getMaxPlayerCount());
	}
}