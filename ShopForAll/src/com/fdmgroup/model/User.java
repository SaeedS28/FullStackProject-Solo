package com.fdmgroup.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name ="User_List")
@Table(name="User_List")
public class User {
	//private int id;
	@Id
	@Column(name="user_name", nullable=false)
	private String username;
	
	@Column(name="password_hash", length=256, nullable=false)
	private String password;
	
	@Column(name="first_name", nullable=false)
	private String firstname;
	
	@Column(name="last_name", nullable=false)
	private String lastname;
	
	@Column(name="user_type", nullable=false)
	private String type;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emailAddress")
	private Address address;
	
	public User() {
		super();
	}
	
	public User(String username, String password, String firstname, String lastname, String type, Address a) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
		this.address = a;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String toString() {
		return "username = " + username +  ", firstname = " + firstname
				+ ", lastname = " + lastname + ", user type = " + type;
	}

}
