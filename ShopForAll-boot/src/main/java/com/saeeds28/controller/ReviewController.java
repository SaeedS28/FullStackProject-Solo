package com.saeeds28.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	ReviewService rs;

	@PostMapping(path = "addReview")
	public void addReview(@RequestParam("rate") int rating, @RequestParam("comment") String reviewText,
			@RequestParam("review") int productId, HttpServletResponse response) throws IOException {
		rs.addReview(productId, rating, reviewText);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+productId+"';");
		out.println("</script>");
	}
	
	@GetMapping(path = "moderateReviews")
	public ModelAndView showModerationPage() {
		ModelAndView mv = new ModelAndView("reviewModeration");
		mv.addObject("modReviews", rs.getReviewsToModerate());
		return mv;
	}
	
	@PostMapping(path = "acceptReview")
	public void acceptReview(@RequestParam("rid") int reviewId, HttpServletResponse response) throws IOException {
		rs.acceptReview(reviewId);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/moderateReviews';");
		out.println("</script>");
	}
	
	@PostMapping(path = "rejectReview")
	public void rejectReview(@RequestParam("rid") int reviewId, HttpServletResponse response) throws IOException {
		rs.rejectReview(reviewId);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/moderateReviews';");
		out.println("</script>");
	}
	
	@PostMapping(path = "deleteReview")
	public void deleteReview(@RequestParam("rid") int reviewId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		rs.rejectReview(reviewId);
		
		String redirector = request.getHeader("referer").split("/")[4];
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/"+redirector+"';");
		out.println("</script>");
	}
}
