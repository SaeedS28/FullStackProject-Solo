package com.fdmgroup.dao.interfaces;

import com.fdmgroup.model.Item;
import com.fdmgroup.model.ShoppingCart;
import com.fdmgroup.model.User;

public interface IShoppingCartDAO  {
	public boolean addItem(User u, int pid, int quantity);
	public boolean removeItem(User u, int pid);
	public boolean removeAllItem(User u);
	public int getSize(User u);
	public ShoppingCart getCartDetails(User u);
	public double getCartTotal(User u);
}
