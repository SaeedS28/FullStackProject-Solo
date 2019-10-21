package com.fdmgroup.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.implementation.ItemDAO;
import com.fdmgroup.dao.implementation.ShoppingCartDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class ChangeQuantityInCart
 */
public class ChangeQuantityInCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeQuantityInCart() {
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
		String add = request.getParameter("add");
		String sub = request.getParameter("subtract");
		
		ShoppingCartDAO scd = new ShoppingCartDAO();
		User loggedIn = (User) request.getSession().getAttribute("user");
		ItemDAO itd = new ItemDAO();

		if(add!=null) {
			System.out.println("add="+add);
			int pid = Integer.parseInt(add);
			int cartQuantity = scd.getQuantity(loggedIn, pid);
			int stock = itd.getItemQuantity(pid);
			if(cartQuantity+1<=stock) {
				System.out.println("added");
				scd.addItem(loggedIn, pid, cartQuantity+1);
				ArrayList<ShoppingCartItem> sci = scd.getCartDetails(loggedIn);
				request.getSession().removeAttribute("sCart");
				request.getSession().setAttribute("sCart", sci);
				request.getRequestDispatcher("ShoppingCart").forward(request, response);
			}
			else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Quantity maxed out. Nothing added');");
				out.println("location='ShoppingCart';");
				out.println("</script>");
			}
		}
		else if(sub!=null) {
			int pid = Integer.parseInt(sub);
			int cartQuantity = scd.getQuantity(loggedIn, pid);
			if(cartQuantity-1>0) {
				scd.addItem(loggedIn, pid, cartQuantity-1);
				ArrayList<ShoppingCartItem> sci = scd.getCartDetails(loggedIn);
				request.getSession().removeAttribute("sCart");
				request.getSession().setAttribute("sCart", sci);
				request.getRequestDispatcher("ShoppingCart").forward(request, response);
			}
			else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Quantity cannot be less than 1');");
				out.println("location='ShoppingCart';");
				out.println("</script>");
			}
		}
	}

}
