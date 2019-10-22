package com.fdmgroup.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.implementation.ReviewDAO;
import com.fdmgroup.model.Review;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class AddReview
 */

public class AddReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO rd = new ReviewDAO();
		int pid = Integer.parseInt(request.getParameter("review"));
		int rating = Integer.parseInt(request.getParameter("rate"));
		String description = request.getParameter("comment");
		rd.addReview(new Review(pid, description, ((User) request.getSession().getAttribute("user")).getUsername(), rating, new Timestamp(System.currentTimeMillis())));
		request.getRequestDispatcher("ProductPage?pid="+pid).forward(request, response);
		
	}

}
