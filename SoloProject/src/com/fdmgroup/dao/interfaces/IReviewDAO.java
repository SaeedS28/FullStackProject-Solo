package com.fdmgroup.dao.interfaces;

import java.util.ArrayList;

import com.fdmgroup.model.Review;
import com.fdmgroup.model.User;

public interface IReviewDAO {
	public boolean addReview(Review b);
	public ArrayList<Review> retrieveReviews(int productID);
	public boolean removeReview(String userName, int productID);
	public Review retrieveReview(String userName, int productID);
	
}
