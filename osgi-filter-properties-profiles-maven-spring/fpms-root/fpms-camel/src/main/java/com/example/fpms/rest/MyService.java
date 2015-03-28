package com.example.fpms.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/rest")
public class MyService {

	@GET
	@Path("/environment")
	@Produces(MediaType.TEXT_PLAIN)
	public String getObject() {
		return null;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/url")
	public String getObjectValue() {
		return null;
	}

}
