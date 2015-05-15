package com.starnetmc.core.punish;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.starnetmc.core.Main;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;
import com.starnetmc.core.util.StarMap;

public class Punishment {

	private String offender;
	private String offense;
	private Player punisher;
	private boolean permanent;
	private boolean temporary;
	private long duration;
	private PunishType pt;

	public static StarMap<String, String> _tempMutes = new StarMap<String, String>();
	public static StarMap<String, String> _tempBans = new StarMap<String, String>();

	public Punishment(String offender, PunishType pt,String offense, Player punisher,
			boolean permanent, boolean temporary, long duration) {

		this.setOffender(offender);
		this.setType(pt);
		this.setOffense(offense);
		this.setPunisher(punisher);
		this.setPermanent(permanent);
		this.setTemporary(temporary);
		this.setDuration(duration);

	}

	public String getOffender() {
		return offender;
	}

	public void setOffender(String offender) {
		this.offender = offender;
	}

	public String getOffense() {
		return offense;
	}

	public void setOffense(String offense) {
		this.offense = offense;
	}

	public Player getPunisher() {
		return punisher;
	}

	public void setPunisher(Player punisher) {
		this.punisher = punisher;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public boolean isTemporary() {
		return temporary;
	}

	public void setTemporary(boolean temporary) {
		this.temporary = temporary;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public PunishType getType() {
		return pt;
	}

	public void setType(PunishType pt) {
		this.pt = pt;
	}
	
	public static Player getOnlinePlayerFromName(String p){
		Player sp = Bukkit.getServer().getPlayer(p);
		if (sp == null){
			return null;
		}
		else{
			return sp;
		}
	}
	
	@SuppressWarnings("deprecation")
	public static OfflinePlayer getOfflinePlayerFromName(String p){
		OfflinePlayer sp = Bukkit.getServer().getOfflinePlayer(p);
		if (sp == null){
			return null;
		}
		else{
			return sp;
		}
	}
	
	public static Player getPlayerFromUUID(UUID uid){
		return Bukkit.getServer().getPlayer(uid);
	}
	
	public static boolean isOnline(String name){
		if (getOnlinePlayerFromName(name) == null){
			return false;
		}
		else { return true; }
	}



	
	public void setPunished() throws Exception {

		if (this.getType() == PunishType.PERMMUTE) {
			Manager.makeMuted(punisher, offender, getOffense());
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.sendMessage(F.info("Punishments", getOfflinePlayerFromName(offender).getName()
						+ " has been muted permanently."));
			}
		} else if (this.getType() == PunishType.PERMBAN) {

			Manager.makeBanned(punisher, offender, getOffense());
			
			if(getOfflinePlayerFromName(offender).isOnline()) {
				getOnlinePlayerFromName(offender).kickPlayer(F.error("Punishments", "You have been banned for \" "+Manager.getPunishReason(getOfflinePlayerFromName(offender).getPlayer())+"\""));
			}
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.sendMessage(F.info("Punishments", getOfflinePlayerFromName(offender).getName()
						+ " has been banned permanently."));
			}
		} else if (this.getType() == PunishType.TEMPMUTE) {
			_tempMutes.put(getOfflinePlayerFromName(offender).getUniqueId().toString(), getOffense());
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.sendMessage(F.info("Punishments", getOfflinePlayerFromName(offender).getName()
						+ " has been muted."));
			}
			new BukkitRunnable() {

				@Override
				public void run() {
					_tempMutes.remove(getOfflinePlayerFromName(offender).getUniqueId().toString());

				}
			}.runTaskLater(Main.getPlugin(), getDuration());

		} else if (this.getType() == PunishType.TEMPBAN) {
			_tempBans.put(getOfflinePlayerFromName(offender).getUniqueId().toString(), getOffense());
			
			if(getOnlinePlayerFromName(offender).isOnline()) {
				getOnlinePlayerFromName(offender).kickPlayer(F.error("Punishments",getOffense()));
			}
			
			for(Player all : Bukkit.getOnlinePlayers()){
				all.sendMessage(F.error("Punishments", getOfflinePlayerFromName(offender).getName()+" has been banned."));
			}

			new BukkitRunnable() {

				@Override
				public void run() {
					_tempBans.remove(getOfflinePlayerFromName(offender).getUniqueId().toString());

				}
			}.runTaskLater(Main.getPlugin(), getDuration());
		}

	}

	

}
