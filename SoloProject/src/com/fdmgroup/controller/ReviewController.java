package com.fdmgroup.controller;

import java.util.ArrayList;

import com.fdmgroup.dao.implementation.PurchaseOrderDAO;
import com.fdmgroup.dao.implementation.ReviewDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.Review;
import com.fdmgroup.model.User;

public class ReviewController {
	public ArrayList<Item> getAllPurchasedItems(User u){
		PurchaseOrderDAO pod = new PurchaseOrderDAO();
		return pod.getDistinctProductPurchasesByUser(u);
	}
	
	public void addReview(Review r) {
		ReviewDAO rd = new ReviewDAO();
		rd.addReview(r);
	}
}
