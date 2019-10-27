package com.fdmgroup.dao.implementation;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fdmgroup.dao.interfaces.IUserDAO;
import com.fdmgroup.model.User;

public class UserDAO implements IUserDAO{
	
	@Autowired
	DBConnection connection;
	
	public UserDAO() {
		connection = DBConnection.getInstance();
	}
	
	public boolean create(User t) {
		EntityManager em = connection.getEntityManger();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		connection.close();
		return true;
	}

	public boolean remove(String s) {
		EntityManager em = connection.getEntityManger();
		User u = em.find(User.class, s);
		
		if(u==null) {
			return false;
		} else {
			ReviewDAO rd = new ReviewDAO();
			rd.removeReviewForUser(s);
			
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
			connection.close();
			return true;
		}
	}

	public User findByUsername(String name) {
		EntityManager em = connection.getEntityManger();
		Query query = em.createQuery(
				   "SELECT u FROM User_List u WHERE u.username LIKE :name", User.class);
		query.setParameter("name", name);
		
		@SuppressWarnings("unchecked")
		ArrayList<User> toReturn = (ArrayList<User>) query.getResultList();
		connection.close();
		if(toReturn.size()==0) {
			return null;
		}
		return toReturn.get(0);
	}

	public boolean updatePassword(User user, String password) {
		EntityManager em = connection.getEntityManger();
		User fU = em.find(User.class, user.getUsername());
		em.getTransaction().begin();
		fU.setPassword(password);
		em.getTransaction().commit();
		connection.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<User> getAllUsers() {
		EntityManager em = connection.getEntityManger();
		Query q = em.createQuery("Select u from User_List u", User.class);
		return (ArrayList<User>) q.getResultList();
	}
	
}
