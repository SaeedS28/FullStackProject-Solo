package com.fdmgroup.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.fdmgroup.controller.UserController;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;

public class UserView {
	private Scanner scanner;
	private UserController uc;

	public UserView() {
		this.scanner = new Scanner(System.in);
		this.uc = new UserController();
	}

	public void showDashboard() {
		System.out.println("-------------------------------");
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Add user");
		System.out.println("2) Remove user");
		System.out.println("3) Change your own password");
		System.out.println("4) Go Back");
		System.out.print(">>> ");
		String userInput = scanner.nextLine();

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
			AdminUserMainView aw = new AdminUserMainView();
			aw.showDashboard();
			break;
		default:
			System.out.println("The input was invalid.");
			showDashboard();
		}
	}

	public void changePassword() {
		UserController uc = new UserController();
		uc.changePassword();
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
		index = Integer.parseInt(scanner.nextLine());

		if ((index - 1) < 0 || (index - 1) >= users.size()) {
			System.out.println("Invalid choice, try again");
			removeUser();
		}
		uc.removeUser(index-1, users);
	}

	private void addUser() {
		String userName;
		String password;
		String firstName;
		String lastName;
		String type;
		int typeChoice;
		System.out.println("-------------------------------");
		System.out.println("New User Wizard");
		
		do {
			System.out.print("Enter user name: ");
			userName = scanner.nextLine();
			if(uc.getUser(userName)!=null) {
				System.out.println("Username already taken. Enter a new username");
				continue;
			}
			break;
		} while(true);
		
		System.out.print("Enter password: ");
		password = scanner.nextLine();
		System.out.print("Enter first name: ");
		firstName = scanner.nextLine();
		System.out.print("Enter last name: ");
		lastName = scanner.nextLine();
		
		do {
			System.out.println("Pick user type: ");
			System.out.println("1) regular");
			System.out.println("2) admin");
			System.out.print(">>> ");
			typeChoice = Integer.parseInt(scanner.nextLine());
			if(typeChoice==1) {
				type = "regular";
			}else if(typeChoice==2) {
				type = "admin";
			}
			else {
				System.out.println("Invalid choice. Try again");
				continue;
			}
			break;
		} while(true);
		User newUser = new User(userName,password,firstName,lastName,type);
		
		String street;
		String city;
		String province;
		String country;
		String postalCode;
		
		System.out.println("-------------------------------");
		System.out.println("New Address Wizard");
		System.out.print("Enter Steet adress: ");
		street = scanner.nextLine();
		System.out.print("Enter City: ");
		city = scanner.nextLine();
		System.out.print("Enter Province: ");
		province = scanner.nextLine();
		System.out.print("Enter Country: ");
		country = scanner.nextLine();
		System.out.print("Enter Postal code: ");
		postalCode= scanner.nextLine();
		
		Address newAddress = new Address(userName, street, city, province, country, postalCode);
		
		uc.addUser(newUser, newAddress);
	}
}