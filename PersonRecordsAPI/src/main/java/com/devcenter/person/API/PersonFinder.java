package com.devcenter.person.API;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.devcenter.person.MODEL.DBConnection;
import com.devcenter.person.MODEL.FetchQueries;

import io.swagger.model.Person;

public class PersonFinder implements Searchable {
	public String SQL;

	@Override
	public List<Person> searchPersonRecord(String firstName, String lastName, String mobile) {
		List<Person> searchedPersons = new ArrayList<Person>();
		try {
			DBConnection db = DBConnection.getDbSingletone();
			Connection con = db.getConnection();
			FetchQueries queryFetcher = new FetchQueries();
			if (mobile.length() == 0) {
				SQL = queryFetcher.fetchQuery("searchByFirstNameAndLastName");
			} else if (mobile.length() != 0) {
				SQL = queryFetcher.fetchQuery("searchByMobileNumber");
			}
			PreparedStatement ps = con.prepareStatement(SQL);
			if (mobile.length() == 0) {
				ps.setString(1, firstName + "%");
				ps.setString(2, lastName + "%");
				ps.setString(3, firstName + "%");
				ps.setString(4, lastName + "%");
				ps.setString(5, firstName + "%");
				ps.setString(6, lastName + "%");
			} else if (mobile.length() != 0) {
				ps.setString(1, mobile);
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Person obj = new Person();
				obj.setPERSONID(rs.getString(1));
				obj.setFIRSTNAME(rs.getString(2));
				obj.setLASTNAME(rs.getString(3));
				obj.setMOBILE(rs.getString(7));
				obj.setBIRTHDATE(rs.getDate(4));
				obj.setGENDER(rs.getString(5));
				obj.setMARITALSTATUS(rs.getString(6));
				obj.setRELIGION(rs.getString(7));
				obj.setADDRESS(rs.getString(10));
				searchedPersons.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchedPersons;
	}
}
