package com.fdmgroup.dao.interfaces;

import java.util.List;

import com.fdmgroup.model.Item;

public interface IItemDAO {
	public boolean addItem(Item i);
	public boolean updateQuantity(int pid, int quantity);
	public boolean updateName(int pid, String name);
	public boolean updateDescription(int pid, String description);
	public boolean updateCategory(int pid, String category);
	public boolean updatePrice(int pid, double price);
	public int getMaxPid();
	public List<Item> getAllItems(String category);
	public List<Item> getItemsByCategory(String category);
	public List<Item> getItemsByPrice(double price);
	public List<Item> getItemsByName(String name);
}
