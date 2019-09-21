package com.fdmgroup.dao.implementation;

import java.util.List;

import com.fdmgroup.dao.interfaces.IItemDao;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.User;

public class ItemDAO implements IItemDao {

	@Override
	public boolean updateQuantity(Item i, int quantity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateName(Item i, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDescription(Item i, String description) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategory(Item i, String category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePrice(Item i, double price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Item> getAllItems(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemsByPrice(double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
