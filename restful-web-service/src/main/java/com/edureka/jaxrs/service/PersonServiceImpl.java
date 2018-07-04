package com.edureka.jaxrs.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.edureka.jaxrs.Person;
import com.edureka.jaxrs.Response;

@Path("/person")
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class PersonServiceImpl implements PersonService {

	private static Map<Integer,Person> persons = new HashMap<Integer,Person>();
	
	@POST
    @Path("/add")
	public Response addPerson1(Person p) {
		Response response = new Response();
		if(persons.get(p.getId()) != null){
			response.setStatus(false);
			response.setMessage("Person Already Exists");
			return response;
		}
		persons.put(p.getId(), p);
		response.setStatus(true);
		response.setMessage("Person created successfully");
		return response;
	}

	@DELETE
    @Path("/{id}/delete")
	public Response deletePerson1(@PathParam("id") int id) {
		Response response = new Response();
		if(persons.get(id) == null){
			response.setStatus(false);
			response.setMessage("Person Doesn't Exists");
			return response;
		}
		persons.remove(id);
		response.setStatus(true);
		response.setMessage("Person deleted successfully");
		return response;
	}

	@GET
	@Path("/{id}/get")
	public Person getPerson1(@PathParam("id") int id) {
		return persons.get(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	public Person getDummyPerson(@PathParam("id") int id) {
		Person p = new Person();
		p.setAge(99);
		p.setName("Dummy");
		p.setId(id);
		return p;
	}

	@GET
	@Path("/getAll")
	public Person[] getAllPersons1() {
		Set<Integer> ids = persons.keySet();
		Person[] p = new Person[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = persons.get(id);
			i++;
		}
		return p;
	}

	public com.edureka.jaxrs.Response addPerson(com.edureka.jaxrs.Person p) {
		// TODO Auto-generated method stub
		return null;
	}

	public com.edureka.jaxrs.Response deletePerson(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public com.edureka.jaxrs.Person getPerson(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public com.edureka.jaxrs.Person[] getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

}