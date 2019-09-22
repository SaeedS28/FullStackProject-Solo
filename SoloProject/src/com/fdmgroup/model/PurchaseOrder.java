package com.fdmgroup.model;

import java.sql.Timestamp;

public class PurchaseOrder {
	int purchaseID;
	Timestamp purchaseDate;
	String emailAddress;
	int productID;
	int quantity;
	
	public PurchaseOrder(int purchaseID, Timestamp purchaseDate, String emailAddress, int productID, int quantity) {
		super();
		this.purchaseID = purchaseID;
		this.purchaseDate = purchaseDate;
		this.emailAddress = emailAddress;
		this.productID = productID;
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseID=" + purchaseID + ", purchaseDate=" + purchaseDate + ", emailAddress="
				+ emailAddress + ", productID=" + productID + ", quantity=" + quantity + "]";
	}
	
	
}
