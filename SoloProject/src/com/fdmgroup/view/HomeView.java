package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.HomeController;
import com.fdmgroup.dao.UserCollectionDao;
import com.fdmgroup.model.User;

public class HomeView {

	private Scanner scanner;
	private HomeController homeController;
	private AuthenticationController authenticationController;
	
	public HomeView() {
		super();
	}
	
	public HomeView(Scanner scanner) {
		super();
		this.scanner = scanner;
	}
	
	public HomeView(Scanner scanner, HomeController homeController, AuthenticationController authenticationController) {
		super();
		this.scanner = scanner;
		this.homeController = homeController;
		this.authenticationController = authenticationController;
	}

	public void showInitialOptions(boolean showLogoutMessage) {
		if (showLogoutMessage) {
			System.out.println("You logged out successfully.");
		}
		
		System.out.println("Welcome to my Solo Project Version 1.0.0");
		System.out.println("Please choose one of the options below:");
		System.out.println("1) Login");
		System.out.println("2) Register");
		System.out.println("3) Exit");
		System.out.println("-------------------------------");
		String userInput = scanner.next();
		
		switch (userInput) {
		case "1":
			showLoginOptions(false);
			break;
		case "2":
			showRegisterOptions();
			break;
		case "3":
			System.out.println("Thanks, Goodbye!");
			System.exit(0);
			break;
		default:
			System.out.println("The input is invalid.");
			showInitialOptions(false);
		}
	}

	private void showRegisterOptions() {
		String userName;
		while(true){
			System.out.print("Enter username: ");
			userName=scanner.next();
			if(authenticationController.getUserDao().findByUsername(userName)==null){
				break;
			}
			System.out.println("Username already taken, try again");
		}
		String password;
		
		while(true){
			System.out.print("Enter password: ");
			password = scanner.next();
			System.out.print("Re-enter password: ");
			String reEnteredPassword = scanner.next();
			if(password.equals(reEnteredPassword)){
				break;
			}
			System.out.println("Mismatching passwords, try again.");
		}
		System.out.print("Enter first name: ");
		String firstName = scanner.next();
		System.out.print("Enter last name: ");
		String lastName = scanner.next();
		
		User user = new User(userName,password,firstName,lastName);
		authenticationController.getUserDao().create(user);
		System.out.println("User entered successfully!");
		showInitialOptions(false);
	}

	public void showLoginOptions(boolean showError) {
		if (showError) {
			System.out.println("Username/Password is wrong.");
		}
		
		System.out.println("Login");
		System.out.println("Please enter username: ");
		String username = scanner.nextLine();
		System.out.println("Please enter password: ");
		String password = scanner.nextLine();

		//TODO add validation here
		
		authenticationController.login(username, password);
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public HomeController getHomeController() {
		return homeController;
	}

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}

	public AuthenticationController getAuthenticationController() {
		return authenticationController;
	}

	public void setAuthenticationController(AuthenticationController authenticationController) {
		this.authenticationController = authenticationController;
	}
}




















