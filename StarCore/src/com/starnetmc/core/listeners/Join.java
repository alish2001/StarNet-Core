package com.starnetmc.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.starnetmc.core.Main;
import com.starnetmc.core.modules.Gadgets;
import com.starnetmc.core.modules.Settings;
import com.starnetmc.core.modules.Tutorial;
import com.starnetmc.core.objects.OfflinePlayerCache;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;
import com.starnetmc.core.util.ParticleEffect;

public class Join implements Listener {

	Tutorial tutorial = new Tutorial();
	
	public static int _partID;

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.MONITOR)
	public void onLogin(PlayerJoinEvent e) throws Exception {
		final Player player = e.getPlayer();
		player.setMaxHealth(20D);
		player.setFoodLevel(20);
		player.setHealthScale(20D);
		player.teleport(player.getWorld().getSpawnLocation());
		player.setGameMode(GameMode.SURVIVAL);
		
		if (!Manager.hasAccount(player.getUniqueId().toString())) {
			Manager.createAccount(player);
		}
		
		OfflinePlayerCache.addPlayer(player);
		OfflinePlayerCache.setRank(player);
		OfflinePlayerCache.setShards(player);
		Settings.createUserPrefs(player);
		Gadgets.createUserGadget(player);
		Manager.setLastLogin(player.getUniqueId().toString());
		
		e.setJoinMessage(F.BLUE + "<" + F.GREEN + "+" + F.BLUE + "> "
				+ F.GRAY + player.getName());

		
		if (Manager.getRank(player.getUniqueId().toString()).equals("ADMIN")) {

			_partID = Bukkit.getScheduler().scheduleSyncRepeatingTask(
					Main.getPlugin(), new BukkitRunnable() {

						@Override
						public void run() {

							ParticleEffect.FLAME.display(0F, 1F, 0F,
									0, 6, player.getLocation(), 3.0D);

						}

					}, 0L, 20L);

		} else if (Manager.getRank(player.getUniqueId().toString()).equals(
				"OWNER")) {
		
			_partID = Bukkit.getScheduler().scheduleSyncRepeatingTask(
					Main.getPlugin(), new BukkitRunnable() {

						@Override
						public void run() {

							ParticleEffect.ENCHANTMENT_TABLE.display(0F, 0F,
									0F, 1, 30, player.getLocation(), 1.0D);

						}

					}, 0L, 10L);
			
		} else if (Manager.getRank(player.getUniqueId().toString()).equals(
				"DEVELOPER")) {
			_partID = Bukkit.getScheduler().scheduleSyncRepeatingTask(
					Main.getPlugin(), new BukkitRunnable() {

						@Override
						public void run() {

							ParticleEffect.CRIT_MAGIC.display(0F, 0F,
									0F, 0, 5, player.getLocation(), 1.0D);

						}

					}, 0L, 20L);
		}
		else if(Manager.getRank(player.getUniqueId().toString()).equals("VIP")) {
			
			_partID = Bukkit.getScheduler().scheduleSyncRepeatingTask(
					Main.getPlugin(), new BukkitRunnable() {

						@Override
						public void run() {

							ParticleEffect.PORTAL.display(0F, 0F,
									0F, 0, 5, player.getLocation(), 1.0D);

						}

					}, 0L, 20L);
			
		}

		
	}

}
