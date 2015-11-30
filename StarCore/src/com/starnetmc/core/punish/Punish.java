package com.starnetmc.core.punish;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.database.Databaser;
import com.starnetmc.core.modules.manager.Module;
import com.starnetmc.core.modules.manager.ModuleType;
import com.starnetmc.core.util.F;

public class Punish extends Module {

	public Punish(JavaPlugin plugin) {
		super("Punish", 0.1, ModuleType.SERVER, plugin);
	}

	public void enable() {

		log("Enabled.");
	}

	public void disable() {

		log("Disabled.");
	}

	public void addCommands() {
		addCommand(new PunishCommand(this));
	}

	@EventHandler
	public void onMutedChat(AsyncPlayerChatEvent e) throws Exception {
		if (Databaser.isPunished(e.getPlayer().getUniqueId().toString(), PunishType.MUTE)) {
			e.setCancelled(true);
			
			e.getPlayer().sendMessage(F.error("Punishments","SHHH!!! You're muted! Reason: " + Databaser.getLastestActivePunishment(e.getPlayer().getUniqueId().toString(), PunishType.MUTE).getReason() + " By: " + Databaser.getUsername(Databaser.getLastestActivePunishment(e.getPlayer().getUniqueId().toString(), PunishType.MUTE).getPunisher())));
		}
	}

	@EventHandler
	public void onBannedLogin(PlayerLoginEvent e) {
		
		try {
			if (Databaser.isPunished(e.getPlayer().getUniqueId().toString(), PunishType.BAN)) {
				e.disallow(Result.KICK_BANNED,
						F.error("Punishments", "You are BANNED! Reason: " + Databaser.getLastestActivePunishment(e.getPlayer().getUniqueId().toString(), PunishType.BAN).getReason() + " By: " + Databaser.getUsername(Databaser.getLastestActivePunishment(e.getPlayer().getUniqueId().toString(), PunishType.MUTE).getPunisher())));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@EventHandler
	public void onPunishClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (!e.getInventory().getName().equalsIgnoreCase(F.underRed + "Punishments"))
			return;

		if (e.getCurrentItem() == null)
			return;

		if (e.getCurrentItem().getType() == Material.AIR)
			return;

		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Permanent Ban")) {
			
			PunishCommand.punish.get(p.getUniqueId().toString()).setType(PunishType.BAN);
			PunishCommand.punish.get(p.getUniqueId().toString()).setPerm(true);
			
			try {
				PunishCommand.punish.get(p.getUniqueId().toString()).execute();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			p.closeInventory();
			e.setCancelled(true);

		}

		else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Permanent Mute")) {

			PunishCommand.punish.get(p.getUniqueId().toString()).setType(PunishType.MUTE);
			PunishCommand.punish.get(p.getUniqueId().toString()).setPerm(true);

			try {
				PunishCommand.punish.get(p.getUniqueId().toString()).execute();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			p.closeInventory();
			e.setCancelled(true);
		}

		else if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.YELLOW + "Warn")) {
			Bukkit.getServer().getPlayer(PunishCommand.punish.get(p.getUniqueId().toString()).getPunished()).sendMessage(F.error("Punishments", "WARNING: You are breaking server rules. Please do not break them again, or face punishment."));
			p.closeInventory();
			e.setCancelled(true);
		}

		else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Chat " + ChatColor.AQUA + "-" + ChatColor.YELLOW + " Severity 1")) {
			
			PunishCommand.punish.get(p.getUniqueId().toString()).setType(PunishType.MUTE);
			PunishCommand.punish.get(p.getUniqueId().toString()).setDuration(1800000L);
			
			try {
				PunishCommand.punish.get(p.getUniqueId().toString()).execute();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			p.closeInventory();
			e.setCancelled(true);

		}

		else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Chat " + ChatColor.AQUA + "-" + ChatColor.GOLD + " Severity 2")) {
			
			PunishCommand.punish.get(p.getUniqueId().toString()).setType(PunishType.MUTE);
			PunishCommand.punish.get(p.getUniqueId().toString()).setDuration(7200000L);

			try {
				PunishCommand.punish.get(p.getUniqueId().toString()).execute();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			p.closeInventory();
			e.setCancelled(true);

		} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Chat " + ChatColor.AQUA + "-" + ChatColor.RED + " Severity 3")) {
			
			PunishCommand.punish.get(p.getUniqueId().toString()).setType(PunishType.MUTE);
			PunishCommand.punish.get(p.getUniqueId().toString()).setPerm(true);
			
			try {
				PunishCommand.punish.get(p.getUniqueId().toString()).execute();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			e.setCancelled(true);
			p.closeInventory();
		}

		else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Exploitation " + ChatColor.AQUA + "-" + ChatColor.YELLOW + " Exploit Sev.")) {

			PunishCommand.punish.get(p.getUniqueId().toString()).setType(PunishType.BAN);
			PunishCommand.punish.get(p.getUniqueId().toString()).setDuration(43200000L);
			
			try {
				PunishCommand.punish.get(p.getUniqueId().toString()).execute();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			e.setCancelled(true);
			p.closeInventory();

		}

		else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Unapproved MODs " + ChatColor.AQUA + "-" + ChatColor.RED + " Unapproved MOD Sev.")) {

			PunishCommand.punish.get(p.getUniqueId().toString()).setType(PunishType.BAN);
			PunishCommand.punish.get(p.getUniqueId().toString()).setDuration(43200000L);
			
			try {
				PunishCommand.punish.get(p.getUniqueId().toString()).execute();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			e.setCancelled(true);
			p.closeInventory();

		} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Hacked Client " + ChatColor.AQUA + "-" + ChatColor.DARK_RED + " Hacking Sev.")) {

			PunishCommand.punish.get(p.getUniqueId().toString()).setType(PunishType.BAN);
			PunishCommand.punish.get(p.getUniqueId().toString()).setPerm(true);
			
			try {
				PunishCommand.punish.get(p.getUniqueId().toString()).execute();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			e.setCancelled(true);
			p.closeInventory();
		} 
		else if(e.getCurrentItem().getType() == Material.SKULL_ITEM) {
			
			e.setCancelled(true);
		
			try {
				Punishment lastBan = Databaser.getLastestActivePunishment(p.getUniqueId().toString(), PunishType.BAN);
				lastBan.setReason(PunishCommand.punish.get(p.getUniqueId().toString()).getReason());
				Punishment lastMute = Databaser.getLastestActivePunishment(p.getUniqueId().toString(), PunishType.MUTE);
				lastMute.setReason(PunishCommand.punish.get(p.getUniqueId().toString()).getReason());
				
				Databaser.removePunishment(lastBan);
				Databaser.removePunishment(lastMute);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			p.closeInventory();
		}
		
		else if(e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
			e.setCancelled(true);
		}
		
		else {
			e.setCancelled(true);

		}

	}

}
