package com.fdmgroup.dao.interfaces;

import com.fdmgroup.model.Item;
import com.fdmgroup.model.ShoppingCart;
import com.fdmgroup.model.User;

public interface IShoppingCartDAO  {
	public boolean addItem(Item t);
	public boolean removeItem(User u, int pid);
	public int getSize(User u);
	public ShoppingCart getCartDetails(User u);
	public double getCartTotal(User u);
}
