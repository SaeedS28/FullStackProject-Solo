package com.fdmgroup.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name ="Review_List")
@Table(name="Review_List")
public class Review {
	@Id
	@SequenceGenerator(name="review_generator", sequenceName = "review_id_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_generator")
	@Column(nullable=false)
	private int reviewID;
	@Column(nullable=false)
	private int productID;
	@Column(nullable=false)
	private String reviewText;
	@Column(nullable=false)
	private String emailAddress;
	@Column(nullable=false)
	private int rating;
	@Column(nullable=false)
	private Timestamp reviewDate;
	
	public Review() {
		super();
	}

	public Review(int productID, String reviewText, String emailAddress, int rating, Timestamp timestamp) {
		super();
		this.productID = productID;
		this.reviewText = reviewText;
		this.emailAddress = emailAddress;
		this.rating = rating;
		this.reviewDate = timestamp;
	}

	public int getReviewID() {
		return reviewID;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Timestamp getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		return "reviewID = " + reviewID + ", reviewText = " + reviewText
				+ ", emailAddress = " + emailAddress + ", rating = " + rating + ", reviewDate = " + reviewDate;
	}
	
	
}
