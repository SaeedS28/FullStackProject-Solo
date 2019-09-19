package com.fdmgroup.model;

public class Item implements IStorable {
	private int productID;
	private String name;
	private String description;
	private int quantity;
	
	public Item(int productID, String name, String description, int quantity){
		this.productID=productID;
		this.name=name;
		this.description = description;
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "Item [productID=" + productID + ", name=" + name + ", description=" + description + ", quantity="
				+ quantity + "]";
	}
	
	
}
