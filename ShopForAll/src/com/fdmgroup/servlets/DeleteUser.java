package com.fdmgroup.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.implementation.ShoppingCartDAO;
import com.fdmgroup.dao.implementation.UserDAO;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class DeleteUser
 */
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		UserDAO ud = new UserDAO();
		User user = (User) request.getSession().getAttribute("user");
		
		if(user.getUsername().equals(userName)) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('You cannot delete your own account');");
			out.println("location='MainPage';");
			out.println("</script>");
		}
		else {
			ud.remove(userName);
			ShoppingCartDAO scd = new ShoppingCartDAO();
			scd.removeAllItem(userName);
			PrintWriter out = response.getWriter();
			ArrayList<User> allUsers = getAllUsers();
			request.getSession().setAttribute("allUsers", allUsers);
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Account with username "+userName+" deleted successfully');");
			out.println("location='MainPage';");
			out.println("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public ArrayList<User> getAllUsers(){
		UserDAO ud = new UserDAO();
		return  ud.getAllUsers();
	}

}
