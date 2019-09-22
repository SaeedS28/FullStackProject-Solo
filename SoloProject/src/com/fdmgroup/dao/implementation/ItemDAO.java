package com.fdmgroup.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fdmgroup.dao.interfaces.IItemDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.User;
import com.fdmgroup.util.DataSource;

public class ItemDAO implements IItemDAO {

	public boolean addItem(Item i) {
		String query = "insert into item(product_id,name,price,category,quantity,description) values (?,?,?,?,?,?)";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setInt(1, i.getProductID());
			stmt.setString(2, i.getName());
			stmt.setDouble(3,i.getPrice());
			stmt.setString(4, i.getCategory());
			stmt.setInt(5, i.getQuantity());
			stmt.setString(6, i.getDescription());
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
	
	public int getMaxPid() {
		String query = "Select max(product_id) as product_count from item";
		int maxPid=0;
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				maxPid = rs.getInt("product_count");
				if(rs.wasNull()) {
					maxPid = 1;
				}
				else {
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
	public boolean updateQuantity(int pid, int quantity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateName(int pid, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDescription(int pid, String description) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategory(int pid, String category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePrice(int pid, double price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Item> getAllItems(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemsByPrice(double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
