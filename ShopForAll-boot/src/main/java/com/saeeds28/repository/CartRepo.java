package com.saeeds28.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saeeds28.model.ShoppingCartItem;

@Repository
public interface CartRepo extends JpaRepository<ShoppingCartItem, Integer> {

	ShoppingCartItem findByUserNameAndProductID(String username,int productID);
	
	List<ShoppingCartItem> findByUserName(String username);
	
	List<ShoppingCartItem> findByProductID(int productID);
	
	@Query("Select SUM(s.cartQuantity * s.price) from Shopping_Cart_Item s where s.userName like :name")
	Double getCartTotal(@Param("name") String username);
}
