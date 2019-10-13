package com.fdmgroup.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.ShoppingCartController;
import com.fdmgroup.model.PurchaseOrder;
import com.fdmgroup.model.UserSession;

public class RegularUserMainView {

	private Scanner scanner;
	
	public RegularUserMainView() {
		scanner = new Scanner(System.in);
	}

	public void showDashboard() {
		AuthenticationController ac = new AuthenticationController();
		
		System.out.println("-------------------------------");
		System.out.println("Welcome " + UserSession.getLoggedInUser().getFirstname() + " " + 
				UserSession.getLoggedInUser().getLastname() + "\tType: "+UserSession.getLoggedInUser().getType());
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Change Password");
		System.out.println("2) Change Address");
		System.out.println("3) Go Shopping");
		System.out.println("4) Shopping Cart");
		System.out.println("5) See order history");
		System.out.println("6) Write a product review for an already purchased product");
		System.out.println("7) Logout");
		
		System.out.print(">>> ");
		String userInput = scanner.nextLine();
		
		switch (userInput) {
		case "1":
			UserView uv = new UserView();
			uv.changePassword();
			break;
		case "2":
			AddressChangeView acw = new AddressChangeView();
			acw.showDashboard();
			break;
		case "3":
			StoreView sv = new StoreView();
			sv.showDashBoard();
			break;
		case "4":
			ShoppingCartView scv = new ShoppingCartView();
			scv.showDashBoard();
			break;
		case "5":
			seeOrderHistory();
			break;
		case "6":
			writeReview();
		case "7":
			ac.logout();
			break;
		default:
			System.out.println("The input was invalid.");
			showDashboard();
		}
	}

	private void writeReview() {
		
	}

	private void seeOrderHistory() {
		System.out.println("-------------------------------");
		ShoppingCartController scc = new ShoppingCartController();
		
		System.out.println("Order history");
		ArrayList<PurchaseOrder> po = scc.getUserOrders(UserSession.getLoggedInUser());
		
		if(po.size()==0) {
			System.out.println("No order exists!");
		}
		
		for(int i=0;i<po.size();i++) {
			System.out.println(i+1+") "+po.get(i));
		}
		System.out.println("Press any key to go back");
		scanner.nextLine();
		showDashboard();
	}
}
