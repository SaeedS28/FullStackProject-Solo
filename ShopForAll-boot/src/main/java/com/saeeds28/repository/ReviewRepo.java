package com.saeeds28.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saeeds28.model.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

}
