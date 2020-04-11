package com.saeeds28.config.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saeeds28.config.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService us;
	
	@RequestMapping(path = "changePassword", method = RequestMethod.POST)
	public void changePassword(String currentPassword, String newPassword, String repeatPassword, HttpServletResponse response) throws IOException {
		boolean isChanged = us.changePassword(currentPassword, newPassword, repeatPassword);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if(isChanged) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password changed successfully. Logging out');");
			out.println("location='/ShopForAll/';");
			out.println("</script>");
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('invalid current password or mismatching new and repeat password fields');");
			out.println("location='/ShopForAll/main';");
			out.println("</script>");
		}
	}
}
