package com.starnetmc.core.punish;

public enum PunishType {
	
	MUTE,
	BAN;

	public static PunishType getPunishmentTypeFromString(String s){
		if (s.equalsIgnoreCase("mute")){
			return MUTE;
		}
		
		if (s.equalsIgnoreCase("ban")){
			return BAN;
		}
		
		return null;
	}
	
}