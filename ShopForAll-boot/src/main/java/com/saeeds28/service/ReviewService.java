package com.saeeds28.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeeds28.model.Review;
import com.saeeds28.model.UserSession;
import com.saeeds28.repository.ReviewRepo;
import com.saeeds28.util.ReviewStatus;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepo rr;
	
	public void addReview(int productId, int rating, String reviewText){
		Review exists = reviewExist(productId, UserSession.getLoggedInUser().getUsername());
		if(exists != null) {
			exists.setRating(rating);
			exists.setReviewText(reviewText);
			exists.setReviewDate(new Timestamp(System.currentTimeMillis()));
			exists.setReviewStatus();
			rr.save(exists);
		}
		else {
			rr.save(new Review(productId, reviewText, UserSession.getLoggedInUser().getUsername(), rating, new Timestamp(System.currentTimeMillis())));
		}
	}
	
	public List<Review> getAcceptedReviews(int productId) {
		return rr.findByProductIDAndStatus(productId, ReviewStatus.ACCEPTED.toString());
	}
	
	public List<Review> getReviewsToModerate() {
		return rr.findByStatus(ReviewStatus.UNDER_REVIEW.toString());
	}

	private Review reviewExist(int productId, String username) {
		Review existReview = rr.findByProductIDAndEmailAddress(productId, username);
		return existReview;
	}
}
