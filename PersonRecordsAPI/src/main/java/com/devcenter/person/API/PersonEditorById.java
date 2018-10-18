package com.devcenter.person.API;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.devcenter.person.MODEL.DBConnection;
import com.devcenter.person.MODEL.FetchQueries;

import io.swagger.model.Person;

public class PersonEditorById implements Editable {
	public String SQL;
	Statement stmt = null;

	@Override
	public void editPersonById(String personId, Person per) {
		try {
			DBConnection db = DBConnection.getDbSingletone();
			Connection con = db.getConnection();

			FetchQueries queryFetcher = new FetchQueries();
			SQL = queryFetcher.fetchQuery("updatePersonByID");
			System.out.println(SQL);
			PreparedStatement stmt = con.prepareStatement(SQL);
			// stmt.setString(1, String.valueOf(per.getBIRTHDATE()));
			System.out.println(per.getGENDER());
			stmt.setString(1, per.getGENDER());
			stmt.setString(2, per.getMARITALSTATUS());
			stmt.setString(3, per.getRELIGION());
			stmt.setString(4, per.getMOBILE());
			stmt.setString(5, per.getADDRESS());
			stmt.setString(6, personId);
			stmt.executeUpdate(SQL);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
