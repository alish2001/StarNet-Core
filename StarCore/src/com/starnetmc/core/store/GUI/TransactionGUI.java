package com.starnetmc.core.store.GUI;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import com.starnetmc.core.store.Purchase;
import com.starnetmc.core.util.F;

public class TransactionGUI {
	
	public static void openTransactionGUI(Purchase transactionToken){
		Inventory gui = Bukkit.createInventory(null, 54, F.boldAqua + "Transaction - " + transactionToken.getName());
		
	}

}