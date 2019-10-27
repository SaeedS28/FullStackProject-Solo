package com.fdmgroup.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.implementation.PurchaseOrderDAO;
import com.fdmgroup.model.PurchaseOrder;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class SeePurchaseHistory
 */

public class SeePurchaseHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeePurchaseHistory() {
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
		PurchaseOrderDAO pod = new PurchaseOrderDAO();
		User u = (User) request.getSession().getAttribute("user");
		ArrayList<PurchaseOrder> po;
		if(u.getType().equals("admin")){
			po = pod.getAllPurchaseOrders();
		} else {
			po = pod.getPurchaseOrdersByUser(u);
		}
		request.setAttribute("orders", po);
		request.getRequestDispatcher("/WEB-INF/view/ShowCustomerOrders.jsp").forward(request, response);
	}

}