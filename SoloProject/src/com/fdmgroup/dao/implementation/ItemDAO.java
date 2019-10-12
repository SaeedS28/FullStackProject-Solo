package com.fdmgroup.dao.implementation;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fdmgroup.dao.interfaces.IItemDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.ShoppingCartItem;

public class ItemDAO implements IItemDAO {

	EntityManagerFactory emf;
	EntityManager em;

	public ItemDAO() {
		emf = Persistence.createEntityManagerFactory("SoloProject");
		em = emf.createEntityManager();
	}
	
	public boolean addItem(Item i) {
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
		return true;
	}
	
	public boolean updateQuantity(int pid, int quantity) {
		Item i = em.find(Item.class, pid);
		
		em.getTransaction().begin();
		i.setQuantity(quantity);
		em.getTransaction().commit();
		return true;
	}

	public boolean updateName(int pid, String name) {
		Item i = em.find(Item.class, pid);
		
		em.getTransaction().begin();
		i.setName(name.toUpperCase());
		em.getTransaction().commit();
		
		Query query = em.createQuery(
				   "SELECT s FROM Shopping_Cart_Item s WHERE s.productID = :pid", ShoppingCartItem.class);
		query.setParameter("pid", pid);
		
		@SuppressWarnings("unchecked")
		ArrayList<ShoppingCartItem> sce = (ArrayList<ShoppingCartItem>) query.getResultList();
		if(sce.size()==0) {
			return true;
		}
		
		for(int j = 0; j < sce.size(); j++) {
			em.getTransaction().begin();
			sce.get(j).setProductName(name);
			em.getTransaction().commit();
		}
		return true;
	}

	public boolean updateDescription(int pid, String description) {
		Item i = em.find(Item.class, pid);
		
		em.getTransaction().begin();
		i.setDescription(description);
		em.getTransaction().commit();
		return true;
	}

	public boolean updateCategory(int pid, String category) {
		Item i = em.find(Item.class, pid);
		
		em.getTransaction().begin();
		i.setCategory(category.toUpperCase());
		em.getTransaction().commit();
		return true;
	}

	public boolean updatePrice(int pid, double price) {
		Item i = em.find(Item.class, pid);
		
		em.getTransaction().begin();
		i.setPrice(price);
		em.getTransaction().commit();
		
		Query query = em.createQuery(
				   "SELECT s FROM Shopping_Cart_Item s WHERE s.productID = :pid", ShoppingCartItem.class);
		query.setParameter("pid", pid);
		
		@SuppressWarnings("unchecked")
		ArrayList<ShoppingCartItem> sce = (ArrayList<ShoppingCartItem>) query.getResultList();
		if(sce.size()==0) {
			return true;
		}
		
		for(int j = 0; j < sce.size(); j++) {
			em.getTransaction().begin();
			sce.get(j).setPrice(price);
			em.getTransaction().commit();
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Item> getAllItems() {
		Query q = em.createQuery("Select i from Item_List i", Item.class);
		return (ArrayList<Item>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Item> getItemsByCategory(String category) {
		Query query = em.createQuery(
				   "SELECT i FROM Item_List i WHERE i.category LIKE :category", Item.class);
		query.setParameter("category", category);
		return (ArrayList<Item>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Item> getItemsByPriceRange(double low, double high) {
		Query query = em.createQuery(
				   "SELECT i FROM Item_List i WHERE i.price >= :low and i.price <= :high", Item.class);
		query.setParameter("low", low);
		query.setParameter("high", high);
		return (ArrayList<Item>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Item> getItemsByName(String name) {
		Query query = em.createQuery(
				   "SELECT i FROM Item_List i WHERE i.name LIKE :name", Item.class);
		query.setParameter("name", "%"+name.toUpperCase()+"%");
		return (ArrayList<Item>) query.getResultList();
	}

	public Item getItemByPid(int pid) {
		return em.find(Item.class, pid);
	}

	public boolean removeItem(int pid) {
		Item i = em.find(Item.class, pid);
		
		em.getTransaction().begin();
		em.remove(i);
		em.getTransaction().commit();
		
		Query query = em.createQuery(
				   "SELECT s FROM Shopping_Cart_Item s WHERE s.productID = :pid", ShoppingCartItem.class);
		query.setParameter("pid", pid);
		
		@SuppressWarnings("unchecked")
		ArrayList<ShoppingCartItem> sce = (ArrayList<ShoppingCartItem>) query.getResultList();
		if(sce.size()==0) {
			return true;
		}
		
		ReviewDAO rd = new ReviewDAO();
		rd.removeReviewForItem(pid);
		
		for(int j = 0; j < sce.size(); j++) {
			em.getTransaction().begin();
			em.remove(sce.get(j));
			em.getTransaction().commit();
		}
		return true;
	}

	public int getItemQuantity(int pid) {
		Item i = em.find(Item.class, pid);
		
		return i.getQuantity();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> getCategories() {
		Query query = em.createQuery(
				   "SELECT Distinct i.category from Item_List i", String.class);
		return (ArrayList<String>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public Item checkDuplicates(String name, String category, double price) {
		Query query = em.createQuery(
				   "SELECT i FROM Item_List i WHERE i.name LIKE :name and i.category LIKE :category and i.price = :price", Item.class);
		query.setParameter("name", name);
		query.setParameter("category", category);
		query.setParameter("price", price);
		
		ArrayList<Item> i = (ArrayList<Item>) query.getResultList();
		if(i.size()==0) {
			return null;
		}
		return i.get(0);
	}
}
