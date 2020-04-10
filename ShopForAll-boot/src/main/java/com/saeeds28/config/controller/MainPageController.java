package com.saeeds28.config.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.config.model.Item;
import com.saeeds28.config.service.ItemService;

@Controller
public class MainPageController {
	
	@Autowired
	ItemService is;
	
	@RequestMapping(path = { "/main" }, method = RequestMethod.GET)
	public ModelAndView showMainPage() {
		ModelAndView mv = new ModelAndView("mainPage");
		List<Item> topPurchases = is.getTopTenPurchasedItems();
		mv.addObject("pop", topPurchases);
		return mv;
	}
}
