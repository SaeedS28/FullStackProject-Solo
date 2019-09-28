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

	public boolean addReview(Review b) {
		String statement = "insert into review(product_id,email_address,review_text,rating,review_date) values (?,?,?,?,?)";
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(statement);) {
			
			if(retrieveReview(b.getEmailAddress(), b.getProductID())!= null) {
				removeReview(b.getEmailAddress(), b.getProductID());
			}
			stmt.setInt(1, b.getProductID());
			stmt.setString(2, b.getEmailAddress());
			stmt.setString(3, b.getReviewText());
			stmt.setInt(4, b.getRating());
			stmt.setTimestamp(5, b.getReviewDate());
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
				Timestamp time = rs.getTimestamp("review_date");
				retreiver.add(new Review(reviewText,emailAddress,productID,rating,time));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return retreiver;
	}

	public boolean removeReview(String userName, int productID) {
		String query = "delete from review where email_address=? and product_id=?";
		
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, userName);
			stmt.setInt(2, productID);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Review retrieveReview(String userName, int productID) {
		String query = "select * from review where product_id=? and email_address=?";
		Review retreiver = null;
		try (Connection con = DataSource.getInstance().getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setInt(1, productID);
			stmt.setString(2, userName);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String emailAddress = rs.getString("email_address");
				int rating = rs.getInt("rating");
				String reviewText = rs.getString("review_text");
				Timestamp time = rs.getTimestamp("review_date");
				retreiver = new Review(reviewText,emailAddress,productID,rating,time);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return retreiver;
	}

}
