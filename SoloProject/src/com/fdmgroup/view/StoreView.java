package com.fdmgroup.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.fdmgroup.controller.AdminInventoryController;
import com.fdmgroup.controller.ShoppingCartController;
import com.fdmgroup.controller.StoreController;
import com.fdmgroup.model.Item;

public class StoreView {
	private Scanner scanner;
	private ArrayList<Item> allItems;

	public StoreView() {
		scanner = new Scanner(System.in);
	}

	public void showDashBoard() {
		System.out.println("-------------------------------");
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Show all items");
		System.out.println("2) Show items by category");
		System.out.println("3) Show items by price range");
		System.out.println("4) Search for an item by name");
		System.out.println("5) Go back");
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
			showItemsByPriceRange();
			break;
		case "4":
			showItemsByName();
			break;
		case "5":
			RegularUserMainView rumv = new RegularUserMainView();
			rumv.showDashboard();
			break;
		default:
			System.out.println("The input was invalid.");
			showDashBoard();
		}
	}

	private void showItemsByName() {
		StoreController sc = new StoreController();
		String userInput;
		
		
		System.out.println("-------------------------------");
		System.out.print("Enter a string to search for an item: ");
		String searchString = scanner.nextLine();
		allItems = sc.getItemsByName(searchString);
		System.out.println("Search result for: "+searchString);
		
		if (allItems.size() == 0) {
			System.out.println("Nothing popped up");
			System.out.print("Press any key to go back: ");
			scanner.nextLine();
			showDashBoard();
		}
		do {
			for (int i = 0; i < allItems.size(); i++) {
				System.out.println(i + 1 + ") " + allItems.get(i));
			}
			
			System.out.println();
			System.out.println("1) Add item to cart");
			System.out.println("2) Go back");
			System.out.print(">>> ");
			userInput = scanner.nextLine();
			
			if (!userInput.equals("1") && !userInput.equals("2")) {
				System.out.println("Invalid choice. Try again");
			}
		} while (!userInput.equals("1") && !userInput.equals("2"));
		
		if (userInput.equals("1")) {
			addToCart(allItems);
		} else {
			showDashBoard();
		}
	}

	private void showItemsByPriceRange() {
		StoreController sc = new StoreController();
		String userInput;
		
		
		System.out.println("-------------------------------");
		System.out.print("Enter min price: ");
		double minPrice = Double.parseDouble(scanner.nextLine());
		System.out.print("Enter max price: ");
		double maxPrice = Double.parseDouble(scanner.nextLine());
		
		allItems = sc.getItemsByPriceRange(minPrice, maxPrice);
		System.out.println("Search result for price range: $"+minPrice +"-"+maxPrice);
		
		if (allItems.size() == 0) {
			System.out.println("Nothing popped up");
			System.out.print("Press any key to go back: ");
			scanner.nextLine();
			showDashBoard();
		}
		do {
			for (int i = 0; i < allItems.size(); i++) {
				System.out.println(i + 1 + ") " + allItems.get(i));
			}
			
			System.out.println();
			System.out.println("1) Add item to cart");
			System.out.println("2) Go back");
			System.out.print(">>> ");
			userInput = scanner.nextLine();
			
			if (!userInput.equals("1") && !userInput.equals("2")) {
				System.out.println("Invalid choice. Try again");
			}
		} while (!userInput.equals("1") && !userInput.equals("2"));
		
		if (userInput.equals("1")) {
			addToCart(allItems);
		} else {
			showDashBoard();
		}

	}

	private void showItemsByCategories() {
		AdminInventoryController aic = new AdminInventoryController();
		ArrayList<String> categories = aic.getAllCategories();
		int catChoice;

		do {
			System.out.println("-------------------------------");
			System.out.println("Categories");
			
			if(categories.size()==0) {
				System.out.println("Nothing exists");
				System.out.println("Press Enter to go back");
				scanner.nextLine();
				showDashBoard();
			}
			for (int i = 0; i < categories.size(); i++) {
				System.out.println(i + 1 + ") " + categories.get(i));
			}
			System.out.println("Make a choice");
			System.out.print(">>> ");
			catChoice = Integer.parseInt(scanner.nextLine());
			if (catChoice - 1 >= 0 && catChoice - 1 < categories.size()) {
				break;
			}
			System.out.println("Invalid choice. Try again");
		} while (true);
		
		String userInput;
		allItems = aic.getItemsByCategory(categories.get(catChoice - 1));
		
		do {
			System.out.println("-------------------------------");

			if (allItems.size() == 0) {
				System.out.println("All out of items!");
				System.out.print("Press any key to go back: ");
				scanner.nextLine();
				showDashBoard();
			}

			System.out.println("All Items in the chosen category");
			for (int i = 0; i < allItems.size(); i++) {
				System.out.println(i + 1 + ") " + allItems.get(i));
			}

			System.out.println();
			System.out.println("1) Add item to cart");
			System.out.println("2) Go back");
			System.out.print(">>> ");
			userInput = scanner.nextLine();

			if (!userInput.equals("1") && !userInput.equals("2")) {
				System.out.println("Invalid choice. Try again");
			}
		} while (!userInput.equals("1") && !userInput.equals("2"));

		if (userInput.equals("1")) {
			addToCart(allItems);
		} else {
			showDashBoard();
		}
	}

	private void showAllItems() {
		StoreController sc = new StoreController();
		String userInput;
		allItems = sc.getAllItems();

		do {
			System.out.println("-------------------------------");

			if (allItems.size() == 0) {
				System.out.println("All out of items!");
				System.out.print("Press any key to go back: ");
				scanner.nextLine();
				showDashBoard();
			}

			System.out.println("All Items");
			for (int i = 0; i < allItems.size(); i++) {
				System.out.println(i + 1 + ") " + allItems.get(i));
			}

			System.out.println();
			System.out.println("1) Add item to cart");
			System.out.println("2) Go back");
			System.out.print(">>> ");
			userInput = scanner.nextLine();

			if (!userInput.equals("1") && !userInput.equals("2")) {
				System.out.println("Invalid choice. Try again");
			}
		} while (!userInput.equals("1") && !userInput.equals("2"));

		if (userInput.equals("1")) {
			addToCart(allItems);
		} else {
			showDashBoard();
		}
	}
	
	private void addToCart(ArrayList<Item> items) {
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
		
		Item choice = items.get(itemChoice-1);
		ShoppingCartController sc = new ShoppingCartController();
		sc.addToCart(choice);
	}
}
