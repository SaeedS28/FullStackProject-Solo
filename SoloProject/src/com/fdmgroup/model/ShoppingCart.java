package com.fdmgroup.model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	String emailAddress;
	Map<Item, Integer> itemCount;
	
	public ShoppingCart(String emailAddress){
		itemCount= new HashMap<>();
		this.emailAddress = emailAddress; 
	}
	
	public void addItems(Item item, int quantity){
		itemCount.put(item, quantity);
	}

	public void reset(){
		itemCount = new HashMap<>();
	}
	
	@Override
	public String toString() {
		return "ShoppingCart [emailAddress=" + emailAddress + ", itemCount=" + itemCount.toString() + "]";
	}
	
}	