package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name ="Item_List")
@Table(name="Item_List")
public class Item {
	@Id
	@SequenceGenerator(name="id_generator", sequenceName = "product_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@Column(nullable=false)
	private int productID;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String description;
	
	@Column(nullable=false)
	private int quantity;
	
	@Column(nullable=false)
	private double price;
	
	@Column(nullable=false)
	private String category;
	
	public Item() {}
	
	public Item(String name, String category, String description, int quantity, double price){
		this.name=name;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
		this.setPrice(price);
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

	@Override
	public String toString() {
		return "productID = " + productID + ", name = " + name + ", description = " + description + ", quantity = "
				+ quantity + ", price = "  + price + ", category = " + category;
	}

	
}
