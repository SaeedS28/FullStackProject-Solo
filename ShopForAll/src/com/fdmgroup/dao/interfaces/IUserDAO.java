package com.fdmgroup.dao.interfaces;

import java.util.ArrayList;

import com.fdmgroup.model.User;

public interface IUserDAO {
	public User findByUsername(String username);
	public boolean updatePassword(User user, String password);
	public boolean create(User t);
	public boolean remove(String s);
	public ArrayList<User> getAllUsers();
	
}
