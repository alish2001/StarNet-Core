package com.starnetmc.core.gadgets;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.starnetmc.core.util.F;
import com.starnetmc.core.util.ItemFactory;

public class GadgetGUI {

	
	public static void openGadgetInventory(Player player) {
		
		Inventory gui = Bukkit.createInventory(player, 9, F.underRed+"Gadgets");
		
		ItemStack fireworks = ItemFactory.createItem(Material.FIREWORK, F.AQUA+"FIREWORKS!!!", Arrays.asList("",F.GOLD+"Feel like celebrating?",F.GOLD+"Set off these bad boys!"), true);
		ItemStack eggs = ItemFactory.createItem(Material.STICK, F.AQUA+"EGG BLASTER 9001", Arrays.asList(F.GOLD+"All the eggs!"), true);
		ItemStack shard = ItemFactory.createItem(Material.NETHER_STAR, F.AQUA+"SHARD SHOOTER", Arrays.asList(F.GOLD+"Feel like giving away some shards?",F.GOLD+"Use this badboy to fire them off!",F.boldRed+"THIS COSTS 20 SHARDS PER USE"), true);
		

		gui.setItem(2, fireworks);
		gui.setItem(4, eggs);
		gui.setItem(6, shard);
		player.openInventory(gui);
	}
	
}
