package com.fdmgroup.dao.implementation;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.dao.interfaces.IItemDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.ShoppingCartItem;

public class ItemDAO implements IItemDAO {

	@Autowired
	DBConnection connection;
	public ItemDAO() {
		connection = DBConnection.getInstance();
	}
	
	public boolean addItem(Item i) {
		EntityManager em = connection.getEntityManger();
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
		connection.close();
		return true;
	}
	
	public boolean updateQuantity(int pid, int quantity) {
		EntityManager em = connection.getEntityManger();
		Item i = em.find(Item.class, pid);
		
		em.getTransaction().begin();
		i.setQuantity(i.getQuantity()+quantity);
		em.getTransaction().commit();
		connection.close();
		return true;
	}

	public boolean updateName(int pid, String name) {
		EntityManager em = connection.getEntityManger();
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
		connection.close();
		return true;
	}

	public boolean updateDescription(int pid, String description) {
		EntityManager em = connection.getEntityManger();
		Item i = em.find(Item.class, pid);
		
		em.getTransaction().begin();
		i.setDescription(description);
		em.getTransaction().commit();
		connection.close();
		return true;
	}

	public boolean updateCategory(int pid, String category) {
		EntityManager em = connection.getEntityManger();
		Item i = em.find(Item.class, pid);
		
		em.getTransaction().begin();
		i.setCategory(category.toUpperCase());
		em.getTransaction().commit();
		connection.close();
		return true;
	}

	public boolean updatePrice(int pid, double price) {
		EntityManager em = connection.getEntityManger();
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
		connection.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Item> getAllItems() {
		EntityManager em = connection.getEntityManger();
		Query q = em.createQuery("Select i from Item_List i", Item.class);
		return (ArrayList<Item>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Item> getItemsByCategory(String category) {
		EntityManager em = connection.getEntityManger();
		Query query = em.createQuery(
				   "SELECT i FROM Item_List i WHERE i.category LIKE :category", Item.class);
		query.setParameter("category", category);
		connection.close();
		return (ArrayList<Item>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Item> getItemsByPriceRange(double low, double high) {
		EntityManager em = connection.getEntityManger();
		Query query = em.createQuery(
				   "SELECT i FROM Item_List i WHERE i.price >= :low and i.price <= :high", Item.class);
		query.setParameter("low", low);
		query.setParameter("high", high);
		return (ArrayList<Item>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Item> getItemsByName(String name) {
		EntityManager em = connection.getEntityManger();
		Query query = em.createQuery(
				   "SELECT i FROM Item_List i WHERE i.name LIKE :name", Item.class);
		query.setParameter("name", "%"+name.toUpperCase()+"%");
		return (ArrayList<Item>) query.getResultList();
	}

	public Item getItemByPid(int pid) {
		EntityManager em = connection.getEntityManger();
		return em.find(Item.class, pid);
	}

	public boolean removeItem(int pid) {
		EntityManager em = connection.getEntityManger();
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
		connection.close();
		return true;
	}

	public int getItemQuantity(int pid) {
		EntityManager em = connection.getEntityManger();
		Item i = em.find(Item.class, pid);
		connection.close();
		return i.getQuantity();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> getCategories() {
		EntityManager em = connection.getEntityManger();
		Query query = em.createQuery(
				   "SELECT Distinct i.category from Item_List i", String.class);
		return (ArrayList<String>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public Item checkDuplicates(String name, String category, double price) {
		EntityManager em = connection.getEntityManger();
		Query query = em.createQuery(
				   "SELECT i FROM Item_List i WHERE i.name LIKE :name and i.category LIKE :category and i.price = :price", Item.class);
		query.setParameter("name", name);
		query.setParameter("category", category);
		query.setParameter("price", price);
		
		ArrayList<Item> i = (ArrayList<Item>) query.getResultList();
		if(i.size()==0) {
			return null;
		}
		connection.close();
		return i.get(0);
	}

	public ArrayList<Item> seePurchasedItemByUser(ArrayList<Integer> pids) {
		EntityManager em = connection.getEntityManger();
		ArrayList<Item> itemToFind = new ArrayList<>();
		
		for(int i=0;i<pids.size();i++) {
			Item item = em.find(Item.class, pids.get(i));
			if(item!=null) {
				itemToFind.add(item);
			}
		}
		connection.close();
		return itemToFind;
	}

	public int getMaxPid() {
		EntityManager em = connection.getEntityManger();
		Query query = em.createQuery(
				   "SELECT max(i.productID) FROM Item_List i", Integer.class);
				
		@SuppressWarnings("unchecked")
		ArrayList<Integer> maxPid = (ArrayList<Integer>) query.getResultList();
		if(maxPid.size()==0) {
			return 0;
		}
		connection.close();
		return maxPid.get(0);
	}
}
