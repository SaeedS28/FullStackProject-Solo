package com.fdmgroup.dao.interfaces;

import java.sql.Timestamp;
import java.util.List;

import com.fdmgroup.model.PurchaseOrder;
import com.fdmgroup.model.ShoppingCart;
import com.fdmgroup.model.User;

public interface IPurchaseOrderDAO {
	public boolean addPurchaseOrder(User u, ShoppingCart cart);
	public List<PurchaseOrder> getPurchaseOrdersByDate(Timestamp d);
	public List<PurchaseOrder> getPurchaseOrdersByUser(User u);
	
}
