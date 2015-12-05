package com.starnetmc.core.punish;

import java.sql.Timestamp;
import java.util.UUID;

import org.bukkit.Bukkit;

import com.starnetmc.core.database.Databaser;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.UNet;

public class Punishment {

	private String punished;
	private String punisher;
	private String reason;
	
	private String remover;
	private String remove_reason;
	private Timestamp removal_time;
	
	private Timestamp time;
	private long duration;
	private boolean permanent;
	private PunishType type;

	public Punishment(String punished, String punisher, String reason, String remover, String remove_reason, Timestamp removal_time, Timestamp time, long duration, boolean permanent, PunishType type){
		this.punished = punished;
		this.punisher = punisher;
		this.reason = reason;
		this.remover = remover;
		this.remove_reason = remove_reason;
		this.removal_time = removal_time;
		this.time = time;
		this.duration = duration;
		this.permanent = permanent;
		this.type = type;
	}
	
	public Punishment(String punished, String punisher, String reason, Timestamp time, long duration, boolean permanent, PunishType type){
		this.punished = punished;
		this.punisher = punisher;
		this.reason = reason;
		this.time = time;
		this.duration = duration;
		this.permanent = permanent;
		this.type = type;
	}
	
	public Punishment(String punished, String punisher){
		this.punished = punished;
		this.punisher = punisher;
		this.permanent = false;
	}
	
	@SuppressWarnings("deprecation")
	public void execute(){
		
		time = new Timestamp(System.currentTimeMillis());
		
		try {
			
			Databaser.executePunishment(this);
			
			if(type == PunishType.BAN){
			   UNet.netKickPlayer(Bukkit.getServer().getPlayer(UUID.fromString(punisher)), Databaser.getUsername(punished), reason);
			}
		
		if (type == PunishType.BAN){
			if (permanent){
		       Bukkit.getServer().broadcastMessage(F.info("Punishments", Databaser.getUsername(punisher) + " has permanently banned " + Databaser.getUsername(punished) + " for " + getReason()));
			} else {
			   Bukkit.getServer().broadcastMessage(F.info("Punishments", Databaser.getUsername(punisher) + " has temporarily banned " + Databaser.getUsername(punished) + " for " + new Timestamp(getDuration()).getHours() + " Hours" + " for " + getReason()));
			}
			
		} else {
			if (permanent){
			       Bukkit.getServer().broadcastMessage(F.info("Punishments", Databaser.getUsername(punisher) + " has permanently muted " + Databaser.getUsername(punished) + " for " + getReason()));
				} else {
				   Bukkit.getServer().broadcastMessage(F.info("Punishments", Databaser.getUsername(punisher) + " has temporarily muted " + Databaser.getUsername(punished) + " for " + new Timestamp(getDuration()).getHours() + " Hours" + " for " + getReason()));
				}
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PunishCommand.punish.get(punisher).remove();
	}
	
	public void remove(){
		
		try {
			Databaser.removePunishment(this);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setPunished(String UUID){
		this.punished = UUID;
	}
	
	public void setPunisher(String UUID){
		this.punisher = UUID;
	}
	
	public void setReason(String reason){
		this.reason = reason;
	}
	
	public void setRemover(String UUID){
		this.remover = UUID;
	}
	
	public void setRemovalReason(String reason){
		this.remove_reason = reason;
	}
	
	public void setRemovalTime(Timestamp time){
		this.removal_time = time;
	}
	
	public void setExecutionTime(Timestamp time){
		this.time = time;
	}
	
	public void setDuration(long duration){
		this.duration = duration;
	}
	
	public void setPerm(boolean perm ){
		this.permanent = perm;
	}
	
	public void setType(PunishType type){
		this.type = type;
	}
	
	public String getPunished(){
		return punished;
	}
	
	public String getPunisher(){
		return punisher;
	}
	
	public String getReason(){
		return reason;
	}
	
	public String getRemover(){
		return remover;
	}
	
	public String getRemovalReason(){
		return remove_reason;
	}
	
	public Timestamp getRemovalTime(){
		
		if (removal_time == null){
			removal_time = new Timestamp(System.currentTimeMillis());
		}
		
		return removal_time;
	}
	
	public Timestamp getExecutionTime(){
		
		if (time == null){
			time = new Timestamp(System.currentTimeMillis());
		}
		
		return time;
	}
	
	public long getDuration(){
		return duration;
	}
	
	public boolean getPerm(){
		return permanent;
	}
	
	public PunishType getType(){
		return type;
	}
	
	public Timestamp getExpiryDate(){
		Timestamp expiry = new Timestamp(time.getTime() + duration);
		
		if (permanent){
			expiry = new Timestamp(time.getTime() - 2000);
		}
		
		return expiry;
	}

}