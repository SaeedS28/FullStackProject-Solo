package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.dao.implementation.ItemDAO;
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
		int quantity;
		do {
			System.out.print("Enter quantity: ");
			quantity = Integer.parseInt(scanner.nextLine());
			if(quantity<=0) {
				System.out.println("Invalid quantity, try again");
			}
			break;
		} while(true);
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
		ItemDAO itd = new ItemDAO();
		System.out.print("Enter quantity (- to remove): ");
		int quantity = Integer.parseInt(scanner.nextLine());
		
		ShoppingCartDAO scd = new ShoppingCartDAO();
		
		if(scd.getQuantity(UserSession.getLoggedInUser(), sci.getProductID())+quantity > itd.getItemQuantity(sci.getItemID())
				|| scd.getQuantity(UserSession.getLoggedInUser(), sci.getProductID())+quantity<=0) {
			System.out.println("Quantity maxed out or non-positve quantity detected. Nothing was modified from the cart");
			ShoppingCartView sv = new ShoppingCartView();
			sv.showDashBoard();
		}
		scd.addItem(UserSession.getLoggedInUser(), sci.getProductID(), quantity);
		System.out.println("Modified "+quantity+" "+sci.getProductName()+" to your cart");
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
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("SoloProject");
		em = emf.createEntityManager();		

		for(int i=0;i<sci.size();i++) {
			Item item = em.find(Item.class, sci.get(i).getProductID());
			if(item.getQuantity()<sci.get(i).getCartQuantity()) {
				System.out.println("Product inventory insufficient to complete the order. Nothing was processed");
				ShoppingCartView sv = new ShoppingCartView();
				sv.showDashBoard();
			}
		}
		PurchaseOrderDAO pod = new PurchaseOrderDAO();
		pod.addPurchaseOrder(loggedInUser, sci);
		System.out.println("Order Processed successfully. Thank you for shopping with us!!!!");
		ShoppingCartView sv = new ShoppingCartView();
		sv.showDashBoard();
	}
	
	public ArrayList<PurchaseOrder> getUserOrders(User u){
		PurchaseOrderDAO pod = new PurchaseOrderDAO();
		return pod.getPurchaseOrdersByUser(u);
	}
}
