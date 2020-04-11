package com.saeeds28.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.config.model.Item;
import com.saeeds28.config.service.ItemService;

@Controller
public class ProductPageController {

	@Autowired
	ItemService is;
	
	@RequestMapping(path = "/ProductPage", method = RequestMethod.GET)
	public ModelAndView loadProductPage(@RequestParam("pid") int pid) {
		Item item = is.getItemById(pid);
		ModelAndView mv = new ModelAndView("productPage");
		mv.addObject("itemInfo", item);
		return mv;
	}
}
