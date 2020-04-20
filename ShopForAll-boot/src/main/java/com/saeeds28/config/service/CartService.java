package com.saeeds28.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeeds28.config.model.Item;
import com.saeeds28.config.model.ShoppingCartItem;
import com.saeeds28.config.model.UserSession;
import com.saeeds28.config.repository.CartRepo;

@Service
public class CartService {

	@Autowired
	CartRepo cr;
	@Autowired
	ItemService is;

	public boolean doesItemExistInUserCart(int productID) {
		ShoppingCartItem sci = cr.getItemsInCartForUser(UserSession.getLoggedInUser().getUsername(), productID);

		if (sci != null && sci.getCartQuantity() > 0) {
			return true;
		}
		return false;
	}

	public void addItemToCart(int productID) {
		Item item = is.getItemById(productID);
		ShoppingCartItem sciCartItem = new ShoppingCartItem(item.getProductID(), item.getName(),
				UserSession.getLoggedInUser().getUsername(), item.getPrice(), 1);
		cr.save(sciCartItem);
	}

	public List<ShoppingCartItem> getShoppingCartItemsForUser() {
		return cr.getCartForUser(UserSession.getLoggedInUser().getUsername());
	}
	
	public List<ShoppingCartItem> getShoppingCartItems(int pid) {
		return cr.getAnItemFromAllCarts(pid);
	}
	
	public double getCartTotal() {
		Double total = cr.getCartTotal(UserSession.getLoggedInUser().getUsername());
		
		if(total == null) {
			return 0;
		}
		return total;
	}
	
	public void removeItemFromCart(int productID) {
		ShoppingCartItem sci = cr.getItemsInCartForUser(UserSession.getLoggedInUser().getUsername(), productID);
		cr.delete(sci);
	}

	public boolean subtractItem(int productID) {
		Item item = is.getItemById(productID);
		ShoppingCartItem sci = cr.getItemsInCartForUser(UserSession.getLoggedInUser().getUsername(), productID);
		
		if(sci.getCartQuantity() - 1 > 0) {
			sci.setCartQuantity(sci.getCartQuantity() - 1);
			cr.save(sci);
			return true;
		}
		return false;
	}
	
	public boolean addItem(int productID) {
		Item item = is.getItemById(productID);
		ShoppingCartItem sci = cr.getItemsInCartForUser(UserSession.getLoggedInUser().getUsername(), productID);
		
		if(sci.getCartQuantity() + 1 <= item.getQuantity()) {
			sci.setCartQuantity(sci.getCartQuantity() + 1);
			cr.save(sci);
			return true;
		}
		return false;
	}
	
	public void update(List<ShoppingCartItem> sci) {
		cr.saveAll(sci);
	}
}
