package com.saeeds28.config.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeeds28.config.model.User;
import com.saeeds28.config.model.UserSession;
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
	
	public boolean changePassword(String currentPassword, String newPassword, String repeat) {
		String currentHash = DigestUtils.sha256Hex(currentPassword);
		String newHash = DigestUtils.sha256Hex(newPassword);
		String repeatHash = DigestUtils.sha256Hex(repeat);
		
		if(currentHash.equals(UserSession.getLoggedInUser().getPassword())) {
			if(newHash.equals(repeatHash)) {
				User loggedIn = userRepo.getOne(UserSession.getLoggedInUser().getUsername());
				loggedIn.setPassword(DigestUtils.sha256Hex(newPassword));
				userRepo.save(loggedIn);
				return true;
			}
			return false;
		}
		return false;
	}
	
}
