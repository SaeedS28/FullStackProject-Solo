package com.fdmgroup.dao.interfaces;

import java.util.ArrayList;

import com.fdmgroup.model.Review;

public interface IReviewDAO {
	public boolean addReview(Review b);
	public ArrayList<Review> retrieveReviews(int productID);
	public boolean removeReviewForItem(int productID);
	public boolean removeReviewForUser(String userName);
	public void acceptReview(int reviewID);
	public void removeIndividualReview(int reviewID);
}
