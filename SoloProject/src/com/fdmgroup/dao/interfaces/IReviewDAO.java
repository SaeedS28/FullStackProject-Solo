package com.fdmgroup.dao.interfaces;

import java.util.ArrayList;

import com.fdmgroup.model.Review;
import com.fdmgroup.model.User;

public interface IReviewDAO {
	public boolean addReview(Review b);
	public ArrayList<Review> retrieveReviews(int productID);
	public boolean removeReview(User u, int productID);
	public ArrayList<Review> retrieveReview(User u, int productID);
	
}
