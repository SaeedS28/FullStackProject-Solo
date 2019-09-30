package com.fdmgroup.controller;

import java.util.ArrayList;

import com.fdmgroup.dao.implementation.ItemDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.view.AdminInventoryView;

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
	
	public Item checkDuplicates(String name, String category, double price) {
		return id.checkDuplicates(name, category,price);
	}
	
	public int getQuantity(int pid) {
		return id.getItemQuantity(pid);
	}
	
	public void updateDuplicateItem(Item i, String description, int quantity) {
		id.updateQuantity(i.getProductID(), i.getQuantity()+quantity);
		id.updateDescription(i.getProductID(), description);
		System.out.println("Item updated successfully.");
		AdminInventoryView aiv = new AdminInventoryView();
		aiv.showDashBoard();
	}
	
	public void addItem(String name,double price, int quantity,String category, String description) {
		Item newItem = new Item(id.getMaxPid(), name, category, description, quantity, price);
		id.addItem(newItem);
		System.out.println("Item added successfully");
		AdminInventoryView aiv = new AdminInventoryView();
		aiv.showDashBoard();
	}
}
