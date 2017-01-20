package com.myapp.myapp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


public interface PersonService {

	@Transactional
	public void addPerson(Person p) ;
	
	@Transactional
	public Person getPersonById(int id) ;
	
	@Transactional
	public List<Person> getAll() ;
	

}
