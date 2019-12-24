package com.fdmgroup.rest.service;

import java.util.ArrayList;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fdmgroup.model.User;
import com.fdmgroup.resources.ApiStatus;
import com.fdmgroup.rest.mapper.UserMapper;


@Path("Users")
public class UserService {
	UserMapper um = new UserMapper();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAllUsers() {
		ArrayList<User> getAll = um.getAllUser();
		return Response.status(Response.Status.OK).entity(getAll).build();
	}
	
	@GET
	@Path("{username}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getUserByUserName(@PathParam("username") String username) {
		return Response.status(Response.Status.OK).entity(um.getIndividualUserByUserName(username)).build();
	}
	
	@POST
	@Path("add")
	@Produces({MediaType.APPLICATION_JSON})
	public Response addUser(User user) {
		if(um.addCustomer(user)) {
			return Response.status(Response.Status.ACCEPTED).entity(
					new ApiStatus("201", "User added successfully", "Successful")
					).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).entity(
				new ApiStatus("400", "Bad Request", "Invalid parameters provided")
				).build();
	}
}
