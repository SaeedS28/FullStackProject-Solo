package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.fdmgroup.dao.implementation.AddressDAO;
import com.fdmgroup.dao.implementation.UserDAO;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;
import com.fdmgroup.view.AdminUserMainView;
import com.fdmgroup.view.RegularUserMainView;
import com.fdmgroup.view.UserView;

public class UserController {
	private AddressDAO ad;
	private UserView uv;
	private Scanner scanner;
	
	public UserController() {
		ad = new AddressDAO();
		scanner = new Scanner(System.in);
	}
	
	public ArrayList<User> getAllUsers(){
		UserDAO ud = new UserDAO();
		return ud.getAllUsers();
	}
	
	public void removeUser(int i, ArrayList<User> users) {
		UserDAO ud = new UserDAO();
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
		UserDAO ud = new UserDAO();
		System.out.print("Enter current password: ");
		String currentPassword = scanner.nextLine();
		String confirmPassword; 
		String newPassword;
		
		if(!UserSession.getLoggedInUser().getPassword().equals(currentPassword)) {
			System.out.println("Current password does not match the records. Bailing out");
			if(UserSession.getLoggedInUser().getType().equals("admin")) {
				AdminUserMainView acw = new AdminUserMainView();
				acw.showDashboard();
			} else if(UserSession.getLoggedInUser().getType().equals("regular")) {
				RegularUserMainView ruv = new RegularUserMainView();
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
		UserDAO ud = new UserDAO();
		return ud.findByUsername(userName);
	}
	
	public void addUser(User newUser, Address newAddress) {
		UserDAO ud = new UserDAO();
		ud.create(newUser);
		ad.addAddress(newAddress);
		System.out.println("New user added successfully");
		uv = new UserView();
		uv.showDashboard();
	}
}
