package com.saeeds28.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.model.Item;
import com.saeeds28.model.Review;
import com.saeeds28.service.CartService;
import com.saeeds28.service.ItemService;
import com.saeeds28.service.PurchaseOrderService;
import com.saeeds28.service.ReviewService;

@Controller
public class ProductPageController {

	@Autowired
	ItemService is;
	
	@Autowired
	CartService cs;
	
	@Autowired
	PurchaseOrderService ps;
	
	@Autowired
	ReviewService rs;
	
	@RequestMapping(path = "/ProductPage", method = RequestMethod.GET)
	public ModelAndView loadProductPage(@RequestParam("pid") int pid, HttpSession session) {
		Item item = is.getItemById(pid);
		boolean isItemInCart = cs.doesItemExistInUserCart(pid);
		boolean isPurchased = ps.isItemPurchased(pid);
		List<Review> reviewList = rs.getAcceptedReviews(pid);
		ModelAndView mv = new ModelAndView("productPage");
		mv.addObject("itemInfo", item);
		mv.addObject("inCart", isItemInCart);
		mv.addObject("purchased", isPurchased);
		mv.addObject("revs", reviewList);
		return mv;
	}
}
