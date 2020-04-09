package com.saeeds28.config.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity(name ="Address_List")
@Table(name="Address_List")
@JsonPropertyOrder({"Street","City","Province","Country","PostalCode"})
public class Address {
	@Id
	private String emailAddress;
	
	@Column(nullable=false)
	private String street;
	
	@Column(nullable=false)
	private String city;
	
	@Column(nullable=false)
	private String province;
	
	@Column(nullable=false)
	private String country;
	
	@Column(nullable=false)
	private String postalCode;
	
	public Address() {
		super();
	}
	
	public Address(String emailAddress, String street, String city, String province, String country,
			String postalCode) {
		this.emailAddress = emailAddress;
		this.street = street;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postalCode = postalCode;
	}

	@JsonIgnore
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@JsonProperty("Street")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@JsonProperty("City")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("Province")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@JsonProperty("Country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("PostalCode")
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
