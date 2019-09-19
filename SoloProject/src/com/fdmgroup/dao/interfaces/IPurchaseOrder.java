package com.fdmgroup.dao.interfaces;

import java.sql.Date;
import java.util.List;

import com.fdmgroup.model.Item;
import com.fdmgroup.model.User;

public interface IPurchaseOrder {
	public boolean addPurchaseOrder(User u, List<Item> items);
	public List<Item> getPurchaseOrdersByDate(Date d);
	public List<Item> getPurchaseOrdersByUser(User u);
	
}
