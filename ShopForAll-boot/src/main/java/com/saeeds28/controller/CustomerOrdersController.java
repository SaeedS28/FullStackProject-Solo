package com.saeeds28.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.service.PurchaseOrderService;

@Controller
public class CustomerOrdersController {

	@Autowired
	PurchaseOrderService pos;
	
	@GetMapping(path = "purchaseHistory")
	public ModelAndView getAllPurchases() {
		ModelAndView mv = new ModelAndView("customerOrders");
		mv.addObject("po", pos.getAllPurchasesForCustomers());
		mv.addObject("totalSpent", pos.getPurchaseTotal());
		return mv;
	}
}
