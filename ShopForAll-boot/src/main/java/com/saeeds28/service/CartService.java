package com.saeeds28.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeeds28.model.Item;
import com.saeeds28.model.ShoppingCartItem;
import com.saeeds28.model.UserSession;
import com.saeeds28.repository.CartRepo;

@Service
public class CartService {

	@Autowired
	CartRepo cr;
	@Autowired
	ItemService is;

	public boolean doesItemExistInUserCart(int productID) {
		ShoppingCartItem sci = cr.findByUserNameAndProductID(UserSession.getLoggedInUser().getUsername(), productID);

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
		return cr.findByUserName(UserSession.getLoggedInUser().getUsername());
	}
	
	public List<ShoppingCartItem> getShoppingCartItems(int pid) {
		return cr.findByProductID(pid);
	}
	
	public double getCartTotal() {
		Double total = cr.getCartTotal(UserSession.getLoggedInUser().getUsername());
		
		if(total == null) {
			return 0;
		}
		return total;
	}
	
	public void removeItemFromCart(int productID) {
		ShoppingCartItem sci = cr.findByUserNameAndProductID(UserSession.getLoggedInUser().getUsername(), productID);
		cr.delete(sci);
	}

	public boolean subtractItem(int productID) {
		ShoppingCartItem sci = cr.findByUserNameAndProductID(UserSession.getLoggedInUser().getUsername(), productID);
		
		if(sci.getCartQuantity() - 1 > 0) {
			sci.setCartQuantity(sci.getCartQuantity() - 1);
			cr.save(sci);
			return true;
		}
		return false;
	}
	
	public boolean addItem(int productID) {
		Item item = is.getItemById(productID);
		ShoppingCartItem sci = cr.findByUserNameAndProductID(UserSession.getLoggedInUser().getUsername(), productID);
		
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
	
	public void emptyUserCart() {
		List<ShoppingCartItem> sci = getShoppingCartItemsForUser();
		cr.deleteAll(sci);
	}
}
