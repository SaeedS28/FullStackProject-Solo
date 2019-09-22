package com.fdmgroup.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fdmgroup.dao.interfaces.IShoppingCartDAO;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.ShoppingCart;
import com.fdmgroup.model.User;
import com.fdmgroup.util.DataSource;

public class ShoppingCartDAO implements IShoppingCartDAO {

	public boolean addItem(User u, int pid, int quantity) {
		String query;
		int retQuantity = getQuantity(u, pid);

		if (retQuantity > 0) {
			query = "Update shopping_cart " + "set quantity = ? " + "where email_address = ? and product_id = ?";
		} else {
			query = "Insert into shopping_cart(quantity, email_address, product_id) values (?,?,?)";
		}

		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setInt(1, quantity);
			stmt.setString(2, u.getUsername());
			stmt.setInt(3, pid);
			stmt.execute();

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

	public boolean removeItem(User u, int pid) {
		String query = "Delete from shopping_cart where email_address = ? and product_id = ?";
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, u.getUsername());
			stmt.setInt(2, pid);
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

	public int getSize(User u) {
		String query = "SELECT SUM(quantity) as cart_quantity " + "FROM shopping_cart "
				+ "where shopping_cart.email_address like ?";
		int size = 0;
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, u.getUsername());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				size = rs.getInt("cart_quantity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return size;
	}

	public ShoppingCart getCartDetails(User u) {
		String query = "SELECT item.product_id PRODUCT_ID," + "item.NAME NAME, " + "item.PRICE PRICE, "
				+ "item.QUANTITY iQuantity, " + "item.CATEGORY CATEGORY, " + "item.DESCRIPTION DESCRIPTION, "
				+ "shopping_cart.QUANTITY CART_QUANTITY " + "FROM shopping_cart " + "INNER JOIN item ON "
				+ "shopping_cart.product_id = item.product_id " + "WHERE shopping_cart.email_address like ?";
		ShoppingCart cart = new ShoppingCart();
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, u.getUsername());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int productID = rs.getInt("PRODUCT_ID");
				String name = rs.getString("NAME");
				int iQuantity = rs.getInt("iQuantity");
				double price = rs.getDouble("PRICE");
				String category = rs.getString("CATEGORY");
				String description = rs.getString("DESCRIPTION");
				int quantity = rs.getInt("CART_QUANTITY");
				cart.addItems(new Item(productID, name, category, description, iQuantity, price), quantity);
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

	private int getQuantity(User u, int pid) {
		String query = "Select Quantity from shopping_cart where email_address = ? and product_id = ?";
		int quantity = 0;
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, u.getUsername());
			stmt.setInt(2, pid);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				quantity = rs.getInt("quantity");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quantity;
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
