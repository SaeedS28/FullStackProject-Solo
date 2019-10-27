package com.fdmgroup.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.implementation.AddressDAO;
import com.fdmgroup.dao.implementation.UserDAO;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class ChangeSettings
 */

public class ChangeSettings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ApplicationContext context;
	public void init(ServletConfig config) throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeSettings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pass = request.getParameter("passwordChange");
		String address = request.getParameter("addressChange");
		User loggedIn = (User) request.getSession().getAttribute("user");
		if(pass!=null && pass.equals("pressed")) {
			String curPass = request.getParameter("cPassword");
			if(loggedIn.getPassword().equals(curPass)) {
				String newPass = request.getParameter("nPassword");
				String repPass = request.getParameter("rPassword");
				if(newPass.equals(repPass)) {
					UserDAO ud = context.getBean(UserDAO.class);
					ud.updatePassword(loggedIn, repPass);
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Password change. Logging out');");
					out.println("location='Logout';");
					out.println("</script>");
				}
				else {
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('New passwords do not match. No changes made');");
					out.println("location='MainPage';");
					out.println("</script>");
				}
			}
			else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Old password was invalid. No changes made');");
				out.println("location='MainPage';");
				out.println("</script>");
			}
		}
		else if(address!=null && address.equals("pressed")) {
			AddressDAO ad = context.getBean(AddressDAO.class);
			ad.changeStreet(request.getParameter("street"), loggedIn);
			ad.changeCity(request.getParameter("city"), loggedIn);
			ad.changeProvince(request.getParameter("province"), loggedIn);
			ad.changeCountry(request.getParameter("country"), loggedIn);
			ad.changePostalCode(request.getParameter("pCode"), loggedIn);
			
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Address changed succressfully. Logging out');");
			out.println("location='Logout';");
			out.println("</script>");
		}
	}

}
