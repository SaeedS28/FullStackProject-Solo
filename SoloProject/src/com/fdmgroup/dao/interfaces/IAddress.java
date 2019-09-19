package com.fdmgroup.dao.interfaces;

import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;

public interface IAddress {
	
	public boolean addAddress(User u, Address a);
	public boolean changeCity(User u);
	public boolean changeStreet(User u);
	public boolean changeCountry(User u);
	public boolean changePostalCode(User u);
	public Address getAddress(User u);	
}
