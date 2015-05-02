package com.starnetmc.core.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;

import com.starnetmc.core.Main;
import com.starnetmc.core.objects.Rank;

public class Manager {

	Main main;
	public static MySQL db;

	public Manager(Main h) {
		this.main = h;
	}

	public void setupDB() throws SQLException, ClassNotFoundException {
		Manager.db = new MySQL(Main.getPlugin(), "69.175.126.226", "3306",
				"mc85490", "mc85490", "221cb17d61");
		Manager.db.openConnection();

		Statement a = db.getConnection().createStatement();
		a.executeUpdate("CREATE TABLE IF NOT EXISTS `Accounts` (`id` INT NOT NULL AUTO_INCREMENT,`Name` varchar(64),`UUID` MEDIUMTEXT, `Shards` INT, `Rank` varchar(32), `firstLogin` LONG, `lastLogin` LONG, `totalPlayTime` INT, PRIMARY KEY (`id`));");

		Statement p = db.getConnection().createStatement();
		p.executeUpdate("CREATE TABLE IF NOT EXISTS `Punishments` (`id` INT NOT NULL AUTO_INCREMENT,`UUID` MEDIUMTEXT, `PunishType` varchar(32), `PunishReason` MEDIUMTEXT,`PunishPerm` BOOL, `PunishExpire` LONG, PRIMARY KEY (`id`));");

		Statement pp = db.getConnection().createStatement();
		pp.executeUpdate("CREATE TABLE IF NOT EXISTS `PastPunishments` (`id` INT NOT NULL AUTO_INCREMENT,`UUID` MEDIUMTEXT, `PunishmentType` varchar(32), `PunishRemover` MEDIUMTEXT, `RemoveReason` MEDIUMTEXT, PRIMARY KEY (`id`));");

	}

	public static boolean hasAccount(String uuid) throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		Statement s = db.getConnection().createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM `Accounts` WHERE `UUID`='"
				+ uuid + "';");

		if (!rs.next()) {
			return false;
		} else {
			return true;
		}

	}

	public static void createAccount(Player player) throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		String name = player.getName();
		String uuid = player.getUniqueId().toString();

		Statement s = db.getConnection().createStatement();
		s.executeUpdate("INSERT INTO `Accounts` (`Name`,`UUID`,`Shards`,`Rank`,`firstLogin`,`lastLogin`,`totalPlayTime`) VALUES ('"
				+ name + "','" + uuid + "','200','DEFAULT',now(),now(),'0');");

	}

	public static String getRank(String uuid) throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		Statement s = db.getConnection().createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM `Accounts` WHERE UUID='"
				+ uuid + "';");

		if (!rs.next()) {
			return "DEFAULT";
		}
		return rs.getString("Rank");

	}

	public static void setRank(String uuid, Rank rank) throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE `Accounts` SET `Rank`='" + rank
				+ "' WHERE `UUID`='" + uuid + "';");

	}

	public static int getShards(String uuid) throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		Statement s = db.getConnection().createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM `Accounts` WHERE `UUID`='"
				+ uuid + "';");

		if (!rs.next()) {
			return 0;
		} else {
			return rs.getInt("Shards");
		}

	}

	public static void setShards(String uuid, int amount) throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}

		Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE `Accounts` SET `Shards`='"
				+ (getShards(uuid) + amount) + "' WHERE `UUID`='" + uuid + "';");

	}

	public static void setLastLogin(String uuid) throws Exception {

		if (!db.checkConnection()) {
			db.openConnection();
		}
		Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE `Accounts` SET `lastLogin`='now()' WHERE `UUID`='"
				+ uuid + "';");
	}

}
