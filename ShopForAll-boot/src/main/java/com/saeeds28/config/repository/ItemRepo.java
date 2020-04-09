package com.saeeds28.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saeeds28.config.model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{
	
}
