package com.flowfact.hans.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class ProspectService {
	
	public ProspectList getLiveProspects() throws IOException{
		String currentLine;
		URL url = new URL("http://lvps87-230-26-65.dedicated.hosteurope.de/files/public-docs/prospects.txt");
		URLConnection conn = url.openConnection();
		BufferedReader readFile = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		ProspectList prospectList = new ProspectList();
		Crawler crawler = new Crawler();
		List<Prospect> draftedProspects = crawler.getProspects();
		int j = 0;
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
				prospectList.addProspect(currentProspect);
			}
			j++;
			if (j > 100){
				break;
			}
		}
		return prospectList;
	}

	public ArrayList<Prospect> getAllProspects(){
		return null;
	}
}
