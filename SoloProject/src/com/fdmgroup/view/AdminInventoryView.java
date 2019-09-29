package com.fdmgroup.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.fdmgroup.controller.AdminInventoryController;
import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.UserSession;

public class AdminInventoryView {
	private Scanner scanner;
	private ArrayList<Item> allItems;
	private AdminInventoryController aic;
	
	public AdminInventoryView() {
		scanner = new Scanner(System.in);
		aic = new AdminInventoryController();
	}
	
	public void showDashBoard() {
		System.out.println("-------------------------------");
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Show all items");
		System.out.println("2) Show items by category");
		System.out.println("3) Add new item");
		System.out.println("4) Change Item property");
		System.out.println("5) Delete Item");
		System.out.println("6) Go back");
		System.out.println("7) Logout");
		System.out.print(">>> ");
		String userInput = scanner.nextLine();
		
		switch (userInput) {
		case "1":
			showAllItems();
			break;
		case "2":
			showItemsByCategories();
			break;
		case "3":
			
			break;
		case "4":
			
			break;
		case "5":
			
			break;
		case "6":
			AdminChoiceView acw = new AdminChoiceView();
			acw.showDashboard();
			break;
		case "7":
			AuthenticationController ac = new AuthenticationController();
			ac.logout();
			break;
		default:
			System.out.println("The input was invalid.");
			showDashBoard();
		}
	}

	private void showItemsByCategories() {
		ArrayList<String> categories = aic.getAllCategories();
		int catChoice;
		
		do {
			System.out.println("-------------------------------");
			System.out.println("Categories");
			for(int i = 0;i<categories.size();i++) {
				System.out.println(i+1+") "+categories.get(i));
			}
			System.out.println("Make a choice");
			System.out.print(">>> ");
			catChoice = Integer.parseInt(scanner.nextLine());
			if(catChoice-1>=0 && catChoice-1<categories.size()) {
				break;
			}
			System.out.println("Invalid choice. Try again");
		} while (true);
		ArrayList<Item> items = aic.getItemsByCategory(categories.get(catChoice-1));
		for(int i=0;i<items.size();i++) {
			System.out.println(items.get(i));
		}
		System.out.println();
		System.out.print("Press any key to go back: ");
		scanner.nextLine();
		showDashBoard();
	}

	private void showAllItems() {
		allItems = aic.getAllItems();
		System.out.println("-------------------------------");
		
		for(int i=0;i<allItems.size();i++) {
			System.out.println(allItems.get(i));
		}
		System.out.print("Press any key to go back: ");
		scanner.nextLine();
		showDashBoard();
	}
}
