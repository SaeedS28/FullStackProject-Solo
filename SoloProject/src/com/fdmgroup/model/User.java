package com.fdmgroup.model;

public class User {

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String type;
	
	public User(String username, String password, String firstname, String lastname, String type) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	// add hashing dependency for the password
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "User [username = " + username + ", password = " + password + ", firstname = " + firstname
				+ ", lastname = " + lastname + ", user type = " + type + "]";
	}

}
