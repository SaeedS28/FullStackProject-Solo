package com.saeeds28.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.saeeds28.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	ReviewService rs;

	@RequestMapping(path = "addReview", method = RequestMethod.POST)
	public void addReview(@RequestParam("rate") int rating, @RequestParam("comment") String reviewText,
			@RequestParam("review") int productId, HttpServletResponse response) throws IOException {
		rs.addReview(productId, rating, reviewText);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/ProductPage?pid="+productId+"';");
		out.println("</script>");
	}
	
	@RequestMapping(path = "moderateReviews", method = RequestMethod.GET)
	public ModelAndView showModerationPage() {
		ModelAndView mv = new ModelAndView("reviewModeration");
		mv.addObject("modReviews", rs.getReviewsToModerate());
		return mv;
	}
	
	@RequestMapping(path = "acceptReview", method = RequestMethod.POST)
	public void acceptReview(@RequestParam("rid") int reviewId, HttpServletResponse response) throws IOException {
		rs.acceptReview(reviewId);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/moderateReviews';");
		out.println("</script>");
	}
	
	@RequestMapping(path = "rejectReview", method = RequestMethod.POST)
	public void rejectReview(@RequestParam("rid") int reviewId, HttpServletResponse response) throws IOException {
		rs.rejectReview(reviewId);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("location='/ShopForAll/moderateReviews';");
		out.println("</script>");
	}
	
	@RequestMapping(path = "deleteReview", method = RequestMethod.POST)
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
