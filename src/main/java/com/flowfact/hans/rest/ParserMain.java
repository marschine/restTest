package com.flowfact.hans.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.omg.CORBA.Current;

import com.mongodb.Mongo;

public class ParserMain {

	public static void main(String... aArgs) throws IOException {
		Morphia morphia = new Morphia();
		morphia.map(Prospect.class);
		Mongo mongo = new Mongo();
		Datastore datastore = morphia.createDatastore(mongo, "dbTest");
		morphia.mapPackage("org.mongodb.morphia.entity");

//		//set taken
//		Crawler crawler = new Crawler();
//		List<Prospect> draftedProspects = crawler.getProspects();
//		for (Prospect prospect : draftedProspects) {
//			String firstname = prospect.getFirstname();
//			String lastname = prospect.getLastname();
//			Prospect p = datastore.createQuery(Prospect.class)
//					.field("lastname").equal(lastname).field("firstname")
//					.equal(firstname).get();
//			UpdateOperations<Prospect> ops = datastore.createUpdateOperations(
//					Prospect.class).set("taken", true);
//			datastore.update(p, ops);
//			System.out.println(prospect.getLastname());
//		}

		// //getLive
		morphia.mapPackage("org.mongodb.morphia.entity");
		Query q = datastore.createQuery(Prospect.class).field("taken")
				.equal(false);
		ArrayList entities = (ArrayList) q.asList();
		ProspectList prospects = new ProspectList(entities);
		System.out.println(prospects);

//		add all
//		URL url = new URL(
//				"http://lvps87-230-26-65.dedicated.hosteurope.de/files/public-docs/prospects.txt");
//		String currentLine;
//		URLConnection conn = url.openConnection();
//		BufferedReader readFile = new BufferedReader(new InputStreamReader(
//				conn.getInputStream()));
//		ProspectList prospectList = new ProspectList();
//		int j = 0;
//		while ((currentLine = readFile.readLine()) != null) {
//			String changedLine = currentLine.replaceAll("\\t+", ";").trim();
//			String[] el = changedLine.split(";");
//			Prospect currentProspect = Util.createProspect(el);
//			datastore.save(currentProspect);
//		}

	}
}
