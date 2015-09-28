package com.starnetmc.core.serversorter.serverinfo;

import org.bukkit.ChatColor;

import com.starnetmc.core.serversorter.GameState;
import com.starnetmc.core.serversorter.GameType;
import com.starnetmc.core.serversorter.ServerType;

public class GameServerInfo extends ServerInfo {
	
	private GameType gameType;
	private GameState gameState;
	private String mapName;
	
	public GameServerInfo(String serverName, String serverMOTD, int serverPlayers, int maxServerPlayers){
		super(serverName, serverMOTD, serverPlayers, maxServerPlayers);
		deSerializeArcadeInfo(serverMOTD);
	}
	
	private void deSerializeArcadeInfo(String motd){
		motd = ChatColor.stripColor(motd);
		String[] data = motd.split("\\|");
		serverType = ServerType.getServerTypeFromString(data[0]); 
		
		gameType = GameType.getGameTypeFromVarName(data[1]);
		gameState = GameState.getStateFromString(data[2]);
		mapName = data[3];
		
		maxServerPlayers = Integer.parseInt(data[4]);
	}
	
	public GameType getGameType(){
		return gameType;
	}
	
	public GameState getGameState(){
		return gameState;
	}
	
	public String getMapName(){
		return mapName;
	}
	
}