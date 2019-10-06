package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Shopping_Cart_Item")
@Table(name = "Shopping_Cart_Item")

public class ShoppingCartItem {
	@Id
	@SequenceGenerator(name="iid_generator", sequenceName = "Item_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iid_generator")
	@Column(nullable=false)
	private int itemID;
	@Column(nullable=false)
	private int productID;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private double price;
	@Column(nullable=false)
	private String category;
	@Column(nullable=false)
	private String description;
	@Column(nullable=false)
	private int cartQuantity;
	@Column(nullable=false)
	private int itemQuantity;
	
	public ShoppingCartItem() {
		super();
	}
	
	public ShoppingCartItem(int productID, String name, double price, String category, String description, int quantity, int itemQuantity) {
		super();
		this.productID=productID;
		this.name = name;
		this.price = price;
		this.description = description;
		this.cartQuantity = quantity;
		this.itemQuantity= itemQuantity;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
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

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "itemID=" + itemID + ", productID=" + productID + ", name=" + name + ", price=" + price
				+ ", category=" + category + ", description=" + description + ", cartQuantity=" + cartQuantity
				+ ", itemQuantity=" + itemQuantity;
	}

	
}
