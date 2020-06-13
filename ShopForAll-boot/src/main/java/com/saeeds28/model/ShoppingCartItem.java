package com.saeeds28.model;

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

@Entity(name="Shopping_Cart_Item")
@Table(name = "Shopping_Cart_Item")
@Getter
@Setter
@NoArgsConstructor
@ToString
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

	public ShoppingCartItem(int productID, String productName, String userName, double price,
			int cartQuantity) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.userName = userName;
		this.price = price;
		this.cartQuantity = cartQuantity;
	}
}