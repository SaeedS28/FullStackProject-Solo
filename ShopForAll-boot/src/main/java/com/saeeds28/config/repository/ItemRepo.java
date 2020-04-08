package com.saeeds28.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saeeds28.config.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer>{
	
}
