package com.saeeds28.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name ="Purchase_Order_List")
@Table(name="Purchase_Order_List")
public class PurchaseOrder {
	
	@Id
	@SequenceGenerator(name="product_order_generator", sequenceName = "pid_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_order_generator")
	@Column(nullable=false, name = "purchase_id")
	private int purchaseID;
	@Column(nullable=false, name = "purchase_date")
	private Timestamp purchaseDate;
	@Column(nullable=false, name = "email_address")
	private String emailAddress;
	@Column(nullable=false, name = "product_id")
	private int productID;
	@Column(nullable=false, name = "quantity")
	private int quantity;
	@Column(nullable=false, name = "price")
	private double price;
	
	public PurchaseOrder(Timestamp purchaseDate, String emailAddress, int productID, int quantity, double price) {
		super();
		this.purchaseDate = purchaseDate;
		this.emailAddress = emailAddress;
		this.productID = productID;
		this.quantity = quantity;
		this.setPrice(price);
	}

	public PurchaseOrder() {}
	
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