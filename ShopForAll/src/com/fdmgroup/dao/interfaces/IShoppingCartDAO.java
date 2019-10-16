package com.fdmgroup.dao.interfaces;

import java.util.ArrayList;


import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.User;

public interface IShoppingCartDAO  {
	public boolean addItem(User u, int pid, int quantity);
	public boolean removeItem(User u, int pid);
	public boolean removeAllItem(String userName);
	public int getSize(User u);
	public ArrayList<ShoppingCartItem> getCartDetails(User u);
	public double getCartTotal(User u);
	public int getQuantity(User u, int pid);
}
