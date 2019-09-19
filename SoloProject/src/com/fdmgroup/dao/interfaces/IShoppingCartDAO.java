package com.fdmgroup.dao.interfaces;

import java.util.List;

import com.fdmgroup.model.Item;
import com.fdmgroup.model.User;

public interface IShoppingCartDAO  {
	public List<Item> getAllItems(User user);
	public boolean addItem(Item t);
	public Item removeItem(User u, String itemName);
	public int getSize(User u);
	public double getCartTotal(User u);
}
