package com.fdmgroup.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.fdmgroup.controller.ShoppingCartController;
import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.UserSession;

public class ShoppingCartView {
	Scanner scanner;
	ArrayList<ShoppingCartItem> sci;
	
	public ShoppingCartView() {
		scanner = new Scanner(System.in);
	}
	
	public void showDashBoard() {
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Show Cart Details");
		System.out.println("2) Add Quantity");
		System.out.println("3) Remove Quantity");
		System.out.println("4) Delete Items outright");
		System.out.println("5) Process orders");
		System.out.println("6) Go Back");
		
		System.out.print(">>> ");
		String userInput = scanner.nextLine();
		
		switch (userInput) {
		case "1":
			getCartDetails();
			break;
		case "2":
			break;
		case "3":
			break;
		case "4":
			break;
		case "5":
			
			break;
		case "6":
			break;
		default:
			System.out.println("The input was invalid.");
			showDashBoard();
		}
	}

	private void getCartDetails() {
		ShoppingCartController scc = new ShoppingCartController();
		sci = scc.getCartDetails(UserSession.getLoggedInUser());
		
		if(sci.size()==0) {
			System.out.println("Nothing in the cart fam");
		}
		
		for (ShoppingCartItem scp : sci) {
			System.out.println(scp);
		}
		System.out.print("Press any key to go back");
		scanner.nextLine();
		showDashBoard();
	}
}
