package com.saeeds28.config.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.config.model.Item;
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
		return mv;
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public ModelAndView executeSearch(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("searchPage");
		
		// checks for the relevant query parameters
		Map<String, String[]> queryParams = request.getParameterMap();
		if(queryParams == null || queryParams.size()==0) {
			List<Item> allItems = is.getAllItems();
			mv.addObject("items", allItems);
			System.out.println(allItems);
		}
		return mv;
		
	}

}
