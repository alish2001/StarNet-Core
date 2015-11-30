package com.starnetmc.core.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public enum Rank {

	OWNER(F.boldDR + "OWNER"),
	DEVELOPER(F.boldDP + "DEV"),
	ADMIN(F.boldRed + "ADMIN"),
	BUILDER(F.boldBlue + "BUILDER"),
	MODERATOR(F.boldGold + "MOD"),
	HELPER(F.boldGreen + "HELPER"),
	YOUTUBE(F.boldRed + "YOU" + F.boldWhite + "[TUBE]"),
	MVP(F.boldAqua + "MVP"),
	VIP(F.boldYellow + "VIP"),
	DEFAULT(F.boldWhite + "DEFAULT");
	
	private String tag;
	
	Rank(String tag){
		this.tag = tag;
	}
	
	public String getTag(boolean noColor){
		
		if (noColor){
			return ChatColor.stripColor(tag);
		}
		
		return tag;
	}
	
	public static List<Rank> getStaffRanks(){
		List<Rank> staffRanks = new ArrayList<Rank>();
		staffRanks.add(OWNER);
		staffRanks.add(DEVELOPER);
		staffRanks.add(ADMIN);
		staffRanks.add(BUILDER);
		staffRanks.add(MODERATOR);
		staffRanks.add(HELPER);
		return staffRanks;
	}
	
	public static Rank getRankFromString(String rank){
		Rank finalRank = DEFAULT;
		
		for (Rank r : getStaffRanks()){
			if (r.getTag(false).equalsIgnoreCase(rank)){
				finalRank = r;
			}
		}
		
		if (rank.equalsIgnoreCase("youtube")) finalRank = YOUTUBE;
		if (rank.equalsIgnoreCase("mvp")) finalRank = MVP;
		if (rank.equalsIgnoreCase("vip")) finalRank = VIP;
		if (rank.equalsIgnoreCase("default")) finalRank = DEFAULT;
		
		return finalRank;
	}

}