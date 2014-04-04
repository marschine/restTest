package com.flowfact.hans.rest;

public class Util {
	public static String prepareThreadElements(String currentElement) {
		String[] newString = currentElement.split("-");
		if (newString[0].equals(currentElement)) {
			newString = currentElement.split("–");
		}
		String name = newString[0].split(",")[0].trim();
		return name;
	}

	public static Prospect createProspect(String[] el) {
		String rank = el[0];
		String name;
		if (el[1].contains("*")) {
			name = el[1].substring(1);
		} else {
			name = el[1];
		}
		String pos = el[2];
		String posRank = el[3];
		String school = el[4];
		String year = el[5];
		String height = el[6];
		String weight = el[7];
		Prospect currentProspect = new Prospect(rank, name, pos, posRank, school, year, height, weight);
		if (el[8] != "--") {
			String proj = el[8];
			currentProspect.setProjRnd(proj);
		}
		return currentProspect;
	}

	public static String prepareThreadProspect(String currentLine) {
		String[] newString = currentLine.split("-");
		if (newString[0].equals(currentLine)) {
			newString = currentLine.split("–");
		}
		String name = newString[1].split(",")[0].trim();
		return name;
	}
}
