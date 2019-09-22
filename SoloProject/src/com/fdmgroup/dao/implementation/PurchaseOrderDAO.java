package com.fdmgroup.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fdmgroup.dao.interfaces.IPurchaseOrderDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.PurchaseOrder;
import com.fdmgroup.model.ShoppingCart;
import com.fdmgroup.model.User;
import com.fdmgroup.util.DataSource;

public class PurchaseOrderDAO implements IPurchaseOrderDAO {

	/*
	 * int purchaseID; Date purchaseDate; String emailAddress; int productID; int
	 * quantity;
	 */
	public boolean addPurchaseOrder(User u, ShoppingCart cart) {
		String query = "insert into purchase_history values (?,?,?,?,?)";
		
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			for (Map.Entry<Item,Integer> entry : cart.getItems().entrySet()) {
				stmt.setInt(1,getMaxPurchaseID());
				stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
				stmt.setString(3, u.getUsername());
				stmt.setInt(4,entry.getKey().getProductID());
				stmt.setInt(5, entry.getValue());
				stmt.executeUpdate();
			}
			ShoppingCartDAO del = new ShoppingCartDAO();
			del.removeAllItem(u);
			cart.reset();
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

	@Override
	public List<PurchaseOrder> getPurchaseOrdersByUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	private int getMaxPurchaseID() {
		String query = "Select max(purchase_id) as purchase_count from purchase_history";
		int maxPid = 0;
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				maxPid = rs.getInt("purchase_count");
				if (rs.wasNull()) {
					maxPid = 1;
				} else {
					++maxPid;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxPid;
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrdersByDate(Timestamp d) {
		// TODO Auto-generated method stub
		return null;
	}
}
