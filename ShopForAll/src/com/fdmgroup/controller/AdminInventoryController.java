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
		showDashBoardAIV();
	}
	
	public void addItem(String name,double price, int quantity,String category, String description) {
		Item newItem = new Item(name, category, description, quantity, price);
		id.addItem(newItem);
		System.out.println("Item added successfully");
		showDashBoardAIV();
	}
	
	public void showDashBoardAIV(){
		AdminInventoryView aiv = new AdminInventoryView();
		aiv.showDashBoard();
	}
	
	public void removeItem(int pid) {
		id.removeItem(pid);
		System.out.println("Item removed successfully");
		showDashBoardAIV();
	}
	
	public void updateDescription(int pid,String description) {
		id.updateDescription(pid, description);
		System.out.println("Description updated successfully");
		showDashBoardAIV();
	}
	
	public void updateCategory(int pid,String category) {
		id.updateCategory(pid, category);
		System.out.println("Category updated successfully");
		showDashBoardAIV();
	}
	
	public void updateName(int pid,String name) {
		id.updateName(pid, name);
		System.out.println("Name updated successfully");
		showDashBoardAIV();
	}
	
	public void updatePrice(int pid,double price) {
		id.updatePrice(pid, price);
		System.out.println("Price updated successfully");
		showDashBoardAIV();
	}
	
	public void updateQuantity(int pid,int quantity) {
		id.updateQuantity(pid, quantity);
		System.out.println("Quantity updated successfully");
		showDashBoardAIV();
	}
}
