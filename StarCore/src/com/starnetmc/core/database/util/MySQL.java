package com.starnetmc.core.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.plugin.java.JavaPlugin;

public class MySQL extends Database {
	
	private static String connectorFlags = "zeroDateTimeBehavior=convertToNull";
	
	private final String user;
	private final String database;
	private final String password;
	private final int port;
	private final String ip;

	public MySQL(JavaPlugin plugin, String hostname, int port, String database,
			String username, String password) {
		super(plugin);
		this.ip = hostname;
		this.port = port;
		this.database = database;
		this.user = username;
		this.password = password;
	}

	@Override
	public Connection openConnection() throws SQLException, ClassNotFoundException {
		if (checkConnection()) {
			return connection;
		}
		
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://"
				+ this.ip + ":" + this.port + "/" + this.database + "?" + connectorFlags,
				this.user, this.password);
		return connection;
	}
}