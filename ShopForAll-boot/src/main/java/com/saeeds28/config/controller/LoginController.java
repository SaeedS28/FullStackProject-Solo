package com.saeeds28.config.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.config.model.User;
import com.saeeds28.config.service.UserService;

@Controller()
public class LoginController {

	@Autowired
	UserService us;

	@RequestMapping(path = { "/", "/logout" }, method = RequestMethod.GET)
	public ModelAndView showLoginPage(HttpSession session) {
		session.invalidate();
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping(path = { "/login" }, method = RequestMethod.POST)
	public void attemptLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		User loggedIn = us.attemptLogin(username, password);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		if (loggedIn != null) {
			session.setAttribute("user", loggedIn);
			out.println("<script type=\"text/javascript\">");
			out.println("location='/ShopForAll/main';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('invalid username or password');");
			out.println("location='/ShopForAll/';");
			out.println("</script>");
		}
	}
}
