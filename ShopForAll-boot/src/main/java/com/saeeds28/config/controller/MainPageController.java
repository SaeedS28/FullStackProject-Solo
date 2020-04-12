package com.saeeds28.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.config.model.Item;
import com.saeeds28.config.model.User;
import com.saeeds28.config.model.UserSession;
import com.saeeds28.config.service.ItemService;
import com.saeeds28.config.service.UserService;

@Controller
public class MainPageController {
	
	@Autowired
	ItemService is;
	
	@Autowired
	UserService us;
	
	@RequestMapping(path = { "/main" }, method = RequestMethod.GET)
	public ModelAndView showMainPage() {
		ModelAndView mv = new ModelAndView("mainPage");
		List<Item> topPurchases = is.getTopTenPurchasedItems();
		if(UserSession.getLoggedInUser().getType().equals("admin")) {
			List<User> allUsers = us.getAllUsers();
			mv.addObject("allUsers", allUsers);			
		}
		mv.addObject("pop", topPurchases);
		return mv;
	}
}
