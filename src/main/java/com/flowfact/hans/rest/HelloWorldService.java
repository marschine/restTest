package com.flowfact.hans.rest;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldService {
	
	ProspectService prospectService = new ProspectService();

	@GET
	@Path("/live")
	public Response getMsg() {

		ArrayList<Prospect> liveProspects;
		try {
			liveProspects = prospectService.getLiveProspects();
			return Response.status(200).entity(liveProspects.toString()).build();
		} catch (IOException e) {
			return Response.status(500).entity("Sorry we couldn't get the Live Prospects").build();
		}

	}

}