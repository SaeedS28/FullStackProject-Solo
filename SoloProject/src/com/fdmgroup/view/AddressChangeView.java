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
		System.out.println("6) Show current address");
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
		System.out.println("-------------------------------");
		AddressController ac = new AddressController();
		System.out.println("Postal code on file: "+ac.getAddress(UserSession.getLoggedInUser()).getPostalCode());
		
		String newCode;
		do {
			System.out.print("Enter new postal code: ");
			newCode = scanner.nextLine();
			if(newCode.length()>7) {
				System.out.println("Postal Code must be less than 8 characters long.");
			}
		}while(newCode.length()>7);
		ac.changePostalCode(newCode, UserSession.getLoggedInUser());
	}

	private void changeStreet() {
		System.out.println("-------------------------------");
		AddressController ac = new AddressController();
		System.out.println("Street on file: "+ac.getAddress(UserSession.getLoggedInUser()).getStreet());
		
		String newStreet;
		System.out.print("Enter new street: ");
		newStreet = scanner.nextLine();
		ac.changeStreet(newStreet, UserSession.getLoggedInUser());
	}

	private void changeCountry() {
		System.out.println("-------------------------------");
		AddressController ac = new AddressController();
		System.out.println("Country on file: "+ac.getAddress(UserSession.getLoggedInUser()).getCountry());
		
		String newCountry;
		System.out.print("Enter new country: ");
		newCountry = scanner.nextLine();
		ac.changeCountry(newCountry, UserSession.getLoggedInUser());
	}

	private void changeProvince() {
		System.out.println("-------------------------------");
		AddressController ac = new AddressController();
		System.out.println("Province on file: "+ac.getAddress(UserSession.getLoggedInUser()).getProvince());
		
		String newProvince;
		System.out.print("Enter new province: ");
		newProvince = scanner.nextLine();
		ac.changeProvince(newProvince, UserSession.getLoggedInUser());
	}

	private void changeCity() {
		System.out.println("-------------------------------");
		AddressController ac = new AddressController();
		System.out.println("City on file: "+ac.getAddress(UserSession.getLoggedInUser()).getCity());
		
		String newCity;
		System.out.print("Enter new city: ");
		newCity = scanner.nextLine();
		ac.changeCity(newCity, UserSession.getLoggedInUser());
	}
}
