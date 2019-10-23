package com.fdmgroup.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.implementation.ItemDAO;
import com.fdmgroup.model.Item;

/**
 * Servlet implementation class AddItem
 */
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem() {
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
		String button = request.getParameter("add");
		
		if(button.equals("pressed")) {
			String name = request.getParameter("pName");
			double price = Double.parseDouble(request.getParameter("pPrice"));
			int quantity = Integer.parseInt(request.getParameter("pQuantity"));
			String desc = request.getParameter("pDesc");
			String cat = request.getParameter("pCat");
			
			ItemDAO itd = new ItemDAO();
			itd.addItem(new Item(name, cat,desc,quantity,price));
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully added a new item');");
			out.println("location='MainPage';");
			out.println("</script>");
		}
	}
}
