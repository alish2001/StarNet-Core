package com.starnetmc.core.store;

import java.util.ArrayList;
import java.util.List;

public enum PurchaseType {
	
	KIT,
	GADGET,
	MOUNT,
	MORPH,
	PARTICLE,
	SCOREBOARD;
	
	public static PurchaseType getPurchaseTypeFromString(String type){
		PurchaseType pType = null;
		for (PurchaseType _type : getAllPurchaseTypes()){
			if (_type.toString().equalsIgnoreCase(type)){
				pType = _type;
			}
		}
		
		return pType;
	}
	
	public static List<PurchaseType> getAllPurchaseTypes(){
		List<PurchaseType> allPurchases = new ArrayList<PurchaseType>();
		allPurchases.add(KIT);
		allPurchases.add(GADGET);
		allPurchases.add(MOUNT);
		allPurchases.add(MORPH);
		allPurchases.add(PARTICLE);
		allPurchases.add(SCOREBOARD);
		return allPurchases;
	}
}