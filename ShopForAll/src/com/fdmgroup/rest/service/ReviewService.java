package com.fdmgroup.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fdmgroup.rest.mapper.ReviewMapper;

@Path("Reviews")
public class ReviewService {
	ReviewMapper rm = new ReviewMapper();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAllReviews() {
		return Response.status(Response.Status.OK).entity(rm.getAllReviews()).build();
	}
}
