package com.saeeds28.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeeds28.model.PurchaseOrder;
import com.saeeds28.model.ShoppingCartItem;
import com.saeeds28.model.UserSession;
import com.saeeds28.repository.CheckoutRepo;

@Service
public class CheckoutService {

	@Autowired
	CheckoutRepo cr;
	@Autowired
	ItemService is;
	@Autowired
	CartService car;

	public boolean processOrder(List<ShoppingCartItem> sci) {
		// checking to see if the quantity is in stock
		for (int i = 0; i < sci.size(); i++) {
			int itemQty = is.getItemById(sci.get(i).getProductID()).getQuantity();
			int cartQty = sci.get(i).getCartQuantity();

			if (cartQty > itemQty) {
				return false;
			}
		}

		for (int i = 0; i < sci.size(); i++) {
			is.addQuantity(sci.get(i).getProductID(), -1 * sci.get(i).getCartQuantity());
			cr.save(new PurchaseOrder(new Timestamp(System.currentTimeMillis()),
					UserSession.getLoggedInUser().getUsername(), sci.get(i).getProductID(),
					sci.get(i).getCartQuantity(), sci.get(i).getPrice()));
		}
		
		car.emptyUserCart();
		return true;
	}
}
