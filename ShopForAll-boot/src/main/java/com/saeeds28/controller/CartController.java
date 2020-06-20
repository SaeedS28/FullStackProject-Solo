package com.saeeds28.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.model.ShoppingCartItem;
import com.saeeds28.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService cs;
	
	@GetMapping(path = "/cart")
	public ModelAndView showCartPage(HttpSession session) {
		ModelAndView mv = new ModelAndView("cart");
		List<ShoppingCartItem> sci = cs.getShoppingCartItemsForUser();
		double cartTotal = cs.getCartTotal();
		mv.addObject("total", cartTotal);
		session.setAttribute("cart", sci);
		return mv;
	}
	
	@PostMapping(path = "/addToCart")
	public void addItemToCart(int pid, HttpServletResponse response) throws IOException {
		cs.addItemToCart(pid);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+pid+"';");
		out.println("</script>");
	}
	
	@PostMapping(path = "/removeItem")
	public void removeItemFromCart(int pid, HttpServletResponse response) throws IOException {
		cs.removeItemFromCart(pid);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/cart';");
		out.println("</script>");
	}
	
	@PostMapping(path = "/subtractQuantity")
	public void subtractItemQuantity(int pid, HttpServletResponse response) throws IOException {
		cs.subtractItem(pid);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/cart';");
		out.println("</script>");
	}
	
	@PostMapping(path = "/addQuantity")
	public void addItemQuantity(int pid, HttpServletResponse response) throws IOException {
		boolean isAdded = cs.addItem(pid);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		if(!isAdded) {
			out.println("alert('Cart quantity exceeded stock. Nothing changed');");
		}
		out.println("location='/ShopForAll/cart';");
		out.println("</script>");
	}
}