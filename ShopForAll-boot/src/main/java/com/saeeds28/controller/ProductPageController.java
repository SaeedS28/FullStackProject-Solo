package com.saeeds28.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.model.Item;
import com.saeeds28.service.CartService;
import com.saeeds28.service.ItemService;

@Controller
public class ProductPageController {

	@Autowired
	ItemService is;
	
	@Autowired
	CartService cs;
	
	@RequestMapping(path = "/ProductPage", method = RequestMethod.GET)
	public ModelAndView loadProductPage(@RequestParam("pid") int pid, HttpSession session) {
		Item item = is.getItemById(pid);
		boolean isItemInCart = cs.doesItemExistInUserCart(pid);
		ModelAndView mv = new ModelAndView("productPage");
		mv.addObject("itemInfo", item);
		mv.addObject("inCart", isItemInCart);
		return mv;
	}
}
