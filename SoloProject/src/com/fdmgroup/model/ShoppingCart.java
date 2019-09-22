package com.fdmgroup.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCart {
	Map<Item, Integer> itemCount;

	public ShoppingCart() {
		itemCount = new HashMap<>();
	}

	public void addItems(Item item, int quantity) {
		itemCount.put(item, quantity);
	}

	public void reset() {
		itemCount = new HashMap<>();
	}

	public boolean removeItem(int pid) {
		Iterator<Item> it = itemCount.keySet().iterator();
		while (it.hasNext()) {
			Item del = it.next();
			if (del.getProductID() == pid) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "ShoppingCart [itemCount=" + itemCount.toString() + "]";
	}

}
