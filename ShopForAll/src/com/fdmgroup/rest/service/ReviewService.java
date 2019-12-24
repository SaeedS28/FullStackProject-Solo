package com.fdmgroup.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fdmgroup.resources.ApiStatus;
import com.fdmgroup.rest.mapper.ReviewMapper;

@Path("Reviews")
public class ReviewService {
	ReviewMapper rm = new ReviewMapper();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAllReviews(@QueryParam("username") String name, @QueryParam("productId") Integer pid) {
		if((name==null || name.isEmpty()) && (pid ==null)) {
			return Response.status(Response.Status.OK).entity(rm.getAllReviews()).build();
		}
		if((name != null && !name.isEmpty()) && (pid !=null)) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new ApiStatus("400", "Bad Request", "One parameter allowed in request")).build();
		}
		if(name != null && !name.isEmpty()) {
			return Response.status(Response.Status.OK).entity(rm.getReviewsByUser(name)).build();			
		}
		return Response.status(Response.Status.OK).entity(rm.getReviewsByItem(pid)).build();			
	}
	
}
