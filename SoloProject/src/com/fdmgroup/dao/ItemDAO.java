package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Item;

public class ItemDAO implements IItemDao {

	@Override
	public Item create(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Item t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateQuantity(int pid, int quantity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateName(int pid, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDescription(int pid, String description) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategory(int pid, String category) {
		// TODO Auto-generated method stub
		return false;
	}

}
