package com.saeeds28.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.config.model.Item;
import com.saeeds28.config.repository.ItemRepo;

@Controller
public class LoginController {

	@Autowired
	ItemRepo ir;
	
	@RequestMapping(path = "login")
	public ModelAndView dummyMethod() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
}
