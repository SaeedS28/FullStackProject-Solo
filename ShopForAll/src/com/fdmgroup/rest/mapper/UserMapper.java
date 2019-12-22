package com.fdmgroup.rest.mapper;

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
import com.fdmgroup.rest.service.UserService;


@Path("Users")
public class UserMapper {
	UserService um = new UserService();
	
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
	public void addUser(User user) {
		System.out.println(user+"\t"+user.getAddress());
	}
}
