package com.alerouge.prova1.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alerouge.prova1.model.Person;
import com.alerouge.prova1.service.IPersonService;

@RestController
public class MyController {

	@Autowired
	private IPersonService service;
	
	@GetMapping("/getAllPersons")
	public List<Person> getAllPersons(){
		return service.getAllPersons();
	}

	@GetMapping("/getPerson/{id}")
	public Person getPerson(@PathVariable Long id){
		Optional<Person> optionalPerson = service.getPersonById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}

	@PostMapping("/savePerson")
	public Person savePerson(@RequestBody Person person){
		Person personCreated = service.createPerson(person);
		
		// logica per test...
		personCreated.setPoints(146);
		
		return personCreated;
	}

}
