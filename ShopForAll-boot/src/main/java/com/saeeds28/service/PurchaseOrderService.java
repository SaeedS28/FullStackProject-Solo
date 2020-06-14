package com.saeeds28.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeeds28.model.PurchaseOrder;
import com.saeeds28.model.UserSession;
import com.saeeds28.repository.PurchaseOrderRepo;

@Service
public class PurchaseOrderService {

	@Autowired
	PurchaseOrderRepo po;
	
	public List<PurchaseOrder> getAllPurchasesForCustomers(){
		if(UserSession.getLoggedInUser().getType().equals("admin")) {
			return po.findAll();
		}
		return po.getPurchasesByUser(UserSession.getLoggedInUser().getUsername());			
	}
	
	public double getPurchaseTotal() {
		Double total;
		if(UserSession.getLoggedInUser().getType().equals("admin")) {
			total = po.getSumOfAllPurchases();
		}
		else {
			total = po.getSumOfAllPurchases(UserSession.getLoggedInUser().getUsername());
		}
		
		if(total == null) {
			return 0;
		}
		return total;
	}
	
	public boolean isItemPurchased(int productId) {
		if(po.getPurchaseCountForUser(productId, UserSession.getLoggedInUser().getUsername()) > 0) {
			return true;
		}
		return false;
	}
}
