package com.fdmgroup.controller;

import java.util.ArrayList;

import com.fdmgroup.dao.implementation.ItemDAO;
import com.fdmgroup.model.Item;

public class AdminInventoryController {
	ItemDAO id;
	
	public AdminInventoryController() {
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
}
