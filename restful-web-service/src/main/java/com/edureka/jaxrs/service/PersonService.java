package com.edureka.jaxrs.service;

import com.edureka.jaxrs.Person;
import com.edureka.jaxrs.Response;

public interface PersonService {

	public Response addPerson(Person p);
	
	public Response deletePerson(int id);
	
	public Person getPerson(int id);
	
	public Person[] getAllPersons();

}