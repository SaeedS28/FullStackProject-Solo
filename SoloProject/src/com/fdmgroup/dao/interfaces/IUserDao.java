package com.fdmgroup.dao.interfaces;

import com.fdmgroup.model.User;

public interface IUserDao {
	public User findByUsername(String username);
	public boolean updatePassword(User user, String password);
	public boolean create(User t);
	public boolean remove(User t);
	
}
