package com.flowfact.hans.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.mongodb.Mongo;

public class ProspectService {

	Crawler crawler = new Crawler();

	public ProspectList getLiveProspects() throws Exception {
		Mongo mongo = new Mongo();
		Morphia morphia = new Morphia();
		Datastore ds = morphia.createDatastore(mongo, "dbTest");
		this.setTaken();
		// look for entries untaken
		Query query = ds.createQuery(Prospect.class).field("taken")
				.equal(false);
		ArrayList<Prospect> prospectListRaw = (ArrayList<Prospect>) query
				.asList();
		ProspectList prospectList = new ProspectList();
		return prospectList;
	}

	public String getOtc() throws IOException {
		return crawler.getOTC();
	}

	public boolean setTaken() throws Exception {
		Mongo mongo = new Mongo();
		Morphia morphia = new Morphia();
		Datastore ds = morphia.createDatastore(mongo, "dbTest");
		Crawler crawler = new Crawler();
		List<Prospect> draftedProspects = crawler.getSelections();
		for (Prospect prospect : draftedProspects) {
			String firstname = prospect.getFirstname();
			String lastname = prospect.getLastname();
			String team = prospect.getTeam();
			Query query = ds.createQuery(Prospect.class).field("lastname")
					.equal(lastname);
			query.field("firstname").equal(firstname);
			System.out.println(lastname);
			UpdateOperations ops = ds.createUpdateOperations(Prospect.class)
					.set("taken", true);
			ds.update(query, ops);
			ops = ds.createUpdateOperations(Prospect.class)
					.set("team", team);
			ds.update(query, ops);
		}
		return true;
	}

	public boolean reset() throws IOException {
		// return true only if success
		Mongo mongo = new Mongo();
		Morphia morphia = new Morphia();
		Datastore ds = morphia.createDatastore(mongo, "dbTest");

		// create all objects
		URL url = new URL(
				"http://lvps87-230-26-65.dedicated.hosteurope.de/files/public-docs/prospects.txt");
		String currentLine;
		URLConnection conn = url.openConnection();
		BufferedReader readFile = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		ProspectList prospectList = new ProspectList();
		while ((currentLine = readFile.readLine()) != null) {
			String changedLine = currentLine.replaceAll("\\t+", ";").trim();
			String[] el = changedLine.split(";");
			Prospect currentProspect = Util.createProspect(el);
			ds.save(currentProspect);
		}
		return true;
	}

	public ProspectList getNewLiveProspects() throws Exception {
		Mongo mongo = new Mongo();
		Morphia morphia = new Morphia();
		Datastore ds = morphia.createDatastore(mongo, "dbTest");
		this.setTaken();
		// look for entries untaken
		Query query = ds.createQuery(Prospect.class).field("taken")
				.equal(false);
		ArrayList<Prospect> prospectListRaw = (ArrayList<Prospect>) query
				.asList();
		ProspectList prospectList = new ProspectList(prospectListRaw.subList(0, 100));
		return prospectList;
	}
}
