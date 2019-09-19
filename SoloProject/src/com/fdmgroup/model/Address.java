package com.fdmgroup.model;

public class Address {
	private String emailAddress;
	private String street;
	private String city;
	private String province;
	private String country;
	private String postalCode;
	
	
	public Address(String emailAddress, String street, String city, String province, String country,
			String postalCode) {
		super();
		this.emailAddress = emailAddress;
		this.street = street;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postalCode = postalCode;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	@Override
	public String toString() {
		return "Address [emailAddress=" + emailAddress + ", street=" + street + ", city=" + city + ", province="
				+ province + ", country=" + country + ", postalCode=" + postalCode + "]";
	}
	
	
}
