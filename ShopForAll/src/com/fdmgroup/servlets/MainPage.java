package com.fdmgroup.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.implementation.PurchaseOrderDAO;
import com.fdmgroup.dao.implementation.UserDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class MainPage
 */
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ApplicationContext context;
	public void init(ServletConfig config) throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User loggedIn = (User) request.getSession().getAttribute("user");
			ArrayList<User> allUsers = getAllUsers();
			request.getSession().setAttribute("allUsers", allUsers);
		
		List<Item> topPurchases = getTopNinePurchases();
		request.setAttribute("topPurchase", topPurchases);
		request.getRequestDispatcher("/WEB-INF/view/MainPage.jsp").forward(request, response);
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
	
	public List<Item> getTopNinePurchases(){
		PurchaseOrderDAO pod = context.getBean(PurchaseOrderDAO.class);
		List<Item> popular = pod.retrieveTopTenPurchases();
		
		List<Item> topNine = new ArrayList<Item>();
		topNine = popular.subList(0,9);
		return topNine;
	}
}
