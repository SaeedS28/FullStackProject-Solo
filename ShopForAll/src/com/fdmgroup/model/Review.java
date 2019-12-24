package com.fdmgroup.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity(name ="Review_List")
@Table(name="Review_List")
@JsonPropertyOrder({"ProductID","Username","Review","Rating","Date"})
public class Review {
	@Id
	@SequenceGenerator(name="review_generator", sequenceName = "review_id_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_generator")
	@Column(name="review_id", nullable=false)
	private int reviewID;
	
	@Column(name="product_id", nullable=false)
	private int productID;
	
	@Column(name="review_descriptiom", length=500, nullable=false)
	private String reviewText;
	
	@Column(name="user_name", nullable=false)
	private String emailAddress;
	
	@Column(name="numerical_rating", nullable=false)
	private int rating;
	
	@Column(name="review_date", nullable=false)
	private Timestamp reviewDate;
	
	@Column(name="review_status", nullable=false)
	private String status;
	
	public static final String UNDER_REVIEW="Under Review";
	public static final String ACCEPTED ="Accepted";
	
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
		this.status = UNDER_REVIEW;
	}

	@JsonIgnore
	public int getReviewID() {
		return reviewID;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}

	@JsonProperty("ProductID")
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	@JsonProperty("Review")
	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	@JsonProperty("Username")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@JsonProperty("Rating")
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@JsonProperty("Date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "E, dd MM yyyy HH:mm:ss z", timezone = "GMT-5")
	public Timestamp getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}

	public void acceptReview() {
		this.status = ACCEPTED;
	}
	
	@JsonIgnore
	public String getStatus() {
		return this.status;
	}
	
	public String toString() {
		return "reviewID = " + reviewID + ", reviewText = " + reviewText
				+ ", emailAddress = " + emailAddress + ", rating = " + rating + ", reviewDate = " + reviewDate;
	}

	public void setReviewStatus() {
		this.status = UNDER_REVIEW;
	}
}
