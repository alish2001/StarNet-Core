package com.starnetmc.core.modules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import com.starnetmc.core.events.UpdateEvent;
import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.objects.OfflinePlayerCache;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;
import com.starnetmc.core.util.UpdateType;

public class LScoreboard extends Module {

	
	public LScoreboard(JavaPlugin plugin) {
		
		super("Hub Scoreboard",1.0,ModuleType.INFO,plugin);
		
		
	}
	
	@EventHandler
	public void updateJoin(PlayerJoinEvent e) throws Exception {
		updateScoreboard();
	}
	
	@EventHandler
	public void update(UpdateEvent e) throws Exception {
		if(e.getType() == UpdateType.SHORT) {
			updateScoreboard();
		}
	}
	
	private void updateScoreboard() throws Exception {

		for (Player player : Bukkit.getOnlinePlayers()) {

			Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
			Objective obj = sb.registerNewObjective("info", "dummy");
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			obj.setDisplayName(F.boldAqua + "The Star Network");

			switch (Manager.getRank(player.getUniqueId().toString())) {

			case "DEFAULT":
				Score rank1 = obj.getScore(F.boldYellow + "RANK:");
				rank1.setScore(12);
				Score rank = obj.getScore("> " + F.BOLD + "NO RANK");
				rank.setScore(11);
				break;
			case "HELPER":
				Score rank2 = obj.getScore(F.boldYellow + "RANK:");
				rank2.setScore(12);
				Score rankh = obj.getScore("> " + F.boldGreen + "HELPER");
				rankh.setScore(11);
				break;
			case "MODERATOR":
				Score rank3 = obj.getScore(F.boldYellow + "RANK:");
				rank3.setScore(12);
				Score rankm = obj.getScore("> " + F.boldGold + "MOD");
				rankm.setScore(11);
				break;
			case "ADMIN":
				Score rank4 = obj.getScore(F.boldYellow + "RANK:");
				rank4.setScore(12);
				Score ranka = obj.getScore("> " + F.boldRed + "ADMIN");
				ranka.setScore(11);
				break;
			case "OWNER":
				Score rank5 = obj.getScore(F.boldYellow + "RANK:");
				rank5.setScore(12);
				Score ranko = obj.getScore("> " + F.boldDR + "OWNER");
				ranko.setScore(11);
				break;
			case "DEVELOPER":
				Score rank6 = obj.getScore(F.boldYellow + "RANK:");
				rank6.setScore(12);
				Score rankd = obj.getScore("> " + F.boldDP + "DEV");
				rankd.setScore(11);
				break;
			case "YOUTUBE":
				Score rank7 = obj.getScore(F.boldYellow + "RANK:");
				rank7.setScore(12);
				Score ranky = obj.getScore("> " + F.boldRed + "YOUTUBER");
				ranky.setScore(11);
				break;
			case "BUILDER":
				Score rank8 = obj.getScore(F.boldYellow + "RANK:");
				rank8.setScore(12);
				Score rankb = obj.getScore("> " + F.boldBlue + "BUILDER");
				rankb.setScore(11);
				break;
			case "VIP":
				Score rank10 = obj.getScore(F.boldYellow + "RANK:");
				rank10.setScore(12);
				Score rankv = obj.getScore("> " + F.boldDA + "VIP");
				rankv.setScore(11);
				break;
			case "MVP":
				Score rank9 = obj.getScore(F.boldYellow + "RANK:");
				rank9.setScore(12);
				Score rankmv = obj.getScore("> " + F.boldAqua + "MVP");
				rankmv.setScore(11);
				break;

			default:
				Score ranke = obj.getScore(F.boldYellow + "RANK:");
				ranke.setScore(12);
				Score rankea = obj.getScore("> " + F.BOLD + "NO RANK");
				rankea.setScore(12);
				break;

			}

			Score whsp2 = obj.getScore(ChatColor.RESET.toString() + "");
			whsp2.setScore(10);

			Score _shard = obj.getScore(F.boldYellow + "SHARDS:");
			_shard.setScore(9);
			Score com = obj.getScore(F.WHITE + "> " + F.GOLD
					+ Manager.getShards(player.getUniqueId().toString()));
			com.setScore(8);

			Score whsp3 = obj.getScore(ChatColor.RESET.toString() + ""
					+ ChatColor.RESET.toString());
			whsp3.setScore(7);

			Score web = obj.getScore(F.boldYellow + "WEBSITE:");
			web.setScore(6);
			Score weba = obj.getScore(F.WHITE + "> " + F.GREEN
					+ "www.starnetmc.com");
			weba.setScore(5);

			Score whsp4 = obj.getScore(ChatColor.RESET.toString()
					+ ChatColor.RESET.toString() + ""
					+ ChatColor.RESET.toString());
			whsp4.setScore(4);

			Score whsp5 = obj.getScore(F.boldYellow + "STAFF:");
			whsp5.setScore(3);

			Score whsp6 = obj.getScore(F.WHITE + "> " + F.GREEN
					+ OfflinePlayerCache.getStaff());
			whsp6.setScore(2);

			Score end = obj.getScore(F.GREEN + "--------------");
			end.setScore(1);

			player.setScoreboard(sb);

		}

	}



	@Override
	public void enable() {
		isEnabled = true;
		try {
			updateScoreboard();
		}
		catch(Exception e) {
			
		}
		
		log("Enabled.");
		

	}

	@Override
	public void disable() {
		isEnabled = false;
		try {
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.setScoreboard(Bukkit.getScoreboardManager()
						.getNewScoreboard());
			}
		} catch (Exception e) {

		}
		log("Disabled.");

	}

	public static boolean isEnabled = true;

	

}
