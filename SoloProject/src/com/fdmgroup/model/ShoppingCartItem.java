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
	private String productName;
	@Column(nullable=false)
	private String userName;
	@Column(nullable=false)
	private double price;
	@Column(nullable=false)
	private int cartQuantity;
	
	public ShoppingCartItem() {}

	public ShoppingCartItem(int productID, String productName, String userName, double price,
			int cartQuantity) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.userName = userName;
		this.price = price;
		this.cartQuantity = cartQuantity;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public String toString() {
		return "itemID = " + itemID + ", productName = " + productName+ ", price per unit = " + price + ", quantity = " + cartQuantity;
	}
	
		
}
