package com.saeeds28.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saeeds28.exception.BadRequestException;
import com.saeeds28.exception.ResourceNotFoundException;
import com.saeeds28.model.Address;
import com.saeeds28.model.User;
import com.saeeds28.service.UserService;

@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {
	
	@Autowired
	UserService us;
	
	@GetMapping
	public List<User> getAllUsers() {
		return us.getAllUsers();
	}
	
	@GetMapping(path = "/active")
	public List<User> getActiveUsers() {
		return us.getActivelUsers();
	}

	@GetMapping(path = "/inactive")
	public List<User> getInactiveUsers() {
		return us.getInactiveUsers();
	}

	@GetMapping(path = "/{username}")
	public User getUserByUsername(@PathVariable String username) {
		User find = us.getUserByUsername(username);
		
		if(find == null) {
			throw new ResourceNotFoundException();
		}
		return find;
	}
	
	@PatchMapping(path = "/{username}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Address updateAddress(@RequestBody Address a, @PathVariable String username) {
		User user = us.getUserByUsername(username);
		if(user == null) {
			throw new BadRequestException();
		}
		us.changeAddressFromRest(a, user);
		user = us.getUserByUsername(username);
		return user.getAddress();
	}
}
