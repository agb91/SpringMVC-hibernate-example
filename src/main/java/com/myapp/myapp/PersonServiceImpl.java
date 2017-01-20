package com.myapp.myapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("personService")
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonDao personDao;

	@Autowired
	public PersonServiceImpl(PersonDao personDao)
	{
		this.personDao = personDao;
	}
	
	public void addPerson(Person p) {
		this.personDao.addPerson(p);
	}

	public Person getPersonById(int id) {
		return this.personDao.getById(id);
	}

	public List<Person> getAll() {
		return this.personDao.getAll();		
	}

}
