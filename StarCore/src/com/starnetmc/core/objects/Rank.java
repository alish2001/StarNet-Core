package com.starnetmc.core.objects;

public enum Rank {

	DEFAULT("DEFAULT"), MVP("MVP"), MVPPLUS("MVPPLUS"), HELPER("HELPER"), MODERATOR(
			"MOD"), ADMIN("ADMIN"), OWNER("OWNER");

	String display;

	Rank(String display) {
		this.display = display;
	}

	String getRankType(Rank rank) {
		return display;
	}

	void setRankType(String newr) {
		
		this.display = newr;
	}
	
}
