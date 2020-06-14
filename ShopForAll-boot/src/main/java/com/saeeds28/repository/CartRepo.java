package com.saeeds28.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saeeds28.model.ShoppingCartItem;

@Repository
public interface CartRepo extends JpaRepository<ShoppingCartItem, Integer> {

	@Query("Select s from Shopping_Cart_Item s where s.userName like :name and s.productID = :pid")
	ShoppingCartItem getItemsInCartForUser(@Param("name") String username, @Param("pid") int productID);
	
	@Query("Select s from Shopping_Cart_Item s where s.userName like :name")
	List<ShoppingCartItem> getCartForUser(@Param("name") String username);
	
	@Query("Select s from Shopping_Cart_Item s where s.productID = :pid")
	List<ShoppingCartItem> getAnItemFromAllCarts(@Param("pid") int productID);
	
	@Query("Select SUM(s.cartQuantity * s.price) from Shopping_Cart_Item s where s.userName like :name")
	Double getCartTotal(@Param("name") String username);
}
