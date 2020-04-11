package com.saeeds28.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saeeds28.config.model.ShoppingCartItem;

@Repository
public interface CartRepo extends JpaRepository<ShoppingCartItem, Integer> {

	@Query("Select s from Shopping_Cart_Item s where s.userName like :name and s.productID = :pid")
	ShoppingCartItem getItemQuantityInCartForUser(@Param("name") String username, @Param("pid") int productID);
	
}
