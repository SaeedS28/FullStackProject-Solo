package com.fdmgroup.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.implementation.ItemDAO;
import com.fdmgroup.model.Item;

/**
 * Servlet implementation class SearchByPrice
 */
public class SearchByPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByPrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String price = request.getParameter("price");
		
		if(price.equals("pressed")) {
			double minPrice = Double.parseDouble(request.getParameter("minPrice"));
			double maxPrice = Double.parseDouble(request.getParameter("maxPrice"));
			ItemDAO itd = new ItemDAO();
			ArrayList<Item> getPrice = itd.getItemsByPriceRange(minPrice, maxPrice);
			
			request.setAttribute("allItems", getPrice);
			
			request.getRequestDispatcher("/WEB-INF/view/SearchPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
