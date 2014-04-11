package com.flowfact.hans.rest;

import org.junit.Test;

import junit.framework.TestCase;

public class UtilTest extends TestCase {

	@Test
	public void testGetSelection() throws Exception {
		// double last names 
		// teams with trades
		// whitespaces before name
		String[] returnedString = Util
				.prepareSelection("#21 Eagles (from Packers) - <font color=\"Green\"> Louis Nix III, DT, Notre Dame</font>");
		assertEquals("Eagles", returnedString[0]);
		assertEquals("Louis", returnedString[1]);
		assertEquals("Nix III", returnedString[2]);
	}

	@Test
	public void testCreateProspect() {
		// test double last name
		String[] testString = {"7", "Khalil Mack III", "OLB", "1", "Buffalo", "rSr", "6-3", "251", "1"};
		Prospect returnedProspect = Util.createProspect(testString);
		Prospect expectedProspect = new Prospect("Khalil", "Mack III", "Falcons");
		assertEquals(expectedProspect.getFirstname(), returnedProspect.getFirstname());
		assertEquals(expectedProspect.getLastname(), returnedProspect.getLastname());
	}
}
