package com.fdmgroup.dao.implementation;

import java.util.ArrayList;

import com.fdmgroup.dao.interfaces.IReviewDAO;
import com.fdmgroup.model.Review;
import com.fdmgroup.model.User;

////////////////// BONUS ///////////////////////
public class ReviewDAO implements IReviewDAO{

	@Override
	public boolean addReview(Review b) {
		return false;
		
	}

	@Override
	public ArrayList<Review> retrieveReviews(int productID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeReview(User u, int productID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Review> retrieveReview(User u, int productID) {
		// TODO Auto-generated method stub
		return null;
	}

}
