package com.saeeds28.config.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saeeds28.config.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService cs;
	
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
