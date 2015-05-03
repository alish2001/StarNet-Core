package com.starnetmc.core.modules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.objects.OfflinePlayerCache;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class LScoreboard implements Module, Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public void onStaffJoin(PlayerJoinEvent e) throws Exception {

		updateScoreboard();

	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onStaffLeave(PlayerQuitEvent e) throws Exception {
		updateScoreboard();
	}

	private void updateScoreboard() throws Exception {

		for (Player player : Bukkit.getOnlinePlayers()) {

			Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
			Objective obj = sb.registerNewObjective("info", "dummy");
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			obj.setDisplayName(F.boldAqua + "The Star Network");

			switch (Manager.getRank(player.getUniqueId().toString())) {

			case "DEFAULT":
				Score beg = obj.getScore(F.GREEN + "--------------");
				beg.setScore(14);
				Score whsp = obj.getScore(ChatColor.RESET.toString());
				whsp.setScore(13);
				Score rank1 = obj.getScore(F.boldYellow + "RANK:");
				rank1.setScore(12);
				Score rank = obj.getScore(F.BOLD + "> NO RANK");
				rank.setScore(11);
				break;
			case "HELPER":
				Score beg2 = obj.getScore(F.GREEN + "--------------");
				beg2.setScore(14);
				Score whsp2 = obj.getScore(ChatColor.RESET.toString());
				whsp2.setScore(13);
				Score rank2 = obj.getScore(F.boldYellow + "RANK:");
				rank2.setScore(12);
				Score rankh = obj.getScore(F.boldGreen + "> HELPER");
				rankh.setScore(11);
				break;
			case "MODERATOR":
				Score beg3 = obj.getScore(F.GREEN + "--------------");
				beg3.setScore(14);
				Score whsp3 = obj.getScore(ChatColor.RESET.toString());
				whsp3.setScore(13);
				Score rank3 = obj.getScore(F.boldYellow + "RANK:");
				rank3.setScore(12);
				Score rankm = obj.getScore(F.boldGold + "> MOD");
				rankm.setScore(11);
				break;
			case "ADMIN":
				Score beg4 = obj.getScore(F.GREEN + "--------------");
				beg4.setScore(14);
				Score whsp4 = obj.getScore(ChatColor.RESET.toString());
				whsp4.setScore(13);
				Score rank4 = obj.getScore(F.boldYellow + "RANK:");
				rank4.setScore(12);
				Score ranka = obj.getScore(F.boldRed + "> ADMIN");
				ranka.setScore(11);
				break;
			case "OWNER":
				Score beg5 = obj.getScore(F.GREEN + "--------------");
				beg5.setScore(14);
				Score whsp5 = obj.getScore(ChatColor.RESET.toString());
				whsp5.setScore(13);
				Score rank5 = obj.getScore(F.boldYellow + "RANK:");
				rank5.setScore(12);
				Score ranko = obj.getScore(F.boldDR + "> OWNER");
				ranko.setScore(11);
				break;
			case "DEVELOPER":
				Score beg6 = obj.getScore(F.GREEN + "--------------");
				beg6.setScore(14);
				Score whsp6 = obj.getScore(ChatColor.RESET.toString());
				whsp6.setScore(13);
				Score rank6 = obj.getScore(F.boldYellow + "RANK:");
				rank6.setScore(12);
				Score rankd = obj.getScore(F.boldDA + "> DEV");
				rankd.setScore(11);
				break;
			case "YOUTUBE":
				Score beg7 = obj.getScore(F.GREEN + "--------------");
				beg7.setScore(14);
				Score whsp7 = obj.getScore(ChatColor.RESET.toString());
				whsp7.setScore(13);
				Score rank7 = obj.getScore(F.boldYellow + "RANK:");
				rank7.setScore(12);
				Score ranky = obj.getScore(F.boldRed + "> YOUTUBER");
				ranky.setScore(11);
				break;
			case "BUILDER":
				Score beg8 = obj.getScore(F.GREEN + "--------------");
				beg8.setScore(14);
				Score whsp8 = obj.getScore(ChatColor.RESET.toString());
				whsp8.setScore(13);
				Score rank8 = obj.getScore(F.boldYellow + "RANK:");
				rank8.setScore(12);
				Score rankb = obj.getScore(F.boldBlue + "> BUILDER");
				rankb.setScore(11);
				break;
			default:
				Score ranke = obj.getScore(F.BOLD + "> NO RANK");
				ranke.setScore(11);
				break;

			}

			Score whsp2 = obj.getScore(ChatColor.RESET.toString() + "");
			whsp2.setScore(10);

			Score _shard = obj.getScore(F.boldYellow + "SHARDS:");
			_shard.setScore(9);
			Score com = obj.getScore(F.WHITE+"- "+F.GOLD + Manager.getShards(player.getUniqueId().toString()));
			com.setScore(8);

			Score whsp3 = obj.getScore(ChatColor.RESET.toString() + ""
					+ ChatColor.RESET.toString());
			whsp3.setScore(7);

			Score web = obj.getScore(F.boldYellow + "WEBSITE:");
			web.setScore(6);
			Score weba = obj.getScore(F.WHITE + "- " + F.GREEN
					+ "www.starnetmc.com");
			weba.setScore(5);

			Score whsp4 = obj.getScore(ChatColor.RESET.toString()
					+ ChatColor.RESET.toString() + ""
					+ ChatColor.RESET.toString());
			whsp4.setScore(4);

			Score whsp5 = obj.getScore(F.boldYellow + "STAFF:");
			whsp5.setScore(3);

			Score whsp6 = obj.getScore(F.WHITE + "- " + F.GREEN
					+ OfflinePlayerCache.getStaff());
			whsp6.setScore(2);

			Score end = obj.getScore(F.GREEN + "--------------");
			end.setScore(1);

			player.setScoreboard(sb);

		}

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Scoreboard Manager";
	}

	

	@Override
	public ModuleType getType(ModuleType mt) {
		// TODO Auto-generated method stub
		return ModuleType.INFO;
	}

	@Override
	public double getVersion() {
		
		return 1.0;
		
	}

	@Override
	public void enable() {
		System.out.println("<Scoreboard> "+getVersion()+" enabled.");

	}

	@Override
	public void disable() {
		System.out.println("<Scoreboard> "+getVersion()+" disabled.");

	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean setEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		return isEnabled() == arg0;
	}

}
