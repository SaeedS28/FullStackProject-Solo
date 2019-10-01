package com.fdmgroup.controller;

import com.fdmgroup.dao.implementation.AddressDAO;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;
import com.fdmgroup.view.AddressChangeView;

public class AddressController {
	
	public Address getAddress(User u) {
		AddressDAO ad = new AddressDAO();
		return ad.getAddress(u);
	}
	
	public void changePostalCode(String code, User u) {
		AddressDAO ad = new AddressDAO();
		ad.changePostalCode(code, u);
		System.out.println("Postal Code successfully changed");
		goBack();
	}
	
	public void changeCity(String city, User u) {
		AddressDAO ad = new AddressDAO();
		ad.changeCity(city, u);
		System.out.println("City successfully changed");
		goBack();
	}
	
	public void changeCountry(String country, User u) {
		AddressDAO ad = new AddressDAO();
		ad.changeCountry(country, u);
		System.out.println("Country successfully changed");
		goBack();
	}
	
	public void changeProvince(String province, User u) {
		AddressDAO ad = new AddressDAO();
		ad.changeProvince(province, u);
		System.out.println("Province successfully changed");
		goBack();
	}
	
	public void changeStreet(String street, User u) {
		AddressDAO ad = new AddressDAO();
		ad.changeStreet(street, u);
		System.out.println("Street successfully changed");
		goBack();
	}
	
	public void goBack() {
		AddressChangeView acw = new AddressChangeView();
		acw.showDashboard();
	}
}
