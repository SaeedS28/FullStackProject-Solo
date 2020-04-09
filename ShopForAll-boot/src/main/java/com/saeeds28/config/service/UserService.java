package com.saeeds28.config.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeeds28.config.model.User;
import com.saeeds28.config.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public User attemptLogin(String username, String password) { 
		User loggedUser = userRepo.findById(username).orElse(null);
		if(loggedUser != null && loggedUser.getPassword().equals(DigestUtils.sha256Hex(password))) {
			return loggedUser;
		}
		
		return null;
	}
	
}
