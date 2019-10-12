package com.fdmgroup.dao.implementation;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fdmgroup.dao.interfaces.IReviewDAO;
import com.fdmgroup.model.Review;


////////////////// BONUS ///////////////////////
public class ReviewDAO implements IReviewDAO {

	EntityManagerFactory emf;
	EntityManager em;

	public ReviewDAO() {
		emf = Persistence.createEntityManagerFactory("SoloProject");
		em = emf.createEntityManager();
	}
	
	public boolean addReview(Review b) {
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
		return true;
	}
	
	public ArrayList<Review> retrieveReviews(int productID) {
		Query q = em.createQuery("Select r from Review_List r where r.productID = :pid",Review.class);
		q.setParameter("pid", productID);
		@SuppressWarnings("unchecked")
		ArrayList<Review> rev = (ArrayList<Review>) q.getResultList();
		
		return rev;
	}

	public boolean removeReview(String userName, int productID) {
		
	}

}
