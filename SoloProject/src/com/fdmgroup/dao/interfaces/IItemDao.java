package com.fdmgroup.dao.interfaces;

import java.util.List;

import com.fdmgroup.model.Item;

public interface IItemDao extends IStorage<Item>, IRemovable<Item> {
	public boolean updateQuantity(Item i, int quantity);
	public boolean updateName(Item i, String name);
	public boolean updateDescription(Item i, String description);
	public boolean updateCategory(Item i, String category);
	public boolean updatePrice(Item i, double price);
	public List<Item> getItemsByCategory(String category);
	public List<Item> getItemsByPrice(double price);
	public List<Item> getItemsByName(String name);
}
