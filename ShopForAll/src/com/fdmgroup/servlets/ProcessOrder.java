package com.fdmgroup.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.implementation.ItemDAO;
import com.fdmgroup.dao.implementation.PurchaseOrderDAO;
import com.fdmgroup.dao.implementation.ShoppingCartDAO;
import com.fdmgroup.model.PurchaseOrder;
import com.fdmgroup.model.ShoppingCartItem;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class ProcessOrder
 */

public class ProcessOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String process = request.getParameter("submit");
		ItemDAO itd = new ItemDAO();
		ShoppingCartDAO scd = new ShoppingCartDAO();
		ArrayList<ShoppingCartItem> sci = scd.getCartDetails((User) request.getSession().getAttribute("user"));
		
		if(process!= null && process.equals("Process")) {
			boolean isOver = false;
			for(int i=0;i<sci.size();i++) {
				if(sci.get(i).getCartQuantity()>itd.getItemQuantity(sci.get(i).getProductID())) {
					isOver=true;
					break;
				}
			}
			if(isOver) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Quantity overflown, please try again');");
				out.println("location='ShoppingCart';");
				out.println("</script>");
			} else {
				PurchaseOrderDAO pod= new PurchaseOrderDAO();
				pod.addPurchaseOrder((User) request.getSession().getAttribute("user"), sci);
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('All Items processed successfully');");
				out.println("location='SeePurchaseHistory';");
				out.println("</script>");
			}
		}
	}
}
