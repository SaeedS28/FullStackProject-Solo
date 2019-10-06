package com.fdmgroup.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fdmgroup.dao.interfaces.IPurchaseOrderDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.PurchaseOrder;
import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.User;
import com.fdmgroup.util.DataSource;

public class PurchaseOrderDAO implements IPurchaseOrderDAO {

	public boolean addPurchaseOrder(User u, ArrayList<ShoppingCartItem> cart) {
		
		return true;
	}

	public ArrayList<PurchaseOrder> getPurchaseOrdersByUser(User u) {
		
		return null;
	}

	public ArrayList<PurchaseOrder> getAllPurchaseOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
