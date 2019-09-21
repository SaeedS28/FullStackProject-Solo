package com.fdmgroup.dao.interfaces;

import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;

public interface IAddressDao {
	
	public boolean addAddress(Address a);
	public boolean changeCity(String city, User u);
	public boolean changeStreet(String street, User u);
	public boolean changeCountry(String country, User u);
	public boolean changePostalCode(String postal, User u);
	public Address getAddress(User u);	
}
