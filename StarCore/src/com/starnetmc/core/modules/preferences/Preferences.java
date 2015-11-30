package com.starnetmc.core.modules.preferences;

import java.util.ArrayList;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.modules.manager.Module;
import com.starnetmc.core.modules.manager.ModuleType;
import com.starnetmc.core.modules.preferences.GUI.PrefUI;
import com.starnetmc.core.modules.preferences.events.PlayerPrefrenceStateChangeEvent;
import com.starnetmc.core.modules.preferences.prefs.Pref_Build;
import com.starnetmc.core.modules.preferences.prefs.Pref_Chat;
import com.starnetmc.core.modules.preferences.prefs.Pref_MSG;
import com.starnetmc.core.modules.preferences.prefs.Pref_Visiblity;
import com.starnetmc.core.util.Logger;
import com.starnetmc.core.util.StarMap;

public class Preferences extends Module {

	public static StarMap<String, ArrayList<Pref>> playerPrefs = new StarMap<String, ArrayList<Pref>>();

	public Preferences(JavaPlugin plugin) {
		super("Preference", 1.0, ModuleType.SERVER, plugin);
	}

	public Preferences() {

	}

	@EventHandler
	public void preferizer(PlayerJoinEvent e){
		createUserPrefData(e.getPlayer());
	}
	
	@EventHandler
	public void dePreferizer(PlayerQuitEvent e){
		removeUser(e.getPlayer());
	}
	
	public static ArrayList<Pref> getDefaultPrefs(){
		ArrayList<Pref> prefs = new ArrayList<Pref>();
		prefs.add(new Pref_Chat());
		prefs.add(new Pref_MSG());
		prefs.add(new Pref_Visiblity());
		prefs.add(new Pref_Build());
		return prefs;
	}
	
	public static ArrayList<Pref> getAdminPrefs(){
		ArrayList<Pref> prefs = new ArrayList<Pref>();
		prefs.add(new Pref_Build());
		return prefs;
	}
	
	public static void setPrefState(Player p, Pref pref, boolean state){
		setPrefState(p, pref.getName(), state);
	}
	
	public static void setPrefState(Player p, String prefName, boolean state){
		Logger.log("Changing pref " + prefName + " to state " + state);
		getPref(p, prefName).setActive(state);
		Bukkit.getServer().getPluginManager().callEvent(new PlayerPrefrenceStateChangeEvent(p, getPref(p, prefName)));
	}
	
	public static ArrayList<Player> getPrefPlayers(Pref pref, boolean state){
		return getPrefPlayers(pref.getName(), state);
	}
	
	public static ArrayList<Player> getPrefPlayers(String prefName, boolean state){
		ArrayList<Player> activePlayers = new ArrayList<Player>();
		for (Player p : Bukkit.getOnlinePlayers()){
			if (getPref(p, prefName).isActive() != state) continue;
			activePlayers.add(p);
		}
		
		return activePlayers;
	}
	
	public static Pref getPref(Player p, Pref pref){
		getPref(p, pref.getName());
		return pref;
	}
	
	public static Pref getPref(Player p, String prefName){
		if (!getPrefData().containsKey(p.getUniqueId().toString())) return null;
		
		boolean indexFound = false;
		int indexLoc = 0;
		int finalIndexLoc = 0;
		
		for (Pref pref : getPrefs(p)){
			if (indexFound) continue;
			
			if (!ChatColor.stripColor(prefName).equalsIgnoreCase(ChatColor.stripColor(pref.getName()))){
				indexLoc++;
				
			} else {
				finalIndexLoc = indexLoc;
				indexFound = true;
			}
		}
		
		//Check for pref nullness.
		Pref pref = getPrefs(p).get(finalIndexLoc);
		
		return pref;
	}
	
	public static ArrayList<Pref> getPrefs(Player p) {
		return playerPrefs.get(p.getUniqueId().toString());
	}

	public static void createUserPrefData(Player player) {
		getPrefData().put(player.getUniqueId().toString(), getDefaultPrefs());
	}

	public static StarMap<String, ArrayList<Pref>> getPrefData() {
		return playerPrefs;
	}

	public static void removeUser(Player player) {
		getPrefData().remove(player.getUniqueId().toString());
	}

	@Override
	public void enable() {
		isEnabled = true;
		Bukkit.getServer().getPluginManager().registerEvents(new PrefUI(), getPlugin());
		log("Enabled.");
	}

	@Override
	public void disable() {
		isEnabled = false;
		log("Disabled.");
	}

	@Override
	public void addCommands() {
		addCommand(new PrefCommand(this));
	}

	public static boolean isEnabled;

}