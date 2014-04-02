package com.flowfact.hans.rest;

import java.io.IOException;
import java.util.ArrayList;

public class ParserMain {

	public static void main(String... aArgs) throws IOException {
		String currentLine;
		ReadFile readFile = new ReadFile("C:\\Users\\ffmartinhans\\Desktop\\prospects.txt");
		ArrayList<Prospect> prospects = new ArrayList<Prospect>();
//		MongoClient mongoClient = new MongoClient();
		while ((currentLine = readFile.readLine()) != null) {
			String changedLine = currentLine.replaceAll("\\t+", ";").trim();
			String[] el = changedLine.split(";");
			Prospect currentProspect = createProspect(el);
//			BasicDBObject persistenceObject = currentProspect.getPersistenceDocument();
			prospects.add(currentProspect);
		}

		
//		ReadFile readFile2 = new ReadFile("/home/martin/Desktop/thread.txt");
//		ArrayList<Prospect> prospects2 = new ArrayList<Prospect>(prospects);
//		while ((currentLine = readFile2.readLine()) != null) {
//			boolean del = false;
//			String name = prepareThreadProspect(currentLine);
//			String firstname = name.split("\\s")[0];
//			String lastname = name.split("\\s")[1];
//			for (Iterator<Prospect> iterator = prospects.iterator(); iterator
//					.hasNext();) {
//				Prospect prospect = (Prospect) iterator.next();
//				if ((prospect.getLastname().equals(lastname))
//						&& (prospect.getFirstname().equals(firstname))) {
//					del = true;
//					prospects2.remove(prospect);
//				}
//			}
//			if (!del){
//				System.out.println(firstname + " " +  lastname + " wurde nicht gelöscht!");
//			}
//		}
//		prospects = prospects2;
		Crawler crawler = new Crawler();
		crawler.getProspects();
	}

	public static String prepareThreadProspect(String currentLine) {
		String[] newString = currentLine.split("-");
		if (newString[0].equals(currentLine)) {
			newString = currentLine.split("–");
		}
		String name = newString[1].split(",")[0].trim();
		return name;
	}

	public static Prospect createProspect(String[] el) {
		int rank = Integer.parseInt(el[0]);
		String name;
		if (el[1].contains("*")) {
			name = el[1].substring(1);
		} else {
			name = el[1];
		}
		String pos = el[2];
		int posRank = Integer.parseInt(el[3]);
		String school = el[4];
		String year = el[5];
		String height = el[6];
		int weight = Integer.parseInt(el[7]);
		Prospect currentProspect = new Prospect(rank, name, pos, posRank,
				school, year, height, weight);
		if (el[8] != "--") {
			String proj = el[8];
			currentProspect.setProjRnd(proj);
		}
		return currentProspect;
	}
}
