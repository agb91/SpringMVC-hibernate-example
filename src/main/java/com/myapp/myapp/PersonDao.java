package com.myapp.myapp;

import java.util.List;

public interface PersonDao {
	
	public Person getById(int id);
	public void addPerson(Person p);
	public List<Person> getAll();

}
