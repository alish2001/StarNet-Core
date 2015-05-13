package com.starnetmc.core.modules;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import com.starnetmc.core.events.ShardFireEvent;
import com.starnetmc.core.events.ShardPickupEvent;
import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Gadget;
import com.starnetmc.core.util.ItemFactory;
import com.starnetmc.core.util.Manager;
import com.starnetmc.core.util.StarMap;

public class Gadgets extends Module {

	private static StarMap<String, Gadget> playergadgets = new StarMap<String, Gadget>();

	public Gadgets(JavaPlugin plugin) {
		super("Gadgets", 0.6, ModuleType.SERVER, plugin);
	}

	public Gadgets() {
		
	}
	
	public static Gadget getGadgets(Player player) {

		return playergadgets.get(player.getUniqueId().toString());
	}

	public static void createUserGadget(Player player) {

		Gadget pf = new Gadget(player, false, false, false);
		getUsers().put(player.getUniqueId().toString(), pf);
	}

	public static StarMap<String, Gadget> getUsers() {

		return playergadgets;
	}

	public static void removeUser(Player player) {

		getUsers().remove(player.getUniqueId().toString());

	}

	@Override
	public void enable() {
		isEnabled = true;
		log("Enabled.");

	}

	@Override
	public void disable() {
		isEnabled = false;
		log("Disabled.");
	}

	public static boolean isEnabled;

	@EventHandler
	public void onShardPickup(ShardPickupEvent e) throws Exception {

		Player player = e.getPlayer();
		Manager.setShards(player.getUniqueId().toString(), 2);
		player.sendMessage(F.info("Economy",
				"2 shards have been added to your account."));

		e.getItem().remove();

	}

	@EventHandler
	public void onFire(ShardFireEvent e) throws Exception {

		Player player = e.getPlayer();
		String uuid = player.getUniqueId().toString();

		if ((Manager.getShards(uuid) - 20) <= 0) {
			e.setCancelled(true);
			player.sendMessage(F.error("Economy",
					"Insufficient funds to fire gadget."));
		} else {

			ItemStack item = ItemFactory.createItem(Material.NETHER_STAR,
					F.AQUA + "SHARD SHOOTER", null, false);
			int rand = new Random().nextInt();

			Vector posxposz = new Vector(rand, 6F, rand).normalize();

			player.getWorld().dropItemNaturally(player.getEyeLocation(), item)
					.setVelocity(posxposz);
			player.getWorld().dropItemNaturally(player.getEyeLocation(), item)
					.setVelocity(posxposz);
			player.getWorld().dropItemNaturally(player.getEyeLocation(), item)
					.setVelocity(posxposz);
			player.getWorld().dropItemNaturally(player.getEyeLocation(), item)
					.setVelocity(posxposz);

			player.getWorld().playSound(player.getLocation(),
					Sound.GHAST_FIREBALL, 10F, 1F);
			player.getWorld().playSound(player.getLocation(), Sound.EXPLODE,
					7F, 1F);

			Manager.setShards(uuid, -20);
			
		}

	}

}
