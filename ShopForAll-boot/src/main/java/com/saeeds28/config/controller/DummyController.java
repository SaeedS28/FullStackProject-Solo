package com.saeeds28.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.config.model.Item;
import com.saeeds28.config.repository.ItemRepo;

@Controller
public class DummyController {

	@Autowired
	ItemRepo ir;
	
	@RequestMapping("home")
	public ModelAndView dummyMethod() {
		ModelAndView mv = new ModelAndView("dumb.jsp");
		ir.save(new Item("baseball", "Sports", "MLB Grade", 10000, 6.99));
		return mv;
	}
	
}
