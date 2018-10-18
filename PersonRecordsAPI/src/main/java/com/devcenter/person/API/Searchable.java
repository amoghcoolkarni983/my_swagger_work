package com.devcenter.person.API;

import java.util.List;

import io.swagger.model.Person;

public interface Searchable {
	
	public List<Person> searchPersonRecord( String firstName,  String lastName,  String mobile);

}
