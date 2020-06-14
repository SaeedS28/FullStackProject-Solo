package com.saeeds28.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saeeds28.model.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

	Review findByProductIDAndEmailAddress(int productId, String username);
	
	List<Review> findByProductIDAndStatus(int productId, String status);
	
	List<Review> findByStatus(String status);
}
