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
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.implementation.ShoppingCartDAO;
import com.fdmgroup.dao.implementation.UserDAO;
import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private static Logger loginLogger = LogManager.getLogger("LoginAttempts");
	ApplicationContext context;
	public void init(ServletConfig config) throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	public Login() {
		
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/Login.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String buttonPress = request.getParameter("loginPress");

		if (buttonPress.equals("pressed")) {
			String userName = request.getParameter("uname");
			String password = request.getParameter("psw");

			User userSession = login(userName, password);

			if (userSession != null) {
				HttpSession user = request.getSession();
				user.setAttribute("user", userSession);
				ShoppingCartDAO scd = context.getBean(ShoppingCartDAO.class);
				ArrayList<ShoppingCartItem> sci = scd.getCartDetails(userSession);
				request.getSession().setAttribute("sCart", sci);
				request.getRequestDispatcher("/MainPage").forward(request, response);
				
			} else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('invalid username or password');");
				out.println("location='Login';");
				out.println("</script>");
			}
		}
	}

	public User login(String username, String password) {
		UserDAO userDAO = context.getBean(UserDAO.class); 
		User user = userDAO.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			loginLogger.info(username + " logged in successfully");
			return user;
		}
		loginLogger.info(username + " tried logging in but was unsuccessful");
		return null;
	}
}
