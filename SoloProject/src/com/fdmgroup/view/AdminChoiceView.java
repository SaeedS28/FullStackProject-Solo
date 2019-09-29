package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.UserController;
import com.fdmgroup.model.UserSession;

public class AdminChoiceView {

	private Scanner scanner;
	
	public AdminChoiceView() {
		scanner = new Scanner(System.in);
	}

	public void showDashboard() {
		AuthenticationController ac = new AuthenticationController();
		
		UserController uc = new UserController();
		System.out.println("-------------------------------");
		System.out.println("Welcome " + UserSession.getLoggedInUser().getFirstname() + " " + 
				UserSession.getLoggedInUser().getLastname() + "\tType: "+UserSession.getLoggedInUser().getType());
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Perform User related Activities");
		System.out.println("2) Perform Inventory related Activities");
		System.out.println("3) Logout");
		System.out.print(">>> ");
		String userInput = scanner.next();
		
		switch (userInput) {
		case "1":
			UserView uw = new UserView();
			uw.showDashboard();
			break;
		case "2":
			System.out.println("Inventory Hit");	
			break;
		case "3":
			ac.logout();
			break;
		default:
			System.out.println("The input was invalid.");
			showDashboard();
		}
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
}