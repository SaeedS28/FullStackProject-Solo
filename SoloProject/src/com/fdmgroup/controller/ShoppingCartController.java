package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.fdmgroup.dao.implementation.PurchaseOrderDAO;
import com.fdmgroup.dao.implementation.ShoppingCartDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.PurchaseOrder;
import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;
import com.fdmgroup.view.ShoppingCartView;
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
	
	public ArrayList<ShoppingCartItem> getCartDetails(User u){
		ShoppingCartDAO scd = new ShoppingCartDAO();
		return scd.getCartDetails(u);
	}
	
	public double getTotalPrice(User u) {
		ShoppingCartDAO scd = new ShoppingCartDAO();
		return scd.getCartTotal(u);
	}
	
	public void addQuantity(User u, ShoppingCartItem sci) {
		System.out.print("Enter quantity (- to remove): ");
		int quantity = Integer.parseInt(scanner.nextLine());
		
		ShoppingCartDAO scd = new ShoppingCartDAO();
		
		if(scd.getQuantity(UserSession.getLoggedInUser(), sci.getProductID())+quantity > sci.getItemQuantity()
				|| scd.getQuantity(UserSession.getLoggedInUser(), sci.getProductID())+quantity<0) {
			System.out.println("Quantity maxed out or negative quantity. Nothing was modified from the cart");
			ShoppingCartView sv = new ShoppingCartView();
			sv.showDashBoard();
		}
		scd.addItem(UserSession.getLoggedInUser(), sci.getProductID(), quantity);
		System.out.println("Modified "+quantity+" "+sci.getName()+" to your cart");
		ShoppingCartView scv= new ShoppingCartView();
		scv.showDashBoard();
	}

	public void removeOutright(User loggedInUser, ShoppingCartItem choice) {
		ShoppingCartDAO scd = new ShoppingCartDAO();
		scd.removeItem(UserSession.getLoggedInUser(), choice.getProductID());
		System.out.println("Item was removed from cart");
		ShoppingCartView scv= new ShoppingCartView();
		scv.showDashBoard();
	}

	public void processOrders(User loggedInUser, ArrayList<ShoppingCartItem> sci) {
		PurchaseOrderDAO pod = new PurchaseOrderDAO();
		pod.addPurchaseOrder(loggedInUser, sci);
		ShoppingCartDAO scd = new ShoppingCartDAO();
		scd.removeAllItem(UserSession.getLoggedInUser());
		System.out.println("Order Processed successfully. Thank you for shopping with us!!!!");
		ShoppingCartView sv = new ShoppingCartView();
		sv.showDashBoard();
	}
	
	public ArrayList<PurchaseOrder> getUserOrders(User u){
		PurchaseOrderDAO pod = new PurchaseOrderDAO();
		return pod.getPurchaseOrdersByUser(u);
	}
}
