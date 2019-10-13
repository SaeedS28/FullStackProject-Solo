package com.fdmgroup.controller;

import java.util.ArrayList;

import com.fdmgroup.dao.implementation.ItemDAO;
import com.fdmgroup.dao.implementation.PurchaseOrderDAO;
import com.fdmgroup.model.Item;


public class StoreController {
	ItemDAO id;
	
	public StoreController() {
		id = new ItemDAO();
	}
	
	public ArrayList<Item> getAllItems(){
		return id.getAllItems();
	}
	
	public ArrayList<String> getAllCategories(){
		return id.getCategories();
	}
	
	public ArrayList<Item> getItemsByCategory(String category){
		return id.getItemsByCategory(category);
	}
	
	public ArrayList<Item> getItemsByName(String name){
		return id.getItemsByName(name);
	}

	public ArrayList<Item> getItemsByPriceRange(double minPrice, double maxPrice){
		return id.getItemsByPriceRange(minPrice, maxPrice);
	}
	
	public ArrayList<Item> getPopularItems(){
		PurchaseOrderDAO pod = new PurchaseOrderDAO();
		ArrayList<Item> popular = pod.retrieveTopTenPurchases();
		if(popular == null) {
			return null;
		}
		if(popular.size()>10) {
			ArrayList<Item> topTen = new ArrayList<Item>();
			topTen = (ArrayList<Item>) popular.subList(0, 10);
			return topTen;
		}
		return popular;
	}
}
