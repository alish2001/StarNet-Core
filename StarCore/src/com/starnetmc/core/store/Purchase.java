package com.starnetmc.core.store;

public class Purchase {

	private String purchaseName;
	private int purchaseValue;
	private String purchase_var_name;
	private PurchaseType purchaseType;
	private String purchaseDate;
	
	public Purchase(String purchaseName, int purchaseValue, String purchase_var_name, PurchaseType purchaseType, String purchaseDate){
		this.purchaseName = purchaseName;
		this.purchaseValue = purchaseValue;
		this.purchase_var_name = purchase_var_name;
		this.purchaseType = purchaseType;
		this.purchaseDate = purchaseDate;
	}
	
	public void setName(String purchaseName){
		this.purchaseName = purchaseName;
	}
	
	public void setValue(int purchaseValue){
		this.purchaseValue = purchaseValue;
	}
	
	public void setVar(String purchase_var_name){
		this.purchase_var_name = purchase_var_name;
	}
	
	public void setType(PurchaseType purchaseType){
		this.purchaseType = purchaseType;
	}
	
	public void setDateTime(String purchaseDate){
		this.purchaseDate = purchaseDate;
	}
	
	public String getName(){
		return purchaseName;
	}
	
	public int getValue(){
		return purchaseValue;
	}
	
	public String getVar(){
		return purchase_var_name;
	}
	
	public PurchaseType getType(){
		return purchaseType;
	}
	
	public String getDateTime(){
		return purchaseDate;
	}
	
}