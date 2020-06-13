package com.saeeds28.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name ="Purchase_Order_List")
@Table(name="Purchase_Order_List")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PurchaseOrder {
	// Add JSON for REST
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
}