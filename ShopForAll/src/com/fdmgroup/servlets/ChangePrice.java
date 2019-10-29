package com.fdmgroup.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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

import com.fdmgroup.dao.implementation.ItemDAO;

/**
 * Servlet implementation class ChangePrice
 */

public class ChangePrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger itemChangeLogger = LogManager.getLogger("ItemChanges");
	ApplicationContext context;
	public void init(ServletConfig config) throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePrice() {
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
		// TODO Auto-generated method stub
		int pid = Integer.parseInt(request.getParameter("pid"));
		double cPrice = Double.parseDouble(request.getParameter("cPrice"));
		
		ItemDAO itd = context.getBean(ItemDAO.class);
		itemChangeLogger.info("Price associated with item product ID: " + pid + " and name: "+ itd.getItemByPid(pid).getName()+" "
				+ "changed successfully from $"+itd.getItemByPid(pid).getPrice()+" to $" + cPrice); 
		itd.updatePrice(pid,cPrice);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Successfully updated price');");
		out.println("location='ProductPage?pid="+pid+"';");
		out.println("</script>");
	}

}
