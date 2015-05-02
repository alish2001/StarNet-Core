package com.starnetmc.core.util;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemFactory {

	public static ItemStack createItem(Material item, String DName, List<String> lore, boolean hasLore){
		ItemStack i = new ItemStack(item);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(DName);
		if (hasLore == true){
			im.setLore(lore);
			i.setItemMeta(im);
			return i;
		}
		else {
			i.setItemMeta(im);
			return i;
		}
	}

	
}
