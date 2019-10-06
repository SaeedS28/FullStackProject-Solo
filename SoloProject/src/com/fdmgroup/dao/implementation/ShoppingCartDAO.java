package com.fdmgroup.dao.implementation;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fdmgroup.dao.interfaces.IShoppingCartDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.User;

public class ShoppingCartDAO implements IShoppingCartDAO {

	EntityManagerFactory emf;
	EntityManager em;

	public ShoppingCartDAO() {
		emf = Persistence.createEntityManagerFactory("SoloProject");
		em = emf.createEntityManager();		
	}

	public boolean addItem(User u, int pid, int quantity) {
		if(getQuantity(u, pid)>0) {
			Query q = em.createQuery("Select s from Shopping_Cart_Item s where s.userName like :name and s.productID = :pid",ShoppingCartItem.class);
			q.setParameter("name", u.getUsername());
			q.setParameter("pid", pid);
			ShoppingCartItem sce = (ShoppingCartItem) q.getSingleResult();
			
			em.getTransaction().begin();
			sce.setCartQuantity(sce.getCartQuantity()+quantity);
			em.getTransaction().commit();
		}
		else {
			Item i = em.find(Item.class, pid);
			ShoppingCartItem sce = new ShoppingCartItem(i.getProductID(),i.getName(),u.getUsername(),i.getPrice(),quantity);
			em.getTransaction().begin();
			em.persist(sce);
			em.getTransaction().commit();
		}
		return true;
	}

	public boolean removeItem(User u, int pid) {
		Query q = em.createQuery("Select s from Shopping_Cart_Item s where s.userName like :name and s.productID = :pid",ShoppingCartItem.class);
		q.setParameter("name", u.getUsername());
		q.setParameter("pid", pid);
		ShoppingCartItem sce = (ShoppingCartItem) q.getSingleResult();
		
		em.getTransaction().begin();
		em.remove(sce);
		em.getTransaction().commit();
		return true;
	}

	public int getSize(User u)  {
		Query q = em.createQuery("Select SUM(s.cartQuantity) from Shopping_Cart_Item s where s.userName like :name",Long.class);
		q.setParameter("name", u.getUsername());
		@SuppressWarnings("unchecked")
		ArrayList<Long> sce = (ArrayList<Long>) q.getResultList();
		if(sce.size()==0) {
			return 0;
		}
		Integer i = (int) (long) sce.get(0);
		return i;
	}

	public ArrayList<ShoppingCartItem> getCartDetails(User u) {
		Query query = em.createQuery(
				   "SELECT s FROM Shopping_Cart_Item s WHERE s.userName = :username", ShoppingCartItem.class);
		query.setParameter("username", u.getUsername());
		
		@SuppressWarnings("unchecked")
		ArrayList<ShoppingCartItem> sce = (ArrayList<ShoppingCartItem>) query.getResultList();
		return sce;
	}

	public double getCartTotal(User u) {
		Query q = em.createQuery("Select SUM(s.cartQuantity * s.price) from Shopping_Cart_Item s where s.userName like :name",Double.class);
		q.setParameter("name", u.getUsername());
		@SuppressWarnings("unchecked")
		ArrayList<Double> sce = (ArrayList<Double>) q.getResultList();
		
		Double total =  sce.get(0);
		if(total==null) {
			return 0;
		}
		return total;
	}

	public int getQuantity(User u, int pid) {
		Query q = em.createQuery("Select s.cartQuantity from Shopping_Cart_Item s where s.userName like :name and s.productID = :pid", Integer.class);
		q.setParameter("name", u.getUsername());
		q.setParameter("pid", pid);
		@SuppressWarnings("unchecked")
		ArrayList<Integer> sce = (ArrayList<Integer>) q.getResultList();
		
		if(sce.size()==0) {
			return 0;
		}
		return sce.get(0);
	}

	public boolean removeAllItem(String userName) {
		Query query = em.createQuery(
				   "SELECT s FROM Shopping_Cart_Item s WHERE s.userName = :username", ShoppingCartItem.class);
		query.setParameter("username", userName);
		
		@SuppressWarnings("unchecked")
		ArrayList<ShoppingCartItem> sce = (ArrayList<ShoppingCartItem>) query.getResultList();
		if(sce.size()==0) {
			return true;
		}
		
		for(int j = 0; j < sce.size(); j++) {
			em.getTransaction().begin();
			em.remove(sce.get(j));
			em.getTransaction().commit();
		}
		return true;
	}
}
