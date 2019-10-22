package com.fdmgroup.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.implementation.ItemDAO;
import com.fdmgroup.dao.implementation.PurchaseOrderDAO;
import com.fdmgroup.model.Item;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class ProductPage
 */
public class ProductPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID = Integer.parseInt(request.getParameter("pid"));
		ItemDAO itd = new ItemDAO();
		Item item = itd.getItemByPid(productID);
		request.setAttribute("itemInfo", item);
		PurchaseOrderDAO pod = new PurchaseOrderDAO();
		if(pod.isPurchased((User)request.getSession().getAttribute("user"), productID)) {
			Boolean b = new Boolean(true);
			request.setAttribute("bought", b);
		}
		else {
			Boolean b = new Boolean(false);
			request.setAttribute("bought", b);
		}
		request.getRequestDispatcher("/WEB-INF/view/ProductPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
