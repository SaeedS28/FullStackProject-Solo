package com.saeeds28.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.model.User;
import com.saeeds28.model.UserSession;
import com.saeeds28.service.UserService;

@Controller()
public class LoginController {

	@Autowired
	UserService us;

	@GetMapping(path = { "/", "/logout" })
	public ModelAndView showLoginPage(HttpSession session) {
		session.invalidate();
		UserSession.setLoggedInUser(null);
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@PostMapping(path = "/login")
	public void attemptLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		User loggedIn = us.attemptLogin(username, password);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if (loggedIn != null) {
			session.setAttribute("user", loggedIn);
			UserSession.setLoggedInUser(loggedIn);
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
