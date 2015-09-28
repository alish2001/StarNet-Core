package com.starnetmc.core.store;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.modules.manager.Module;
import com.starnetmc.core.modules.manager.ModuleType;
import com.starnetmc.core.store.GUI.TransactionGUI;
import com.starnetmc.core.store.GUI.TransactionUI;

public class StarStore extends Module {
	
	public StarStore(JavaPlugin plugin) {
		super("StarStore", 1.0, ModuleType.SERVER, plugin);
	}
	
	public StarStore() {
	}


	@Override
	public void enable() {
		Bukkit.getServer().getPluginManager().registerEvents(new TransactionUI(), getPlugin());
		isEnabled = true;
		log("Enabled.");
	}

	@Override
	public void disable() {
		isEnabled = false;
		log("Disabled.");
	}

	public static boolean isEnabled;
	
	public void initiateTransaction(Player p, Purchase transactionToken){
		TransactionGUI.openTransactionGUI(transactionToken);
	}

}