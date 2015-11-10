package com.starnetmc.core.database;

public class StarDatabaseCreds extends DatabaseCreds {

	public StarDatabaseCreds(String dbIP, int dbPort, String dbName, String dbUserName, String dbPassword) {
		super("server.starnetworkmc.com", 3306, "star_net", "root", "Fcdytrff1!");
	}
	
	public StarDatabaseCreds() {
		super("server.starnetworkmc.com", 3306, "star_net", "root", "Fcdytrff1!");
	}

}