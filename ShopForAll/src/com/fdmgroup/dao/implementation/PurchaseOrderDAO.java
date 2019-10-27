package com.fdmgroup.dao.implementation;

import java.sql.Timestamp;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.dao.interfaces.IPurchaseOrderDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.PurchaseOrder;
import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.User;

public class PurchaseOrderDAO implements IPurchaseOrderDAO {


	@Autowired
	DBConnection connection;

	public PurchaseOrderDAO() {
		connection = DBConnection.getInstance();
	}
	
	public boolean addPurchaseOrder(User u, ArrayList<ShoppingCartItem> cart) {
		EntityManager em = connection.getEntityManger();
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
		connection.close();
		return true;
	}

	public ArrayList<PurchaseOrder> getPurchaseOrdersByUser(User u) {
		EntityManager em = connection.getEntityManger();
		Query query = em.createQuery(
				   "SELECT p FROM Purchase_Order_List p WHERE p.emailAddress = :username", PurchaseOrder.class);
		query.setParameter("username", u.getUsername());
		
		@SuppressWarnings("unchecked")
		ArrayList<PurchaseOrder> sce = (ArrayList<PurchaseOrder>) query.getResultList();
		connection.close();
		return sce;
	}

	public int isPurchased(User u, int pid) {
		EntityManager em = connection.getEntityManger();
		Query query = em.createQuery(
				"SELECT p FROM Purchase_Order_List p WHERE p.emailAddress = :username and p.productID = :pid", PurchaseOrder.class);
		query.setParameter("username", u.getUsername());
		query.setParameter("pid", pid);
		
		@SuppressWarnings("unchecked")
		ArrayList<PurchaseOrder> sce = (ArrayList<PurchaseOrder>) query.getResultList();
		connection.close();
		return sce.size();
	}
	
	public ArrayList<PurchaseOrder> getAllPurchaseOrders() {
		EntityManager em = connection.getEntityManger();
		Query query = em.createQuery(
				   "SELECT p FROM Purchase_Order_List p", PurchaseOrder.class);
		
		@SuppressWarnings("unchecked")
		ArrayList<PurchaseOrder> sce = (ArrayList<PurchaseOrder>) query.getResultList();
		connection.close();
		return sce;
	}

	public ArrayList<Item> getDistinctProductPurchasesByUser(User u) {
		EntityManager em = connection.getEntityManger();
		Query query = em.createQuery(
				   "SELECT DISTINCT p.productID FROM Purchase_Order_List p where p.emailAddress like :name", Integer.class);
		query.setParameter("name", u.getUsername());
		@SuppressWarnings("unchecked")
		ArrayList<Integer> sce = (ArrayList<Integer>) query.getResultList();
		if(sce.size()==0) {
			return null;
		}
		connection.close();
		ItemDAO itd = new ItemDAO();
		return itd.seePurchasedItemByUser(sce);
	}

	public ArrayList<Item> retrieveTopTenPurchases() {
		EntityManager em = connection.getEntityManger();
		Query query = em.createQuery("Select p.productID from Purchase_Order_List p "
				+ "GROUP BY p.productID having sum(p.quantity) > 0 order by p.productID", Integer.class);
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer> sce = (ArrayList<Integer>) query.getResultList();
		if(sce.size()==0) {
			return null;
		}
		connection.close();
		ItemDAO itd = new ItemDAO();
		return itd.seePurchasedItemByUser(sce);
	}
}
