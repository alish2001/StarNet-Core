package com.starnetmc.core.objects;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class OfflinePlayerCache extends java.lang.Object {

	static Player player;
	static String uuid;
	static String rank;
	static int shards;

	public static List<OfflinePlayerCache> players = new ArrayList<OfflinePlayerCache>();
	public static List<String> staff = new ArrayList<String>();

	public OfflinePlayerCache(Player player, String uuid, String rank,
			int shards) {

		OfflinePlayerCache.player = player;
		OfflinePlayerCache.uuid = uuid;
		OfflinePlayerCache.rank = rank;
		OfflinePlayerCache.shards = shards;

	}

	public static void addPlayer(Player player) throws Exception {

		String uuid = player.getUniqueId().toString();

		OfflinePlayerCache e = new OfflinePlayerCache(player, uuid,
				Manager.getRank(uuid), Manager.getShards(uuid));

		players.add(e);
	}

	public static String getRank(Player player) throws Exception {

		return rank;

	}

	public static void setRank(Player player) throws Exception {

		switch (Manager.getRank(player.getUniqueId().toString())) {

		case "DEFAULT":

			player.setDisplayName(F.YELLOW + player.getName());
			player.setPlayerListName(player.getDisplayName());

			break;

		case "HELPER":

			staff.add(player.getName());
			player.setDisplayName(F.GREEN + "" + F.BOLD + "HELPER " + F.YELLOW
					+ player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "MODERATOR":

			staff.add(player.getName());
			player.setDisplayName(F.GOLD + "" + F.BOLD + "MOD " + F.YELLOW
					+ player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "ADMIN":

			staff.add(player.getName());
			player.setDisplayName(F.RED + "" + F.BOLD + "ADMIN " + F.YELLOW
					+ player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "OWNER":

			staff.add(player.getName());
			player.setDisplayName(F.DARK_RED + "" + F.BOLD + "OWNER "
					+ F.YELLOW + player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "YOUTUBE":
			player.setDisplayName(F.BOLD + "YOU" + F.RED + "" + F.BOLD
					+ "[TUBE] " + F.YELLOW + player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "BUILDER":
			player.setDisplayName(F.BLUE + "" + F.BOLD + "BUILDER " + F.YELLOW
					+ player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "DEVELOPER":

			staff.add(player.getName());
			player.setDisplayName(F.DARK_PURPLE + "" + F.BOLD + "DEV "
					+ F.YELLOW + player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "VIP":

			player.setDisplayName(F.boldDA + "VIP " + F.YELLOW
					+ player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "MVP":

			player.setDisplayName(F.AQUA + "" + F.BOLD + "MVP " + F.YELLOW
					+ player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "NULL":
			player.setDisplayName(F.YELLOW + player.getName() + F.GRAY);
			Manager.createAccount(player);
			player.setPlayerListName(player.getDisplayName());
			break;

		case "(NULL)":
			player.setDisplayName(F.YELLOW + player.getName() + F.GRAY);
			Manager.createAccount(player);
			player.setPlayerListName(player.getDisplayName());
			break;

		default:
			player.setDisplayName(F.YELLOW + player.getName() + F.GRAY);
			Manager.createAccount(player);
			player.setPlayerListName(player.getDisplayName());
			break;

		}

	}

	public static int getShards(Player player) throws Exception {

		return shards;
	}

	public static void setShards(Player player) throws Exception {

		shards = Manager.getShards(player.getUniqueId().toString());

	}

	public static int getStaff() {

		return staff.size();

	}

}
