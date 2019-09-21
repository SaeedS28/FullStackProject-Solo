package com.fdmgroup.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fdmgroup.dao.interfaces.IUserDao;
import com.fdmgroup.model.User;
import com.fdmgroup.util.DataSource;

public class UserDAO implements IUserDao{
	
	public boolean create(User t) {
		String query = "Insert into users(email_address, password, first_name, last_name, types) values (?,?,?,?,?)";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1, t.getUsername());
			stmt.setString(2, t.getPassword());
			stmt.setString(3, t.getFirstname());
			stmt.setString(4, t.getLastname());
			stmt.setString(5, t.getType());
			
			stmt.execute();
			
			
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

	public boolean remove(String s) {
		String query = "Delete from users where email_address = ?";
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1, s);			
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

	public User findByUsername(String username) {
		String query = "Select * from users where email_address = ?";
		User user=null;
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				String userName = rs.getString("email_address");
				String pwd = rs.getString("password");
				String firstName= rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String type = rs.getString("types");
				
				user = new User(userName,pwd,firstName,lastName,type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public boolean updatePassword(User user, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
