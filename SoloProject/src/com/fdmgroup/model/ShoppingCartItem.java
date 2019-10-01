package com.fdmgroup.model;

public class ShoppingCartItem {
	private int productID;
	private String name;
	private double price;
	private String category;
	private String description;
	private int quantity;
	private int itemQuantity;
	
	public ShoppingCartItem(int productID, String name, double price, String category, String description, int quantity, int itemQuantity) {
		super();
		this.productID=productID;
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
		this.quantity = quantity;
		this.itemQuantity= itemQuantity;
	}

	public String getName() {
		return name;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
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

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String toString() {
		return "name=" + name + ", price=" + price + ", category=" + category + ", description="
				+ description + ", quantity=" + quantity;
	}	
}
