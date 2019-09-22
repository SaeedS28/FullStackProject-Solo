package com.fdmgroup.dao.implementation;

import java.util.List;

import com.fdmgroup.dao.interfaces.IShoppingCartDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.ShoppingCart;
import com.fdmgroup.model.User;

public class ShoppingCartDAO implements IShoppingCartDAO {

	@Override
	public boolean addItem(Item t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeItem(User u, int pid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShoppingCart getCartDetails(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCartTotal(User u) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
