package com.fdmgroup.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			stmt.setString(2, i.getName().toUpperCase());
			stmt.setDouble(3,i.getPrice());
			stmt.setString(4, i.getCategory().toUpperCase());
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

	public boolean updateQuantity(int pid, int quantity) {
		String query = "UPDATE item "
				+ "SET quantity = ?" + 
				"where  product_id = ? ";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setInt(1,quantity);
			stmt.setInt(2, pid);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateName(int pid, String name) {
		String query = "UPDATE item "
				+ "SET name = ?" + 
				"where  product_id = ? ";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1,name.toUpperCase());
			stmt.setInt(2, pid);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateDescription(int pid, String description) {
		String query = "UPDATE item "
				+ "SET description = ?" + 
				"where  product_id = ? ";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1,description);
			stmt.setInt(2, pid);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateCategory(int pid, String category) {
		String query = "UPDATE item "
				+ "SET category = ?" + 
				"where  product_id = ? ";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1,category.toUpperCase());
			stmt.setInt(2, pid);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updatePrice(int pid, double price) {
		String query = "UPDATE item "
				+ "SET price = ?" + 
				"where  product_id = ? ";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setDouble(1,price);
			stmt.setInt(2, pid);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList<Item> getAllItems() {
		String query = "Select * from item";
		ArrayList<Item> all = new ArrayList<>();
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				int pid = rs.getInt("product_id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String categoryReturn = rs.getString("category");
				int quantity = rs.getInt("quantity");
				String description = rs.getString("description");
				all.add(new Item(pid,name,categoryReturn,description,quantity,price));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
	}

	public ArrayList<Item> getItemsByCategory(String category) {
		String query = "Select * from item where category = ?";
		ArrayList<Item> cat = new ArrayList<>();
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1, category.toUpperCase());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				int pid = rs.getInt("product_id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String categoryReturn = rs.getString("category");
				int quantity = rs.getInt("quantity");
				String description = rs.getString("description");
				cat.add(new Item(pid,name,categoryReturn,description,quantity,price));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;
	}

	public ArrayList<Item> getItemsByPriceRange(double low, double high) {
		String query = "Select * from item where price between ? and ?";
		ArrayList<Item> priceList = new ArrayList<>();
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setDouble(1, low);
			stmt.setDouble(2, high);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				int pid = rs.getInt("product_id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String categoryReturn = rs.getString("category");
				int quantity = rs.getInt("quantity");
				String description = rs.getString("description");
				priceList.add(new Item(pid,name,categoryReturn,description,quantity,price));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return priceList;
	}

	public ArrayList<Item> getItemsByName(String name) {
		String query = "Select * from item where name like ?";
		ArrayList<Item> priceList = new ArrayList<>();
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1, "%" + name.toUpperCase() + "%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				int pid = rs.getInt("product_id");
				String nameReturn = rs.getString("name");
				double price = rs.getDouble("price");
				String categoryReturn = rs.getString("category");
				int quantity = rs.getInt("quantity");
				String description = rs.getString("description");
				priceList.add(new Item(pid,nameReturn,categoryReturn,description,quantity,price));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return priceList;
	}

	public Item getItemByPid(int pid) {
		String query = "Select * from item where product_id = ?";
		Item item = null;
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setDouble(1, pid);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String categoryReturn = rs.getString("category");
				int quantity = rs.getInt("quantity");
				String description = rs.getString("description");
				item = new Item(pid,name,categoryReturn,description,quantity,price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	public boolean removeItem(int pid) {
		String query = "Delete from item where product_id = ?";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setInt(1, pid);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int getItemQuantity(int pid) {
		String query = "Select quantity from item where product_id = ?";
		int quantity=0;
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setInt(1, pid);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				quantity = rs.getInt("quantity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quantity;
	}

	public ArrayList<String> getCategories() {
		ArrayList<String> categories = new ArrayList<>();
		String query = "Select distinct category from item";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				categories.add(rs.getString("category"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}

	public Item checkDuplicates(String name, String category, double qPrice) {
		String query = "Select * from item where name = ? and category = ? and price = ?";
		
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1, name);
			stmt.setString(2, category);
			stmt.setDouble(3, qPrice);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				int pid = rs.getInt("product_id");
				String nameReturn = rs.getString("name");
				double price = rs.getDouble("price");
				String categoryReturn = rs.getString("category");
				int quantity = rs.getInt("quantity");
				String description = rs.getString("description");
				return new Item(pid,nameReturn,categoryReturn,description,quantity,price);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
