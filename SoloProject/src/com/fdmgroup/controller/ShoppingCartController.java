package com.fdmgroup.controller;

import java.util.Scanner;

import com.fdmgroup.dao.implementation.ShoppingCartDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.UserSession;
import com.fdmgroup.view.StoreView;

public class ShoppingCartController {
	Scanner scanner;
	
	public ShoppingCartController() {
		scanner = new Scanner(System.in);
	}
	
	public void addToCart(Item i) {
		System.out.print("Enter quantity: ");
		int quantity = Integer.parseInt(scanner.nextLine());
		
		ShoppingCartDAO scd = new ShoppingCartDAO();
		
		if(scd.getQuantity(UserSession.getLoggedInUser(), i.getProductID())+quantity > i.getQuantity()) {
			System.out.println("Quantity maxed out. Nothing was added to the cart");
			StoreView sv = new StoreView();
			sv.showDashBoard();
		}
		scd.addItem(UserSession.getLoggedInUser(), i.getProductID(), quantity);
		System.out.println("Added "+quantity+" "+i.getName()+" to your cart");
		StoreView sv = new StoreView();
		sv.showDashBoard();
	}
}
