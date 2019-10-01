package com.fdmgroup.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fdmgroup.dao.interfaces.IPurchaseOrderDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.PurchaseOrder;
import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.User;
import com.fdmgroup.util.DataSource;

public class PurchaseOrderDAO implements IPurchaseOrderDAO {

	public boolean addPurchaseOrder(User u, ArrayList<ShoppingCartItem> cart) {
		String query = "insert into purchase_history values (?,?,?,?,?,?)";
		
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			for (Map.Entry<Item,Integer> entry : cart.getItems().entrySet()) {
				stmt.setInt(1,getMaxPurchaseID());
				stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
				stmt.setString(3, u.getUsername());
				stmt.setInt(4,entry.getKey().getProductID());
				stmt.setInt(5, entry.getValue());
				stmt.setDouble(6, entry.getKey().getPrice());
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

	public ArrayList<PurchaseOrder> getPurchaseOrdersByUser(User u) {
		ArrayList<PurchaseOrder> po = new ArrayList<>();
		String query = "Select * from purchase_history where email_address like ?";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1,u.getUsername());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int purchaseID = rs.getInt("purchase_id");
				Timestamp ts = rs.getTimestamp("purchase_date");
				String emailAddress = rs.getString("email_address");
				int productID = rs.getInt("product_id");
				double price = rs.getDouble("price_per_unit");
				int quantity = rs.getInt("quantity");
				po.add(new PurchaseOrder(purchaseID, ts, emailAddress, productID, quantity, price));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
		
	}

	public int getMaxPurchaseID() {
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
}
