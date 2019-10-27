package com.fdmgroup.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.dao.interfaces.IAddressDAO;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;


public class AddressDAO implements IAddressDAO {

	@Autowired
	DBConnection connection;

	public AddressDAO() {
		connection = DBConnection.getInstance();
	}

	public boolean changeCity(String city, User u) {
		EntityManager em = connection.getEntityManger();
		Address a = em.find(Address.class, u.getUsername());
		em.getTransaction().begin();
		a.setCity(city);
		em.getTransaction().commit();
		connection.close();
		return true;
	}

	public boolean changeStreet(String street, User u) {
		EntityManager em = connection.getEntityManger();
		Address a = em.find(Address.class, u.getUsername());
		
		em.getTransaction().begin();
		a.setStreet(street);
		em.getTransaction().commit();
		connection.close();
		return true;
	}

	public boolean changeCountry(String country, User u){
		EntityManager em = connection.getEntityManger();
		Address a = em.find(Address.class, u.getUsername());
		
		em.getTransaction().begin();
		a.setCountry(country);
		em.getTransaction().commit();
		connection.close();
		return true;
	}

	public boolean changePostalCode(String postal, User u) {
		EntityManager em = connection.getEntityManger();
		Address a = em.find(Address.class, u.getUsername());
		
		em.getTransaction().begin();
		a.setPostalCode(postal);
		em.getTransaction().commit();
		connection.close();
		return true;
	}

	public Address getAddress(User u) {
		EntityManager em = connection.getEntityManger();
		Address a = em.find(Address.class, u.getUsername());
		connection.close();
		return a;
	}

	public boolean changeProvince(String province, User u) {
		EntityManager em = connection.getEntityManger();
		Address a = em.find(Address.class, u.getUsername());
		
		em.getTransaction().begin();
		a.setProvince(province);
		em.getTransaction().commit();
		connection.close();
		return true;
	}

}
