package com.fdmgroup.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fdmgroup.dao.interfaces.IShoppingCartDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.ShoppingCartEntry;
import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.User;
import com.fdmgroup.util.DataSource;


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
			ShoppingCartItem sce = new ShoppingCartItem(i.getProductID(),i.getName(),u.getUsername(),i.getPrice(),quantity,i.getQuantity());
			em.getTransaction().begin();
			em.persist(sce);
			em.getTransaction().commit();
		}
		return true;
	}

	public boolean removeItem(User u, int pid) {
		
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
		String query = "Select item.product_id PRODUCT_ID, item.NAME NAME, " + "item.PRICE PRICE, "
				+ "item.CATEGORY CATEGORY, " + "item.DESCRIPTION DESCRIPTION, item.quantity iqty, "
				+ "shopping_cart.QUANTITY CART_QUANTITY " + "FROM shopping_cart " + "INNER JOIN item ON "
				+ "shopping_cart.product_id = item.product_id " + "WHERE shopping_cart.email_address like ?";
		ArrayList<ShoppingCartItem> cart = new ArrayList<>();
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, u.getUsername());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("PRODUCT_ID");
				String name = rs.getString("NAME");
				double price = rs.getDouble("PRICE");
				String category = rs.getString("CATEGORY");
				
				String description = rs.getString("DESCRIPTION");
				int quantity = rs.getInt("CART_QUANTITY");
				int itemQty = rs.getInt("iqty");
				cart.add(new ShoppingCartItem(productId, name, price, category, description, quantity,itemQty));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}

	public double getCartTotal(User u) {
		String query = "SELECT SUM(item.price*shopping_cart.quantity) as total_cart_price " + "FROM shopping_cart "
				+ "INNER JOIN item ON " + "shopping_cart.product_id = item.product_id "
				+ "where shopping_cart.email_address like ?";
		double priceTotal = 0;
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, u.getUsername());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				priceTotal = rs.getDouble("total_cart_price");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return priceTotal;
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

	public boolean removeAllItem(User u) {
		String query = "Delete from shopping_cart where email_address = ?";
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, u.getUsername());
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
}
