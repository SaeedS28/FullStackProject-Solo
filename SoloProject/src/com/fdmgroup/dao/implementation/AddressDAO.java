package com.fdmgroup.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.dao.interfaces.IAddressDAO;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;


public class AddressDAO implements IAddressDAO {

	EntityManagerFactory emf;
	EntityManager em;

	public AddressDAO() {
		emf = Persistence.createEntityManagerFactory("SoloProject");
		em = emf.createEntityManager();		
	}

	public boolean changeCity(String city, User u) {
		Address a = em.find(Address.class, u.getUsername());
		em.getTransaction().begin();
		a.setCity(city);
		em.getTransaction().commit();
		return true;
	}

	public boolean changeStreet(String street, User u) {
		Address a = em.find(Address.class, u.getUsername());
		
		em.getTransaction().begin();
		a.setStreet(street);
		em.getTransaction().commit();
		return true;
	}

	public boolean changeCountry(String country, User u) {
		Address a = em.find(Address.class, u.getUsername());
		
		em.getTransaction().begin();
		a.setCountry(country);
		em.getTransaction().commit();
		return true;
	}

	public boolean changePostalCode(String postal, User u) {
		Address a = em.find(Address.class, u.getUsername());
		
		em.getTransaction().begin();
		a.setPostalCode(postal);
		em.getTransaction().commit();
		return true;
	}

	public Address getAddress(User u) {
		Address a = em.find(Address.class, u.getUsername());
		return a;
	}

	public boolean changeProvince(String province, User u) {
		Address a = em.find(Address.class, u.getUsername());
		
		em.getTransaction().begin();
		a.setProvince(province);
		em.getTransaction().commit();
		return true;
	}

}
