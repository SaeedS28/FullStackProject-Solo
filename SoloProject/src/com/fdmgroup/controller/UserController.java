package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.fdmgroup.dao.implementation.AddressDAO;
import com.fdmgroup.dao.implementation.UserDAO;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;
import com.fdmgroup.view.AdminChoiceView;
import com.fdmgroup.view.RegularUserView;
import com.fdmgroup.view.UserView;

public class UserController {
	private UserDAO ud;
	private AddressDAO ad;
	private UserView uv;
	private Scanner scanner;
	
	public UserController() {
		ud = new UserDAO();
		ad = new AddressDAO();
		scanner = new Scanner(System.in);
	}
	
	public ArrayList<User> getAllUsers(){
		return ud.getAllUsers();
	}
	
	public void removeUser(int i, ArrayList<User> users) {
		uv = new UserView();
		String userToDelete;
		if(users.get(i).getUsername().equals(UserSession.getLoggedInUser().getUsername())) {
			System.out.println("You cannot delete yourself. This ensures that at least one admin is present at all times");
			uv.showDashboard();
		}
		userToDelete = users.get(i).getUsername();
		ud.remove(users.get(i).getUsername());
		System.out.println(userToDelete + " was deleted successfully.");
		uv.showDashboard();
	}
	
	public void changePassword() {
		System.out.println("-------------------------------");
		System.out.print("Enter current password: ");
		String currentPassword = scanner.nextLine();
		String confirmPassword; 
		String newPassword;
		
		if(!UserSession.getLoggedInUser().getPassword().equals(currentPassword)) {
			System.out.println("Current password does not match the records. Bailing out");
			if(UserSession.getLoggedInUser().getType().equals("admin")) {
				AdminChoiceView acw = new AdminChoiceView();
				acw.showDashboard();
			} else if(UserSession.getLoggedInUser().getType().equals("regular")) {
				RegularUserView ruv = new RegularUserView();
				ruv.showDashboard();
			}
		}
		do {
			System.out.print("Enter new password: ");
			newPassword= scanner.nextLine();
			System.out.print("Confirm password: ");
			confirmPassword= scanner.nextLine();
			if(!newPassword.equals(confirmPassword)) {
				System.out.println("Password don't match. Try again");
				continue;
			}
			break;
		} while(true);
		ud.updatePassword(UserSession.getLoggedInUser(), confirmPassword);
		UserSession.getLoggedInUser().setPassword(confirmPassword);
		System.out.println("Password changed successfully\nLogging out");
		AuthenticationController ac = new AuthenticationController();
		ac.logout();
		
	}
	
	public User getUser(String userName) {
		return ud.findByUsername(userName);
	}
	
	public void addUser(User newUser, Address newAddress) {
		ud.create(newUser);
		ad.addAddress(newAddress);
		System.out.println("New user added successfully");
		uv = new UserView();
		uv.showDashboard();
	}
}
