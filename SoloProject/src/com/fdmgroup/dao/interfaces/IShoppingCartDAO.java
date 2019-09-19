package com.fdmgroup.dao.interfaces;

import java.util.List;

import com.fdmgroup.model.User;

public interface IShoppingCartDAO <T extends IItemDao> {
	public List<T> getAllItems(User user);
	public boolean addItem(T t);
	public T removeItem(User u, String itemName);
	public int getSize(User u);
	public double getCartTotal(User u);
}
