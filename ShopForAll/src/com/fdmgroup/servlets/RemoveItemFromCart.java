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
 * Servlet implementation class RemoveItemFromCart
 */
public class RemoveItemFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ApplicationContext context;
	public void init(ServletConfig config) throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveItemFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("remove"));
		User user = (User) request.getSession().getAttribute("user");
		
		ShoppingCartDAO scd = context.getBean(ShoppingCartDAO.class);
		scd.removeItem(user, pid);
		ArrayList<ShoppingCartItem> sci = scd.getCartDetails(user);
		request.getSession().removeAttribute("sCart");
		request.getSession().setAttribute("sCart", sci);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Successfully removed item from cart');");
		out.println("location='ShoppingCart';");
		out.println("</script>");
	}

}
