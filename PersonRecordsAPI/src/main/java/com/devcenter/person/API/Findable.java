package com.devcenter.person.API;

import java.util.List;

import io.swagger.model.Person;

public interface Findable {

	public List<Person> findPersonById(String personId);

}