package com.example.jpah.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.example.jpah.model.User;

@Path("/rest")
public class RESTService {

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	@Path("/create")
	public String create(User user) {
		return null;
	}
	
	@GET
	@Path("/read/{id}")
	@Produces("application/json")
	public User read(@PathParam("id") Integer id) {
		return null;
	}
	
	@GET
	@Path("/read")
	@Produces("application/json")
	public List<User> readAll() {
		return null;
	}
	
	@PUT
	@Path("/update")
	@Consumes("application/json")
	@Produces("application/json")
	public User update(User user) {
		return null;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces("text/plain")
	public String delete(@PathParam("id") Integer id) {
		return null;
	}
}