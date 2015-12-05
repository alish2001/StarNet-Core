package com.starnetmc.core.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.database.util.MySQL;
import com.starnetmc.core.punish.PunishType;
import com.starnetmc.core.punish.Punishment;
import com.starnetmc.core.util.Rank;
import com.starnetmc.core.util.UString;

public class Databaser {

	JavaPlugin main;
    public static MySQL db;

	public Databaser(JavaPlugin main, MySQL database) {
		this.main = main;
		db = database;
	}
	
	public Databaser(JavaPlugin main) {
		this.main = main;
	}
	
	public void deploy() throws Exception, SQLException, ClassNotFoundException {
		
		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		//UUID | Username | Rank | Shards
		Statement accountsTable = db.getConnection().createStatement();
		accountsTable.executeUpdate("CREATE TABLE IF NOT EXISTS Accounts("
				                  + "UUID varchar(36) PRIMARY KEY,"
				                  + "Username varchar(16) NOT NULL,"
				                  + "Rank varchar(16) NOT NULL,"
				                  + "Shards INT);");

		//Punished_UUID | Punisher_UUID | PunishmentType | PunishmentReason | PunishmentDate | PunishmentExpiryDate | Permanent | Remover_UUID | RemoveReason | RemoveDate
		Statement punishmentsTable = db.getConnection().createStatement();
		punishmentsTable.executeUpdate("CREATE TABLE IF NOT EXISTS Punishments("
				                     + "Punished_UUID varchar(36) NOT NULL,"
									 + "Punisher_UUID varchar(36) NOT NULL,"
									 + "PunishmentType varchar(16) NOT NULL,"
									 + "PunishmentReason TINYTEXT NOT NULL,"
									 + "PunishmentDate TIMESTAMP NOT NULL,"
									 + "PunishmentExpiryDate TIMESTAMP,"
									 + "Permanent BOOLEAN NOT NULL,"
									 + "Remover_UUID varchar(36),"
									 + "RemoveReason TINYTEXT,"
									 + "RemoveDate TIMESTAMP);");
		
		//Buyer_UUID | PurchaseName | PurchaseType | Cost | Date 
		Statement transactionsTable = db.getConnection().createStatement();
		transactionsTable.executeUpdate("CREATE TABLE IF NOT EXISTS Transactions("
				                       + "Buyer_UUID varchar(36),"
			                           + "PurchaseName varchar(64),"
				                       + "PurchaseType varchar (16),"
				                       + "Cost INT,"
			               	           + "Date TIMESTAMP);");
		
		//Words
		Statement filterTable = db.getConnection().createStatement();
		filterTable.executeUpdate("CREATE TABLE IF NOT EXISTS Filter("
				                 + "Word varchar(32));");

		//ID | Name | Type | ServerType | Location_World | Location_X | Location_Y | Location_Z
		Statement n = db.getConnection().createStatement();
		n.executeUpdate("CREATE TABLE IF NOT EXISTS NPCs ("
				      + "ID INT AUTO_INCREMENT PRIMARY KEY,"
				      + "Name TINYTEXT,"
				      + "Type varchar(32),"
				      + "ServerType varchar(16),"
				      + "Location_World varchar(32),"
				      + "Location_X DECIMAL,"
				      + "Location_Y DECIMAL,"
				      + "Location_Z DECIMAL"
				      + ");");
		
		db.closeConnection();
	}
	
	public void setup() throws Exception {
		
		String alisID = "f5738c50-ca61-44d7-af98-6b188e6285a1";
		
		if (!hasAccount(alisID)){
			createAccount(alisID, "alish2001", Rank.OWNER, 9000);
		}
	}
	
	//Accounts
	public static void createAccount(Player p, Rank rank, int shards) throws Exception {
		createAccount(p.getUniqueId().toString(), p.getName(), rank, shards);
	}
	
