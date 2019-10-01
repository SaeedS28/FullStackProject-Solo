package com.fdmgroup.model;

public class ShoppingCartItem {
	private String name;
	private double price;
	private String category;
	private String description;
	private int quantity;
	
	public ShoppingCartItem(String name, double price, String category, String description, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String toString() {
		return " name=" + name + ", price=" + price + ", category=" + category + ", description="
				+ description + ", quantity=" + quantity;
	}	
}
