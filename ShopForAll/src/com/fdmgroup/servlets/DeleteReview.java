package com.fdmgroup.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.implementation.ItemDAO;
import com.fdmgroup.dao.implementation.PurchaseOrderDAO;
import com.fdmgroup.dao.implementation.ReviewDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class DeleteReview
 */
public class DeleteReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ApplicationContext context;
    public DeleteReview() {
    	super();
    	context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getHeader("referer"));
		String redirector = request.getHeader("referer").split("/")[4];
		
		int reviewID = Integer.parseInt(request.getParameter("deleteReview"));
		ReviewDAO rd = context.getBean(ReviewDAO.class);
		rd.removeIndividualReview(reviewID);
		request.getRequestDispatcher(redirector).forward(request, response);
	}

}
