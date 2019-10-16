package com.fdmgroup.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.ProductOrderController;
import com.fdmgroup.model.PurchaseOrder;
import com.fdmgroup.model.UserSession;

public class AdminUserMainView {

	private Scanner scanner;

	public AdminUserMainView() {
		scanner = new Scanner(System.in);
	}

	public void showDashboard() {
		AuthenticationController ac = new AuthenticationController();

		System.out.println("-------------------------------");
		System.out.println("Welcome " + UserSession.getLoggedInUser().getFirstname() + " "
				+ UserSession.getLoggedInUser().getLastname() + "\tType: " + UserSession.getLoggedInUser().getType());
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Perform User related Activities");
		System.out.println("2) Perform Inventory related Activities");
		System.out.println("3) See all processed orders ");
		System.out.println("4) Logout");
		System.out.print(">>> ");
		String userInput = scanner.nextLine();

		switch (userInput) {
		case "1":
			UserView uw = new UserView();
			uw.showDashboard();
			break;
		case "2":
			AdminInventoryView aiv = new AdminInventoryView();
			aiv.showDashBoard();
			break;
		case "3":
			showAllOrders();
			break;
		case "4":
			ac.logout();
		default:
			System.out.println("The input was invalid.");
			showDashboard();
		}

	}

	private void showAllOrders() {
		ProductOrderController poc = new ProductOrderController();
		ArrayList<PurchaseOrder> all;
		all = poc.getAllPurchaseOrders();

		System.out.println("-------------------------------");
		System.out.println("Purchase Made");
		for (int i = 0; i < all.size(); i++) {
			System.out.println(i + 1 + ") " + all.get(i));
		}
		if (all == null || all.size() == 0) {
			System.out.println("Nothing exists");
		}
		System.out.println("Press Enter to go back");
		scanner.nextLine();
		showDashboard();

	}
}