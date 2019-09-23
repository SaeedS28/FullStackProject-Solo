package com.fdmgroup.model;

import java.sql.Timestamp;

public class Review {
	private String reviewText, emailAddress;
	private int reviewID;
	private int productID;
	private int rating;
	private Timestamp reviewDate;
	
	public Review(String reviewText, String emailAddress, int reviewID, int productID, int rating, Timestamp reviewDate) {
		super();
		this.reviewText = reviewText;
		this.emailAddress = emailAddress;
		this.reviewID = reviewID;
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
		return "username = " + emailAddress + ", reviewID = " + reviewID + ", productID = "
				+ productID + ", rating=" + rating +" reviewText = " + reviewText + ", reviewDate=" + reviewDate + "]";
	}
	
	
}
