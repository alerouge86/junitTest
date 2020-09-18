package com.alerouge.prova1.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alerouge.prova1.model.Person;
import com.alerouge.prova1.model.PersonDto;
import com.alerouge.prova1.repository.service.PersonService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	private final PersonService personService;
	
	public RestController(PersonService personService){
		this.personService = personService;
	}

	@GetMapping("/dummy1")
	public List<Person> helloRest(){
		
		// returns list dummy person objects
		return Arrays.asList(
				new Person("ale"),
				new Person("vita"),
				new Person("cri"),
				new Person("ele"));
		
	}

	@GetMapping("/person/{id}")
	public Person helloRest(@PathVariable("id") long id){
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
