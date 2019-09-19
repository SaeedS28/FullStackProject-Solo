package com.fdmgroup.dao.implementation;

import java.sql.Date;
import java.util.List;

import com.fdmgroup.dao.interfaces.IPurchaseOrder;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.User;

public class PoDAO implements IPurchaseOrder {

	@Override
	public boolean addPurchaseOrder(User u, List<Item> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Item> getPurchaseOrdersByDate(Date d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getPurchaseOrdersByUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
