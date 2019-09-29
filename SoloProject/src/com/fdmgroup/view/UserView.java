package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.UserController;

public class UserView {
	private Scanner scanner;
	private UserController uc;
	
	public UserView() {
		this.scanner = new Scanner(System.in);
		this.uc = new UserController();
	}
	
	public void showDashboard() {
		UserController uc = new UserController();
		
		System.out.println("-------------------------------");
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Add user");
		System.out.println("2) Remove user");
		System.out.println("3) Go Back");
		System.out.print(">>> ");
		String userInput = scanner.next();
		
		switch (userInput) {
		case "1":
			addUser();
			break;
		case "2":
			removeUser();
			break;
		case "3":
			AdminChoiceView acw = new AdminChoiceView();
			acw.showDashboard();
			break;
		default:
			System.out.println("The input was invalid.");
			showDashboard();
		}
	}

	private void removeUser() {
		
	}

	private void addUser() {
		
	}
}
