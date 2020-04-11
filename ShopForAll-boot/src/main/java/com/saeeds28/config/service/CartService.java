package com.saeeds28.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeeds28.config.model.ShoppingCartItem;
import com.saeeds28.config.repository.CartRepo;

@Service
public class CartService {
	
	@Autowired
	CartRepo cr;
	
	public boolean doesItemExistInUserCart(String username, int productID) {
		ShoppingCartItem sci = cr.getItemQuantityInCartForUser(username, productID);
		
		if(sci != null && sci.getCartQuantity() > 0) {
			return true;
		}
		return false;
	}
}
