package com.fdmgroup.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fdmgroup.resources.ApiStatus;
import com.fdmgroup.rest.mapper.ItemMapper;

@Path("Items")
public class ItemService {
	ItemMapper im = new ItemMapper();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllItemsAndItemsInPriceRange(@QueryParam("range") List<Integer> range) {
		if(range==null || range.size()==0) {	
			return Response.status(Status.OK).entity(im.getAllItems()).build();
		}
		if((range.size()==1) || (range.size()>2)) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new ApiStatus("400", "Bad Request", "Invalid parameters provided")).build();
		}
		else if(range.size()==2) {
			return Response.status(Status.OK).entity(im.getItemsInRange(range)).build();
		}
		return null;
	}
	
	@GET
	@Path("top")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTopItems() {
		return Response.status(Status.OK).entity(im.getTopItems()).build();
	}
	
	@GET
	@Path("Item/{productID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItemsByPid(@PathParam("productID") int pid) {
		return Response.status(Status.OK).entity(im.getItemByProductID(pid)).build();
	}
}
