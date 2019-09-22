package com.fdmgroup.controller;

import com.fdmgroup.dao.interfaces.IUserDAO;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;
import com.fdmgroup.view.DashboardView;
import com.fdmgroup.view.HomeView;

public class AuthenticationController {

	private DashboardView dashboardView;
	private HomeView homeView;
	private IUserDAO userDao;
	
	public AuthenticationController() {
		super();
	}

	public AuthenticationController(DashboardView dashboardView, HomeView homeView, IUserDAO userDao) {
		super();
		this.dashboardView = dashboardView;
		this.homeView = homeView;
		this.userDao = userDao;
	}

	public void login(String username, String password) {
		User user = userDao.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			UserSession.setLoggedInUser(user);
			dashboardView.showDashboard();
			return;
		}
		
		homeView.showLoginOptions(true);
	}

	public void logout() {
		UserSession.setLoggedInUser(null);
		homeView.showInitialOptions(true);
	}

	public DashboardView getDashboardView() {
		return dashboardView;
	}

	public void setDashboardView(DashboardView dashboardView) {
		this.dashboardView = dashboardView;
	}

	public HomeView getHomeView() {
		return homeView;
	}

	public void setHomeView(HomeView homeView) {
		this.homeView = homeView;
	}

	public IUserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}
}



















