package com.jersey.series.headerparam;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("bookservice")
public class BookServiceImpl implements IBookService {

	// http://localhost:8080/Jersey-HeaderParam/rest/bookservice/getheader
	@GET
	@Path("getheader")
	public Response getHeaderDetails(
			@HeaderParam("User-Agent") String userAgent,
			@HeaderParam("Content-Type") String contentType,
			@HeaderParam("Accept") String accept
			){

		String header = "User-Agent: " + userAgent +
				"\nContent-Type: " + contentType +
				"\nAccept: " + accept;
		return Response.status(200).entity(header).build();
	}

	// http://localhost:8080/Jersey-HeaderParam/rest/bookservice/getallheader
	@GET
	@Path("getallheader")
	public Response getAllHeader(@Context HttpHeaders httpHeaders){

		// local variables
		StringBuffer stringBuffer = new StringBuffer();
		String headerValue = "";

		for(String header : httpHeaders.getRequestHeaders().keySet()) {
			headerValue = httpHeaders.getRequestHeader(header).get(0);
			stringBuffer.append(header + ": " + headerValue + "\n");
		}
		return Response.status(200).entity(stringBuffer.toString()).build();
	}
}