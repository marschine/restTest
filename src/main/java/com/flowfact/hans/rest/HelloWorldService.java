package com.flowfact.hans.rest;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("/live")
	@Produces(MediaType.APPLICATION_JSON)
	public ProspectList getMsg() throws Exception {
		ProspectService prospectService = new ProspectService();
		return prospectService.getLiveProspects();
	}

	@GET
	@Path("/newlive")
	@Produces(MediaType.APPLICATION_JSON)
	public ProspectList getLive() throws Exception {
		ProspectService prospectService = new ProspectService();
		return prospectService.getNewLiveProspects();
	}

	@GET
	@Path("/otc")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOtc() throws IOException {
		ProspectService prospectService = new ProspectService();
		return prospectService.getOtc();
	}

	@GET
	@Path("/reset")
	public void resetDB() throws Exception {
		ProspectService prospectService = new ProspectService();
		prospectService.reset();
	}

}