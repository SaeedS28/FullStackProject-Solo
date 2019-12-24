package com.fdmgroup.rest.mapper;

import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.implementation.UserDAO;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;

public class UserMapper {

	private static Logger userLogger = LogManager.getLogger("UserAR");
	ApplicationContext context;
	UserDAO ud;
	public UserMapper() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ud = context.getBean(UserDAO.class); 
	}

	public ArrayList<User> getAllUser(){
		return (ArrayList<User>)ud.getAllUsers();
	}
	
	public User getIndividualUserByUserName(String username) {
		return ud.findByUsername(username);
	}
	
	private boolean checkUserFields(User user) {
		if(user.getUsername()==null || user.getUsername().isEmpty()) {
			System.out.println("something wrong with username");
			return false;
		}
		if(user.getPassword()==null || user.getPassword().isEmpty()) {
			System.out.println("something wrong with password");
			return false;
		}
		if(user.getFirstname()==null || user.getFirstname().isEmpty()) {
			System.out.println("something wrong with first name");
			return false;
		}
		if(user.getLastname()==null || user.getLastname().isEmpty()) {
			System.out.println("something wrong with last name");
			return false;
		}
		if(user.getType()==null || user.getType().isEmpty() || !user.getType().equalsIgnoreCase("customer")) {
			System.out.println("something wrong with type");
			return false;
		}
		
		user.getAddress().setEmailAddress(user.getUsername());
		
		if(user.getAddress().getCity()==null || user.getAddress().getCity().isEmpty()) {
			return false;
		}
		if(user.getAddress().getCountry()==null || user.getAddress().getCountry().isEmpty()) {
			return false;
		}
		if(user.getAddress().getProvince()==null || user.getAddress().getProvince().isEmpty()) {
			return false;
		}
		if(user.getAddress().getPostalCode()==null || user.getAddress().getPostalCode().isEmpty()) {
			return false;
		}
		if(user.getAddress().getStreet()==null || user.getAddress().getStreet().isEmpty()) {
			return false;
		}
		return true;
	}
	
	public boolean addCustomer(User user) {
		if(checkUserFields(user) && ud.findByUsername(user.getUsername())==null) {
			user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
			user.setType("regular");
			ud.create(user);
			userLogger.info("User with username: " + user.getUsername() + " and account type: "+ user.getType() +" created successfully");
			return true;
			
		}
		return false;
	}
	
}
