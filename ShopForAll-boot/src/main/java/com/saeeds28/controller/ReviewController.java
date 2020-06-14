package com.saeeds28.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saeeds28.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	ReviewService rs;

	@RequestMapping(path = "addReview", method = RequestMethod.POST)
	public void addReview(@RequestParam("rate") int rating, @RequestParam("comment") String reviewText,
			@RequestParam("review") int productId, HttpServletResponse response) {
		rs.addReview(productId, rating, reviewText);
	}

}
