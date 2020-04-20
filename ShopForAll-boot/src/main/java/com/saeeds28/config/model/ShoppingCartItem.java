package com.saeeds28.config.model;

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
	@SequenceGenerator(name="iid_generator", sequenceName = "Item_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iid_generator")
	@Column(nullable=false, name = "item_id")
	private int itemID;
	@Column(nullable=false, name = "product_id")
	private int productID;
	@Column(nullable=false, name = "product_name")
	private String productName;
	@Column(nullable=false, name = "user_name")
	private String userName;
	@Column(nullable=false, name = "price")
	private double price;
	@Column(nullable=false, name = "cart_quantity")
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