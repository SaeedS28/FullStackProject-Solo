package com.saeeds28.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeeds28.exception.ResourceNotFoundException;
import com.saeeds28.model.Address;
import com.saeeds28.model.User;
import com.saeeds28.model.UserSession;
import com.saeeds28.repository.UserRepo;
import com.saeeds28.util.UserStatus;

@Service
public class UserService {
	
	private static Logger login = LogManager.getLogger("login");
	private static Logger user = LogManager.getLogger("user");
	
	@Autowired
	UserRepo userRepo;

	public User attemptLogin(String username, String password) {
		User loggedUser = userRepo.findById(username).orElse(null);
		if (loggedUser != null && loggedUser.getPassword().equals(DigestUtils.sha256Hex(password))
				&& loggedUser.getStatus().equals(UserStatus.ACTIVE.toString())) {
			login.info("Login attempt: username (" + username + ") successful");
			return loggedUser;
		}
		login.info("Login attempt: username (" + username + ") unsuccessful");
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
		user.info("(" + UserSession.getLoggedInUser().getUsername() + " address change success");
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
				user.info("(" + UserSession.getLoggedInUser()+")" + " password change success");
				return true;
			}
			user.info("(" + UserSession.getLoggedInUser().getUsername() + ")" + " password change fail. Password mismatch");
			return false;
		}
		user.info("(" + UserSession.getLoggedInUser().getUsername() + ")" + " password change fail. Password mismatch");
		return false;
	}

	public boolean addUser(User userAdd, Address a) {
		User existing = userRepo.findById(userAdd.getUsername()).orElse(null);
		if (existing != null) {
			user.info("(" + UserSession.getLoggedInUser().getUsername() + ")" + " initiated addUser. Fail (" + userAdd.getUsername() + ") already taken");
			return false;
		}
		a.setEmailAddress(userAdd.getUsername());
		userAdd.setAddress(a);
		userAdd.setStatus(UserStatus.ACTIVE.toString());
		userAdd.setPassword(DigestUtils.sha256Hex(userAdd.getPassword()));
		userRepo.save(userAdd);
		user.info("(" + UserSession.getLoggedInUser().getUsername() + ")" + " initiated addUser. Success (" + userAdd.getUsername() + ") with user type " + userAdd.getType());
		return true;
	}

	public List<User> getActivelUsers() {
		return userRepo.findByStatus(UserStatus.ACTIVE.toString());
	}

	public List<User> getInactiveUsers() {
		return userRepo.findByStatus(UserStatus.INACTIVE.toString());
	}
	
	public boolean inactivateUser(String username) {
		if(UserSession.getLoggedInUser().getUsername().equals(username)) {
			user.info("(" + UserSession.getLoggedInUser().getUsername() + ")" + " failed user ban. Cannot ban self");
			return false;
		}
		User userBan = userRepo.getOne(username);
		userBan.setStatus(UserStatus.INACTIVE.toString());
		userRepo.save(userBan);
		user.info("(" + UserSession.getLoggedInUser().getUsername() + ")" + " successfully banned user (" + username + ")");
		return true;
	}
	
	public boolean activateUser(String username) {
		User userActive = userRepo.getOne(username);
		userActive.setStatus(UserStatus.ACTIVE.toString());
		userRepo.save(userActive);
		user.info("(" + UserSession.getLoggedInUser().getUsername() + ")" + " reactivated user account (" + username + ")");
		return true;
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User getUserByUsername(String username) {
		User find = userRepo.findById(username).orElse(null);
		
		if(find == null) {
			throw new ResourceNotFoundException();
		}
		return find;
	}
}
