package com.avaldes;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.avaldes.model.Actor;

@Path("/actors")
public class RestfulWSExample {
	static final String api_version = "1.01A rev.18729";
	static Logger logger = Logger.getLogger(RestfulWSExample.class);
	static String xmlString = null;
	static Map<String, Actor> actors = new HashMap<String, Actor>();
	
	static { 
		System.out.println("Initializing Internal DataStore...");
		actors.put("123", new Actor(123, "Hugh Jackson", "Hugh Michael Jackman", "October 12, 1968", "hughjackman@mail.com", "https://stocklandmartelblog.files.wordpress.com/2013/07/nino-muncc83oz_hugh-jackman_page_3.jpg", true));
		actors.put("124", new Actor(124, "Jennifer Lawrence", "Jennifer Shrader Lawrence", "August 15, 1990", "jennifer@mail.com", "http://www.siempre-lindas.cl/wp-content/uploads/2014/11/jennifer-lawrence-164522_w1000.jpg", true));
		actors.put("345", new Actor(345, "Jennifer Lopez", "Jennifer Lynn Lopez", "July 24, 1969", "jlo@verizon.com", "http://media1.popsugar-assets.com/files/2013/01/01/5/192/1922398/e0bd827287eb8c5f_145351598.xxxlarge_2.jpg", true));
		actors.put("333", new Actor(333, "Jennifer Anniston", "Jennifer Joanna Aniston", "February 11, 1969", "jennifer.anniston@eonline.com", "http://media1.popsugar-assets.com/files/2013/01/01/5/192/1922398/e59ab35359063e7c_139123757.xxxlarge_2.jpg", true));
		actors.put("444", new Actor(444, "Julia Roberts", "Julia Fiona Roberts ", "October 28, 1967", "julia.roberts@att.com", "http://img2.timeinc.net/people/i/2013/specials/beauties/then-now/julia-roberts-4-435.jpg", true));
		actors.put("777", new Actor(777, "Chris Evans", "Christopher Robert Evans", "June 13, 1981", "chris.evans@comcast.com", "http://assets-s3.usmagazine.com/uploads/assets/celebrities/28454-chris-evans/1311353993_chris-evans-bio-402.jpg", true));
		actors.put("654", new Actor(654, "Robert Downey Jr.", "Robert John Downey Jr", "April 4, 1965", "robertdowney@verizon.com", "http://cdn.playbuzz.com/cdn/3bfbcced-5435-4fb0-898a-91c8146f0a37/2c641acc-e33d-4f59-8fe9-f7c0cc11a951.jpg", true));
		actors.put("255", new Actor(255, "Johnny Depp", "John Christopher Depp II", "June 9, 1963", "johndepp@hollywood.com", "http://images.latinpost.com/data/images/full/9536/johnny-depp-at-transcendence-los-angeles-premiere.jpg?w=600", true));		
		actors.put("989", new Actor(989, "Scarlet Johansson", "Scarlett Ingrid Johansson", "November 22, 1984", "scarjo@mail.com", "http://static.comicvine.com/uploads/original/11111/111117228/4087439-2415305600-Scarl.jpg", true));
	}
		
	@Path("/version") 
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion() {
		return "<p>Version: " + api_version + "</p>";
	}

	// This is the default @PATH
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ArrayList<Actor> getAllActors() {
		System.out.println("Getting all actors...");
		ArrayList<Actor> actorList = new ArrayList<Actor>(actors.values());
		return actorList;
	}
	
	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Actor getActorById(@PathParam("id") String id) {
		System.out.println("Getting actor by ID: " + id);

		Actor actor = actors.get(id);
	  if (actor != null) {
		logger.info("Inside getActorById, returned: " + actor.toString());
	  } else {
		logger.info("Inside getActorById, ID: " + id + ", NOT FOUND!");
	  }
	  return actor;
	}
	
	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Actor updateActor(Actor actor) {
	  actors.put(""+actor.getId(), actor);
	  
	  System.out.println("updateActor with ID: " + actor.getId());
	  if (actor != null) {
		logger.info("Inside updateActor, returned: " + actor.toString());
	  } else {
		logger.info("Inside updateActor, ID: " + actor.getId() + ", NOT FOUND!");
	  }
	  return actor; 
	}
	
	@Path("/search/{query}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ArrayList<Actor> searchActorByName(@PathParam("query") String query) {
  	  System.out.println("Searching actor by Name: " + query);
	  
  	  ArrayList<Actor> actorList = new ArrayList<Actor>();	  
	  for (Actor c: actors.values()) {
	    if (c.getName().toUpperCase().contains(query.toUpperCase()))
	    	actorList.add(c);
	  }
	  return actorList;
	}
	
	@Path("/add")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Actor addActor(Actor actor) {
	  System.out.println("Adding actor with ID: " + actor.getId());
	  
	  if (actor != null) {
		System.out.println("Inside addActor, returned: " + actor.toString());
		actors.put(""+actor.getId(), actor);
		System.out.println("# of actors: " + actors.size());
		System.out.println("Actors are now: " + actors);
	  } else {
		System.out.println("Inside addActor, Unable to add actors...");
	  } 
	  return actor;
	}
	
	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Actor deleteActorById(@PathParam("id") String id) {
	  System.out.println("Deleting actor with ID: " + id);
		
	  Actor actor = actors.remove(id);
	  if (actor != null) {
		logger.info("Inside deleteActorById, returned: " + actor.toString());
	  } else {
		logger.info("Inside deleteActorById, ID: " + id + ", NOT FOUND!");
	  }
	  return actor;
	}
}
