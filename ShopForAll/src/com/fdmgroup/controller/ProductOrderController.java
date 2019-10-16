package com.fdmgroup.controller;

import java.util.ArrayList;

import com.fdmgroup.dao.implementation.PurchaseOrderDAO;
import com.fdmgroup.model.PurchaseOrder;
import com.fdmgroup.model.User;

public class ProductOrderController {
	public ArrayList<PurchaseOrder> getAllPurchaseOrders(){
		PurchaseOrderDAO pod = new PurchaseOrderDAO();
		return pod.getAllPurchaseOrders();
	}
	
	public ArrayList<PurchaseOrder> getPurchaseOrdersByUser(User u){
		PurchaseOrderDAO pod = new PurchaseOrderDAO();
		return pod.getPurchaseOrdersByUser(u);
	}
}
