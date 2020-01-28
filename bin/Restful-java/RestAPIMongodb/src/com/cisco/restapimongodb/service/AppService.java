package com.cisco.restapimongodb.service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.lang.JoseException;

import com.cisco.restapimongodb.model.StatusMessage;

@Path("/security")
public class AppService {
	
	static List<JsonWebKey> jwkList = new LinkedList<JsonWebKey>();
	
	static {
		for(int i =1 ;i<=3;i++) {
			JsonWebKey jwk = null;
			try {
				jwk = RsaJwkGenerator.generateJwk(2048);
				
			}
			catch(JoseException e) {
				e.printStackTrace();
			}
			jwk.setKeyId(String.valueOf(i));
			jwkList.add(jwk);
		}
		
	}

	@Path("/status")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion() {
		return " Status is OK...";
	}

	@Path("/authenticate")
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public Response authenticateCredentials(@HeaderParam("username") String userName,
			@HeaderParam("password") String password)
			throws JsonGenerationException, JsonMappingException, IOException {
		

		if(userName== null) {
			StatusMessage message  = new StatusMessage();
			message.setStatus(Status.PRECONDITION_FAILED.getStatusCode());
			message.setMessage("username is missing");
			return Response.status(Status.PRECONDITION_FAILED.getStatusCode()).entity(message).build();
			
		}
		if(password== null) {
			StatusMessage message  = new StatusMessage();
			message.setStatus(Status.PRECONDITION_FAILED.getStatusCode());
			message.setMessage("password is missing");
			return Response.status(Status.PRECONDITION_FAILED.getStatusCode()).entity(message).build();
			
		}
		// do we need to validate data with DB or not?
		// Generate token
		// Add details
		// send token as a response
		
		return Response.status(200).entity("all good").build();
	}

}
