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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Item {
	@Id
	@SequenceGenerator(name="id_generator", sequenceName = "product_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@Column(name ="product_id", nullable=false)
	@JsonProperty("ID")
	private int productID;
	
	@Column(name="product_name", length=69, nullable=false)
	@JsonProperty("Name")
	private String name;
	
	@Column(name="product_description", length = 1500, nullable=false)
	@JsonProperty("Description")
	private String description;
	
	@Column(name="store_quantity", nullable=false)
	@JsonProperty("Quantity")
	private int quantity;
	
	@Column(name="unit_price", nullable=false)
	@JsonProperty("Price")
	private double price;
	
	@Column(name="product_category", length = 100, nullable=false)
	@JsonProperty("Category")
	private String category;
	
	public Item(String name, String category, String description, int quantity, double price){
		this.name=name.toUpperCase();
		this.description = description;
		this.quantity = quantity;
		this.category = category.toUpperCase();
		this.setPrice(price);
	}
}