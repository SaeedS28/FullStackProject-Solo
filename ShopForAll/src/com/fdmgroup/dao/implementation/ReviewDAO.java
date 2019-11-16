package com.fdmgroup.dao.implementation;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.dao.interfaces.IReviewDAO;
import com.fdmgroup.model.Review;


////////////////// BONUS ///////////////////////
public class ReviewDAO implements IReviewDAO {

	@Autowired
	DBConnection connection;

	public ReviewDAO() {
		connection = DBConnection.getInstance();
	}
	
	public boolean addReview(Review b) {
		EntityManager em = connection.getEntityManger();
		Query q = em.createQuery("Select r from Review_List r where r.emailAddress like :email and r.productID = :pid",Review.class);
		q.setParameter("email", b.getEmailAddress());
		q.setParameter("pid", b.getProductID());
		@SuppressWarnings("unchecked")
		ArrayList<Review> rev = (ArrayList<Review>) q.getResultList();
		
		if(rev.size()==0) {
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();			
		}
		else {
			em.getTransaction().begin();
			rev.get(0).setRating(b.getRating());
			rev.get(0).setReviewText(b.getReviewText());
			rev.get(0).setReviewDate(b.getReviewDate());
			em.getTransaction().commit();
		}
		connection.close();
		return true;
	}
	
	public ArrayList<Review> retrieveReviews(int productID) {
		EntityManager em = connection.getEntityManger();
		Query q = em.createQuery("Select r from Review_List r where r.productID = :pid",Review.class);
		q.setParameter("pid", productID);
		@SuppressWarnings("unchecked")
		ArrayList<Review> rev = (ArrayList<Review>) q.getResultList();
		connection.close();
		return rev;
	}

	public boolean removeReviewForItem(int productID) {
		EntityManager em = connection.getEntityManger();
		Query q = em.createQuery("Select r from Review_List r where r.productID = :pid",Review.class);
		q.setParameter("pid", productID);
		
		@SuppressWarnings("unchecked")
		ArrayList<Review> rev = (ArrayList<Review>) q.getResultList();
		
		for(int i=0;i<rev.size();i++) {
			em.getTransaction().begin();
			em.remove(rev.get(i));
			em.getTransaction().commit();
		}
		connection.close();
		return true;
	}

	public boolean removeReviewForUser(String userName) {
		EntityManager em = connection.getEntityManger();
		Query q = em.createQuery("Select r from Review_List r where r.emailAddress like :userName",Review.class);
		q.setParameter("userName", userName);
		@SuppressWarnings("unchecked")
		ArrayList<Review> rev = (ArrayList<Review>) q.getResultList();
		
		for(int i=0;i<rev.size();i++) {
			em.getTransaction().begin();
			em.remove(rev.get(i));
			em.getTransaction().commit();
		}
		connection.close();
		return true;
	}

	@Override
	public void acceptReview(int reviewID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeIndividualReview(int reviewID) {
		// TODO Auto-generated method stub
		
	}

}
