package com.fdmgroup.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.fdmgroup.controller.UserController;
import com.fdmgroup.model.User;

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
		System.out.println("3) Change your own password");
		System.out.println("4) Go Back");
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
			changePassword();
			break;
		case "4":
			AdminChoiceView aw = new AdminChoiceView();
			aw.showDashboard();
			break;
		default:
			System.out.println("The input was invalid.");
			showDashboard();
		}
	}

	private void changePassword() {
		// TODO Auto-generated method stub
		
	}

	private void removeUser() {
		ArrayList<User> users = uc.getAllUsers();
		System.out.println("-------------------------------");
		System.out.println("Current users: ");

		for (int i = 0; i < users.size(); i++) {
			System.out.println(i + 1 + ")  " + users.get(i));
		}
		int index;

		System.out.println("Enter the number on the side to delete that user");
		System.out.print(">>> ");
		index = scanner.nextInt();

		if ((index - 1) < 0 || (index - 1) >= users.size()) {
			System.out.println("Invalid choice, try again");
			removeUser();
		}
		uc.removeUser(index-1, users);
	}

	private void addUser() {

	}
}
