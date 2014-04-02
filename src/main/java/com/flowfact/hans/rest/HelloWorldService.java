package com.flowfact.hans.rest;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldService {

	ProspectService prospectService = new ProspectService();

	@GET
	@Path("/live")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Prospect> getMsg() throws IOException {
		ArrayList<Prospect> liveProspects;
		return prospectService.getLiveProspects();
	}

}