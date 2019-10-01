package com.fdmgroup.dao.interfaces;

import java.util.ArrayList;

import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.PurchaseOrder;
import com.fdmgroup.model.User;

public interface IPurchaseOrderDAO {
	public boolean addPurchaseOrder(User u, ArrayList<ShoppingCartItem> cart);
	public ArrayList<PurchaseOrder> getPurchaseOrdersByUser(User u);
	public int getMaxPurchaseID();
}
