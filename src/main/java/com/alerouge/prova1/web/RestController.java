package com.alerouge.prova1.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alerouge.prova1.model.Person;
import com.alerouge.prova1.model.PersonDto;
import com.alerouge.prova1.model.UserLoggedSession;
import com.alerouge.prova1.repository.service.PersonService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@Autowired
	private PersonService personService;

	
//	private final UserLoggedSession userLoggedSession;
//	public RestController(PersonService personService, UserLoggedSession userLoggedSession){
//		this.personService = personService;
//		this.userLoggedSession = userLoggedSession;
//	}
	
	@Autowired
	private UserLoggedSession userLoggedSession;


	@GetMapping("/initSession")
	public boolean initSession(){
		System.out.println("initSession");
		userLoggedSession.setPerson(new PersonDto("userDaSession"));
		return true;
	}

	@GetMapping("/getSession")
	public PersonDto getSession(){
		PersonDto person = userLoggedSession.getPerson();
		System.out.println("person from session: " + person.getNome());
		return person;
	}
	
	@GetMapping("/dummy1")
	public List<Person> gestDummyList(){
		
		// returns list dummy person objects
		return Arrays.asList(
				new Person("ale"),
				new Person("vita"),
				new Person("cri"),
				new Person("ele"));
		
	}

	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable("id") long id){
		
		System.out.println("/person/{id} callded");
		
		PersonDto person = userLoggedSession.getPerson();
//		System.out.println("person from session: " + person.getNome());
		
		return personService.findById(id);
	}

	@GetMapping("/savePerson/{nome}")
	public Person savePerson(@PathVariable("nome") String nome){
		PersonDto personDto = new PersonDto(nome);
		Person personSaved = personService.savePerson(personDto);
//		personSaved.setNome("chris");
		return personSaved;
	}
	
}
