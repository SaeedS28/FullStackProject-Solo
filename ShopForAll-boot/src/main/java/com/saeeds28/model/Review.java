package com.saeeds28.model;

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
import com.saeeds28.util.ReviewStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name ="Review_List")
@Table(name="Review_List")
@JsonPropertyOrder({"ProductID","Username","Review","Rating","Date"})

@NoArgsConstructor
@ToString
public class Review {
	@Id
	@SequenceGenerator(name="review_generator", sequenceName = "review_id_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_generator")
	@Getter
	@Setter
	@JsonIgnore
	@Column(name="review_id", nullable=false)
	private int reviewID;
	
	@Getter
	@Setter
	@JsonProperty("ProductID")
	@Column(name="product_id", nullable=false)
	private int productID;
	
	@Getter
	@Setter
	@JsonProperty("Review")
	@Column(name="review_descriptiom", length=500, nullable=false)
	private String reviewText;
	
	@Getter
	@Setter
	@JsonProperty("Username")
	@Column(name="user_name", nullable=false)
	private String emailAddress;
	
	@Getter
	@Setter
	@JsonProperty("Rating")
	@Column(name="numerical_rating", nullable=false)
	private int rating;
	
	@Getter
	@Setter
	@JsonProperty("Date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "E, dd MM yyyy HH:mm:ss z", timezone = "GMT-5")
	@Column(name="review_date", nullable=false)
	private Timestamp reviewDate;
	
	@Getter
	@JsonIgnore
	@Column(name="review_status", nullable=false)
	private String status;

	public Review(int productID, String reviewText, String emailAddress, int rating, Timestamp timestamp) {
		super();
		this.productID = productID;
		this.reviewText = reviewText;
		this.emailAddress = emailAddress;
		this.rating = rating;
		this.reviewDate = timestamp;
		this.status = ReviewStatus.UNDER_REVIEW.toString();
	}
	
	public void acceptReview() {
		this.status = ReviewStatus.ACCEPTED.toString();
	}
	
	public void setReviewStatus() {
		this.status = ReviewStatus.UNDER_REVIEW.toString();
	}
}
