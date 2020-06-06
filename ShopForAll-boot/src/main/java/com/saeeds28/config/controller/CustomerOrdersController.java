package com.saeeds28.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.config.service.PurchaseOrderService;

@Controller
public class CustomerOrdersController {

	@Autowired
	PurchaseOrderService pos;
	
	@RequestMapping(path = "purchaseHistory", method = RequestMethod.GET)
	public ModelAndView getAllPurchases() {
		ModelAndView mv = new ModelAndView("customerOrders");
		mv.addObject("po", pos.getAllPurchasesForCustomers());
		return mv;
	}
}
