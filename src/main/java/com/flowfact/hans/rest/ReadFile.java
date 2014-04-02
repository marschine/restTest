package com.flowfact.hans.rest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	private BufferedReader br;

	public ReadFile(String filename) throws FileNotFoundException {
		super();
		this.br = new BufferedReader(new FileReader(filename));
	}

	public String readLine() throws IOException{
		return br.readLine();
	}
	
}
