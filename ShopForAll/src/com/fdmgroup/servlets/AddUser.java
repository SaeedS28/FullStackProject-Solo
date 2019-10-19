package com.fdmgroup.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.implementation.UserDAO;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/MainPage").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO ud = new UserDAO();
		String addUser = request.getParameter("addUserButton");
		if(addUser.equals("pressed")) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("newPassword");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String userType = request.getParameter("userType");
			
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String province = request.getParameter("province");
			String country = request.getParameter("country");
			String postalCode = request.getParameter("pCode");
			
			if(!seeIfUserExists(userName)) {
				Address add = new Address(userName,street,city,province,country,postalCode);
				User newUser = new User(userName,password,firstName,lastName,userType,add);
				ud.create(newUser);
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Successfully added new user');");
				out.println("location='MainPage';");
				out.println("</script>");
				
			}
			else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Username already takem. Try again');");
				out.println("location='MainPage';");
				out.println("</script>");
			}
		}
	}
	
	public boolean seeIfUserExists(String username) {
		UserDAO ud = new UserDAO();
		User user = ud.findByUsername(username);
		if(user == null) {
			return false;
		}
		return true;
		
	}
}