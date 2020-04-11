package com.saeeds28.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saeeds28.config.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
	
}
