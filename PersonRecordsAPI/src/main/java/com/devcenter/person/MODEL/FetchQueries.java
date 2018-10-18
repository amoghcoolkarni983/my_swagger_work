package com.devcenter.person.MODEL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FetchQueries {
	public String fetchQuery(String fileName) {
		String filePath = "resources/" + fileName + ".sql";
		String line = null;
		String query = null;
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				query = line;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return query;
	}

}
