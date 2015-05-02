package com.starnetmc.core.util;

import java.util.Random;

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

import com.starnetmc.core.modules.Gadgets;

public class GadgetsUI implements Listener {

	@EventHandler
	public void onInvClick(InventoryClickEvent e) {

		if (e.getInventory().getName().equals(F.underRed + "Gadgets")) {

			Player player = (Player) e.getWhoClicked();

			if (e.getCurrentItem().getType() == null)
				return;
			if (e.getCurrentItem().getType() == Material.AIR)
				return;

			if (e.getCurrentItem().getType() == Material.FIREWORK) {

				if (Gadgets.getGadgets(player).fireworksEnabled()) {
					Gadgets.getGadgets(player).setFWEnabled(true);
					player.getInventory().addItem(
							new ItemStack(Material.FIREWORK));
				} else {
					Gadgets.getGadgets(player).setFWEnabled(false);
					player.getInventory().remove(
							new ItemStack(Material.FIREWORK));
				}

			}
		} else
			return;

	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getPlayer().getItemInHand().getType() == Material.FIREWORK) {
				Player player = e.getPlayer();
				e.setCancelled(true);

				Firework fw = (Firework) player.getWorld().spawnEntity(
						player.getEyeLocation(), EntityType.FIREWORK);
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
				if (rt == 2) {
					type = Type.BURST;
				}
				if (rt == 2) {
					type = Type.STAR;
				}
				if (rt == 2) {
					type = Type.CREEPER;
				}

				int r1i = r.nextInt(4) + 1;
				Color color = Color.RED;
				
				if(r1i == 1) {
					color = Color.AQUA;
				}if(r1i == 1) {
					color = Color.FUCHSIA;
				}if(r1i == 1) {
					color = Color.YELLOW;
				}if(r1i == 1) {
					color = Color.GREEN;
				}if(r1i == 1) {
					color = Color.RED;
				}
				
				FireworkEffect effect = FireworkEffect.builder().withColor(color).with(type).build();
				fwm.addEffect(effect);
				fwm.setPower(2);
				fw.setFireworkMeta(fwm);
				
				
			} else
				return;
		}

		else
			return;

	}

}
