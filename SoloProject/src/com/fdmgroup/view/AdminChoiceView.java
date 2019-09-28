package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.model.UserSession;

public class AdminChoiceView {

	private Scanner scanner;
	
	public AdminChoiceView() {
		scanner = new Scanner(System.in);
	}
	

	public void showDashboard() {
		AuthenticationController ac = new AuthenticationController();
		
		System.out.println("Welcome " + UserSession.getLoggedInUser().getFirstname() + " " + 
				UserSession.getLoggedInUser().getLastname() + "\tType: "+UserSession.getLoggedInUser().getType());
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Logout");
		System.out.print(">>> ");
		String userInput = scanner.next();
		
		switch (userInput) {
		case "1":
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