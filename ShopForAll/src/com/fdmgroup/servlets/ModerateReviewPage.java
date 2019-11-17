package com.fdmgroup.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.implementation.ReviewDAO;
import com.fdmgroup.model.Review;

/**
 * Servlet implementation class ModerateReviewPage
 */
public class ModerateReviewPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ApplicationContext context;
    public ModerateReviewPage() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO rd = context.getBean(ReviewDAO.class);
		ArrayList<Review> pending = rd.retrievePendingReviews();
		request.setAttribute("reviewMod", pending);
		request.getRequestDispatcher("/WEB-INF/view/ReviewAdminPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
