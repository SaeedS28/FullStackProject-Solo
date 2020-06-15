package com.saeeds28.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeeds28.model.Address;
import com.saeeds28.model.User;
import com.saeeds28.model.UserSession;
import com.saeeds28.repository.UserRepo;
import com.saeeds28.util.UserStatus;

@Service
public class UserService {
	
	private static Logger login = LogManager.getLogger("login");
	
	@Autowired
	UserRepo userRepo;

	public User attemptLogin(String username, String password) {
		User loggedUser = userRepo.findById(username).orElse(null);
		if (loggedUser != null && loggedUser.getPassword().equals(DigestUtils.sha256Hex(password))
				&& loggedUser.getStatus().equals(UserStatus.ACTIVE.toString())) {
			login.info("Login attempt: username (" + username + ") successful");
			return loggedUser;
		}
		return null;
	}
	
	public void changeAddress(Address a) {
		User loggedIn = userRepo.getOne(UserSession.getLoggedInUser().getUsername());
		Address toChange = loggedIn.getAddress();
		toChange.setStreet(a.getStreet());
		toChange.setCountry(a.getCountry());
		toChange.setProvince(a.getProvince());
		toChange.setPostalCode(a.getPostalCode());
		userRepo.save(loggedIn);
		UserSession.getLoggedInUser().setAddress(a);
	}
	
	public boolean changePassword(String currentPassword, String newPassword, String repeat) {
		String currentHash = DigestUtils.sha256Hex(currentPassword);
		String newHash = DigestUtils.sha256Hex(newPassword);
		String repeatHash = DigestUtils.sha256Hex(repeat);

		if (currentHash.equals(UserSession.getLoggedInUser().getPassword())) {
			if (newHash.equals(repeatHash)) {
				User loggedIn = userRepo.getOne(UserSession.getLoggedInUser().getUsername());
				loggedIn.setPassword(DigestUtils.sha256Hex(newPassword));
				userRepo.save(loggedIn);
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean addUser(User user, Address a) {
		User existing = userRepo.findById(user.getUsername()).orElse(null);
		if (existing != null) {
			return false;
		}
		a.setEmailAddress(user.getUsername());
		user.setAddress(a);
		user.setStatus(UserStatus.ACTIVE.toString());
		user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
		userRepo.save(user);
		return true;
	}

	public List<User> getActivelUsers() {
		return userRepo.getActiveUsers();
	}

	public List<User> getInactiveUsers() {
		return userRepo.getInactiveUsers();
	}
	
	public boolean inactivateUser(String username) {
		if(UserSession.getLoggedInUser().getUsername().equals(username)) {
			return false;
		}
		User user = userRepo.getOne(username);
		user.setStatus(UserStatus.INACTIVE.toString());
		userRepo.save(user);
		return true;
	}
	
	public boolean activateUser(String username) {
		User user = userRepo.getOne(username);
		user.setStatus(UserStatus.ACTIVE.toString());
		userRepo.save(user);

		return true;
	}
}
