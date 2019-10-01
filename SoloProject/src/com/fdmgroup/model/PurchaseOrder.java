package com.fdmgroup.model;

import java.sql.Timestamp;

public class PurchaseOrder {
	private int purchaseID;
	private Timestamp purchaseDate;
	private String emailAddress;
	private int productID;
	private int quantity;
	private double price;
	
	public PurchaseOrder(int purchaseID, Timestamp purchaseDate, String emailAddress, int productID, int quantity, double price) {
		super();
		this.purchaseID = purchaseID;
		this.purchaseDate = purchaseDate;
		this.emailAddress = emailAddress;
		this.productID = productID;
		this.quantity = quantity;
		this.setPrice(price);
	}

	public int getPurchaseID() {
		return purchaseID;
	}

	public void setPurchaseID(int purchaseID) {
		this.purchaseID = purchaseID;
	}

	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "purchaseID = " + purchaseID + ", purchaseDate = " + purchaseDate + ", emailAddress = "
				+ emailAddress + ", productID = " + productID + ", quantity = " + quantity + ", price = " + price;
	}

	
	
	
}
