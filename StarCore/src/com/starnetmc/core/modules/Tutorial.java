package com.starnetmc.core.modules;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.starnetmc.core.Main;
import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;

public class Tutorial implements Module {

	ModuleType mt = ModuleType.INFO;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Tutorial";
	}

	

	@Override
	public ModuleType getType(ModuleType mt) {
		// TODO Auto-generated method stub
		return this.mt;
	}

	@Override
	public void enable() {
		setEnabled(true);
		System.out.println(getName()+" enabled.");

	}

	@Override
	public void disable() {
		setEnabled(false);
		System.out.println(getName()+" disabled.");

	}

	public static void sendTutorial(final Player player) {

		Location tutLoc = new Location(player.getWorld(), 144, 100, -27);

		Settings.getPrefs(player).setPlayersVisible(false);
		player.teleport(tutLoc);

		player.sendMessage(F.GREEN + "" + F.STRIKE
				+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		player.sendMessage("   \n");
		player.sendMessage("   \n");
		player.sendMessage("   \n");
		player.sendMessage(F.AQUA + "" + F.BOLD + "- Welcome to our server!");
		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 8, (float) 1);

		player.sendMessage("   \n");
		player.sendMessage("   \n");
		player.sendMessage("   \n");
		player.sendMessage("   \n");

		player.sendMessage(F.GREEN + "" + F.STRIKE
				+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

		new BukkitRunnable() {

			@Override
			public void run() {

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage(F.AQUA + "" + F.BOLD
						+ "- We have many things for you to try here!");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 8,
						(float) 1);

				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			}

		}.runTaskLater(Main.getPlugin(), 60L);
		new BukkitRunnable() {

			@Override
			public void run() {

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage(F.AQUA + "" + F.BOLD
						+ "- There are many minigames coming soon!");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 8,
						(float) 1);

				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			}

		}.runTaskLater(Main.getPlugin(), 120L);
		new BukkitRunnable() {

			@Override
			public void run() {

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage(F.AQUA + "" + F.BOLD
						+ "- Our developers have been working hard!");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 8,
						(float) 1);

				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			}

		}.runTaskLater(Main.getPlugin(), 180L);
		new BukkitRunnable() {

			@Override
			public void run() {

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage(F.boldAqua + "- But, here are some rules:");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 8,
						(float) 1);

				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			}

		}.runTaskLater(Main.getPlugin(), 240L);
		new BukkitRunnable() {

			@Override
			public void run() {

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			}

		}.runTaskLater(Main.getPlugin(), 300L);
		new BukkitRunnable() {

			@Override
			public void run() {

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("�a1. �cNo exploiting of bugs");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 8,
						(float) 1);
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			}

		}.runTaskLater(Main.getPlugin(), 330L);
		new BukkitRunnable() {

			@Override
			public void run() {

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("�a1. �cNo exploiting of bugs");
				player.sendMessage("   \n");
				player.sendMessage("�a2. �cNo Griefing");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 8,
						(float) 1);
				player.sendMessage("   \n");

				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			}

		}.runTaskLater(Main.getPlugin(), 360L);
		new BukkitRunnable() {

			@Override
			public void run() {

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("�a1. �cNo exploiting of bugs");
				player.sendMessage("   \n");
				player.sendMessage("�a2. �cNo Griefing");
				player.sendMessage("   \n");

				player.sendMessage("�a3. �cHave Good Etiquette");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 8,
						(float) 1);
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			}

		}.runTaskLater(Main.getPlugin(), 390L);
		new BukkitRunnable() {

			@Override
			public void run() {

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			}

		}.runTaskLater(Main.getPlugin(), 420L);

		new BukkitRunnable() {

			@Override
			public void run() {

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage("�a4. �cDo NOT Disturb �bSpark �cor �bAli �cwhen they are AFK, they could be coding.");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 8,
						(float) 1);

				player.sendMessage("   \n");

				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			}

		}.runTaskLater(Main.getPlugin(), 450L);
		new BukkitRunnable() {

			@Override
			public void run() {

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage("�a4. �cDo NOT Disturb �bSpark �cor �bAli �cwhen they are AFK, they could be coding.");
				player.sendMessage("   \n");
				player.sendMessage("�a5. �6Feel free to come online and test games with us!");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 8,
						(float) 1);
				player.sendMessage("   \n");

				player.sendMessage("   \n");

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			}

		}.runTaskLater(Main.getPlugin(), 480L);
		new BukkitRunnable() {

			@Override
			public void run() {

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");

				player.sendMessage(F.GREEN
						+ ""
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

				Settings.getPrefs(player).setPlayersVisible(false);
				player.teleport(player.getWorld().getSpawnLocation());

			}

		}.runTaskLater(Main.getPlugin(), 540L);

		new BukkitRunnable() {

			@Override
			public void run() {

				for (int i = 0; i < 150; i++) {
					player.sendMessage("   \n");
				}

			}
		}.runTaskLater(Main.getPlugin(), 560L);

	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean setEnabled(boolean arg0) {
		return isEnabled() == arg0;
	}

}