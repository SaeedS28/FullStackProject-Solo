package com.saeeds28.config.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.config.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService is;

	@RequestMapping(path = "/addQty")
	public void addQuantity(int pid, int quantity, HttpServletResponse response) throws IOException {
		is.addQuantity(pid, quantity);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+pid+"';");
		out.println("</script>");
	}
}
