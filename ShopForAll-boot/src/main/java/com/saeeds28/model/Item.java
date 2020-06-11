package com.saeeds28.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity(name ="Item_List")
@Table(name="Item_List")
@JsonPropertyOrder({
	"ID",
	"Name",
	"Description",
	"Quantity",
	"Price",
	"Category"
})
public class Item {
	@Id
	@SequenceGenerator(name="id_generator", sequenceName = "product_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@Column(name ="product_id", nullable=false)
	private int productID;
	
	@Column(name="product_name", length=69, nullable=false)
	private String name;
	
	@Column(name="product_description", length = 1500, nullable=false)
	private String description;
	
	@Column(name="store_quantity", nullable=false)
	private int quantity;
	
	@Column(name="unit_price", nullable=false)
	private double price;
	
	@Column(name="product_category", length = 100, nullable=false)
	private String category;
	
	public Item() {}
	
	public Item(String name, String category, String description, int quantity, double price){
		this.name=name.toUpperCase();
		this.description = description;
		this.quantity = quantity;
		this.category = category.toUpperCase();
		this.setPrice(price);
	}

	@JsonProperty("ID")
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	@JsonProperty("Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("Quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("Price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@JsonProperty("Category")
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