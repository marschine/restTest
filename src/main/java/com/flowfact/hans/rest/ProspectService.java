package com.flowfact.hans.rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ProspectService {
	
	public ArrayList<Prospect> getLiveProspects() throws IOException{
		String currentLine;
		ReadFile readFile = new ReadFile("C:\\Users\\ffmartinhans\\Desktop\\prospects.txt");
		ArrayList<Prospect> prospects = new ArrayList<Prospect>();
		Crawler crawler = new Crawler();
		ArrayList<Prospect> draftedProspects = crawler.getProspects();
		while ((currentLine = readFile.readLine()) != null) {
			String changedLine = currentLine.replaceAll("\\t+", ";").trim();
			String[] el = changedLine.split(";");
			Prospect currentProspect = Util.createProspect(el);
			boolean addable = true;
			for (int i = 0; i < draftedProspects.size(); i++) {
				if (draftedProspects.get(i).equals(currentProspect)){
					addable = false;
				}
			}
			if (addable){
				prospects.add(currentProspect);
			}
		}
		return prospects;
	}

	public ArrayList<Prospect> getAllProspects(){
		return null;
	}
}
