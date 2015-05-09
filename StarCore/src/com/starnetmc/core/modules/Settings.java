package com.starnetmc.core.modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Setting;
import com.starnetmc.core.util.SettingsGUI;

public class Settings implements Module, Listener {

	public static HashMap<String, Setting> playerPrefs_ = new HashMap<String, Setting>();
	private static List<String> invisPlayers_ = new ArrayList<String>();

	public static Setting getPrefs(Player player) {

		return playerPrefs_.get(player.getUniqueId().toString());
	}

	public static void createUserPrefs(Player player) {

		Setting pf = new Setting(player, true, false, true);
		getUsers().put(player.getUniqueId().toString(), pf);
	}

	public static HashMap<String, Setting> getUsers() {

		return playerPrefs_;
	}

	public static void removeUser(Player player) {

		getUsers().remove(player.getUniqueId().toString());

	}

	@EventHandler
	public void sGUIClick(InventoryClickEvent e) {

		Player player = (Player) e.getWhoClicked();

		if (e.getInventory().getName()
				.equalsIgnoreCase(F.underRed + "SETTINGS")) {

			if (e.getCurrentItem() == null)
				return;
			if (e.getCurrentItem().getType() == Material.AIR)
				return;

			if (e.getCurrentItem().getType() == Material.SIGN
					&& e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(F.boldGreen + "Chat ENABLED")) {

				e.setCancelled(true);
				Settings.getPrefs(player).setCanChat(false);
				player.closeInventory();
				SettingsGUI.openSettingsGUI(player);

			}
			if (e.getCurrentItem().getType() == Material.ANVIL
					&& e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(F.boldRed + "Chat DISABLED")) {

				e.setCancelled(true);
				Settings.getPrefs(player).setCanChat(true);
				player.closeInventory();
				SettingsGUI.openSettingsGUI(player);
			}

			if (e.getCurrentItem().getType() == Material.EYE_OF_ENDER
					&& e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(F.boldGreen + "Players ENABLED")) {

				e.setCancelled(true);
				Settings.getPrefs(player).setPlayersVisible(false);
				invisPlayers_.add(player.getUniqueId().toString());
				for (Player p : Bukkit.getOnlinePlayers()) {

					player.hidePlayer(p);

				}
				player.closeInventory();
				SettingsGUI.openSettingsGUI(player);
			}

			if (e.getCurrentItem().getType() == Material.ENDER_PEARL
					&& e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(F.boldRed + "Players DISABLED")) {

				e.setCancelled(true);
				Settings.getPrefs(player).setPlayersVisible(true);
				invisPlayers_.remove(player.getUniqueId().toString());
				for (Player p : Bukkit.getOnlinePlayers()) {

					player.showPlayer(p);

				}
				player.closeInventory();
				SettingsGUI.openSettingsGUI(player);

			}

		}
		if (e.getInventory().getName()
				.equalsIgnoreCase(F.underRed + "ADMIN SETTINGS")) {

			if (e.getCurrentItem() == null)
				return;
			if (e.getCurrentItem().getType() == Material.AIR)
				return;

			if (e.getCurrentItem().getType() == Material.SIGN
					&& e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(F.boldGreen + "Chat ENABLED")) {

				e.setCancelled(true);
				Settings.getPrefs(player).setCanChat(false);
				player.closeInventory();
				SettingsGUI.openSettingsAGUI(player);

			}
			if (e.getCurrentItem().getType() == Material.ANVIL
					&& e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(F.boldRed + "Chat DISABLED")) {

				e.setCancelled(true);
				Settings.getPrefs(player).setCanChat(true);
				player.closeInventory();
				SettingsGUI.openSettingsAGUI(player);
			}

			if (e.getCurrentItem().getType() == Material.EYE_OF_ENDER
					&& e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(F.boldGreen + "Players ENABLED")) {

				e.setCancelled(true);
				Settings.getPrefs(player).setPlayersVisible(false);
				invisPlayers_.add(player.getUniqueId().toString());
				for (Player p : Bukkit.getOnlinePlayers()) {

					player.hidePlayer(p);

				}
				player.closeInventory();
				SettingsGUI.openSettingsAGUI(player);
			}

			if (e.getCurrentItem().getType() == Material.ENDER_PEARL
					&& e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(F.boldRed + "Players DISABLED")) {

				e.setCancelled(true);
				Settings.getPrefs(player).setPlayersVisible(true);
				invisPlayers_.remove(player.getUniqueId().toString());
				for (Player p : Bukkit.getOnlinePlayers()) {

					player.showPlayer(p);

				}
				player.closeInventory();
				SettingsGUI.openSettingsAGUI(player);

			}

			if (e.getCurrentItem().getType() == Material.DIAMOND_PICKAXE
					&& e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(F.boldGreen + "Build ENABLED")) {

				e.setCancelled(true);
				Settings.getPrefs(player).setBuildMode(false);
				player.closeInventory();
				SettingsGUI.openSettingsAGUI(player);

			}
			if (e.getCurrentItem().getType() == Material.WOOD_PICKAXE
					&& e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(F.boldRed + "Build DISABLED")) {

				e.setCancelled(true);
				Settings.getPrefs(player).setBuildMode(true);
				player.closeInventory();
				SettingsGUI.openSettingsAGUI(player);

			}

		}

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Settings Manager";
	}


	@Override
	public ModuleType getType(ModuleType mt) {
		// TODO Auto-generated method stub
		return ModuleType.SERVER;
	}


	public double getVersion() {
		
		return 1.0;
		
	}
	
	@Override
	public void enable() {
		setEnabled(true);
		System.out.println("<Settings> "+getVersion()+" enabled.");

	}

	@Override
	public void disable() {
		setEnabled(false);
		System.out.println("<Settings> "+getVersion()+" disabled.");

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
