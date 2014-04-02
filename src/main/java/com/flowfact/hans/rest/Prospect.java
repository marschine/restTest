package com.flowfact.hans.rest;



public class Prospect {
	private int rank;

	private String firstname;
	
	private String lastname;
	
	private String pos;
	
	private int posRank;
	
	private String school;
	
	private String classYear;
	
	private String height;
	
	private int weight;
	
	private String projRnd;


	public Prospect(int rank, String name, String pos, int posRank,
			String school, String classYear, String height, int weight) {
		super();
		this.rank = rank;
		this.firstname = name.split(" ")[0];
		this.lastname = name.split(" ")[1];
		this.pos = pos;
		this.posRank = posRank;
		this.school = school;
		this.classYear = classYear;
		this.height = height;
		this.weight = weight;
	}

	public String getProjRnd() {
		return projRnd;
	}

	public void setProjRnd(String projRnd) {
		this.projRnd = projRnd;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Prospect [rank=" + rank + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", pos=" + pos + ", posRank="
				+ posRank + ", school=" + school + ", classYear=" + classYear
				+ ", height=" + height + ", weight=" + weight + ", projRnd="
				+ projRnd + "]" + "\n";
	}

//	public BasicDBObject getPersistenceDocument(){
//		BasicDBObject document = new BasicDBObject();
//		document.put("rank", Integer.toString((this.rank)));
//		document.put("firstname", this.firstname);
//		document.put("lastname", this.lastname);
//		document.put("pos", this.pos);
//		document.put("posRank", this.posRank);
//		document.put("school", this.school);
//		document.put("classYear", this.classYear);
//		document.put("height", this.height);
//		document.put("weight", Integer.toString((this.weight)));
//		document.put("projRnd", this.projRnd);
//		return document;
//	}

}
