package com.saeeds28.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.config.service.ItemService;

@Controller
public class SearchController {
	
	@Autowired
	ItemService is;
	
	@RequestMapping(path = "/category", method = RequestMethod.GET)
	public ModelAndView getAllProductCategories() {
		ModelAndView mv = new ModelAndView("categories");
		List<String> categories = is.getProductCategories();
		mv.addObject("categories", categories);
		mv.addObject("size", categories.size());
		System.out.println(categories);
		return mv;
	}

}
