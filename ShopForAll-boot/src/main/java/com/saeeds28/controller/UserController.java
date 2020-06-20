package com.saeeds28.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.saeeds28.model.Address;
import com.saeeds28.model.User;
import com.saeeds28.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService us;
	
	@PostMapping(path = "/changePassword")
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
	
	@PostMapping(path = "/changeAddress")
	public void changeAddress(Address a, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		us.changeAddress(a);
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Address updated successfully');");
		out.println("location='/ShopForAll/main';");
		out.println("</script>");
	}
	
	@PostMapping(path = "/addUser")
	public void addUser(User newUser, Address address, HttpServletResponse response) throws IOException {
		boolean isAdded = us.addUser(newUser, address);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		if(isAdded) {
			out.println("alert('User added successfully');");
		}
		else {
			out.println("alert('Duplicate username found. User not added');");			
		}
		out.println("location='/ShopForAll/main';");
		out.println("</script>");
		
	}
	
	@PostMapping(path = "/disableUser")
	public void deactivateUser(String username, HttpServletResponse response) throws IOException {		
		boolean isInactive = us.inactivateUser(username);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		if (isInactive) {
			out.println("alert('User inactivated successfully');");
		} else {
			out.println("alert('You cannot deactivate yourself. Get another admin to deactivate the account');");
		}
		out.println("location='/ShopForAll/main';");
		out.println("</script>");
		
	}
	
	@PostMapping(path = "/enableUser")
	public void activateUser(String username, HttpServletResponse response) throws IOException {		
		boolean isActive = us.activateUser(username);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		if (isActive) {
			out.println("alert('User activated successfully');");
		} else {
			out.println("alert('You cannot deactivate yourself. Get another admin to deactivate the account');");
		}
		out.println("location='/ShopForAll/main';");
		out.println("</script>");
		
	}
	
}
