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

public class PersonFinderById implements Findable {
	public String SQL;

	@Override
	public List<Person> findPersonById(String personId) {
		List<Person> findPerson = new ArrayList<Person>();
		try {
			DBConnection db = DBConnection.getDbSingletone();
			Connection con = db.getConnection();
			FetchQueries queryFetcher = new FetchQueries();
			SQL = queryFetcher.fetchQuery("fetchPersonByID");
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, personId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Person obj = new Person();
				obj.setPERSONID(rs.getString(1));
				obj.setFIRSTNAME(rs.getString(2));
				obj.setLASTNAME(rs.getString(3));
				obj.setMOBILE(rs.getString(9));
				obj.setBIRTHDATE(rs.getDate(4));
				obj.setGENDER(rs.getString(5));
				obj.setMARITALSTATUS(rs.getString(6));
				obj.setRELIGION(rs.getString(7));
				obj.setADDRESS(rs.getString(10));
				findPerson.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return findPerson;
	}

}
