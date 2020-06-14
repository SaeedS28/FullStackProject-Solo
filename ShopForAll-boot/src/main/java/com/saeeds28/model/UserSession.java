package com.saeeds28.model;

public class UserSession {

	private static User loggedInUser;

	public static User getLoggedInUser() {
		return loggedInUser;
	}

	public static void setLoggedInUser(User loggedInUser) {
		UserSession.loggedInUser = loggedInUser;
	}
}
