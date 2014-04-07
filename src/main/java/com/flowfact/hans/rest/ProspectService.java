package com.flowfact.hans.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class ProspectService {

	Crawler crawler = new Crawler();

	public ProspectList getLiveProspects() throws IOException {
		URL url = new URL(
				"http://lvps87-230-26-65.dedicated.hosteurope.de/files/public-docs/prospects.txt");
		String currentLine;
		URLConnection conn = url.openConnection();
		BufferedReader readFile = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		ProspectList prospectList = new ProspectList();
		List<Prospect> draftedProspects = crawler.getProspects();
		int j = 0;
		while ((currentLine = readFile.readLine()) != null) {
			String changedLine = currentLine.replaceAll("\\t+", ";").trim();
			String[] el = changedLine.split(";");
			Prospect currentProspect = Util.createProspect(el);
			boolean addable = true;
			for (int i = 0; i < draftedProspects.size(); i++) {
				if (draftedProspects.get(i).equals(currentProspect)) {
					addable = false;
				}
			}
			if (addable) {
				prospectList.addProspect(currentProspect);
				j++;
			}
			if (j > 100) {
				break;
			}
		}
		return prospectList;
	}

	public String getOtc() throws IOException{
		return crawler.getOTC();
	}

	public ProspectList getNewLiveProspects() {
		return null;
	}
}
