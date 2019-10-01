package com.fdmgroup.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.fdmgroup.controller.ShoppingCartController;
import com.fdmgroup.controller.StoreController;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.User;
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
			addQuantity();
			break;
		case "3":
			removeQuantity();
			break;
		case "4":
			removeItem();
			break;
		case "5":
			processOrder();
			break;
		case "6":
			RegularUserMainView rumv = new RegularUserMainView();
			rumv.showDashboard();
			break;
		default:
			System.out.println("The input was invalid.");
			showDashBoard();
		}
	}

	private void processOrder() {
		// TODO Auto-generated method stub
		
	}

	private void removeItem() {
		// TODO Auto-generated method stub
		
	}

	private void removeQuantity() {
		// TODO Auto-generated method stub
		
	}

	private void addQuantity() {
		ShoppingCartController scc = new ShoppingCartController();
		sci = scc.getCartDetails(UserSession.getLoggedInUser());
		String userInput;
		
		do {
			System.out.println("-------------------------------");

			if (sci.size() == 0) {
				System.out.println("All out of items!");
				System.out.print("Press any key to go back: ");
				scanner.nextLine();
				showDashBoard();
			}

			System.out.println("All Items");
			for (int i = 0; i < sci.size(); i++) {
				System.out.println(i + 1 + ") " + sci.get(i));
			}

			System.out.println();
			System.out.println("1) Add Quantity: ");
			System.out.println("2) Go back");
			System.out.print(">>> ");
			userInput = scanner.nextLine();

			if (!userInput.equals("1") && !userInput.equals("2")) {
				System.out.println("Invalid choice. Try again");
			}
		} while (!userInput.equals("1") && !userInput.equals("2"));
		
		if (userInput.equals("1")) {
			addToCart(sci);
		} else {
			showDashBoard();
		}
	}

	private void getCartDetails() {
		ShoppingCartController scc = new ShoppingCartController();
		sci = scc.getCartDetails(UserSession.getLoggedInUser());
		
		System.out.println("-------------------------------");
		if(sci.size()==0) {
			System.out.println("Nothing in the cart fam");
		}
		System.out.println("Cart total: "+ scc.getTotalPrice(UserSession.getLoggedInUser()));		
		for (ShoppingCartItem scp : sci) {
			System.out.println(scp);
		}
		
		System.out.print("Press any key to go back");
		scanner.nextLine();
		showDashBoard();
	}
	
	private void addToCart(ArrayList<ShoppingCartItem> items) {
		int itemChoice;
		do {
			System.out.println("-------------------------------");
			
			for (int i = 0; i < items.size(); i++) {
				System.out.println(i + 1 + ") " + items.get(i));
			}
			System.out.println("Choose a product: ");
			System.out.print(">>> ");
			itemChoice = Integer.parseInt(scanner.nextLine());
			if (itemChoice - 1 >= 0 && itemChoice - 1 < items.size()) {
				break;
			}
			System.out.println("Invalid choice. Try again");
		} while (true);
		
		ShoppingCartItem choice = items.get(itemChoice-1);
		ShoppingCartController sc = new ShoppingCartController();
		sc.addQuantity(UserSession.getLoggedInUser(),choice);
	}
}
