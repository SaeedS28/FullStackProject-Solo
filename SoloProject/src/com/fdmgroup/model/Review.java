package com.fdmgroup.model;

import java.sql.Timestamp;

public class Review {
	private String reviewText, emailAddress;
	private int productID;
	private int rating;
	private Timestamp reviewDate;
	
	public Review(String reviewText, String emailAddress, int productID, int rating, Timestamp reviewDate) {
		super();
		this.reviewText = reviewText;
		this.emailAddress = emailAddress;
		this.productID = productID;
		this.rating = rating;
		this.reviewDate = reviewDate;
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
	
	public int getProductID() {
		return productID;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
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

	public String toString() {
		return "username = " + emailAddress + ", productID = " + productID + ", rating=" + rating +" reviewText = " + reviewText + ", reviewDate=" + reviewDate + "]";
	}
	
	
}
