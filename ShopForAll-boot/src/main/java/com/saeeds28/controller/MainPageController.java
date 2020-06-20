package com.saeeds28.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.model.Item;
import com.saeeds28.model.User;
import com.saeeds28.model.UserSession;
import com.saeeds28.service.ItemService;
import com.saeeds28.service.UserService;

@Controller
public class MainPageController {
	
	@Autowired
	ItemService is;
	
	@Autowired
	UserService us;
	
	@GetMapping(path = "/main")
	public ModelAndView showMainPage() {
		ModelAndView mv = new ModelAndView("mainPage");
		List<Item> topPurchases = is.getTopTenPurchasedItems();
		if(UserSession.getLoggedInUser().getType().equals("admin")) {
			List<User> activeUsers = us.getActivelUsers();
			List<User> inactiveUsers = us.getInactiveUsers();
			mv.addObject("active", activeUsers);
			mv.addObject("inactive", inactiveUsers);
		}
		mv.addObject("pop", topPurchases);
		return mv;
	}
}
