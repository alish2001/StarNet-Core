package com.starnetmc.core.util;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import com.starnetmc.core.events.ShardFireEvent;
import com.starnetmc.core.modules.Gadgets;

public class GadgetsUI implements Listener {

	@EventHandler
	public void onInvClick(InventoryClickEvent e) {

		ItemStack fireworks = ItemFactory.createItem(Material.FIREWORK, F.AQUA
				+ "FIREWORKS!!!", null, false);
		ItemStack eggs = ItemFactory.createItem(Material.STICK, F.AQUA
				+ "Egg Blaster 9001", null, false);
		ItemStack item = ItemFactory.createItem(Material.NETHER_STAR, F.AQUA
				+ "SHARD SHOOTER", null, false);
		if (e.getInventory().getName().equals(F.underRed + "Gadgets")) {

			e.setCancelled(true);

			Player player = (Player) e.getWhoClicked();

			if (e.getCurrentItem().getType() == null)
				return;
			if (e.getCurrentItem().getType() == Material.AIR)
				return;

			if (e.getCurrentItem().getType() == Material.FIREWORK) {

				if (Gadgets.getGadgets(player).fireworksEnabled() == false) {
					Gadgets.getGadgets(player).setFWEnabled(true);
					player.getInventory().addItem(fireworks);
				} else {
					Gadgets.getGadgets(player).setFWEnabled(false);
					player.getInventory().remove(fireworks);
				}

			} else if (e.getCurrentItem().getType() == Material.STICK) {
				if (Gadgets.getGadgets(player).eggsEnabled() == false) {
					Gadgets.getGadgets(player).setEggsEnabled(true);
					player.getInventory().addItem(eggs);
				} else {
					Gadgets.getGadgets(player).setEggsEnabled(false);
					player.getInventory().remove(eggs);
				}
			} else if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
				if (Gadgets.getGadgets(player).isShardEnabled() == false) {
					Gadgets.getGadgets(player).setShardEnabled(true);
					player.getInventory().addItem(item);

				} else {
					Gadgets.getGadgets(player).setShardEnabled(false);
					player.getInventory().remove(item);
				}
			}
		}

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) throws Exception {

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getPlayer().getItemInHand().getType() == Material.FIREWORK) {
				Player player = e.getPlayer();
				e.setCancelled(true);

				Firework fw = (Firework) player.getWorld().spawnEntity(
						e.getClickedBlock().getLocation(), EntityType.FIREWORK);
				FireworkMeta fwm = fw.getFireworkMeta();

				Random r = new Random();

				int rt = r.nextInt(5) + 1;
				Type type = Type.BALL;
				if (rt == 1) {
					type = Type.BALL;
				}
				if (rt == 2) {
					type = Type.BALL_LARGE;
				}
				if (rt == 3) {
					type = Type.BURST;
				}
				if (rt == 4) {
					type = Type.STAR;
				}
				if (rt == 5) {
					type = Type.CREEPER;
				}

				int r1i = r.nextInt(5) + 1;
				Color color = Color.RED;

				if (r1i == 1) {
					color = Color.AQUA;
				}
				if (r1i == 2) {
					color = Color.FUCHSIA;
				}
				if (r1i == 3) {
					color = Color.YELLOW;
				}
				if (r1i == 4) {
					color = Color.GREEN;
				}
				if (r1i == 5) {
					color = Color.RED;
				}

				FireworkEffect effect = FireworkEffect.builder()
						.withColor(color).with(type).build();
				fwm.addEffect(effect);
				fwm.setPower(1);
				fw.setFireworkMeta(fwm);

			} else if (e.getPlayer().getItemInHand().getType() == Material.STICK) {

				Player player = e.getPlayer();
				player.throwEgg();

			} else
				return;
		}

		if (e.getAction() == Action.RIGHT_CLICK_AIR) {

			if (e.getPlayer().getItemInHand().getType() == Material.STICK) {

				Player player = e.getPlayer();
				player.throwEgg();

			} else if (e.getPlayer().getItemInHand().getType() == Material.NETHER_STAR) {

				Player player = e.getPlayer();

				

				Bukkit.getServer().getPluginManager().callEvent(new ShardFireEvent(player));
				
				
			}

		}

	}

}
