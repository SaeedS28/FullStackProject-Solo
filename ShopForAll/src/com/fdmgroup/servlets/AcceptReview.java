package com.fdmgroup.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.implementation.ReviewDAO;
import com.fdmgroup.model.Review;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class AcceptReview
 */
public class AcceptReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptReview() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ApplicationContext context;
	public void init(ServletConfig config) throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO rd = context.getBean(ReviewDAO.class);
		int reviewId = Integer.parseInt(request.getParameter("AcceptReview"));
		rd.acceptReview(reviewId);
		request.getRequestDispatcher("ModerateReviewPage").forward(request, response);
	}

}
