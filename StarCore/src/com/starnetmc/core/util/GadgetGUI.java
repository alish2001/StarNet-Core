package com.starnetmc.core.util;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GadgetGUI {

	
	public static void openGadgetInventory(Player player) {
		
		Inventory gui = Bukkit.createInventory(player, 9, F.underRed+"Gadgets");
		
		ItemStack fireworks = ItemFactory.createItem(Material.FIREWORK, F.AQUA+"FIREWORKS!!!", Arrays.asList("",F.GOLD+"Feel like celebrating?",F.GOLD+"Set off these bad boys!"), true);
		ItemStack eggs = ItemFactory.createItem(Material.STICK, F.AQUA+"EGG BLASTER 9001", Arrays.asList(F.GOLD+"All the eggs!"), true);

		gui.setItem(3, fireworks);
		gui.setItem(5, eggs);
		player.openInventory(gui);
	}
	
}
