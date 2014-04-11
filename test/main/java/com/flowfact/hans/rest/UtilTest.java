package com.flowfact.hans.rest;

import junit.framework.TestCase;

public class UtilTest extends TestCase {

	@Test
	public void getSelectionTest() throws Exception {
		String[] returnedString = Util
				.prepareSelection("#21 Eagles (from Packers) - <font color=\"Green\">Louis Nix III, DT, Notre Dame</font>");
		assertEquals("Eagles", returnedString[0]);
		assertEquals("Louis", returnedString[1]);
		assertEquals("Nix III", returnedString[2]);
	}
}
