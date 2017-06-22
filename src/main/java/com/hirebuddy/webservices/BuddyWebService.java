package com.hirebuddy.webservices;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hirebuddy.domain.Buddy;
import com.hirebuddy.services.BuddyService;

@Path("/buddyService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BuddyWebService {
	@Autowired
	BuddyService buddyService;
	
	static org.slf4j.Logger logger = LoggerFactory.getLogger(BuddyWebService.class);
	
	
	@GET
	@Path("/test")
	public Response test(){
		return Response.ok("good").build();
	}
	
	@GET
	@Path("/buddy")
	@Produces("application/json")
	public Response getBuddyEx(){
		Buddy buddy = new Buddy();
		buddy.setEmail("jatin.sutaria@thev2technologies.com");
		buddy.setFirstName("Jatin");
		buddy.setLastName("Sutaria");
		buddy.setCategories("Helper, Cleaner");
		buddy.setIdentityType("email");
		return Response.ok(buddy).build();
	}
	
	
	@POST
	@Path("/buddy/token/{token}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response saveOrUpdateBuddy(Buddy buddy, @PathParam("token") String token){
		
		try {
			buddyService.saveOrUpdate(buddy);
			return Response.ok("BUDDY_SAVED_UPDATED").build();
		} catch (Exception e) {
			logger.error("Problem saving buddy", e);
			return Response.status(Status.BAD_REQUEST).entity("BUDDY_UPDATE_FAILURE").build();
		}
	}

}
