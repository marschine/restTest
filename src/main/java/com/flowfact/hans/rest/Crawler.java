package com.flowfact.hans.rest;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	private String url = new String("http://nfl-talk.net/forum/showpost.php"
			+ "?" + "p=1255579&postcount=1");

	public void getProspects() throws IOException {
		Document doc = Jsoup.connect(url).get();
		Elements Prospect = doc.select("font[color=green]");
		for (Element element : Prospect) {
			String name = Util.prepareThreadElements(element.html());
			String firstname = name.split("\\s")[0];
			String lastname = name.split("\\s")[1];
		}
	}
}
