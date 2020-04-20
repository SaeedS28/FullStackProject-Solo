package com.saeeds28.config.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.config.model.ShoppingCartItem;
import com.saeeds28.config.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService cs;
	
	@RequestMapping(path = "/cart")
	public ModelAndView showCartPage() {
		ModelAndView mv = new ModelAndView("cart");
		List<ShoppingCartItem> sci = cs.getShoppingCartItemsForUser();
		double cartTotal = cs.getCartTotal();
		mv.addObject("total", cartTotal);
		mv.addObject("cart", sci);
		return mv;
	}
	
	@RequestMapping(path = "/addToCart")
	public void addItemToCart(int pid, HttpServletResponse response) throws IOException {
		cs.addItemToCart(pid);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+pid+"';");
		out.println("</script>");
	}
}
