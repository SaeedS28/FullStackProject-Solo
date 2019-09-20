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
		return null;
	}
}
