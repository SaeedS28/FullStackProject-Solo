package com.fdmgroup.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fdmgroup.dao.interfaces.IAddressDao;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;
import com.fdmgroup.util.DataSource;

public class AddressDAO implements IAddressDao {

	/*
	 * email_address varchar2(50),
  street varchar2(65) not null,
  city varchar2(30) not null,
  province varchar2(20) not null,
  country varchar2(25) not null,
  postal_code varchar2(8) not null
	 */
	@Override
	public boolean addAddress(Address a) {
		String query = "Insert into address(email_address, street, city, province, country, postal_code) values (?,?,?,?,?,?)";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1, a.getEmailAddress());
			stmt.setString(2, a.getStreet());
			stmt.setString(3, a.getCity());
			stmt.setString(4, a.getProvince());
			stmt.setString(5, a.getCountry());
			stmt.setString(6, a.getPostalCode());
			
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean changeCity(String city, User u) {
		String query = "UPDATE address "
				+ "SET city = ?" + 
				"Where email_address = ? ";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1, city);
			stmt.setString(2, u.getUsername());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean changeStreet(String street, User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeCountry(String country, User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePostalCode(String postal, User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address getAddress(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