	public static void createAccount(String UUID, String username, Rank rank, int shards) throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		Statement creationStatement = db.getConnection().createStatement();
		creationStatement.executeUpdate("INSERT INTO Accounts(UUID, Username, Rank, Shards) VALUES ("
				                      + "'" + UUID + "'," + "'" + username + "'," + "'" + rank + "'," + "'" + shards + "'" + ");");
		db.closeConnection();
	}
	
	public static void setUsername(Player p) throws Exception {
		setUsername(p.getUniqueId().toString(), p.getName());
	}
	
	public static void setUsername(String UUID, String username) throws Exception {
		
		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		PreparedStatement nameStatement = db.getConnection().prepareStatement("UPDATE Accounts SET Username = " + "'" + username + "'" + " WHERE UUID = " + "'" + UUID + "';");
		nameStatement.execute();
		db.closeConnection();
	}
	
	public static void setRank(Player p, Rank rank) throws Exception {
		setRank(p.getUniqueId().toString(), rank);
	}
	
	public static void setRank(String UUID, Rank rank) throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		PreparedStatement rankStatement = db.getConnection().prepareStatement("UPDATE Accounts SET Rank = " + "'" + rank + "'" + " WHERE UUID = " + "'" + UUID + "';");
		rankStatement.execute();
		db.closeConnection();
	}
	
	public static void setShards(Player p, int shards) throws Exception {
		setShards(p.getUniqueId().toString(), shards);
	}
	
	public static void setShards(String UUID, int shards) throws Exception {
		
		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		PreparedStatement rankStatement = db.getConnection().prepareStatement("UPDATE Accounts SET Shards = " + "'" + shards + "'" + " WHERE UUID = " + "'" + UUID + "';");
		rankStatement.execute();
		db.closeConnection();
	}
	
	public static String getUUID(String username) throws Exception {
		
		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		Statement uuidStatement = db.getConnection().createStatement();
		ResultSet uuid = uuidStatement.executeQuery("SELECT * FROM Accounts WHERE Username = " + "'" + username + "';");
		String retrieved_uuid = "";
		
		while(uuid.next()){
		   retrieved_uuid = uuid.getString("UUID");
		}
		
		db.closeConnection();
		return retrieved_uuid;
	}
	
	public static String getUsername(String UUID) throws Exception {
		
		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		Statement nameStatement = db.getConnection().createStatement();
		ResultSet name = nameStatement.executeQuery("SELECT * FROM Accounts WHERE UUID = " + "'" + UUID + "';");
		String username = "";
		
		while(name.next()){
		    username = name.getString("Username");
	    }
		
		db.closeConnection();
		return username;
	}
	
	public static Rank getRank(String UUID) throws Exception {
		
		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		Statement rankStatement = db.getConnection().createStatement();
		ResultSet rank = rankStatement.executeQuery("SELECT * FROM Accounts WHERE UUID = " + "'" + UUID + "';");
		
		Rank r = Rank.DEFAULT;
		
		while(rank.next()){
	       r = Rank.getRankFromString(rank.getString("Rank"));
		}
		
		db.closeConnection();
		return r;
	}
	
	public static int getShards(String UUID) throws Exception {
		
		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		Statement nameStatement = db.getConnection().createStatement();
		ResultSet shards = nameStatement.executeQuery("SELECT * FROM Accounts WHERE UUID = " + "'" + UUID + "';");
		
		int shardBalance = 0;
		
		while(shards.next()){
			shardBalance = shards.getInt("Shards");
		}
		
		db.closeConnection();
		return shardBalance;
	}
	
	public static boolean hasAccount(String UUID) throws Exception {
		
		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		Statement nameStatement = db.getConnection().createStatement();
		ResultSet name = nameStatement.executeQuery("SELECT * FROM Accounts WHERE UUID = " + "'" + UUID + "';");
		
		if (!name.next()){
			
			db.closeConnection();
			return false;
		} else {
			
			db.closeConnection();
			return true;
		}
	}
	
	public static boolean usernameHasAccount(String username) throws Exception {
		
		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		Statement nameStatement = db.getConnection().createStatement();
		ResultSet name = nameStatement.executeQuery("SELECT * FROM Accounts WHERE Username = " + "'" + username + "';");
		
		if (!name.next()){
			
			db.closeConnection();
			return false;
		} else {
			
			db.closeConnection();
			return true;
		}
	}
	
	
	//Punishments
	public static void executePunishment(Punishment p) throws Exception {
		
		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		Statement punishment = db.getConnection().createStatement();
		punishment.executeUpdate("INSERT INTO Punishments(Punished_UUID, Punisher_UUID, PunishmentType, PunishmentReason, PunishmentDate, PunishmentExpiryDate, Permanent)"
				              + " VALUES ("
				              + "'" + p.getPunished() + "',"
				              + "'" + p.getPunisher() + "',"
				              + "'" + p.getType() + "',"
				              + "'" + p.getReason() + "',"
				              + "'" + p.getExecutionTime() + "',"
				              + "'" + p.getExpiryDate() + "',"
				              + "'" + UString.booleanToNumericalString(p.getPerm()) + "'"
				              + ");");
		db.closeConnection();
	}
	
	public static List<Punishment> getPunishments(String UUID) throws Exception {
		
		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		List<Punishment> punishments = new ArrayList<Punishment>();
		
		Statement checkQuery = db.getConnection().createStatement();
		ResultSet punishSet = checkQuery.executeQuery("SELECT * FROM Punishments WHERE Punished_UUID = " + "'" + UUID + "'" + "ORDER BY PunishmentDate DESC;");
		
		while(punishSet.next()){
			punishments.add(new Punishment(punishSet.getString("Punished_UUID"), punishSet.getString("Punisher_UUID"), punishSet.getString("PunishmentReason"), punishSet.getString("Remover_UUID"), punishSet.getString("RemoveReason"), punishSet.getTimestamp("RemoveDate"), punishSet.getTimestamp("PunishmentDate"), punishSet.getTimestamp("PunishmentExpiryDate").getTime() - punishSet.getTimestamp("PunishmentDate").getTime(), punishSet.getBoolean("Permanent"), PunishType.getPunishmentTypeFromString(punishSet.getString("PunishmentType"))));
		}
		
		
		db.closeConnection();
		return punishments;
	}
	
	public static Punishment getLastestActivePunishment(String UUID, PunishType type) throws Exception {
		
		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		Statement checkQuery = db.getConnection().createStatement();
		ResultSet punishSet = checkQuery.executeQuery("SELECT * FROM Punishments WHERE Punished_UUID = " + "'" + UUID + "'" + " AND PunishmentType = " + "'" + type + "'" + " AND Remover_UUID IS NULL AND (TIMESTAMPDIFF(SECOND, now(), PunishmentExpiryDate) > -1 OR Permanent = true) ORDER BY PunishmentDate DESC LIMIT 1;");
		
		Punishment p = null;
		
		while(punishSet.next()){
		    p = new Punishment(punishSet.getString("Punished_UUID"), punishSet.getString("Punisher_UUID"), punishSet.getString("PunishmentReason"), punishSet.getString("Remover_UUID"), punishSet.getString("RemoveReason"), punishSet.getTimestamp("RemoveDate"), punishSet.getTimestamp("PunishmentDate"), punishSet.getTimestamp("PunishmentExpiryDate").getTime() - punishSet.getTimestamp("PunishmentDate").getTime(), punishSet.getBoolean("Permanent"), PunishType.getPunishmentTypeFromString(punishSet.getString("PunishmentType")));
		}
		
		
		db.closeConnection();
		return p;
	}
	
	public static void removePunishment(Punishment p) throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		PreparedStatement punishment = db.getConnection().prepareStatement("UPDATE Punishments SET Remover_UUID = " + "'" + p.getRemover() + "'," +" RemoveReason = " + "'" + p.getRemovalReason() + "'," + " RemoveDate = " + "'" + p.getRemovalTime() + "' WHERE Punished_UUID = " + "'" + p.getPunished() + "'" + ";");
		punishment.execute();
		db.closeConnection();
	}
	
	public static boolean isPunished(String UUID, PunishType type) throws Exception {
		
		if (!db.checkConnection()) {
			db.openConnection();
		}
		
		Statement checkQuery = db.getConnection().createStatement();
		ResultSet punishSet = checkQuery.executeQuery("SELECT * FROM Punishments WHERE Punished_UUID = " + "'" + UUID + "'" + " AND PunishmentType = " + "'" + type + "'" + " AND Remover_UUID IS NULL AND (TIMESTAMPDIFF(SECOND, now(), PunishmentExpiryDate) > -1 OR Permanent = true);");
		
		if (!punishSet.next()){
			db.closeConnection();
			return false;
		}
		
		db.closeConnection();
		return true;
	}

	//Filter
	public static void addWordToFilter(String word) throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		Statement addWordStatement = db.getConnection().createStatement();
		addWordStatement.executeUpdate("INSERT INTO Filter(Word) VALUES (" + "'" + word + "'" + ");");
		
		db.closeConnection();
	}
	
	public static List<String> downloadFilter() throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		List<String> words = new ArrayList<String>();

		Statement downloadStatement = db.getConnection().createStatement();
		ResultSet wordList = downloadStatement.executeQuery("SELECT * FROM Filter");

		while (wordList.next()) {
			words.add(wordList.getString("Word").toLowerCase());
		}
		
		db.closeConnection();
		return words;

	}

	// Start NPC Code
	public static LinkedHashMap<String, Location> downloadVillagerNPCs()
			throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		LinkedHashMap<String, Location> npcs = new LinkedHashMap<String, Location>();

		Statement s = db.getConnection().createStatement();
		ResultSet rs = s
				.executeQuery("SELECT * FROM `NPCs` WHERE `NPCType`='VILLAGER'");

		while (rs.next()) {

			npcs.put(
					rs.getString("Name"),
					new Location(Bukkit.getWorld(rs.getString("World")), rs
							.getInt("x"), rs.getInt("y"), rs.getInt("z")));
		}

		return npcs;

	}

	public static LinkedHashMap<String, Location> downloadPigNPCs()
			throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		LinkedHashMap<String, Location> npcs = new LinkedHashMap<String, Location>();

		Statement s = db.getConnection().createStatement();
		ResultSet rs = s
				.executeQuery("SELECT * FROM `NPCs` WHERE `NPCType`='PIG'");

		while (rs.next()) {

			npcs.put(
					rs.getString("Name"),
					new Location(Bukkit.getWorld(rs.getString("World")), rs
							.getInt("x"), rs.getInt("y"), rs.getInt("z")));
		}

		return npcs;

	}

	public static LinkedHashMap<String, Location> downloadSkeletonNPCs()
			throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		LinkedHashMap<String, Location> npcs = new LinkedHashMap<String, Location>();

		Statement s = db.getConnection().createStatement();
		ResultSet rs = s
				.executeQuery("SELECT * FROM `NPCs` WHERE `NPCType`='SKELETON'");

		while (rs.next()) {

			npcs.put(
					rs.getString("Name"),
					new Location(Bukkit.getWorld(rs.getString("World")), rs
							.getInt("x"), rs.getInt("y"), rs.getInt("z")));
		}

		return npcs;

	}

	public static LinkedHashMap<String, Location> downloadSlimeNPCs()
			throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		LinkedHashMap<String, Location> npcs = new LinkedHashMap<String, Location>();

		Statement s = db.getConnection().createStatement();
		ResultSet rs = s
				.executeQuery("SELECT * FROM `NPCs` WHERE `NPCType`='SLIME'");

		while (rs.next()) {

			npcs.put(
					rs.getString("Name"),
					new Location(Bukkit.getWorld(rs.getString("World")), rs
							.getInt("x"), rs.getInt("y"), rs.getInt("z")));
		}

		return npcs;

	}

	public static LinkedHashMap<String, Location> downloadZombieNPCs()
			throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		LinkedHashMap<String, Location> npcs = new LinkedHashMap<String, Location>();

		Statement s = db.getConnection().createStatement();
		ResultSet rs = s
				.executeQuery("SELECT * FROM `NPCs` WHERE `NPCType`='ZOMBIE'");

		while (rs.next()) {

			npcs.put(
					rs.getString("Name"),
					new Location(Bukkit.getWorld(rs.getString("World")), rs
							.getInt("x"), rs.getInt("y"), rs.getInt("z")));
		}

		return npcs;

	}

	public static void createNPC(String name, String entitytype, Location loc)
			throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		Statement s = db.getConnection().createStatement();
		s.execute("INSERT INTO `NPCs` (`Name`,`NPCType`,`World`,`x`,`y`,`z`) VALUES ('"
				+ name
				+ "','"
				+ entitytype
				+ "','"
				+ loc.getWorld().getName()
				+ "','"
				+ loc.getX()
				+ "','"
				+ loc.getY()
				+ "','"
				+ loc.getZ()
				+ "');");

	}

	public static void deleteNPC(String name) throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		Statement s = db.getConnection().createStatement();
		s.executeUpdate("DELETE FROM `NPCs` WHERE `Name`='" + name
				+ " ';");

	}


}