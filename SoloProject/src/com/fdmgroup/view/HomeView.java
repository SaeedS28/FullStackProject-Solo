package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;

public class HomeView {

	private Scanner scanner;
	
	public HomeView() {
		scanner = new Scanner(System.in);
	}
	
	public HomeView(Scanner scanner) {
		super();
		this.scanner = scanner;
	}
	
	public void showInitialOptions(boolean showLogoutMessage) {
		if (showLogoutMessage) {
			System.out.println("You logged out successfully.");
		}
		System.out.println("-------------------------------");
		System.out.println("Welcome to the store");
		System.out.println("Please choose one of the options below:");
		System.out.println("1) Login");
		System.out.println("2) Exit");
		System.out.println("-------------------------------");
		System.out.print(">>> ");
		String userInput = scanner.nextLine();
		
		switch (userInput) {
		case "1":
			showLoginOptions(false);
			break;
		case "2":
			System.out.println("Goodbye!");
			System.exit(0);
			break;
		default:
			System.out.println("The input is invalid.");
			showInitialOptions(false);
		}
	}

	public void showLoginOptions(boolean showError) {
		if (showError) {
			System.out.println("Username/Password is wrong.");
		}
		
		System.out.println("Login");
		System.out.print("Please enter username: ");
		String username = scanner.nextLine();
		System.out.print("Please enter password: ");
		String password = scanner.nextLine();

		//TODO add validation here
		AuthenticationController ac = new AuthenticationController();
		
		ac.login(username, password);
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
}