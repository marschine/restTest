package com.flowfact.hans.rest;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawlerer {
	private String url = new String(
			"http://nfl-talk.net/forum/showpost.php?p=1329051&postcount=2");

	public String getOTC() throws IOException {
		Document doc = Jsoup.connect(url).get();
		Elements otcElement = doc.select("font[color=red]");
		String otc = otcElement.text();
		return otc;
	}

	public ArrayList<Prospect> getSelections() throws Exception {
		Document doc = Jsoup.connect(url).get();
		Elements selections = doc.select("b");
		ArrayList<Prospect> draftedProspects = new ArrayList<Prospect>();
		for (Element element : selections) {
			if (element.html().contains("#")&& element.html().contains("Green")) {
				String[] selection = Util.prepareSelection(element.html());
				draftedProspects.add(new Prospect(selection[1], selection[2], selection[0]));
			}
		}
		return draftedProspects;
	}
}