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
	
	public User create(User t) {
		return null;
	}

	public boolean remove(User t) {
		// TODO Auto-generated method stub
		return false;
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
				System.out.println(userName+") "+ userName+ " "+ pwd+" "+firstName+" "+lastName);
				//user = new User(userName,pwd,firstName,lastName);
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
