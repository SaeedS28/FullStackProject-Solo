package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.model.UserSession;

public class DashboardView {

	private Scanner scanner;
	private AuthenticationController authenticationController;
	
	public DashboardView() {
		super();
	}
	
	public DashboardView(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public DashboardView(Scanner scanner, AuthenticationController authenticationController) {
		super();
		this.scanner = scanner;
		this.authenticationController = authenticationController;
	}

	public void showDashboard() {
		System.out.println("Welcome " + UserSession.getLoggedInUser().getFirstname() + " " + UserSession.getLoggedInUser().getLastname() + "!");
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Logout");
		String userInput = scanner.nextLine();
		
		switch (userInput) {
		case "1":
			authenticationController.logout();
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

	public AuthenticationController getAuthenticationController() {
		return authenticationController;
	}

	public void setAuthenticationController(AuthenticationController authenticationController) {
		this.authenticationController = authenticationController;
	}
}



















