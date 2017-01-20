package com.myapp.myapp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonDaoImpl implements PersonDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public Person getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Person p = (Person) session.get(Person.class, id);
		return p;
	}

	public List<Person> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Person> results = session.createQuery("from Person").list();
		return results;
	}

	public void addPerson(Person p) {
		Session session = sessionFactory.getCurrentSession();
		session.save(p);
		session.flush();		
	}

}
