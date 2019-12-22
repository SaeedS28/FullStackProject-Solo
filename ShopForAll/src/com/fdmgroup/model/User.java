package com.fdmgroup.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity(name ="User_List")
@Table(name="User_List")
@XmlRootElement(name = "User")
@XmlType(propOrder = {"username","firstname","lastname","type","address"})
@JsonPropertyOrder({"username","firstname","lastname","type","address"})
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

	@XmlTransient
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@XmlElement(name = "FirstName")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@XmlElement(name = "LastName")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@XmlElement(name = "Address")
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
