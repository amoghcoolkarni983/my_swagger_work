package com.devcenter.person.API;

import io.swagger.model.Person;

public interface Editable {

	public void editPersonById(String personId, Person per);
}
