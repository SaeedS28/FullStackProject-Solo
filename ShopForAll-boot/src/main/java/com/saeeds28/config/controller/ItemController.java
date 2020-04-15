package com.saeeds28.config.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saeeds28.config.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService is;

	@RequestMapping(path = "/addQty",method = RequestMethod.POST)
	public void addQuantity(int pid, int quantity, HttpServletResponse response) throws IOException {
		is.addQuantity(pid, quantity);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+pid+"';");
		out.println("</script>");
	}
	
	@RequestMapping(path = "/changePrice", method = RequestMethod.POST)
	public void changePrice(int pid, double price, HttpServletResponse response) throws IOException {
		is.changePrice(pid, price);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+pid+"';");
		out.println("</script>");
	}
	
	@RequestMapping(path = "/changeDescription", method = RequestMethod.POST)
	public void changeDescription(int pid, String description, HttpServletResponse response) throws IOException {
		is.changeDescription(pid, description);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+pid+"';");
		out.println("</script>");
	}
	
	@RequestMapping(path = "/changeCategory", method = RequestMethod.POST)
	public void changeCategory(int pid, String category, HttpServletResponse response) throws IOException {
		is.changeCategory(pid, category);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+pid+"';");
		out.println("</script>");
	}
}
