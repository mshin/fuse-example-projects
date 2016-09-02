package com.example.cxfrj.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.cxfrj.rest.model.RestModel;

public interface CxfRestJsonService {

	@GET
	@Path("/rest")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getModels();
	
	@GET
	@Path("/rest/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getModel(@PathParam("id") Integer id);
	
	@POST
	@Path("/rest")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createModel(RestModel restModel);
	
	@DELETE
	@Path("/rest/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteModel(@PathParam("id") Integer id);

}
