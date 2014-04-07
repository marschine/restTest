package com.flowfact.hans.rest;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	private String url = new String("http://nfl-talk.net/forum/showpost.php?p=1329050&postcount=1");

	public ArrayList<Prospect> getProspects() throws IOException{
		Document doc = Jsoup.connect(url).get();
		Elements Prospect = doc.select("font[color=green]");
		ArrayList<Prospect> draftedProspects = new ArrayList<Prospect>();
		for (Element element : Prospect) {
			String name = Util.prepareThreadElements(element.html());
			String firstname = name.split("\\s")[0];
			String lastname = name.split("\\s")[1];
			draftedProspects.add(new Prospect(firstname, lastname));
		}
		return draftedProspects;
	}

	public String getOTC() throws IOException {
		Document doc = Jsoup.connect(url).get();
		Elements otcElement = doc.select("font[color=red]");
		String otc = otcElement.text();
		return otc;
	}
}