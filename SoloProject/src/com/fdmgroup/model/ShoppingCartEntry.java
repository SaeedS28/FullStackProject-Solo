package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Shopping_Cart_Entry")
@Table(name = "Shopping_Cart_Entry")
public class ShoppingCartEntry {
	@Id
	@SequenceGenerator(name = "sid", sequenceName = "shopping_cart_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sid")
	private int cartEntryID;
	@Column(nullable=false)
	private String userName;
	@Column(nullable=false)
	private int productID;
	@Column(nullable=false)
	private int itemQuantity;
	
	public ShoppingCartEntry() {
		super();
	}

	public ShoppingCartEntry(String userName, int productID, int itemQuantity) {
		super();
		this.userName = userName;
		this.productID = productID;
		this.itemQuantity = itemQuantity;
	}

	public int getCartEntryID() {
		return cartEntryID;
	}

	public void setCartEntryID(int cartEntryID) {
		this.cartEntryID = cartEntryID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}	
}
