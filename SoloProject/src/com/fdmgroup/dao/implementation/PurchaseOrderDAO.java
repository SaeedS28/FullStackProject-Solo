package com.fdmgroup.dao.implementation;

import java.sql.Timestamp;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fdmgroup.dao.interfaces.IPurchaseOrderDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.PurchaseOrder;
import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.User;

public class PurchaseOrderDAO implements IPurchaseOrderDAO {

	EntityManagerFactory emf;
	EntityManager em;

	public PurchaseOrderDAO() {
		emf = Persistence.createEntityManagerFactory("SoloProject");
		em = emf.createEntityManager();		
	}
	
	public boolean addPurchaseOrder(User u, ArrayList<ShoppingCartItem> cart) {
		for(int i=0; i<cart.size();i++) {
			PurchaseOrder po = new PurchaseOrder(
					new Timestamp(System.currentTimeMillis()), u.getUsername(), 
					cart.get(i).getProductID(), cart.get(i).getCartQuantity(), 
					cart.get(i).getPrice());
			em.getTransaction().begin();
			em.persist(po);
			em.getTransaction().commit();
		}
		
		for(int i=0; i<cart.size();i++) {
			Item item = em.find(Item.class, cart.get(i).getProductID());
			em.getTransaction().begin();
			item.setQuantity(item.getQuantity()-cart.get(i).getCartQuantity());
			em.getTransaction().commit();
		}
		
		for(int i=0; i<cart.size();i++) {
			ShoppingCartItem sci = em.find(ShoppingCartItem.class, cart.get(i).getItemID());
			em.getTransaction().begin();
			em.remove(sci);
			em.getTransaction().commit();
		}
		
		return true;
	}

	public ArrayList<PurchaseOrder> getPurchaseOrdersByUser(User u) {
		Query query = em.createQuery(
				   "SELECT p FROM Purchase_Order_List p WHERE p.emailAddress = :username", PurchaseOrder.class);
		query.setParameter("username", u.getUsername());
		
		@SuppressWarnings("unchecked")
		ArrayList<PurchaseOrder> sce = (ArrayList<PurchaseOrder>) query.getResultList();
		return sce;
	}

	public ArrayList<PurchaseOrder> getAllPurchaseOrders() {
		Query query = em.createQuery(
				   "SELECT p FROM Purchase_Order_List p", PurchaseOrder.class);
		
		@SuppressWarnings("unchecked")
		ArrayList<PurchaseOrder> sce = (ArrayList<PurchaseOrder>) query.getResultList();
		return sce;
	}

}
