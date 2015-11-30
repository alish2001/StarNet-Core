package com.starnetmc.core.punish;

import java.sql.Timestamp;

import org.bukkit.Bukkit;

import com.starnetmc.core.database.Databaser;
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
	
	public void execute(){
		try {
			
			Databaser.executePunishment(this);
			UNet.netKickPlayer(Bukkit.getServer().getPlayer(punisher), Databaser.getUsername(punished), reason);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		return removal_time;
	}
	
	public Timestamp getExecutionTime(){
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
		return expiry;
	}

}