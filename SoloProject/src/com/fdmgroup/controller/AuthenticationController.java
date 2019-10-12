package com.fdmgroup.controller;

import com.fdmgroup.dao.implementation.UserDAO;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;
import com.fdmgroup.view.AdminUserMainView;
import com.fdmgroup.view.HomeView;
import com.fdmgroup.view.RegularUserMainView;

public class AuthenticationController {
	HomeView homeView;
	
	public AuthenticationController() {
		 homeView = new HomeView();
	}
	public void login(String username, String password) {
		UserDAO userDao = new UserDAO();
		User user = userDao.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			UserSession.setLoggedInUser(user);
			
			if(UserSession.getLoggedInUser().getType().equals("admin")) {
				AdminUserMainView acw = new AdminUserMainView();
				acw.showDashboard();
			}
			else if(UserSession.getLoggedInUser().getType().equals("regular")) {
				RegularUserMainView ruv = new RegularUserMainView();
				ruv.showDashboard();
			}
			else {
				homeView.showLoginOptions(true);
			}
		}
		else {
			System.out.println("Incorrect credentials provided. Try again");
			homeView.showLoginOptions(false);
		}
	}

	public void logout() {
		UserSession.setLoggedInUser(null);
		homeView.showInitialOptions(true);
	}
	
}