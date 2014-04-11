package com.flowfact.hans.rest;

import static org.junit.Assert.*;

import java.net.UnknownHostException;

import org.junit.Test;

public class ProspectServiceTest {

	@Test
	public void testSaveCurrentLine() throws UnknownHostException {
		ProspectService ps = new ProspectService();
		Prospect returnedProspect = ps
				.saveCurrentLineProspect("19	Louis Nix III	DT	2	Notre Dame	rJr	6-2	331	1");
		Prospect expectedProspect = new Prospect("Louis", "Nix III", "");
		assertEquals(expectedProspect.getFirstname(), returnedProspect.getFirstname());
		assertEquals(expectedProspect.getLastname(), returnedProspect.getLastname());
	}

}
