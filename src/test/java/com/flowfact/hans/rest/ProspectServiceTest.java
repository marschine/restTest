package com.flowfact.hans.rest;

import static org.junit.Assert.*;

import java.net.UnknownHostException;

import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class ProspectServiceTest {

	@Test
	public void testSaveCurrentLine() throws UnknownHostException {
		Mongo mongo = new MongoClient();
		Morphia morphia = new Morphia();
		Datastore ds = morphia.createDatastore(mongo, "dbTest");
		ProspectService ps = new ProspectService();
		Prospect returnedProspect = ps
				.saveCurrentLineProspect("19	Louis Nix III	DT	2	Notre Dame	rJr	6-2	331	1", ds);
		Prospect expectedProspect = new Prospect("Louis", "Nix III", "");
		assertEquals(expectedProspect.getFirstname(), returnedProspect.getFirstname());
		assertEquals(expectedProspect.getLastname(), returnedProspect.getLastname());
	}

}
