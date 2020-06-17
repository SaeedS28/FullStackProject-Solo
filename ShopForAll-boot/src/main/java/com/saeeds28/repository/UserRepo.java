package com.saeeds28.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saeeds28.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
	
	List<User> findByStatus(String status);
}
