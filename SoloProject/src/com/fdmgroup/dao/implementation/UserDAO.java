package com.fdmgroup.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fdmgroup.dao.interfaces.IUserDao;
import com.fdmgroup.model.User;
import com.fdmgroup.util.DataSource;

public class UserDAO implements IUserDao {
	

	@Override
	public User create(User t) {
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findByUsername(String username) {
		String query = "Select * from Java_User where Username = ?";
		User user=null;
		try(Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt= con.prepareStatement(query);){
			ResultSet rs = stmt.executeQuery();
			stmt.setString(2, username);
			
			while(rs.next()){
				int id = rs.getInt("user_ID");
				String userName = rs.getString("username");
				String pwd = rs.getString("pwd");
				String firstName= rs.getString("firstname");
				String lastName = rs.getString("lastname");
				System.out.println(id+") "+ userName+ " "+ pwd+" "+firstName+" "+lastName);
				user = new User(userName,pwd,firstName,lastName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> findByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

}
