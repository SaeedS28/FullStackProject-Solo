package com.fdmgroup.dao.interfaces;

import java.util.ArrayList;

import com.fdmgroup.model.Item;

public interface IItemDAO {
	public boolean addItem(Item i);
	public boolean updateQuantity(int pid, int quantity);
	public boolean updateName(int pid, String name);
	public boolean updateDescription(int pid, String description);
	public boolean updateCategory(int pid, String category);
	public boolean updatePrice(int pid, double price);
	public ArrayList<Item> getAllItems();
	public Item getItemByPid(int pid);
	public int getItemQuantity(int pid);
	public ArrayList<Item> getItemsByCategory(String category);
	public ArrayList<Item> getItemsByPriceRange(double low, double high);
	public ArrayList<Item> getItemsByName(String name);
	public boolean removeItem(int pid);
	public ArrayList<String> getCategories();
	public Item checkDuplicates(String name, String category, double qPrice);
	public ArrayList<Item> seePurchasedItemByUser(ArrayList<Integer> pids);
}
