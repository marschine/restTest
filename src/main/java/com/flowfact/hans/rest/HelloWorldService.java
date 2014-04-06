package com.flowfact.hans.rest;

import java.io.IOException;

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
	public ProspectList getMsg() throws IOException {
		return prospectService.getLiveProspects();
	}

	@GET
	@Path("/otc")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOtc() throws IOException {
		return prospectService.getOtc();
	}

}