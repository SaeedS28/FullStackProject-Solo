package com.fdmgroup.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fdmgroup.rest.mapper.ItemMapper;

@Path("Items")
public class ItemService {
	ItemMapper im = new ItemMapper();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllItems() {
		return Response.status(Status.OK).entity(im.getAllItems()).build();
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
