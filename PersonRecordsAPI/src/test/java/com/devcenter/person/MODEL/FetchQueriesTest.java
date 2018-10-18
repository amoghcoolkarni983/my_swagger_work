package com.devcenter.person.MODEL;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FetchQueriesTest {

	@Test
	public void testFetchQuery() {
		FetchQueries test = new FetchQueries();
		String output = test.fetchQuery("fetchPersonByID");
		assertEquals("SELECT * FROM person WHERE PERSON_ID = ?", output);

	}

}
