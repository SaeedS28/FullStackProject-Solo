package com.fdmgroup.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.implementation.UserDAO;
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
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		UserDAO userDao = new UserDAO();
		User user = userDao.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}
