package com.starnetmc.core.serversorter;

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

import com.starnetmc.core.util.F;


public enum GameState {

	LOBBY(F.boldGreen + "Awaiting Players"),
	LOADING(F.boldYellow + "Starting Join Now!"),
	INGAME(F.boldRed + "IN-GAME"),
	POSTGAME(F.boldGold + "Post-Game");
	
	private String statusString;
	
	GameState(String statusString){
		this.statusString = statusString;
	}
	
	public String getStatus(boolean stripColor){
		
		if (stripColor){
			String returnString = ChatColor.stripColor(statusString);
			return returnString;
		}
		
		return statusString;
	}
	
	public static GameState getStateFromString(String state){
		state = ChatColor.stripColor(state).trim();
		GameState fState = LOBBY;
		
		for (GameState _state : getAllGameStates()){
			if (state.equalsIgnoreCase(_state.toString())){
				fState = _state;
			}
		}
		
		return fState;
	}
	
	public static List<GameState> getAllGameStates(){
		List<GameState> allStates = new ArrayList<GameState>();
		allStates.add(LOBBY);
		allStates.add(LOADING);
		allStates.add(INGAME);
		allStates.add(POSTGAME);
		return allStates;
	}
	
}