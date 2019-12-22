package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity(name ="Address_List")
@Table(name="Address_List")
@XmlRootElement(name = "Address")
@XmlType(propOrder = {"street","city","province","country","postalCode"})
@JsonPropertyOrder({"street","city","province","country","postalCode"})
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

	public String getEmailAddress() {
		return emailAddress;
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

	public String toString() {
		return "[ street=" + street + ", city=" + city + ", province="
				+ province + ", country=" + country + ", postalCode=" + postalCode + "]";
	}
}
