package com.cisco.rest;

import java.util.List;

import javax.annotation.Generated;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/users")
public class UserService {
	@Path("query")
    public Response queryHeaderInfo(@HeaderParam("Cache-Control") String ccControl,
                                        @HeaderParam("User-Agent") String uaStr){
         
        String resp = "Received http headers are Cache-Control: "+ccControl+
                        "<br>User-Agent: "+uaStr;
        return Response.status(200).entity(resp).build();
    } 
//	@GET
//	@Path("/query")
//	public Response getUsers(@HeaderParam("user-agent") String userAgent) {
//		
//		return Response.status(200).entity(""+userAgent).build();
//	}
	/*public Response getUsers(@Context UriInfo uri) {
		String from = uri.getQueryParameters().getFirst("from");
		List<String> list =uri.getQueryParameters().get("orderBy");
		return Response.status(200).entity(list.toString()).build();
	}*/
	/*public Response getUsers(@DefaultValue("1000") @QueryParam("from") int from ) {
		return Response.status(200).entity(new Integer(from).toString()).build();
	}
*/
}
