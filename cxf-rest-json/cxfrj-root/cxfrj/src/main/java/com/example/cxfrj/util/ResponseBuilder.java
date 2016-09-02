package com.example.cxfrj.util;

import javax.ws.rs.core.Response;

/**
 * 
 * @author imcmahon
 *
 */
public class ResponseBuilder {

	private static final int HTTP_UNPROCESSABLE_ENTITY = 422;

	private ResponseBuilder() {

	}
	
	public static Response createOk() {
		return createResponse(Response.Status.OK.getStatusCode());
	}

	public static Response createOk(Object body) {
		return createResponse(body, Response.Status.OK.getStatusCode());
	}
	
	public static Response createCreated() {
		return createResponse(Response.Status.CREATED.getStatusCode());
	}
	
	public static Response createCreated(Object body) {
		return createResponse(body, Response.Status.CREATED.getStatusCode());
	}
	
	public static Response createNoContent() {
		return createResponse(Response.Status.NO_CONTENT.getStatusCode());
	}
	
	public static Response createUnprocessableEntity() {
		return createResponse(HTTP_UNPROCESSABLE_ENTITY);
	}

	public static Response createInternalError() {
		return createResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
	}

	public static Response createInternalError(Object body) {
		return createResponse(body, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
	}

	public static Response createBadRequestError() {
		return createResponse(Response.Status.BAD_REQUEST.getStatusCode());
	}

	public static Response createBadRequestError(Object body) {
		return createResponse(body, Response.Status.BAD_REQUEST.getStatusCode());
	}

	public static Response createResponse(int status) {
		return Response.status(status).build();
	}

	public static Response createResponse(Object body, int status) {
		return Response.status(status).entity(body).build();
	}
}
