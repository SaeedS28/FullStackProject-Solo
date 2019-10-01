package com.fdmgroup.controller;

import com.fdmgroup.dao.implementation.AddressDAO;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;

public class AddressController {
	
	public Address getAddress(User u) {
		AddressDAO ad = new AddressDAO();
		return ad.getAddress(u);
	}
}
