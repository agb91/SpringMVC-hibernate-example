package com.myapp.myapp;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.myapp.*;
/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	

	private PersonServiceImpl personService;
	
	
	@Autowired
    private PersonDaoImpl personDao;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	@Transactional
	public String home(Locale locale, Model model, @ModelAttribute Person person) {
		
		personService = getService();	
		
		//write
		Person p1 = createPerson( "primo" );
		Person p2 = createPerson( "secondo" );
		personService.addPerson(p1);
		personService.addPerson(p2);
		//read
		Person other = personService.getPersonById( p2.getId() );

		model.addAttribute("read" , other.getName());
		return "home";
	}
	
	@RequestMapping(value = "/", method=RequestMethod.POST)
	@Transactional
	public String homePost(Locale locale, Model model, @ModelAttribute Person person) 
	{
		System.out.println( "Received name" + person.getName() );
		return "redirect:/home";
	}
		
	
	
	
	
	//FROM HERE PRIVATES
	
	private PersonServiceImpl getService()
	{
		return new PersonServiceImpl(personDao);
	}
	
	private Person createPerson( String name )
	{
		Person p = new Person();
		p.setName( name );
		return p;
	}
	
	
}
