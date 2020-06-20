package com.saeeds28.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.saeeds28.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService is;

	@PostMapping(path = "/addQty")
	public void addQuantity(int pid, int quantity, HttpServletResponse response) throws IOException {
		is.addQuantity(pid, quantity);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+pid+"';");
		out.println("</script>");
	}
	
	@PostMapping(path = "/changePrice")
	public void changePrice(int pid, double price, HttpServletResponse response) throws IOException {
		is.changePrice(pid, price);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+pid+"';");
		out.println("</script>");
	}
	
	@PostMapping(path = "/changeDescription")
	public void changeDescription(int pid, String description, HttpServletResponse response) throws IOException {
		is.changeDescription(pid, description);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+pid+"';");
		out.println("</script>");
	}
	
	@PostMapping(path = "/changeCategory")
	public void changeCategory(int pid, String category, HttpServletResponse response) throws IOException {
		is.changeCategory(pid, category);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+pid+"';");
		out.println("</script>");
	}
	
	@PostMapping(path = "/addItem")
	public void addItemToCatalogue(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int pid = is.addItem(request);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+pid+"';");
		out.println("</script>");
	}
}
