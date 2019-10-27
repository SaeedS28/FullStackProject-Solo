package com.fdmgroup.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.implementation.ShoppingCartDAO;
import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class AddItemToCart
 */
public class AddItemToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ApplicationContext context;
	public void init(ServletConfig config) throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
    public AddItemToCart() {
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
		int pid = Integer.parseInt(request.getParameter("pid"));
		User loggedIn = (User) request.getSession().getAttribute("user");
		ShoppingCartDAO scd = context.getBean(ShoppingCartDAO.class);
		scd.addItem(loggedIn, pid, 1);
		ArrayList<ShoppingCartItem> sci = scd.getCartDetails(loggedIn);
		request.getSession().removeAttribute("sCart");
		request.getSession().setAttribute("sCart", sci);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Added item to cart.');");
		out.println("location='ProductPage?pid="+pid+"';");
		out.println("</script>");
	}

}
