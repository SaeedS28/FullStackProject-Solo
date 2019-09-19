package com.fdmgroup.model;

import com.fdmgroup.dao.interfaces.IStorable;

public class Item implements IStorable {
	private int productID;
	private String name;
	private String description;
	private int quantity;
	private double price;
	
	public Item(int productID, String name, String description, int quantity, double price){
		this.productID=productID;
		this.name=name;
		this.description = description;
		this.quantity = quantity;
		this.setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductID() {
		return productID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [productID=" + productID + ", name=" + name + ", description=" + description + ", quantity="
				+ quantity + "]";
	}
	
	
}
