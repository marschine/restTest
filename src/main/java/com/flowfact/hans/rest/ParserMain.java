package com.flowfact.hans.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.mongodb.Mongo;

public class ParserMain {

	public static void main(String... aArgs) throws IOException {
		Mongo mongo = new Mongo();
		Morphia morphia = new Morphia();
		Datastore ds = morphia.createDatastore(mongo, "dbTest");

		//look for entries untaken
		Query query = ds.createQuery(Prospect.class).field("taken").equal(false);
		ArrayList<Prospect> prospectListRaw = (ArrayList<Prospect>) query.asList();
		ProspectList prospectList = new ProspectList(prospectListRaw);
		System.out.println(prospectList);
		
		//set taken
//		Crawler crawler = new Crawler();
//		List<Prospect> draftedProspects = crawler.getProspects();
//		for (Prospect prospect : draftedProspects) {
//			String firstname = prospect.getFirstname();
//			String lastname = prospect.getLastname();
//			Query query = ds.createQuery(Prospect.class).field("lastname")
//					.equal(lastname).field("firstname").equal(firstname);
//			UpdateOperations ops = ds.createUpdateOperations(Prospect.class).set("taken", true);
//			ds.update(query, ops);
//		}

		// create all objects
		// URL url = new URL(
		// "http://lvps87-230-26-65.dedicated.hosteurope.de/files/public-docs/prospects.txt");
		// String currentLine;
		// URLConnection conn = url.openConnection();
		// BufferedReader readFile = new BufferedReader(new InputStreamReader(
		// conn.getInputStream()));
		// ProspectList prospectList = new ProspectList();
		// while ((currentLine = readFile.readLine()) != null) {
		// String changedLine = currentLine.replaceAll("\\t+", ";").trim();
		// String[] el = changedLine.split(";");
		// Prospect currentProspect = Util.createProspect(el);
		// ds.save(currentProspect);
		// }

		// set taken ones

	}
}
