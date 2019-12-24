package com.fdmgroup.rest.mapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.implementation.ReviewDAO;
import com.fdmgroup.model.Review;;

public class ReviewMapper {
	ApplicationContext context;
	ReviewDAO ud;
	
	public ReviewMapper() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ud = context.getBean(ReviewDAO.class); 
	}
	
	public List<Review> getAllReviews(){
		return ud.retrieveAcceptedReviews();
	}

	public List<Review> getReviewsByUser(String name) {
		return ud.retrieveReviewsByCustomer(name);
	}
}
