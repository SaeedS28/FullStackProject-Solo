package com.saeeds28.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.model.ShoppingCartItem;
import com.saeeds28.model.UserSession;
import com.saeeds28.service.CheckoutService;

@Controller
public class CheckoutController {
	@Autowired
	CheckoutService cs;
	
	@RequestMapping(path = "/checkout", method = RequestMethod.POST)
	public ModelAndView showCheckoutPage() {
		ModelAndView mv = new ModelAndView("checkout");
		mv.addObject("user", UserSession.getLoggedInUser());
		return mv;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/process", method = RequestMethod.POST)
	public void processOrder(HttpSession session, HttpServletResponse response) throws IOException {
		List<ShoppingCartItem> sci = (List<ShoppingCartItem>)session.getAttribute("cart");
		boolean isProcessed = cs.processOrder(sci);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		if(isProcessed) {
			out.println("alert('Order Processed successfully');");
			out.println("location='/ShopForAll/main';");
		}
		else {
			out.println("alert('Something went wrong. Order Unsuccessful');");
			out.println("location='/ShopForAll/cart';");
		}
		out.println("</script>");
	}
	
}
