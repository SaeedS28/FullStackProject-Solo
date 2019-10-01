package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.AddressController;
import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.model.UserSession;

public class AddressChangeView {
	
	Scanner scanner;
	
	public AddressChangeView() {
		scanner=new Scanner(System.in);
	}
	
	public void showDashboard() {		
		System.out.println("-------------------------------");
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Change City");
		System.out.println("2) Change Street Address");
		System.out.println("3) Change Province/Territory");
		System.out.println("4) Change Country");
		System.out.println("5) Change Postal Code");
		System.out.println("6  Show current address");
		System.out.println("7) Go back");
		
		System.out.print(">>> ");
		String userInput = scanner.nextLine();
		
		switch (userInput) {
		case "1":
			changeCity();
			break;
		case "2":
			changeStreet();
			break;
		case "3":
			changeProvince();
			break;
		case "4":
			changeCountry();
			break;
		case "5":
			changePostalCode();
			break;
		case "6":
			getCurrentAddress();
			break;
		case "7":
			RegularUserMainView rumv = new RegularUserMainView();
			rumv.showDashboard();
		default:
			System.out.println("The input was invalid.");
			showDashboard();
		}
	}

	private void getCurrentAddress() {
		System.out.println("-------------------------------");
		AddressController ac = new AddressController();
		
		System.out.println("Address on file: "+ac.getAddress(UserSession.getLoggedInUser()).toString());
		System.out.print("Press any key to go back: ");
		scanner.nextLine();
		showDashboard();
	}

	private void changePostalCode() {
		
	}

	private void changeStreet() {
		
	}

	private void changeCountry() {
		
	}

	private void changeProvince() {
		
	}

	private void changeCity() {
		
	}
}
