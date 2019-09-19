package com.fdmgroup.dao;

import com.fdmgroup.model.Item;

public interface IItemDao extends IStorage<Item>, IRemovable<Item> {
	public boolean updateQuantity(int pid, int quantity);
	public boolean updateName(int pid, String name);
	public boolean updateDescription(int pid, String description);
	public boolean updateCategory(int pid, String category);
}
