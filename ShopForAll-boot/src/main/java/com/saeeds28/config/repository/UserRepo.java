package com.saeeds28.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saeeds28.config.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
	
	@Query("SELECT u FROM User_List u WHERE u.status like 'ACTIVE'")
	List<User> getActiveUsers();
	
	@Query("SELECT u FROM User_List u WHERE u.status like 'INACTIVE'")
	List<User> getInactiveUsers();
}
