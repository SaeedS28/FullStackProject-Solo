package com.saeeds28.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;import com.saeeds28.config.model.UserSession;

@Controller
public class CheckoutController {

	@RequestMapping(path = "/checkout", method = RequestMethod.POST)
	public ModelAndView showCheckoutPage() {
		ModelAndView mv = new ModelAndView("checkout");
		mv.addObject("user", UserSession.getLoggedInUser());
		return mv;
	}
}
