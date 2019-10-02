package com.fdmgroup.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.dao.interfaces.IAddressDAO;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;
import com.fdmgroup.util.DataSource;

public class AddressDAO implements IAddressDAO {

	EntityManagerFactory emf;
	EntityManager em;

	public AddressDAO() {
		emf = Persistence.createEntityManagerFactory("SoloProject");
		em = emf.createEntityManager();		
	}

	public boolean changeCity(String city, User u) {
		String query = "UPDATE address " + "SET city = ?" + "Where email_address = ? ";
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, city);
			stmt.setString(2, u.getUsername());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean changeStreet(String street, User u) {
		String query = "UPDATE address " + "SET street = ?" + "Where email_address = ? ";
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, street);
			stmt.setString(2, u.getUsername());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean changeCountry(String country, User u) {
		String query = "UPDATE address " + "SET country = ?" + "Where email_address = ? ";
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, country);
			stmt.setString(2, u.getUsername());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean changePostalCode(String postal, User u) {
		String query = "UPDATE address " + "SET postal_code= ?" + "Where email_address = ? ";
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, postal);
			stmt.setString(2, u.getUsername());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Address getAddress(User u) {
		Address a = em.find(Address.class, u.getUsername());
		return a;
	}

	public boolean changeProvince(String province, User u) {
		String query = "UPDATE address " + "SET province = ?" + "Where email_address = ? ";
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, province);
			stmt.setString(2, u.getUsername());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean addAddress(Address a) {
		User u = em.find(User.class, UserSession.getLoggedInUser().getUsername());
		em.getTransaction().begin();
		em.persist(u);
		u.setAddress(a);
		em.getTransaction().commit();
		return true;
	}
}
