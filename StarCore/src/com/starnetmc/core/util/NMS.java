package com.starnetmc.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.server.v1_8_R1.BiomeBase;
import net.minecraft.server.v1_8_R1.BiomeMeta;
import net.minecraft.server.v1_8_R1.EntityInsentient;
import net.minecraft.server.v1_8_R1.EntityTypes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.events.NPCRemoveEvent;
import com.starnetmc.core.events.NPCSpawnEvent;
import com.starnetmc.core.modules.Tutorial;
import com.starnetmc.core.npc.NPCVillager;
import com.starnetmc.core.npc.command.NPCCommand;
import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;

public class NMS extends Module {

	public static LinkedHashMap<String, Location> npcs = new LinkedHashMap<String, Location>();

	public NMS(JavaPlugin plugin) {

		super("NPC Manager", 2.0, ModuleType.SERVER, plugin);

	}

	public static void registerEntity(String name, int id, Class<?> class1,
			Class<? extends EntityInsentient> customClass) {
		try {
			List<Map<?, ?>> dataMaps = new ArrayList<Map<?, ?>>();
			for (Field f : EntityTypes.class.getDeclaredFields()) {
				if (f.getType().getSimpleName()
						.equals(Map.class.getSimpleName())) {
					f.setAccessible(true);
					dataMaps.add((Map<?, ?>) f.get(null));
				}
			}
			if (dataMaps.get(2).containsKey(Integer.valueOf(id))) {
				dataMaps.get(0).remove(name);
				dataMaps.get(2).remove(Integer.valueOf(id));
			}
			Method method = EntityTypes.class.getDeclaredMethod("a",
					new Class[] { Class.class, String.class, Integer.TYPE });
			method.setAccessible(true);
			method.invoke(null,
					new Object[] { customClass, name, Integer.valueOf(id) });
			for (Field f : BiomeBase.class.getDeclaredFields()) {
				if ((f.getType().getSimpleName().equals(BiomeBase.class
						.getSimpleName())) && (f.get(null) != null)) {
					for (Field list : BiomeBase.class.getDeclaredFields()) {
						if (list.getType().getSimpleName()
								.equals(List.class.getSimpleName())) {
							list.setAccessible(true);

							@SuppressWarnings("unchecked")
							List<BiomeMeta> metaList = (List<BiomeMeta>) list
									.get(f.get(null));
							for (BiomeMeta meta : metaList) {
								Field clazz = BiomeMeta.class
										.getDeclaredFields()[0];
								if (clazz.get(meta).equals(class1)) {
									clazz.set(meta, customClass);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addCommands() {
		addCommand(new NPCCommand(this));
	}
	
	@Override
	public void enable() {
		try {
			npcs = Manager.downloadNPCs();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		spawnNPCS();
		log("Enabled.");

	}

	@Override
	public void disable() {
		log("Disabled");

	}

	@EventHandler(priority = EventPriority.LOW)
	public void onRemoval(PlayerInteractEntityEvent e) throws Exception {

		e.setCancelled(true);
		Player player = e.getPlayer();
		Entity en = e.getRightClicked();

		if (player.getItemInHand().getType() == Material.BLAZE_ROD) {

			if (Manager.getRank(player.getUniqueId().toString())
					.equals(Rank.OWNER)) {

				if (en instanceof Player) {
					return;
				} else {
					en.remove();
					player.sendMessage(F
							.info("NPC", "NPC Removed Successfully"));
				}
				Bukkit.getServer()
						.getPluginManager()
						.callEvent(
								new NPCRemoveEvent((LivingEntity) en, en
										.getCustomName(), en.getLocation()));

			} else {
				return;
			}

		} else {
			return;
		}

	}

	@EventHandler
	public void onRemove(NPCRemoveEvent e) throws Exception {

		Manager.deleteNPC(e.getName());

	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onInteract(PlayerInteractEntityEvent e) throws Exception {

		Player player = e.getPlayer();
		Entity en = e.getRightClicked();

		if (en instanceof Villager) {

			if (en.getCustomName().equalsIgnoreCase(
					F.GOLD + " Welcome Tutorial (Shard Reward) ")) {
				Tutorial.sendTutorial(player);

			}
			if (en.getCustomName().equalsIgnoreCase(
					F.GOLD + " Minigame Arcade (COMING SOON) ")) {
				player.sendMessage(F.GOLD
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage(F.boldAqua + "LOVE Minigames? We do too!");
				player.sendMessage(F.boldAqua
						+ "Coming soon, we'll have a minigame arcade!");
				player.sendMessage(F.boldGold + "HOPE TO SEE YOU THERE! :)");
				player.sendMessage(F.RED + "- Ali");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage(F.GOLD
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			}
			if (en.getCustomName().equalsIgnoreCase(
					F.GOLD + " Hub Parkour (COMING SOON) ")) {
				player.sendMessage(F.GOLD
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage(F.boldRed + "COMING SOON!");
				player.sendMessage(F.AQUA + "- Spark");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage("   \n");
				player.sendMessage(F.GOLD
						+ F.STRIKE
						+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			}

		} else {
			return;
		}

	}

	@EventHandler
	public void onHitInteract(EntityDamageByEntityEvent e) throws Exception {

		if (e.getDamager() instanceof Player) {

			Player player = (Player) e.getDamager();
			Entity en = e.getEntity();

			if (en instanceof Villager) {

				if (en.getCustomName().equalsIgnoreCase(
						F.GOLD + " Welcome Tutorial (Shard Reward) ")) {
					Tutorial.sendTutorial(player);

				}
				if (en.getCustomName().equalsIgnoreCase(
						F.GOLD + " Minigame Arcade (COMING SOON) ")) {
					player.sendMessage(F.GOLD
							+ F.STRIKE
							+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					player.sendMessage("   \n");
					player.sendMessage("   \n");
					player.sendMessage(F.boldAqua
							+ "LOVE Minigames? We do too!");
					player.sendMessage(F.boldAqua
							+ "Coming soon, we'll have a minigame arcade!");
					player.sendMessage(F.boldGold + "HOPE TO SEE YOU THERE! :)");
					player.sendMessage(F.RED + "- Ali");
					player.sendMessage("   \n");
					player.sendMessage("   \n");
					player.sendMessage(F.GOLD
							+ F.STRIKE
							+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

				}
				if (en.getCustomName().equalsIgnoreCase(
						F.GOLD + " Hub Parkour (COMING SOON) ")) {
					player.sendMessage(F.GOLD
							+ F.STRIKE
							+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					player.sendMessage("   \n");
					player.sendMessage("   \n");
					player.sendMessage("   \n");
					player.sendMessage(F.boldRed + "COMING SOON!");
					player.sendMessage(F.AQUA + "- Spark");
					player.sendMessage("   \n");
					player.sendMessage("   \n");
					player.sendMessage("   \n");
					player.sendMessage(F.GOLD
							+ F.STRIKE
							+ "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

				}

			}

		} else
			return;

	}

	@EventHandler(priority = EventPriority.LOW)
	public void onSpawn(NPCSpawnEvent e) throws Exception {

		Manager.createNPC(e.getName(), e.getLocation());

	}

	public static void spawnNPCS() {

		for (String s : npcs.keySet()) {

			Villager b = NPCVillager.spawn(npcs.get(s));
			b.setCustomName(ChatColor.GOLD + " " + s);
			b.setCustomNameVisible(true);
		}

	}

	
}

enum NPCType {

	VILLAGER, SKELETON, PIG, SLIME, SKELETONWITHER, PIGBABY, VILLAGERBABY, ZOMBIE, ZOMBIEBABY;

}
