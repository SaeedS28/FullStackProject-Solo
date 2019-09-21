package com.fdmgroup.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fdmgroup.dao.interfaces.IAddressDao;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;
import com.fdmgroup.util.DataSource;

public class AddressDAO implements IAddressDao {

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

	public boolean changeStreet(String street, User u) {
		String query = "UPDATE address "
				+ "SET street = ?" + 
				"Where email_address = ? ";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1, street);
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

	public boolean changeCountry(String country, User u) {
		String query = "UPDATE address "
				+ "SET country = ?" + 
				"Where email_address = ? ";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1, country);
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

	public boolean changePostalCode(String postal, User u) {
		String query = "UPDATE address "
				+ "SET postal_code= ?" + 
				"Where email_address = ? ";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1, postal);
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

	public Address getAddress(User u) {
		String query = "Select * from address where email_address = ?";
		Address address=null;
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1, u.getUsername());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				String userName = rs.getString("email_address");
				String street = rs.getString("street");
				String city = rs.getString("city");
				String province = rs.getString("province");
				String country = rs.getString("country");
				String postalCode = rs.getString("postal_code");
				
				address = new Address(userName, street, city,province, country, postalCode);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return address;
	}

}
