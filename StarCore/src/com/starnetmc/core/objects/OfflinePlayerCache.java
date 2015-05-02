package com.starnetmc.core.objects;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

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
			
			player.setDisplayName(ChatColor.YELLOW + player.getName());
			player.setPlayerListName(player.getDisplayName());

			break;

		case "HELPER":
			
			staff.add(player.getName());
			player.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD
					+ "HELPER " + ChatColor.YELLOW + player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "MODERATOR":

			staff.add(player.getName());
			player.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "MOD "
					+ ChatColor.YELLOW + player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "ADMIN":

			staff.add(player.getName());
			player.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD
					+ "ADMIN " + ChatColor.YELLOW + player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "OWNER":

			staff.add(player.getName());
			player.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD
					+ "OWNER " + ChatColor.YELLOW + player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "YOUTUBE":
			player.setDisplayName(ChatColor.BOLD + "YOU" + ChatColor.RED + ""
					+ ChatColor.BOLD + "TUBE " + ChatColor.YELLOW
					+ player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "BUILDER":
			player.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD
					+ "BUILDER " + ChatColor.YELLOW + player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "DEVELOPER":

			staff.add(player.getName());
			player.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD
					+ "DEV " + ChatColor.YELLOW + player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;
		case "INVENTOR":
			player.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD
					+ "INVENTOR " + ChatColor.YELLOW + player.getName());
			player.setPlayerListName(player.getDisplayName());
			break;

		case "NULL":
			player.setDisplayName(ChatColor.YELLOW + player.getName()
					+ ChatColor.GRAY);
			Manager.createAccount(player);
			player.setPlayerListName(player.getDisplayName());
			break;
			
		case "(NULL)":
			player.setDisplayName(ChatColor.YELLOW + player.getName()
					+ ChatColor.GRAY);
			Manager.createAccount(player);
			player.setPlayerListName(player.getDisplayName());
			break;

		default:
			player.setDisplayName(ChatColor.YELLOW + player.getName()
					+ ChatColor.GRAY);
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
