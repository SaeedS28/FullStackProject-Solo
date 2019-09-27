package com.fdmgroup.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.fdmgroup.dao.interfaces.IReviewDAO;
import com.fdmgroup.model.Review;
import com.fdmgroup.model.User;
import com.fdmgroup.util.DataSource;

////////////////// BONUS ///////////////////////
public class ReviewDAO implements IReviewDAO {

	@Override
	public boolean addReview(Review b) {
		return false;

	}
	
	public ArrayList<Review> retrieveReviews(int productID) {
		String query = "select * from review where product_id=?";
		ArrayList<Review> retreiver = new ArrayList<>();
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setInt(1, productID);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String emailAddress = rs.getString("email_address");
				int rating = rs.getInt("rating");
				String reviewText = rs.getString("review_text");
				int reviewID = rs.getInt("review_id");
				Timestamp time = rs.getTimestamp("review_date");
				retreiver.add(new Review(reviewText,emailAddress,reviewID,productID,rating,time));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return retreiver;
	}

	public boolean removeReview(User u, int productID) {
		String query = "delete from review where email_address=? and product_id=?";
		
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, u.getUsername());
			stmt.setInt(2, productID);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Review> retrieveReview(User u, int productID) {
		// TODO Auto-generated method stub
		return null;
	}

}
