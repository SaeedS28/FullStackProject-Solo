package com.fdmgroup.rest.service;

import java.util.ArrayList;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.implementation.UserDAO;
import com.fdmgroup.model.User;

public class UserService {

	ApplicationContext context;
	UserDAO ud;
	public UserService() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ud = context.getBean(UserDAO.class); 
	}

	public ArrayList<User> getAllUser(){
		return (ArrayList<User>)ud.getAllUsers();
	}
	
	public User getIndividualUserByUserName(String username) {
		return ud.findByUsername(username);
	}
}
