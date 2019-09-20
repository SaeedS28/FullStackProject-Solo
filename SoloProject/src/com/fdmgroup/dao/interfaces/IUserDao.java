package com.fdmgroup.dao.interfaces;

import com.fdmgroup.model.User;

public interface IUserDao extends IStorage<User>, IEditable<User>, IRemovable<User> {
	public User findByUsername(String username);
}
