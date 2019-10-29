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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.implementation.ShoppingCartDAO;
import com.fdmgroup.dao.implementation.UserDAO;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class DeleteUser
 */
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger userLogger = LogManager.getLogger("UserAR");
	ApplicationContext context;
	public void init(ServletConfig config) throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
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
		UserDAO ud = context.getBean(UserDAO.class);
		User user = (User) request.getSession().getAttribute("user");
		
		if(user.getUsername().equals(userName)) {
			userLogger.info(userName+" tried to delete their own account. Invalid operation");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('You cannot delete your own account');");
			out.println("location='MainPage';");
			out.println("</script>");
		}
		else {
			ud.remove(userName);
			ShoppingCartDAO scd = context.getBean(ShoppingCartDAO.class);
			scd.removeAllItem(userName);
			PrintWriter out = response.getWriter();
			ArrayList<User> allUsers = getAllUsers();
			userLogger.info("User with username: "+userName+" deleted successfully");
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
		UserDAO ud = context.getBean(UserDAO.class);
		return  ud.getAllUsers();
	}

}
