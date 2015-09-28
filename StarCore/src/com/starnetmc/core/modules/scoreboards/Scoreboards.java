package com.starnetmc.core.modules.scoreboards;

import java.util.List;
import java.util.Map.Entry;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.events.UpdateEvent;
import com.starnetmc.core.modules.manager.Module;
import com.starnetmc.core.modules.manager.ModuleType;
import com.starnetmc.core.util.StarMap;
import com.starnetmc.core.util.UpdateType;

public class Scoreboards extends Module {

	JavaPlugin plugin;
	private static StarMap<Player, StarBoard> boards = new StarMap<Player, StarBoard>();

	public Scoreboards(JavaPlugin plugin) {
		super("Scoreboard Manager", 0.5, ModuleType.INFO, plugin);
	}

	public Scoreboards() {
	}
	
	@EventHandler
	public void update(UpdateEvent e) throws Exception {
		if (e.getType() == UpdateType.SECOND) {
			for(Entry<Player, StarBoard> b : boards.entrySet()) {
				if(!b.getKey().isOnline()) {
					boards.remove(b.getKey());
				}
			}
		}
	}

	@Override
	public void enable() {
		isEnabled = true;
		log("Enabled.");
	}

	@Override
	public void addCommands() {
		//Nothing here ;o
	}

	@Override
	public void disable() {
		isEnabled = false;
		log("Disabled.");
	}

	public static boolean isEnabled;
	
	public boolean hasScoreboard(Player p) {
		return boards.containsKey(p);
	}
	
	public void removeScoreboard(Player p) {
		if(hasScoreboard(p)) {
			boards.get(p).resetScores();
			boards.remove(p);
		}
	}
	
	public void updateScoreboard(Player p, List<String> lines) {
		if(hasScoreboard(p)) {
			int current = 1;
			
			for(String s : lines) {
				getScoreboard(p).setLine(current, s);
				
				current++;
			}
			
			getScoreboard(p).update();
		}
	}
	
	public void updateScoreboard(Player p, int line, String replace) {
		if(hasScoreboard(p)) {
			getScoreboard(p).setLine(line, replace);
			
			getScoreboard(p).update();
		}
	}
	
	public void setScoreboardTitle(Player p, String title) {
		if(hasScoreboard(p)) {
			getScoreboard(p).setDisplayName(title);
		}
	}
	
	public void createScoreboard(StarBoard scoreboard, Player p) {
		removeScoreboard(p);
		
		boards.put(p, new HubStarBoard(p, null));
	}
	
	public void createScoreboard(Player p, boolean useDefault) {
		removeScoreboard(p);
		
		StarBoard board = new HubStarBoard(p, "Scoreboard");
		
		if(useDefault) {
		/*	board.setDisplayName(F.boldAqua + "The Star Network");
			
			board.setLine(12, F.boldYellow + "RANK:");
			board.setLine(11, "> " + AccountManager.getAccount(p).getRank().getTag(false));
			board.setBlank(10);
			board.setLine(9, F.boldPurple + "SHARDS:");
			board.setLine(8, "> " + F.boldYellow + AccountManager.getAccount(p).getShards());
			board.setBlank(7);
			board.setLine(6, F.boldYellow + "WEBSITE:");
			board.setLine(5, "> " + F.GREEN + "www.StarNetMC.com");
			board.setBlank(4);
			board.setLine(3, F.boldYellow + "ONLINE STAFF:");
			board.setLine(2, "> " + F.GREEN + AccountManager.getStaff().size());
			board.setLine(1, F.strikeGreen + "--------------");*/
		} else {
			board.setLine(1, "&b");
		}

		board.build();
		board.send();
		
		boards.put(p, board);
	}
	
	public StarBoard getScoreboard(Player p) {
		return boards.get(p);
	}
}